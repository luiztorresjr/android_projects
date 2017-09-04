DROP TABLE IF EXISTS livro;
create table livro(
	n_livro serial,
	titulo varchar(30),
	autor varchar(30),
	paginas_total integer,
	paginas_lida integer,
	paginas_faltando integer,
	PRIMARY KEY (idLivro)
);

insert into livro (nome_livro, autor, paginas_total, paginas_lida, paginas_faltando, status) values (1,1,1,1,1,'lido');
insert into livro (nome_livro, autor, paginas_total, paginas_lida, paginas_faltando, status) values (2,2,2,2,2,'lido');
insert into livro (nome_livro, autor, paginas_total, paginas_lida, paginas_faltando, status) values (3,3,3,3,3,'lido');
insert into livro (nome_livro, autor, paginas_total, paginas_lida, paginas_faltando, status) values (4,4,4,4,4,'lido');
insert into livro (nome_livro, autor, paginas_total, paginas_lida, paginas_faltando, status) values (5,5,5,5,5,'lido');