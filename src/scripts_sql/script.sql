create database if not exists dbSapataria ;

use dbSapataria;

create table if not exists tbSapato (
	SAP_CODIGO int not null primary key auto_increment,
    SAP_NOME varchar(50) not null,
    SAP_FORNECEDOR varchar(50) not null,
    SAP_PRECO_COMPRA decimal(6, 2) not null,
    SAP_PRECO_VENDA decimal(6, 2) not null,
    SAP_QUANTIDADE int not null
);

create table if not exists tbPedido (
	PED_CODIGO int not null primary key auto_increment,
    PED_CLIENTE varchar(50) not null,
    PED_DATA date not null,
    PED_QUANTIDADE int not null,
    PED_PRECO_TOTAL decimal(7, 2) not null,
    SAP_CODIGO int not null,
    foreign key (SAP_CODIGO) references tbSapato(SAP_CODIGO)
);