Create Database CRUD_JavaWeb
go
use CRUD_JavaWeb

create table TB_Clientes
(
	ID_Cliente int primary key identity (1,1),
	Nm_Cliente varchar(50),
	Nr_Telefone varchar(15),
	Dt_Contratacao date
);
