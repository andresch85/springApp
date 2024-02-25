INSERT INTO tipo_personas(codigo,nombre) VALUES('1','Natural');
INSERT INTO tipo_personas(codigo,nombre) VALUES('2','Juridica');

INSERT INTO personas(cedula,nombre,apellido,estado,fecha,tipo_persona_id,imagen) VALUES('100', 'Pedro','Perez',true,NOW(),1,"imagen1.jpg");
INSERT INTO personas(cedula,nombre,apellido,estado,fecha,tipo_persona_id,imagen) VALUES('200', 'Ana','Torres',false,NOW(),2,"imagen3.jpg");
INSERT INTO personas(cedula,nombre,apellido,estado,fecha,tipo_persona_id,imagen) VALUES('300', 'Camilo','lopez',true,NOW(),1,"imagen4.jpg");
INSERT INTO personas(cedula,nombre,apellido,estado,fecha,tipo_persona_id,imagen) VALUES('400', 'Jorge','Remirez',true,NOW(),1,"imagen4.jpg");
INSERT INTO personas(cedula,nombre,apellido,estado,fecha,tipo_persona_id,imagen) VALUES('500', 'Rocio','Quintana',false,NOW(),2,"sinimagen.jpg");


INSERT INTO roles(nombre) VALUES('ROLE_USER');
INSERT INTO roles(nombre) VALUES('ROLE_ADMIN');

INSERT INTO usuarios(username,password,enabled,email) VALUES('usuario1','{noop}12345',true,'usuario1@gmail.com');
INSERT INTO usuarios(username,password,enabled,email) VALUES('usuario2','{noop}67890',true,'usuario2@gmail.com');
INSERT INTO usuarios(username,password,enabled,email) VALUES('usuario3','{noop}09876',false,'usuario3@gmail.com');
INSERT INTO usuarios(username,password,enabled,email) VALUES('usuario4','{noop}12345',true,'usuario4@gmail.com');

INSERT INTO usuario_roles(usuario_id,role_id) VALUES(1,1);
INSERT INTO usuario_roles(usuario_id,role_id) VALUES(1,2);
INSERT INTO usuario_roles(usuario_id,role_id) VALUES(2,2);
INSERT INTO usuario_roles(usuario_id,role_id) VALUES(3,1);
INSERT INTO usuario_roles(usuario_id,role_id) VALUES(4,1);