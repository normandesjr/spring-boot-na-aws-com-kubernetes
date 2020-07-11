# Spring Boot na AWS com Kubernetes

## Infrastructure

We have 2 steps to set up our infrastructure, the first one we'll use [Terraform](https://www.terraform.io/) and 
the second one [eksctl](https://eksctl.io/).

### eksctl

#### Installation

Follow the instructions here https://eksctl.io/introduction/#installation

For macOS we can use Homebrew:

````
brew tap weaveworks/tap
brew install weaveworks/tap/eksctl
````

- Version used: 0.22.0

#### Cluster creation

If you don't use default profile, use --profile flag

````
eksctl create cluster -f eks-hibicode-cluster.yaml --kubeconfig=./kubeconfig.cluster.yaml --profile hibicode
````

Export KUBECONFIG variable to use kubectl:

````
export KUBECONFIG=$PWD/kubeconfig.cluster.yaml
````

Check nodes:

````
kubectl get nodes
````

![kubectl get nodes](./media/get-nodes.png)

### Terraform

#### Installation

It's very simple, just download, unzip and add it to path. Download it [here](https://www.terraform.io/downloads.html).

- Version used: v0.12.28

#### Running

After create the EKS cluster, we can run Terraform to provisioning some services like ECR and RDS.

````
terraform init
terraform apply
````

### Dockerizing and pushing the app

To improve image size separating in layers, we'll use jib from Google.

It is configured in pom.xml and to build the project just use:

````
./mvnw compile jib:dockerBuild
````

If you want to see the tradicional way, build like this:

````
docker build -t personal-load .
````

Login to ECR:

Use _ecr_uri_ without the last /hibicode word from Terraform output to run the command:

````
aws ecr get-login-password --region us-east-1 --profile hibicode | docker login --username AWS --password-stdin <ecr_uri>
````

After our build and login successfully, we can tag our image (now use the full ecr_url):

````
docker tag personal-loan:latest <ecr_uri>:latest
````

Then push our image (use full ecr_uri):

````
docker push <ecr_uri>:latest
````

### Create Deploy Manifest

Now we should be able to deploy our application

````
kubectl apply -f manifests/personal-loan-deployment.yaml
````

Checking:

````
kubectl get deployments
kubectl get pods
kubectl logs -f <pod-name>
````

Deleting deployment:

````
kubectl delete deployment personal-loan
````

### Deleting infrastructure

````
eksctl delete cluster -f eks-hibicode-cluster.yaml --profile hibicode
````

````
terraform destroy
````

### Getting a shell to a container

Create the Pod:

````
kubectl apply -f manifests/shell-demo.yaml
````

Verify that the container is running:

````
kubectl get pods
````

Get a shell to the running container:

````
kubectl exec --stdin --tty shell-demo -- /bin/bash
````

### Cluster AutoScaler

#### Install Cluster Auto Scaler in cluster:

````
kubectl apply -f https://raw.githubusercontent.com/kubernetes/autoscaler/master/cluster-autoscaler/cloudprovider/aws/examples/cluster-autoscaler-autodiscover.yaml
````

To ensure that our autoscaler deployment do not be removed:

```` 
kubectl -n kube-system annotate deployment.apps/cluster-autoscaler cluster-autoscaler.kubernetes.io/safe-to-evict="false"
````

Get the last version of autoscaler for our Kubernetes (EKS) version - https://github.com/kubernetes/autoscaler/releases

Then edit deployment to set it:

````
kubectl -n kube-system edit deployment cluster-autoscaler 
````

- Replace: YOUR_CLUSTER_NAME with your cluster name

Add the following properties:

- --balance-similar-node-groups 
- --skip-nodes-with-system-pods=false

And finally edit the image version got on Github 

The final version will be something like this:

````
- --node-group-auto-discovery=asg:tag=k8s.io/cluster-autoscaler/enabled,k8s.io/cluster-autoscaler/eks-hibicode-cluster
- --balance-similar-node-groups
- --skip-nodes-with-system-pods=false
image: k8s.gcr.io/cluster-autoscaler:v1.16.5
````

Update the image:

````
kubectl -n kube-system set image deployment.apps/cluster-autoscaler cluster-autoscaler=us.gcr.io/k8s-artifacts-prod/autoscaling/cluster-autoscaler:v1.16.5
````

Now, lets check the logs:

````
kubectl -n kube-system get deployment
kubectl logs -f deployment/cluster-autoscaler -n kube-system
kubectl -n kube-system describe deployments cluster-autoscaler
````

Reference: https://docs.aws.amazon.com/pt_br/eks/latest/userguide/cluster-autoscaler.html#ca-ng-considerations

### Application Load Balancer

Walk through: https://kubernetes-sigs.github.io/aws-alb-ingress-controller/guide/walkthrough/echoserver/

#### Exposing Personal Loan throughout ALB

````
kubectl apply -f manifests/personal-loan-namespace.yaml &
kubectl apply -f manifests/personal-loan-service.yaml &
kubectl apply -f manifests/personal-loan-deployment.yaml
````

Then, we can deploy ingress:

````
kubectl apply -f manifests/personal-loan-ingress.yaml
````

Check if alb-ingress-controller create the resources:

````
kubectl logs -n kube-system $(kubectl get po -n kube-system | egrep -o 'alb-ingress[a-zA-Z0-9-]+') | grep 'personalloan\/personal-loan'
````