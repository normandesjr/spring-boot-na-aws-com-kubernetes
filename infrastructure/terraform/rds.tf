module "rds" {
  source  = "terraform-aws-modules/rds/aws"
  version = "~> 2.0"

  identifier = "hibicode-rds"

  engine = "postgres"
  engine_version = "9.6.9"
  instance_class = "db.t2.micro"
  allocated_storage = "20"
  storage_encrypted = false

  name = "personalloan"
  username = "postgres"
  password = local.personal_loan_variables.password
  port = "5432"

//  vpc_security_group_ids = [aws_security_group.database.id]
  create_db_parameter_group = false

  major_engine_version = "9.6"
  family = "postgres9.6"

  maintenance_window = "Thu:03:30-Thu:05:30"
  backup_window = "05:30-06:30"

  multi_az = "false"

  subnet_ids = var.private_subnet_ids
}

output "database_endpoint" {
  value = module.rds.this_db_instance_endpoint
}