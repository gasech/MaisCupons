create database bdcupons;

use bdcupons;

DROP TABLE cadastro_usuario;
DROP TABLE cadastro_empresa;
DROP TABLE cadastro_cupom;
DROP TABLE solicitacao_usuario;
DROP TABLE solicitacao_empresa;

-- Tabela dos Usuários
CREATE TABLE cadastro_usuario (
  id int not null PRIMARY KEY auto_increment,
  nome varchar(30) NOT NULL,
  cpf bigint NOT NULL,
  telefone int NOT NULL,
  email varchar(100) NOT NULL,
  senha varchar(40) NOT NULL,
  saldo int NOT NULL
);

-- Tabela das Empresas
CREATE TABLE cadastro_empresa (  
  id int not null PRIMARY KEY auto_increment,
  nome varchar(30) NOT NULL,
  cnpj bigint NOT NULL ,
  telefone bigint NOT NULL,
  email varchar(100) NOT NULL,
  senha varchar(40) NOT NULL
);

-- Tabela dos Cupons
CREATE TABLE cadastro_cupom (
  id int not null PRIMARY KEY auto_increment,
  nome varchar(30) NOT NULL,
  departamento varchar(100) NOT NULL,
  desconto bigint NOT NULL  
);
  
-- Tabela de Solicitações dos Usuários
CREATE TABLE solicitacao_usuario(  
  id int not null PRIMARY KEY auto_increment,
  nome varchar(30) NOT NULL,
  cpf bigint NOT NULL,
  mensagem varchar(100) NOT NULL 
);

-- Tabela de Solicitações das Empresas
CREATE TABLE solicitacao_empresa(  
  id int not null PRIMARY KEY auto_increment,
  nome varchar(30) NOT NULL,
  cnpj bigint NOT NULL,
  mensagem varchar(100) NOT NULL 
);

select * from cadastro_cupom;
select * from cadastro_empresa;
select * from cadastro_usuario;
select * from solicitacao_empresa;
select * from solicitacao_usuario;



  