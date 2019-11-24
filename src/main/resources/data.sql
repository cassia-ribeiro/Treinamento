insert into tb_estado (id_estado, ds_sigla) values (1, 'MG');
insert into tb_estado (id_estado, ds_sigla) values (1, 'RJ');

insert into tb_cidade (id_cidade, ds_nome, ds_estado) values (1, 'Belo Horizonte',1);
insert into tb_cidade (id_cidade, ds_nome, ds_estado) values (2, 'Nova Lima',1);
insert into tb_cidade (id_cidade, ds_nome, ds_estado) values (3, 'Contagem',1);
insert into tb_cidade (id_cidade, ds_nome, ds_estado) values (4, 'Santa Barbara',1);
insert into tb_cidade (id_cidade, ds_nome, ds_estado) values (5, 'Petropolis',2);

insert into tb_bairro (id_bairro, ds_nome, id_cidade) values (1, 'Centro', 1);
insert into tb_bairro (id_bairro, ds_nome, id_cidade) values (2, 'Funcionarios', 1);
insert into tb_bairro (id_bairro, ds_nome, id_cidade) values (3, 'Mangabeiras', 1);
insert into tb_bairro (id_bairro, ds_nome, id_cidade) values (4, 'Centro', 2);

insert into tb_endereco (id_endereco, ds_logradouro, en_tipo_local) values (1, 'Afonso Pena', 'AVENIDA');
insert into tb_endereco (id_endereco, ds_logradouro, en_tipo_local) values (2, 'Rio Grande do Norte', 'RUA');
insert into tb_endereco (id_endereco, ds_logradouro, en_tipo_local) values (3, 'Tiradentes', 'RUA');


insert into tb_cep (id_cep, ds_cep, id_endereco) values (1, '30120002', '1');
insert into tb_cep (id_cep, ds_cep, id_endereco) values (2, '30170102', '1');
insert into tb_cep (id_cep, ds_cep, id_endereco) values (3, '30170102', '1');
insert into tb_cep (id_cep, ds_cep, id_endereco) values (4, '34000129', '3');

insert into tb_complemento (id_complemento_endereco, ds_complemento, nm_numero, id_endereco) values (1, '8o andar', 981, '1');
insert into tb_complemento (id_complemento_endereco, ds_complemento, nm_numero, id_endereco) values (2, '', 541, '1');
insert into tb_complemento (id_complemento_endereco, ds_complemento, nm_numero, id_endereco) values (2, '', 541, '1');
