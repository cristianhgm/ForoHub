create table users(

id bigint not null auto_increment,
name varchar(100)not null unique,
password varchar(300)not null,
email varchar(100)not null unique,

primary key(id)


);