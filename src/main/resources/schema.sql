/*
 * SGBD: MySQL
 * 
 * Este arquivo contém a definição da estrutura do banco de dados `loja` (tabelas).
 */

DROP DATABASE IF EXISTS loja;
CREATE DATABASE loja;
USE loja;


-- tabelas

create table produto (
	id int not null auto_increment,
	descricao varchar(40) not null,
    preco double(7, 2) not null,
    primary key (id)
);

create table cliente (
	id int not null auto_increment,
    nome varchar(40) not null,
    email varchar(80),
    ativo boolean default true,
    primary key (id)
);

create table pedido (
	id int not null auto_increment,
    cliente_id int not null,
    dt_criacao datetime not null,
    primary key (id)
);
alter table pedido add constraint fk_cliente foreign key (cliente_id) references cliente(id);

create table pedido_item (
	id int not null auto_increment,
    pedido_id int not null,
    produto_id int not null,
    quantidade int not null,
    primary key (id)
);
alter table pedido_item add constraint fk_pedido foreign key (pedido_id) references pedido(id);
alter table pedido_item add constraint fk_produto foreign key (produto_id) references produto(id);
alter table pedido_item add constraint ck_quantidade check (quantidade > 0);

