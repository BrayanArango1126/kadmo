-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 09-12-2024 a las 06:59:04
-- Versión del servidor: 10.4.32-MariaDB
-- Versión de PHP: 8.2.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `kadmodb`
--

CREATE TABLE `calificaciones` (
  `idCalificacion` int(11) NOT NULL,
  `idLibro` int(11) DEFAULT NULL,
  `idUsuario` int(11) DEFAULT NULL,
  `fechaCalificacion` datetime DEFAULT current_timestamp(),
  `comentario` varchar(2000) DEFAULT NULL,
  `puntuacion` double(1,1) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

CREATE TABLE `categoriaslibros` (
  `idCategoriaLibro` int(11) NOT NULL,
  `categoria` varchar(50) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

INSERT INTO `categoriaslibros` (`idCategoriaLibro`, `categoria`) VALUES
(1, 'Historia'),
(2, 'Romance'),
(3, 'Terror'),
(4, 'Suspenso'),
(5, 'Novela'),
(6, 'Tesis'),
(7, 'Artículo Científico'),
(8, 'Biología'),
(9, 'Aventura'),
(10, 'Policiaco'),
(11, 'Ciencias políticas');

CREATE TABLE `datosusuarios` (
  `idDatoUsuario` int(11) NOT NULL,
  `nombres` varchar(80) DEFAULT NULL,
  `apellidos` varchar(80) DEFAULT NULL,
  `direccion` varchar(250) DEFAULT NULL,
  `documento` varchar(10) DEFAULT NULL,
  `telefono` varchar(10) DEFAULT NULL,
  `edad` int(11) DEFAULT NULL,
  `usuarioVerificado` bit(1) DEFAULT NULL,
  `idGenero` int(11) DEFAULT NULL,
  `idUsuario` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

CREATE TABLE `disponibilidadlibros` (
  `idDisponibilidadLibro` int(11) NOT NULL,
  `disponibilidad` varchar(50) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

INSERT INTO `disponibilidadlibros` (`idDisponibilidadLibro`, `disponibilidad`) VALUES
(1, 'Disponible'),
(2, 'Vendido'),
(3, 'Retirado'),
(4, 'En consulta');

CREATE TABLE `editoriales` (
  `idEditoriales` int(11) NOT NULL,
  `nombre` varchar(200) DEFAULT NULL,
  `telefono` varchar(10) DEFAULT NULL,
  `direccion` varchar(250) DEFAULT NULL,
  `idUsuario` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

CREATE TABLE `estadoslibros` (
  `idEstadosLibros` int(11) NOT NULL,
  `estado` varchar(50) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

INSERT INTO `estadoslibros` (`idEstadosLibros`, `estado`) VALUES
(1, 'NUEVO'),
(2, 'USADO');

CREATE TABLE `estadostransacciones` (
  `idEstadoTransaccion` int(11) NOT NULL,
  `estado` varchar(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;


INSERT INTO `estadostransacciones` (`idEstadoTransaccion`, `estado`) VALUES
(1, 'ACEPTADO'),
(2, 'PENDIENTE'),
(3, 'RECHAZADO'),
(4, 'CANCELADO');

CREATE TABLE `generos` (
  `idGenero` int(11) NOT NULL,
  `genero` varchar(50) DEFAULT NULL,
  `fechaPublicacion` datetime DEFAULT current_timestamp()
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;


INSERT INTO `generos` (`idGenero`, `genero`, `fechaPublicacion`) VALUES
(1, 'Femenino', '2024-11-01 20:19:46'),
(2, 'Maculino', '2024-11-01 20:19:46'),
(3, 'Prefiero no Responder', NULL);

CREATE TABLE `imageneslibros` (
  `idImagenLibro` int(11) NOT NULL,
  `url` varchar(250) DEFAULT NULL,
  `idLibro` int(11) DEFAULT NULL,
  `fechaRegistro` datetime DEFAULT current_timestamp()
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

CREATE TABLE `libros` (
  `idLibros` int(11) NOT NULL,
  `nombre` varchar(100) DEFAULT NULL,
  `autor` varchar(100) DEFAULT NULL,
  `precio` double(10,2) DEFAULT NULL,
  `descripcion` varchar(3000) DEFAULT NULL,
  `idEstadosLibros` int(11) DEFAULT NULL,
  `idDisponibilidadLibro` int(11) DEFAULT NULL,
  `idCategoriaLibro` int(11) DEFAULT NULL,
  `fechaModificacion` datetime DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

CREATE TABLE `librosfavoritos` (
  `idLibroFavorito` int(11) NOT NULL,
  `idLibro` int(11) DEFAULT NULL,
  `idUsuario` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;


CREATE TABLE `librospublicados` (
  `idLibrosPublicados` int(11) NOT NULL,
  `idLibro` int(11) DEFAULT NULL,
  `idUsuario` int(11) DEFAULT NULL,
  `fechaPublicacion` datetime DEFAULT current_timestamp()
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

CREATE TABLE `membresias` (
  `idMembresia` int(11) NOT NULL,
  `tipo` varchar(20) DEFAULT NULL,
  `estado` bit(1) DEFAULT NULL,
  `fechaIncio` datetime DEFAULT current_timestamp(),
  `fechaFin` datetime DEFAULT current_timestamp(),
  `pago` decimal(10,2) DEFAULT NULL,
  `idUsuario` int(11) DEFAULT NULL,
  `idTarjetaCredito` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;


CREATE TABLE `publicacionesautores` (
  `idPublicacionAutor` int(11) NOT NULL,
  `titulo` varchar(200) DEFAULT NULL,
  `idUsuario` int(11) DEFAULT NULL,
  `descripcion` varchar(2000) DEFAULT NULL,
  `fechaPublicacion` datetime DEFAULT current_timestamp()
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

CREATE TABLE `roles` (
  `idRol` int(11) NOT NULL,
  `rol` varchar(50) DEFAULT NULL,
  `fechaRegistro` datetime DEFAULT current_timestamp()
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

INSERT INTO `roles` (`idRol`, `rol`, `fechaRegistro`) VALUES
(1, 'Administrador', '2024-11-01 20:13:10'),
(2, 'Editorial', '2024-11-01 20:13:10'),
(3, 'Autor', '2024-11-01 20:13:10'),
(4, 'Cliente', '2024-11-01 20:13:10');

CREATE TABLE `tarjetacredito` (
  `idTarjetaCredito` int(11) NOT NULL,
  `idUsuario` int(11) DEFAULT NULL,
  `titular` varchar(150) DEFAULT NULL,
  `numeroTarjeta` varchar(18) DEFAULT NULL,
  `cvs` varchar(60) DEFAULT NULL,
  `fechaExpiracion` date DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

CREATE TABLE `transacciones` (
  `idTransaccion` int(11) NOT NULL,
  `idLibro` int(11) DEFAULT NULL,
  `idUsuario` int(11) DEFAULT NULL,
  `fechaTransaccion` datetime DEFAULT current_timestamp(),
  `total` decimal(10,2) DEFAULT NULL,
  `idEstadoTransaccion` int(11) DEFAULT NULL,
  `idTarjetaCredito` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

CREATE TABLE `usuarios` (
  `idUsuario` int(11) NOT NULL,
  `correo` varchar(250) DEFAULT NULL,
  `contraseña` varchar(250) DEFAULT NULL,
  `idRol` int(11) DEFAULT NULL,
  `fechaRegistro` datetime DEFAULT current_timestamp()
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

ALTER TABLE `calificaciones`
  ADD PRIMARY KEY (`idCalificacion`),
  ADD KEY `idLibro` (`idLibro`),
  ADD KEY `idUsuario` (`idUsuario`);  

ALTER TABLE `categoriaslibros`
  ADD PRIMARY KEY (`idCategoriaLibro`);

ALTER TABLE `datosusuarios`
  ADD PRIMARY KEY (`idDatoUsuario`),
  ADD KEY `idUsuario` (`idUsuario`),
  ADD KEY `idGenero` (`idGenero`);

ALTER TABLE `disponibilidadlibros`
  ADD PRIMARY KEY (`idDisponibilidadLibro`);

ALTER TABLE `editoriales`
  ADD PRIMARY KEY (`idEditoriales`),
  ADD KEY `idUsuario` (`idUsuario`);

ALTER TABLE `estadoslibros`
  ADD PRIMARY KEY (`idEstadosLibros`);

ALTER TABLE `estadostransacciones`
  ADD PRIMARY KEY (`idEstadoTransaccion`);

ALTER TABLE `generos`
  ADD PRIMARY KEY (`idGenero`);

ALTER TABLE `imageneslibros`
  ADD PRIMARY KEY (`idImagenLibro`),
  ADD KEY `idLibro` (`idLibro`);

ALTER TABLE `libros`
  ADD PRIMARY KEY (`idLibros`),
  ADD KEY `idEstadosLibros` (`idEstadosLibros`),
  ADD KEY `idDisponibilidadLibro` (`idDisponibilidadLibro`),
  ADD KEY `idCategoriaLibro` (`idCategoriaLibro`);

ALTER TABLE `librosfavoritos`
  ADD PRIMARY KEY (`idLibroFavorito`),
  ADD KEY `idLibro` (`idLibro`),
  ADD KEY `idUsuario` (`idUsuario`);

ALTER TABLE `librospublicados`
  ADD PRIMARY KEY (`idLibrosPublicados`),
  ADD KEY `idLibro` (`idLibro`),
  ADD KEY `idUsuario` (`idUsuario`);

ALTER TABLE `membresias`
  ADD PRIMARY KEY (`idMembresia`),
  ADD KEY `idUsuario` (`idUsuario`),
  ADD KEY `idTarjetaCredito` (`idTarjetaCredito`);

ALTER TABLE `publicacionesautores`
  ADD PRIMARY KEY (`idPublicacionAutor`),
  ADD KEY `idUsuario` (`idUsuario`);

ALTER TABLE `roles`
  ADD PRIMARY KEY (`idRol`);

ALTER TABLE `tarjetacredito`
  ADD PRIMARY KEY (`idTarjetaCredito`),
  ADD KEY `idUsuario` (`idUsuario`);

ALTER TABLE `transacciones`
  ADD PRIMARY KEY (`idTransaccion`),
  ADD KEY `idEstadoTransaccion` (`idEstadoTransaccion`),
  ADD KEY `idLibro` (`idLibro`),
  ADD KEY `idUsuario` (`idUsuario`),
  ADD KEY `idTarjetaCredito` (`idTarjetaCredito`);

ALTER TABLE `usuarios`
  ADD PRIMARY KEY (`idUsuario`),
  ADD KEY `idRol` (`idRol`);



ALTER TABLE `calificaciones`
  MODIFY `idCalificacion` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

ALTER TABLE `categoriaslibros`
  MODIFY `idCategoriaLibro` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=13;

ALTER TABLE `datosusuarios`
  MODIFY `idDatoUsuario` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=19;

ALTER TABLE `disponibilidadlibros`
  MODIFY `idDisponibilidadLibro` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

ALTER TABLE `editoriales`
  MODIFY `idEditoriales` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;

ALTER TABLE `estadoslibros`
  MODIFY `idEstadosLibros` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

ALTER TABLE `estadostransacciones`
  MODIFY `idEstadoTransaccion` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=12;

ALTER TABLE `generos`
  MODIFY `idGenero` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

ALTER TABLE `imageneslibros`
  MODIFY `idImagenLibro` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

ALTER TABLE `libros`
  MODIFY `idLibros` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;

ALTER TABLE `librosfavoritos`
  MODIFY `idLibroFavorito` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=10;

ALTER TABLE `librospublicados`
  MODIFY `idLibrosPublicados` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;

ALTER TABLE `membresias`
  MODIFY `idMembresia` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

ALTER TABLE `publicacionesautores`
  MODIFY `idPublicacionAutor` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

ALTER TABLE `roles`
  MODIFY `idRol` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=11;

ALTER TABLE `tarjetacredito`
  MODIFY `idTarjetaCredito` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=14;

ALTER TABLE `transacciones`
  MODIFY `idTransaccion` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

ALTER TABLE `usuarios`
  MODIFY `idUsuario` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=51;

--

ALTER TABLE `calificaciones`
  ADD CONSTRAINT `calificaciones_ibfk_1` FOREIGN KEY (`idLibro`) REFERENCES `libros` (`idLibros`),
  ADD CONSTRAINT `calificaciones_ibfk_2` FOREIGN KEY (`idUsuario`) REFERENCES `usuarios` (`idUsuario`);

ALTER TABLE `datosusuarios`
  ADD CONSTRAINT `datosusuarios_ibfk_1` FOREIGN KEY (`idUsuario`) REFERENCES `usuarios` (`idUsuario`),
  ADD CONSTRAINT `datosusuarios_ibfk_2` FOREIGN KEY (`idGenero`) REFERENCES `generos` (`idGenero`);

ALTER TABLE `editoriales`
  ADD CONSTRAINT `editoriales_ibfk_1` FOREIGN KEY (`idUsuario`) REFERENCES `usuarios` (`idUsuario`);

ALTER TABLE `imageneslibros`
  ADD CONSTRAINT `imageneslibros_ibfk_1` FOREIGN KEY (`idLibro`) REFERENCES `libros` (`idLibros`);

ALTER TABLE `libros`
  ADD CONSTRAINT `libros_ibfk_1` FOREIGN KEY (`idEstadosLibros`) REFERENCES `estadoslibros` (`idEstadosLibros`),
  ADD CONSTRAINT `libros_ibfk_2` FOREIGN KEY (`idDisponibilidadLibro`) REFERENCES `disponibilidadlibros` (`idDisponibilidadLibro`),
  ADD CONSTRAINT `libros_ibfk_3` FOREIGN KEY (`idCategoriaLibro`) REFERENCES `categoriaslibros` (`idCategoriaLibro`);

ALTER TABLE `librosfavoritos`
  ADD CONSTRAINT `librosfavoritos_ibfk_1` FOREIGN KEY (`idLibro`) REFERENCES `libros` (`idLibros`),
  ADD CONSTRAINT `librosfavoritos_ibfk_2` FOREIGN KEY (`idUsuario`) REFERENCES `usuarios` (`idUsuario`);

ALTER TABLE `librospublicados`
  ADD CONSTRAINT `librospublicados_ibfk_1` FOREIGN KEY (`idLibro`) REFERENCES `libros` (`idLibros`),
  ADD CONSTRAINT `librospublicados_ibfk_2` FOREIGN KEY (`idUsuario`) REFERENCES `usuarios` (`idUsuario`);

ALTER TABLE `membresias`
  ADD CONSTRAINT `membresias_ibfk_1` FOREIGN KEY (`idUsuario`) REFERENCES `usuarios` (`idUsuario`),
  ADD CONSTRAINT `membresias_ibfk_2` FOREIGN KEY (`idTarjetaCredito`) REFERENCES `tarjetacredito` (`idTarjetaCredito`);

ALTER TABLE `publicacionesautores`
  ADD CONSTRAINT `publicacionesautores_ibfk_1` FOREIGN KEY (`idUsuario`) REFERENCES `usuarios` (`idUsuario`);

ALTER TABLE `tarjetacredito`
  ADD CONSTRAINT `tarjetacredito_ibfk_1` FOREIGN KEY (`idUsuario`) REFERENCES `usuarios` (`idUsuario`);

ALTER TABLE `transacciones`
  ADD CONSTRAINT `transacciones_ibfk_1` FOREIGN KEY (`idEstadoTransaccion`) REFERENCES `estadostransacciones` (`idEstadoTransaccion`),
  ADD CONSTRAINT `transacciones_ibfk_2` FOREIGN KEY (`idLibro`) REFERENCES `libros` (`idLibros`),
  ADD CONSTRAINT `transacciones_ibfk_3` FOREIGN KEY (`idUsuario`) REFERENCES `usuarios` (`idUsuario`),
  ADD CONSTRAINT `transacciones_ibfk_4` FOREIGN KEY (`idTarjetaCredito`) REFERENCES `tarjetacredito` (`idTarjetaCredito`);

ALTER TABLE `usuarios`
  ADD CONSTRAINT `usuarios_ibfk_1` FOREIGN KEY (`idRol`) REFERENCES `roles` (`idRol`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;