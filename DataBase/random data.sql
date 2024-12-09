INSERT INTO `libros` (`idLibros`, `nombre`, `autor`, `precio`, `descripcion`, `idEstadosLibros`, `idDisponibilidadLibro`, `idCategoriaLibro`, `fechaModificacion`) VALUES
(1, 'Cien Años de Soledad', 'Gabriel García Márquez', 50000, 'Una obra maestra del realismo mágico que narra la historia de la familia Buendía en Macondo.', 1, 1, 5, '2024-12-01 10:00:00'),
(2, 'El Amor en los Tiempos del Cólera', 'Gabriel García Márquez', 45000, 'Una historia de amor que perdura a través del tiempo y las adversidades.', 1, 1, 2, '2024-12-02 11:00:00'),
(3, 'La Sombra del Viento', 'Carlos Ruiz Zafón', 60000, 'Un joven descubre un libro maldito que cambiará su vida para siempre.', 1, 1, 4, '2024-12-03 12:00:00'),
(4, '1984', 'George Orwell', 40000, 'Una distopía sobre un régimen totalitario que controla cada aspecto de la vida.', 1, 1, 11, '2024-12-04 13:00:00'),
(5, 'Don Quijote de la Mancha', 'Miguel de Cervantes', 55000, 'Las aventuras del ingenioso hidalgo Don Quijote y su escudero Sancho Panza.', 1, 1, 9, '2024-12-05 14:00:00'),
(6, 'Crónica de una Muerte Anunciada', 'Gabriel García Márquez', 35000, 'La crónica de un asesinato anunciado en un pequeño pueblo.', 1, 1, 5, '2024-12-06 15:00:00'),
(7, 'Rayuela', 'Julio Cortázar', 48000, 'Una novela innovadora que desafía las convenciones narrativas tradicionales.', 1, 1, 7, '2024-12-07 16:00:00'),
(8, 'El Alquimista', 'Paulo Coelho', 42000, 'Un joven pastor emprende un viaje en busca de su leyenda personal.', 1, 1, 3, '2024-12-08 17:00:00'),
(9, 'La Casa de los Espíritus', 'Isabel Allende', 47000, 'La saga de la familia Trueba a lo largo de varias generaciones.', 1, 1, 5, '2024-12-09 18:00:00'),
(10, 'Pedro Páramo', 'Juan Rulfo', 38000, 'Un hombre viaja al pueblo de Comala en busca de su padre y descubre un lugar fantasmagórico.', 1, 1, 3, '2024-12-10 19:00:00'),
(11, 'El Coronel No Tiene Quien le Escriba', 'Gabriel García Márquez', 30000, 'La historia de un coronel que espera una pensión que nunca llega.', 1, 1, 5, '2024-12-11 20:00:00'),
(12, 'Ficciones', 'Jorge Luis Borges', 45000, 'Una colección de cuentos que exploran conceptos filosóficos y metafísicos.', 1, 1, 7, '2024-12-12 21:00:00'),
(13, 'La Fiesta del Chivo', 'Mario Vargas Llosa', 52000, 'Una novela sobre la dictadura de Trujillo en la República Dominicana.', 1, 1, 11, '2024-12-13 22:00:00'),
(14, 'El Otoño del Patriarca', 'Gabriel García Márquez', 40000, 'Una reflexión sobre el poder absoluto y la soledad del dictador.', 1, 1, 5, '2024-12-14 23:00:00'),
(15, 'Los Detectives Salvajes', 'Roberto Bolaño', 48000, 'La búsqueda de un poeta desaparecido en México.', 1, 1, 4, '2024-12-15 10:00:00'),
(16, 'Cien Años de Soledad', 'Gabriel García Márquez', 50000, 'Una obra maestra del realismo mágico que narra la historia de la familia Buendía en Macondo.', 1, 1, 5, '2024-12-16 11:00:00'),
(17, 'El Amor en los Tiempos del Cólera', 'Gabriel García Márquez', 45000, 'Una historia de amor que perdura a través del tiempo y las adversidades.', 1, 1, 2, '2024-12-17 12:00:00'),
(18, 'La Sombra del Viento', 'Carlos Ruiz Zafón', 60000, 'Un joven descubre un libro maldito que cambiará su vida para siempre.', 1, 1, 4, '2024-12-18 13:00:00'),
(19, '1984', 'George Orwell', 40000, 'Una distopía sobre un régimen totalitario que controla cada aspecto de la vida.', 1, 1, 11, '2024-12-19 14:00:00'),
(20, 'Don Quijote de la Mancha', 'Miguel de Cervantes', 55000, 'Las aventuras del ingenioso hidalgo Don Quijote y su escudero Sancho Panza.', 1, 1, 9, '2024-12-20 15:00:00');



