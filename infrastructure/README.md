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

- Version used: v0.12.28



