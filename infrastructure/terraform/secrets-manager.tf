resource "random_password" "database_password" {
  length           = 16
  special          = false
  override_special = "_%@/"
}

locals {
  personal_loan_variables = {
    username    = "personal_loan",
    password    = random_password.database_password.result
  }
}

resource "aws_secretsmanager_secret" "personal_loan_secret" {
  name          = "personal-loan-secret"
  recovery_window_in_days = 0
}

resource "aws_secretsmanager_secret_version" "personal_loan_secret_version" {
  secret_id     = aws_secretsmanager_secret.personal_loan_secret.id
  secret_string = jsonencode(local.personal_loan_variables)
}
