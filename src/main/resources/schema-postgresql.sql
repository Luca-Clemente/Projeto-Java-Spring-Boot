CREATE TABLE IF NOT EXISTS obra (
     id serial PRIMARY KEY,
     nome  varchar(50),
     ano   varchar(20),
     autor varchar(20)
);
CREATE TABLE IF NOT EXISTS compradores (
	id serial PRIMARY KEY,
	nome varchar(50),
	email varchar(20)
);
CREATE TABLE IF NOT EXISTS funcionarios (
	id serial PRIMARY KEY,
	nome varchar(50),
	cargo varchar (20)
);
CREATE TABLE IF NOT EXISTS materiais(
	id serial PRIMARY KEY,
	nome varchar(50),
	quantidade int
	
);
