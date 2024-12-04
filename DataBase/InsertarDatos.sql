-- INSERTAR DATOS EN KADMO

USE KadmoDB;

INSERT INTO Roles (rol) VALUES
('Administrador'),
('Editorial'),
('Autor'),
('Cliente');

INSERT INTO Usuarios(correo, contraseña, idRol) VALUES
('barango@uniempresarial.edu.co', 'omglolwtf22', 1),
('lacasa@moneda.com', 'omglolwtf22', 2),
('egallo@uniempresarial.edu.co', 'elmacho123', 3),
('omglolwtf651@gmail.com', 'omglolwtf22', 4);

INSERT INTO Editoriales(nombre, telefono, direccion, idUsuario) VALUES
('La casa de la moneda', '3232319714', 'Calle 80 # 23 -54', 2);

INSERT INTO Generos (genero) VALUES
('Femenino'),
('Maculino');

INSERT INTO DatosUsuarios(nombres ,apellidos ,direccion ,documento ,telefono ,edad ,usuarioVerificado ,idGenero ,idUsuario) VALUES
('Brayan Stiven', 'Arango Romero', 'Calle 43 # 09-32', '100012423523', '3164857538', 22, 0, 2, 3);

INSERT INTO PublicacionesAutores (titulo , descripcion, idUsuario ) VALUES
('La mancha', 'Cuenta la historia que una vez habia un lorem impusn pron asclr lasoa oitrdl slacvs cvmlsda asic weqoljnsivn qwnjdauscn enbfrngsnl fwngiowsn', 3);

INSERT INTO Membresias(tipo , estado, fechaFin, pago , idUsuario, idTarjetaCredito ) VALUES
('MENSUAL', 'ACTIVA', '2024-12-01 20:14:47', 45000, 4, 1);

INSERT INTO EstadosLibros(estado) VALUES
('NUEVO'),
('USADO');

INSERT INTO DisponibilidadLibros (disponibilidad) VALUES
('Disponible'),
('Vendido'),
('Eliminado');

INSERT INTO CategoriasLibros (categoria) VALUES
('Historia'),
('Romance'),
('Terror'),
('Suspenso'),
('Novela'),
('Tesis'),
('Artículo Científico'),
('Biología'),
('Aventura'),
('Policiaco');

INSERT INTO Libros (nombre ,autor ,precio ,descripcion ,idEstadosLibros ,idDisponibilidadLibro ,idCategoriaLibro ) VALUES
('Harry Potter: La piedra filosofal', 'J. K. Rolling', 45000, 'Harry Potter y la piedra filosofal. Es la historia sobre un niño llamado Harry Potter que vive en el armario debajo de las escaleras de una casa propiedad del señor y la señora Dursley, y que descubre que es mago, escrita por J.K Rowling.', 2, 1, 9);

INSERT INTO LibrosPublicados(idLibro , idUsuario ) VALUES
(1, 4);

INSERT INTO EstadosTransacciones (estado) VALUES
('ACEPTADO'),
('PENDIENTE'),
('RECHAZADO'),
('CANCELADO');

INSERT INTO Transacciones (idLibro ,idUsuario ,total ,idEstadoTransaccion, idTarjetaCredito ) VALUES
(1, 4, 55000, 1, 1);

INSERT INTO Calificaciones (idLibro ,idUsuario ,fechaCalificacion ,comentario ,puntuacion ) VALUES 
(1, 4, '2024-11-02', 'Libro en excelente estado', 4.5);

INSERT INTO TarjetaCredito (idUsuario , titular , numeroTarjeta , cvs , fechaExpiracion) VALUES
(4, 'SANTIAGO GALLO' , '556090344567', '767', '2024-09-23');

Select * from Membresias;





