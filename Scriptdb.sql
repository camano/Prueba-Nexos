create database pruebanexos;

INSERT INTO cargo  (nombre) values('Asesor de Ventas '),('Administrador'),('Soporte');

insert into usuario (nombre,edad,fecha_ingreso,cargo_id) values('Jonathan',23,current_date,1);
insert into usuario (nombre,edad,fecha_ingreso,cargo_id) values('Admin',40,'2022-01-01',2);
insert into usuario (nombre,edad,fecha_ingreso,cargo_id) values('Support',20,'2022-02-01',3);

select * from usuario u ;

select * from  mercancia;