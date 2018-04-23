create database geoffrey;
use geoffrey;

create table usuarios (
	id int primary key auto_increment,
	login varchar(50) not null,
	password varchar(100) not null,
	activo boolean not null default 1
);

create table roles (
	id int primary key auto_increment,
	nombre varchar(50) not null
);

create table autorizaciones (
	id_usuario int not null,
	id_rol int not null,
	primary key (id_usuario, id_rol),
	constraint fk_autorizaciones_usuarios foreign key (id_usuario) references usuarios (id),
	constraint fk_autorizaciones_roles foreign key (id_rol) references roles (id)
);

insert into usuarios (login, password) values ('admin', '$2a$04$AGxRnbHs67Rr71XJTIqVCuoCU2kyk3zj5yiEGm.t/BFFOp19F6Oqi');  /* bcrypt */
insert into roles (nombre) values ('ROLE_ADMIN');
insert into roles (nombre) values ('ROLE_USER');
insert into autorizaciones values (1, 1);
insert into autorizaciones values (1, 2);
commit;
