create database performacao;

create table cliente (
    id bigint primary key auto_increment not null,
    cpf varchar(15) not null,
    data_nascimento date not null,
    email varchar(45) not null,
    estado_civil varchar(15) not null,
    genero varchar(25) not null,
    nome varchar(55) not null,
    profissao varchar(25) not null,
    telefone varchar(15) not null,
    endereco_id bigint not null,
    CONSTRAINT unique_cliente  
    UNIQUE(id,cpf)  
);

create table endereco (
    id bigint primary key auto_increment not null,
    bairro varchar(45) not null,
    cep varchar(9) not null,
    cidade varchar(30) not null,
    complemento varchar(10),
    estado varchar(2) not null,
    logradouro varchar(100) not null,
    numero integer not null,
    pais varchar(25) not null,
    tipo varchar(12) not null
);

create table servico (
    id bigint primary key auto_increment not null,
    descricao varchar(255) not null,
    preco numeric not null,
    quantidade_horas numeric not null
  );

create table transacao (
       id bigint primary key auto_increment not null,
        data timestamp not null,
        horas_totais numeric not null,
        valor_total numeric not null,
        cliente_id bigint,
    	INDEX cliente_ind (cliente_id),
    	FOREIGN KEY (cliente_id)
        REFERENCES cliente(id)
    );


 alter table cliente 
    add constraint fk_endereco 
    foreign key (endereco_id) 
    references endereco (id);

alter table transacao
       add constraint fk_cliente 
       foreign key (cliente_id) 
       references cliente (id);       

create table transacoes_servicos (
	id bigint primary key auto_increment not null,
	transacao_id bigint,
    	INDEX transacao_ind (transacao_id),
    	FOREIGN KEY (transacao_id)
        REFERENCES transacao(id),
    servico_id bigint,
    	INDEX servico_ind (servico_id),
    	FOREIGN KEY (servico_id)
        REFERENCES servico(id)    
);     