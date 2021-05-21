create database bdcupons;

use bdcupons;

CREATE TABLE cadastro_usuario (
  id int not null PRIMARY KEY auto_increment,
  nome varchar(30) NOT NULL,
  cpf bigint NOT NULL,
  telefone int NOT NULL,
  email varchar(100) NOT NULL,
  senha varchar(40) NOT NULL
  );
  
  CREATE TABLE cadastro_empresa (  
  id int not null PRIMARY KEY auto_increment,
  nome varchar(30) NOT NULL,
  cnpj bigint NOT NULL ,
  telefone bigint NOT NULL,
  email varchar(100) NOT NULL,
  senha varchar(40) NOT NULL
  );
  
  CREATE TABLE cadastro_cupom (
  id int not null PRIMARY KEY auto_increment,
  nome varchar(30) NOT NULL,
  departamento varchar(100) NOT NULL,
  desconto bigint NOT NULL  
  );
  
  CREATE TABLE carteira_cashback (
  id int not null PRIMARY KEY auto_increment,
  cpf bigint NOT NULL,
  fk_id_usuario int NOT NULL,
  fk_id_empresa int NOT NULL,  
  foreign key (fk_id_usuario) references cadastro_usuario (id),
  foreign key (fk_id_empresa) references cadastro_empresa (id)
  );
  
  CREATE TABLE solicitacao_usuario(  
  id int not null PRIMARY KEY auto_increment,
  nome varchar(30) NOT NULL,
  cpf bigint NOT NULL,
  mensagem varchar(100) NOT NULL 
  );
  
  CREATE TABLE solicitacao_empresa(  
  id int not null PRIMARY KEY auto_increment,
  nome varchar(30) NOT NULL,
  cnpj bigint NOT NULL,
  mensagem varchar(100) NOT NULL 
  )
  
  select  * from carteira_cashback
  