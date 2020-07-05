variable "vpc_id" {}

data "aws_vpc" "main" {
  id = var.vpc_id
}

data "aws_subnet_ids" "private_subnets" {
  vpc_id = var.vpc_id
  tags = {
    Name = "*Private*"
  }
}

output "subnet_cidr_blocks" {
  value = data.aws_subnet_ids.private_subnets.ids
}