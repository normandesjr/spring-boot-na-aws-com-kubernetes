provider "aws" {
  version = "~> 2.0"
  region  = "us-east-1"
  profile = "hibicode"
}

terraform {
  backend "s3" {
    bucket = "hibicode-terraform-state"
    key = "spring-aws-k8s"
    region = "us-east-1"
    profile = "hibicode"
  }
}