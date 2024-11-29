-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 10-11-2024 a las 21:20:16
-- Versión del servidor: 10.4.28-MariaDB
-- Versión de PHP: 8.2.4

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
CREATE DATABASE kadmo;
USE kadmo;
-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `calificaciones`
--

CREATE TABLE `calificaciones` (
  `idCalificacion` int(11) NOT NULL,
  `idLibro` int(11) DEFAULT NULL,
  `idUsuario` int(11) DEFAULT NULL,
  `fechaCalificacion` datetime DEFAULT current_timestamp(),
  `comentario` varchar(2000) DEFAULT NULL,
  `puntuacion` double(1,1) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `calificaciones`
--

INSERT INTO `calificaciones` (`idCalificacion`, `idLibro`, `idUsuario`, `fechaCalificacion`, `comentario`, `puntuacion`) VALUES
(1, 1, 4, '2024-11-02 00:00:00', 'Libro en excelente estado', 0.9);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `categoriaslibros`
--

CREATE TABLE `categoriaslibros` (
  `idCategoriaLibro` int(11) NOT NULL,
  `categoria` varchar(50) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `categoriaslibros`
--

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
(10, 'Policiaco');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `datosusuarios`
--

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

--
-- Volcado de datos para la tabla `datosusuarios`
--

INSERT INTO `datosusuarios` (`idDatoUsuario`, `nombres`, `apellidos`, `direccion`, `documento`, `telefono`, `edad`, `usuarioVerificado`, `idGenero`, `idUsuario`) VALUES
(1, 'Brayan Stiven', 'Arango Romero', 'Calle 43 # 09-32', '1000124235', '3164857538', 22, b'0', 2, 3),
(4, 'Brayan ', 'Ricardo', 'Calle 65 sur # 12-32', '1000352632', '3232319603', 21, b'0', 2, 6),
(6, 'Brayan ', 'Ricardo', 'Calle 65 sur # 12-32', '1000352632', '3232319603', 21, b'0', 2, 9),
(7, 'Brayan ', 'Ricardo', 'Calle 65 sur # 12-32', '1000352632', '3232319603', 21, b'0', 2, 7),
(8, 'Alison ', 'Arango', 'Calle 65 sur # 12-32', '1000352632', '3232319603', 21, b'0', 1, 5),
(9, 'asca', 'ascas', 'asc', 'ascasc', 'ascsca', 20, b'0', 2, 19),
(10, 'asca', 'ascas', 'asc', 'ascasc', 'ascsca', 20, b'0', 2, 20),
(11, 'Juan Toloso', 'Alvarez Francesa', 'Calle 16 sur # 132-32', '1205320108', '3156363464', 19, b'0', 1, 20);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `disponibilidadlibros`
--

CREATE TABLE `disponibilidadlibros` (
  `idDisponibilidadLibro` int(11) NOT NULL,
  `disponibilidad` varchar(50) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `disponibilidadlibros`
--

INSERT INTO `disponibilidadlibros` (`idDisponibilidadLibro`, `disponibilidad`) VALUES
(1, 'Disponible'),
(2, 'Vendido'),
(3, 'Eliminado');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `editoriales`
--

CREATE TABLE `editoriales` (
  `idEditoriales` int(11) NOT NULL,
  `nombre` varchar(200) DEFAULT NULL,
  `telefono` varchar(10) DEFAULT NULL,
  `direccion` varchar(250) DEFAULT NULL,
  `idUsuario` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `editoriales`
--

INSERT INTO `editoriales` (`idEditoriales`, `nombre`, `telefono`, `direccion`, `idUsuario`) VALUES
(1, 'La casa de la moneda', '3232319714', 'Calle 80 # 23 -54', 2);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `estadoslibros`
--

CREATE TABLE `estadoslibros` (
  `idEstadosLibros` int(11) NOT NULL,
  `estado` varchar(50) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `estadoslibros`
--

INSERT INTO `estadoslibros` (`idEstadosLibros`, `estado`) VALUES
(1, 'NUEVO'),
(2, 'USADO');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `estadostransacciones`
--

CREATE TABLE `estadostransacciones` (
  `idEstadoTransaccion` int(11) NOT NULL,
  `estado` varchar(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `estadostransacciones`
--

INSERT INTO `estadostransacciones` (`idEstadoTransaccion`, `estado`) VALUES
(1, 'ACEPTADO'),
(2, 'PENDIENTE'),
(3, 'RECHAZADO'),
(4, 'CANCELADO');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `generos`
--

CREATE TABLE `generos` (
  `idGenero` int(11) NOT NULL,
  `genero` varchar(50) DEFAULT NULL,
  `fechaPublicacion` datetime DEFAULT current_timestamp()
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `generos`
--

INSERT INTO `generos` (`idGenero`, `genero`, `fechaPublicacion`) VALUES
(1, 'Femenino', '2024-11-01 20:19:46'),
(2, 'Maculino', '2024-11-01 20:19:46');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `imageneslibros`
--

CREATE TABLE `imageneslibros` (
  `idImagenLibro` int(11) NOT NULL,
  `url` varchar(250) DEFAULT NULL,
  `idLibro` int(11) DEFAULT NULL,
  `fechaRegistro` datetime DEFAULT current_timestamp()
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `libros`
--

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

--
-- Volcado de datos para la tabla `libros`
--

INSERT INTO `libros` (`idLibros`, `nombre`, `autor`, `precio`, `descripcion`, `idEstadosLibros`, `idDisponibilidadLibro`, `idCategoriaLibro`, `fechaModificacion`) VALUES
(1, 'Harry Potter: La piedra filosofal', 'J. K. Rolling', 45000.00, 'Harry Potter y la piedra filosofal. Es la historia sobre un niño llamado Harry Potter que vive en el armario debajo de las escaleras de una casa propiedad del señor y la señora Dursley, y que descubre que es mago, escrita por J.K Rowling.', 2, 1, 9, NULL);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `librosfavoritos`
--

CREATE TABLE `librosfavoritos` (
  `idLibroFavorito` int(11) NOT NULL,
  `idLibro` int(11) DEFAULT NULL,
  `idUsuario` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `librospublicados`
--

CREATE TABLE `librospublicados` (
  `idLibrosPublicados` int(11) NOT NULL,
  `idLibro` int(11) DEFAULT NULL,
  `idUsuario` int(11) DEFAULT NULL,
  `fechaPublicacion` datetime DEFAULT current_timestamp()
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `librospublicados`
--

INSERT INTO `librospublicados` (`idLibrosPublicados`, `idLibro`, `idUsuario`, `fechaPublicacion`) VALUES
(1, 1, 4, '2024-11-01 20:51:33');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `membresias`
--

CREATE TABLE `membresias` (
  `idMembresia` int(11) NOT NULL,
  `tipo` varchar(20) DEFAULT NULL,
  `estado` bit(1) DEFAULT NULL,
  `fechaIncio` datetime DEFAULT current_timestamp(),
  `fechaFin` datetime DEFAULT current_timestamp(),
  `idUsuario` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `membresias`
--

INSERT INTO `membresias` (`idMembresia`, `tipo`, `estado`, `fechaIncio`, `fechaFin`, `idUsuario`) VALUES
(1, 'MENSUAL', b'1', '2024-11-01 20:32:03', '2024-12-01 20:14:47', 4);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `publicacionesautores`
--

CREATE TABLE `publicacionesautores` (
  `idPublicacionAutor` int(11) NOT NULL,
  `titulo` varchar(200) DEFAULT NULL,
  `idUsuario` int(11) DEFAULT NULL,
  `descripcion` varchar(2000) DEFAULT NULL,
  `fechaPublicacion` datetime DEFAULT current_timestamp()
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `publicacionesautores`
--

INSERT INTO `publicacionesautores` (`idPublicacionAutor`, `titulo`, `idUsuario`, `descripcion`, `fechaPublicacion`) VALUES
(1, 'La mancha', 3, 'Cuenta la historia que una vez habia un lorem impusn pron asclr lasoa oitrdl slacvs cvmlsda asic weqoljnsivn qwnjdauscn enbfrngsnl fwngiowsn', '2024-11-01 20:27:37');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `roles`
--

CREATE TABLE `roles` (
  `idRol` int(11) NOT NULL,
  `rol` varchar(50) DEFAULT NULL,
  `fechaRegistro` datetime DEFAULT current_timestamp()
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `roles`
--

INSERT INTO `roles` (`idRol`, `rol`, `fechaRegistro`) VALUES
(1, 'Administrador', '2024-11-01 20:13:10'),
(2, 'Editorial', '2024-11-01 20:13:10'),
(3, 'Autor', '2024-11-01 20:13:10'),
(4, 'Cliente', '2024-11-01 20:13:10'),
(5, 'AutorIndependiente', '2024-11-01 20:13:10');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `transacciones`
--

CREATE TABLE `transacciones` (
  `idTransaccion` int(11) NOT NULL,
  `idLibro` int(11) DEFAULT NULL,
  `idUsuario` int(11) DEFAULT NULL,
  `fechaTransaccion` datetime DEFAULT current_timestamp(),
  `total` decimal(10,2) DEFAULT NULL,
  `idEstadoTransaccion` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `transacciones`
--

INSERT INTO `transacciones` (`idTransaccion`, `idLibro`, `idUsuario`, `fechaTransaccion`, `total`, `idEstadoTransaccion`) VALUES
(1, 1, 4, '2024-11-02 08:13:56', 55000.00, 1);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `usuarios`
--

CREATE TABLE `usuarios` (
  `idUsuario` int(11) NOT NULL,
  `correo` varchar(250) DEFAULT NULL,
  `contraseña` varchar(250) DEFAULT NULL,
  `idRol` int(11) DEFAULT NULL,
  `fechaRegistro` datetime DEFAULT current_timestamp()
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `usuarios`
--

INSERT INTO `usuarios` (`idUsuario`, `correo`, `contraseña`, `idRol`, `fechaRegistro`) VALUES
(1, 'barango@uniempresarial.edu.co', 'omglolwtf22', 1, '2024-11-01 20:14:47'),
(2, 'lacasa@moneda.com', 'omglolwt', 2, '2024-11-01 20:18:14'),
(3, 'omglolwtf651@gmail.com', 'omglolwtf22', 4, '2024-11-01 20:21:32'),
(4, 'egallo@uniempresarial.edu.co', 'elmacho123', 3, '2024-11-01 20:27:17'),
(5, 'omglolwtf652@gmail.com', 'omglolwtf22', 4, '2024-11-01 20:21:32'),
(6, 'omglolwtf655@gmail.com', 'omglolwtf123415', 4, '2024-11-01 20:21:32'),
(7, 'omglolwtf660@gmail.com', 'omglolwtf123415', 4, '2024-11-01 20:21:32'),
(8, 'omglolwtf60@gmail.com', 'omglolwtf123415', 4, NULL),
(9, 'omglolwt0@gmail.com', 'omglolwtf123415', 4, NULL),
(10, 'omglol0@gmail.com', 'omglolwtf415', 4, NULL),
(11, NULL, NULL, NULL, NULL),
(12, 'asc', 'ASCASCASCASCASC', 4, NULL),
(13, 'asc', 'ascascsbvdfbdbdf', 3, NULL),
(14, 'asc', 'sacascasc', 4, NULL),
(15, 'asc', 'ascascascascasc', 4, NULL),
(16, 'asc', 'ascadbfggndbvsd', 3, NULL),
(17, 'asc', 'ascascasc', 4, NULL),
(18, 'asc', 'ascascas', 3, NULL),
(19, 'asc', 'ascascasc', 3, NULL),
(20, 'asc', 'wevsadsdv', 3, NULL);

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `calificaciones`
--
ALTER TABLE `calificaciones`
  ADD PRIMARY KEY (`idCalificacion`),
  ADD KEY `idLibro` (`idLibro`),
  ADD KEY `idUsuario` (`idUsuario`);

--
-- Indices de la tabla `categoriaslibros`
--
ALTER TABLE `categoriaslibros`
  ADD PRIMARY KEY (`idCategoriaLibro`);

--
-- Indices de la tabla `datosusuarios`
--
ALTER TABLE `datosusuarios`
  ADD PRIMARY KEY (`idDatoUsuario`),
  ADD KEY `idUsuario` (`idUsuario`),
  ADD KEY `idGenero` (`idGenero`);

--
-- Indices de la tabla `disponibilidadlibros`
--
ALTER TABLE `disponibilidadlibros`
  ADD PRIMARY KEY (`idDisponibilidadLibro`);

--
-- Indices de la tabla `editoriales`
--
ALTER TABLE `editoriales`
  ADD PRIMARY KEY (`idEditoriales`),
  ADD KEY `idUsuario` (`idUsuario`);

--
-- Indices de la tabla `estadoslibros`
--
ALTER TABLE `estadoslibros`
  ADD PRIMARY KEY (`idEstadosLibros`);

--
-- Indices de la tabla `estadostransacciones`
--
ALTER TABLE `estadostransacciones`
  ADD PRIMARY KEY (`idEstadoTransaccion`);

--
-- Indices de la tabla `generos`
--
ALTER TABLE `generos`
  ADD PRIMARY KEY (`idGenero`);

--
-- Indices de la tabla `imageneslibros`
--
ALTER TABLE `imageneslibros`
  ADD PRIMARY KEY (`idImagenLibro`),
  ADD KEY `idLibro` (`idLibro`);

--
-- Indices de la tabla `libros`
--
ALTER TABLE `libros`
  ADD PRIMARY KEY (`idLibros`),
  ADD KEY `idEstadosLibros` (`idEstadosLibros`),
  ADD KEY `idDisponibilidadLibro` (`idDisponibilidadLibro`),
  ADD KEY `idCategoriaLibro` (`idCategoriaLibro`);

--
-- Indices de la tabla `librosfavoritos`
--
ALTER TABLE `librosfavoritos`
  ADD PRIMARY KEY (`idLibroFavorito`),
  ADD KEY `idLibro` (`idLibro`),
  ADD KEY `idUsuario` (`idUsuario`);

--
-- Indices de la tabla `librospublicados`
--
ALTER TABLE `librospublicados`
  ADD PRIMARY KEY (`idLibrosPublicados`),
  ADD KEY `idLibro` (`idLibro`),
  ADD KEY `idUsuario` (`idUsuario`);

--
-- Indices de la tabla `membresias`
--
ALTER TABLE `membresias`
  ADD PRIMARY KEY (`idMembresia`),
  ADD KEY `idUsuario` (`idUsuario`);

--
-- Indices de la tabla `publicacionesautores`
--
ALTER TABLE `publicacionesautores`
  ADD PRIMARY KEY (`idPublicacionAutor`),
  ADD KEY `idUsuario` (`idUsuario`);

--
-- Indices de la tabla `roles`
--
ALTER TABLE `roles`
  ADD PRIMARY KEY (`idRol`);

--
-- Indices de la tabla `transacciones`
--
ALTER TABLE `transacciones`
  ADD PRIMARY KEY (`idTransaccion`),
  ADD KEY `idEstadoTransaccion` (`idEstadoTransaccion`),
  ADD KEY `idLibro` (`idLibro`),
  ADD KEY `idUsuario` (`idUsuario`);

--
-- Indices de la tabla `usuarios`
--
ALTER TABLE `usuarios`
  ADD PRIMARY KEY (`idUsuario`),
  ADD KEY `idRol` (`idRol`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `calificaciones`
--
ALTER TABLE `calificaciones`
  MODIFY `idCalificacion` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT de la tabla `categoriaslibros`
--
ALTER TABLE `categoriaslibros`
  MODIFY `idCategoriaLibro` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=11;

--
-- AUTO_INCREMENT de la tabla `datosusuarios`
--
ALTER TABLE `datosusuarios`
  MODIFY `idDatoUsuario` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=12;

--
-- AUTO_INCREMENT de la tabla `disponibilidadlibros`
--
ALTER TABLE `disponibilidadlibros`
  MODIFY `idDisponibilidadLibro` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT de la tabla `editoriales`
--
ALTER TABLE `editoriales`
  MODIFY `idEditoriales` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT de la tabla `estadoslibros`
--
ALTER TABLE `estadoslibros`
  MODIFY `idEstadosLibros` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT de la tabla `estadostransacciones`
--
ALTER TABLE `estadostransacciones`
  MODIFY `idEstadoTransaccion` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- AUTO_INCREMENT de la tabla `generos`
--
ALTER TABLE `generos`
  MODIFY `idGenero` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT de la tabla `imageneslibros`
--
ALTER TABLE `imageneslibros`
  MODIFY `idImagenLibro` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `libros`
--
ALTER TABLE `libros`
  MODIFY `idLibros` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT de la tabla `librosfavoritos`
--
ALTER TABLE `librosfavoritos`
  MODIFY `idLibroFavorito` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `librospublicados`
--
ALTER TABLE `librospublicados`
  MODIFY `idLibrosPublicados` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT de la tabla `membresias`
--
ALTER TABLE `membresias`
  MODIFY `idMembresia` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT de la tabla `publicacionesautores`
--
ALTER TABLE `publicacionesautores`
  MODIFY `idPublicacionAutor` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT de la tabla `roles`
--
ALTER TABLE `roles`
  MODIFY `idRol` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

--
-- AUTO_INCREMENT de la tabla `transacciones`
--
ALTER TABLE `transacciones`
  MODIFY `idTransaccion` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT de la tabla `usuarios`
--
ALTER TABLE `usuarios`
  MODIFY `idUsuario` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=21;

--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `calificaciones`
--
ALTER TABLE `calificaciones`
  ADD CONSTRAINT `calificaciones_ibfk_1` FOREIGN KEY (`idLibro`) REFERENCES `libros` (`idLibros`),
  ADD CONSTRAINT `calificaciones_ibfk_2` FOREIGN KEY (`idUsuario`) REFERENCES `usuarios` (`idUsuario`);

--
-- Filtros para la tabla `datosusuarios`
--
ALTER TABLE `datosusuarios`
  ADD CONSTRAINT `datosusuarios_ibfk_1` FOREIGN KEY (`idUsuario`) REFERENCES `usuarios` (`idUsuario`),
  ADD CONSTRAINT `datosusuarios_ibfk_2` FOREIGN KEY (`idGenero`) REFERENCES `generos` (`idGenero`);

--
-- Filtros para la tabla `editoriales`
--
ALTER TABLE `editoriales`
  ADD CONSTRAINT `editoriales_ibfk_1` FOREIGN KEY (`idUsuario`) REFERENCES `usuarios` (`idUsuario`);

--
-- Filtros para la tabla `imageneslibros`
--
ALTER TABLE `imageneslibros`
  ADD CONSTRAINT `imageneslibros_ibfk_1` FOREIGN KEY (`idLibro`) REFERENCES `libros` (`idLibros`);

--
-- Filtros para la tabla `libros`
--
ALTER TABLE `libros`
  ADD CONSTRAINT `libros_ibfk_1` FOREIGN KEY (`idEstadosLibros`) REFERENCES `estadoslibros` (`idEstadosLibros`),
  ADD CONSTRAINT `libros_ibfk_2` FOREIGN KEY (`idDisponibilidadLibro`) REFERENCES `disponibilidadlibros` (`idDisponibilidadLibro`),
  ADD CONSTRAINT `libros_ibfk_3` FOREIGN KEY (`idCategoriaLibro`) REFERENCES `categoriaslibros` (`idCategoriaLibro`);

--
-- Filtros para la tabla `librosfavoritos`
--
ALTER TABLE `librosfavoritos`
  ADD CONSTRAINT `librosfavoritos_ibfk_1` FOREIGN KEY (`idLibro`) REFERENCES `libros` (`idLibros`),
  ADD CONSTRAINT `librosfavoritos_ibfk_2` FOREIGN KEY (`idUsuario`) REFERENCES `usuarios` (`idUsuario`);

--
-- Filtros para la tabla `librospublicados`
--
ALTER TABLE `librospublicados`
  ADD CONSTRAINT `librospublicados_ibfk_1` FOREIGN KEY (`idLibro`) REFERENCES `libros` (`idLibros`),
  ADD CONSTRAINT `librospublicados_ibfk_2` FOREIGN KEY (`idUsuario`) REFERENCES `usuarios` (`idUsuario`);

--
-- Filtros para la tabla `membresias`
--
ALTER TABLE `membresias`
  ADD CONSTRAINT `membresias_ibfk_1` FOREIGN KEY (`idUsuario`) REFERENCES `usuarios` (`idUsuario`);

--
-- Filtros para la tabla `publicacionesautores`
--
ALTER TABLE `publicacionesautores`
  ADD CONSTRAINT `publicacionesautores_ibfk_1` FOREIGN KEY (`idUsuario`) REFERENCES `usuarios` (`idUsuario`);

--
-- Filtros para la tabla `transacciones`
--
ALTER TABLE `transacciones`
  ADD CONSTRAINT `transacciones_ibfk_1` FOREIGN KEY (`idEstadoTransaccion`) REFERENCES `estadostransacciones` (`idEstadoTransaccion`),
  ADD CONSTRAINT `transacciones_ibfk_2` FOREIGN KEY (`idLibro`) REFERENCES `libros` (`idLibros`),
  ADD CONSTRAINT `transacciones_ibfk_3` FOREIGN KEY (`idUsuario`) REFERENCES `usuarios` (`idUsuario`);

--
-- Filtros para la tabla `usuarios`
--
ALTER TABLE `usuarios`
  ADD CONSTRAINT `usuarios_ibfk_1` FOREIGN KEY (`idRol`) REFERENCES `roles` (`idRol`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