INSERT INTO `usuarios` (`idUsuario`, `correo`, `contraseña`, `idRol`, `fechaRegistro`) VALUES
(1, 'juan.perez@example.com', '$2b$12$TfgLOk8GQbazOsad2f1NAuARgSoanoBL7zIsrLtMHYCaGGDBCcaG2', 4, '2024-12-19 10:00:00'),
(2, 'maria.gomez@example.com', '$2b$12$Igr/ffHsLz0YK0igbqnsW.NyCFhj4qH/XoVHAHBj1qyPi7wYQtmrq', 2, '2024-12-06 10:00:00'),
(3, 'carlos.rodriguez@example.com', '$2b$12$msUD2HwywMNvkCgh/rJsxu8jT4JskwLA8SPPzZVdKg.5hR6AVHEES', 3, '2024-12-18 10:00:00'),
(4, 'ana.martinez@example.com', '$2b$12$2m1nhq5t1uzm7DLLxV/JQOLati22m.033eGNNZKxf1L53B0TUJ1V2', 4, '2024-12-06 10:00:00'),
(5, 'luis.fernandez@example.com', '$2b$12$B0k3TTSTUELOXuUBIlktTOa2oZLZdJpjD2iJWzK19Aw7BE5JKiOV2', 3, '2024-12-08 10:00:00'),
(6, 'sofia.garcia@example.com', '$2b$12$LVG5B3NBAAd2Xe0Te350We823LHR52TKc7OggwZ.7rvyLRnCHYzva', 3, '2024-12-20 10:00:00'),
(7, 'pedro.lopez@example.com', '$2b$12$MLImA2KvAuqsnH2HI33cP.pxhp7vyzgamG2aRAoGjwBBv5k72jykG', 2, '2024-12-04 10:00:00'),
(8, 'diana.ramirez@example.com', '$2b$12$gJnPQo1wC2cPIlemqgv5duZwfGPkUYazBsYyWQF/KeHf1istSNore', 4, '2024-12-08 10:00:00'),
(9, 'jorge.morales@example.com', '$2b$12$UtMN6Rqyo8t/sPjv9jzAxeUuRv4P9anPiWymxq/wX12WzAFbu/llC', 3, '2024-12-04 10:00:00'),
(10, 'camila.castillo@example.com', '$2b$12$WKbw3AkIWOajou.uDwLOEOnRvS0wDJpjwe.gwIBGukz0aVsIq/QDG', 3, '2024-12-19 10:00:00');




INSERT INTO `librosfavoritos` (`idLibroFavorito`, `idLibro`, `idUsuario`) VALUES
(1, 18, 1),
(2, 6, 6),
(3, 17, 10),
(4, 14, 1),
(5, 15, 7),
(6, 19, 6),
(7, 2, 5),
(8, 17, 4),
(9, 12, 7),
(10, 7, 4),
(11, 2, 6),
(12, 18, 6),
(13, 14, 2),
(14, 3, 9),
(15, 13, 10),
(16, 4, 6),
(17, 4, 1),
(18, 15, 5),
(19, 15, 4),
(20, 5, 6),
(21, 11, 1),
(22, 8, 2),
(23, 1, 3),
(24, 6, 1),
(25, 16, 5),
(26, 4, 4),
(27, 11, 6),
(28, 5, 8),
(29, 18, 8),
(30, 18, 6);


INSERT INTO `librospublicados` (`idLibrosPublicados`, `idLibro`, `idUsuario`, `fechaPublicacion`) VALUES
(1, 4, 6, '2024-12-06 00:00:00'),
(2, 7, 6, '2024-12-19 00:00:00'),
(3, 1, 1, '2024-10-27 00:00:00'),
(4, 20, 2, '2024-12-11 00:00:00'),
(5, 15, 8, '2024-11-21 00:00:00'),
(6, 9, 10, '2024-12-22 00:00:00'),
(7, 10, 2, '2024-11-08 00:00:00'),
(8, 14, 6, '2024-11-21 00:00:00'),
(9, 17, 9, '2024-10-12 00:00:00'),
(10, 8, 6, '2024-10-19 00:00:00'),
(11, 12, 4, '2024-10-27 00:00:00'),
(12, 16, 3, '2024-11-16 00:00:00'),
(13, 13, 6, '2024-11-07 00:00:00'),
(14, 3, 2, '2024-12-12 00:00:00'),
(15, 2, 1, '2024-10-24 00:00:00'),
(16, 18, 6, '2024-11-15 00:00:00'),
(17, 6, 8, '2024-12-23 00:00:00'),
(18, 5, 9, '2024-11-23 00:00:00'),
(19, 19, 7, '2024-11-25 00:00:00'),
(20, 11, 5, '2024-11-09 00:00:00');



INSERT INTO `tarjetacredito` (`idTarjetaCredito`, `idUsuario`, `titular`, `numeroTarjeta`, `cvs`, `fechaExpiracion`) VALUES
(1, 1, 'John Doe', '4929834092837485', '123', '2025-07-15'),
(2, 2, 'Jane Smith', '5820938409283749', '456', '2028-05-20'),
(3, 3, 'Carlos Martinez', '4902837409283748', '789', '2027-11-10'),
(4, 4, 'Ana Gonzalez', '4029387409283748', '234', '2029-03-22'),
(5, 5, 'Luis Rodriguez', '4029385702837482', '567', '2030-09-14'),
(6, 6, 'Maria Fernandez', '5039283482038475', '891', '2026-06-19'),
(7, 7, 'Pedro Lopez', '4820938409283749', '111', '2027-02-11'),
(8, 8, 'Diana Ramirez', '5920837482038475', '222', '2025-12-30'),
(9, 9, 'Jorge Morales', '4902837483928475', '333', '2028-08-15'),
(10, 10, 'Camila Castillo', '4902838409283748', '444', '2030-04-05');
