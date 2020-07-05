resource "aws_security_group" "database_security" {
  name          = "hibicode-postgres-databases"
  vpc_id        =  data.aws_vpc.main.id

  ingress {
    from_port   = 5432
    to_port     = 5432
    protocol    = "tcp"
    cidr_blocks = [data.aws_vpc.main.cidr_block]
    self        = true
  }
}