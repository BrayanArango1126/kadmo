CREATE DATABASE KadmoDB;

USE KadmoDB;

-- Creamos las tablas

CREATE TABLE Roles
(
idRol INT PRIMARY KEY AUTO_INCREMENT,
rol VARCHAR(50),
fechaRegistro DATETIME DEFAULT NOW()
);

CREATE TABLE Usuarios 
(
idUsuario INT PRIMARY KEY AUTO_INCREMENT,
correo VARCHAR(250),
contraseña VARCHAR(250),
idRol INT,
fechaRegistro DATETIME DEFAULT NOW(),
FOREIGN KEY (idRol) REFERENCES Roles(idRol)
);

CREATE TABLE Editoriales
(
idEditoriales INT PRIMARY KEY AUTO_INCREMENT,
nombre VARCHAR(200),
telefono VARCHAR(10),
direccion VARCHAR(250),
idUsuario INT,
FOREIGN KEY (idUsuario) REFERENCES Usuarios(idUsuario)
);

CREATE TABLE Generos
(
idGenero INT PRIMARY KEY AUTO_INCREMENT,
genero VARCHAR(50),
fechaPublicacion DATETIME DEFAULT NOW()
);

CREATE TABLE DatosUsuarios
(
idDatoUsuario INT PRIMARY KEY AUTO_INCREMENT,
nombres VARCHAR(80),
apellidos VARCHAR(80),
direccion VARCHAR(250),
documento VARCHAR(10),
telefono VARCHAR(10),
edad INT,
usuarioVerificado BIT,
idGenero INT,
idUsuario INT,
FOREIGN KEY (idUsuario) REFERENCES Usuarios(idUsuario),
FOREIGN KEY (idGenero) REFERENCES Generos(idGenero)
);

CREATE TABLE PublicacionesAutores 
(
idPublicacionAutor INT PRIMARY KEY AUTO_INCREMENT,
titulo VARCHAR(200),
idUsuario INT,
descripcion VARCHAR(2000),
fechaPublicacion DATETIME DEFAULT NOW(),
FOREIGN KEY (idUsuario) REFERENCES Usuarios(idUsuario)
);

CREATE TABLE Membresias
(
idMembresia INT PRIMARY KEY AUTO_INCREMENT,
tipo VARCHAR(20),
estado BIT,
fechaIncio DATETIME DEFAULT NOW(),
fechaFin DATETIME DEFAULT NOW(),
idUsuario INT,
FOREIGN KEY (idUsuario) REFERENCES Usuarios(idUsuario)
);

CREATE TABLE EstadosLibros
(
idEstadosLibros INT PRIMARY KEY AUTO_INCREMENT,
estado VARCHAR(50)
);

CREATE TABLE DisponibilidadLibros
(
idDisponibilidadLibro INT PRIMARY KEY AUTO_INCREMENT,
disponibilidad VARCHAR(50)
);

CREATE TABLE CategoriasLibros
(
idCategoriaLibro INT PRIMARY KEY AUTO_INCREMENT,
categoria VARCHAR(50)
);

CREATE TABLE Libros 
(
idLibros INT PRIMARY KEY AUTO_INCREMENT,
nombre VARCHAR(100),
autor VARCHAR(100),
precio DOUBLE(10,2),
descripcion VARCHAR(3000),
idEstadosLibros INT,
idDisponibilidadLibro INT,
idCategoriaLibro INT,
fechaModificacion DATETIME,
FOREIGN KEY (idEstadosLibros) REFERENCES EstadosLibros(idEstadosLibros),
FOREIGN KEY (idDisponibilidadLibro) REFERENCES DisponibilidadLibros(idDisponibilidadLibro),
FOREIGN KEY (idCategoriaLibro) REFERENCES CategoriasLibros(idCategoriaLibro)
);

CREATE TABLE ImagenesLibros
(
idImagenLibro INT PRIMARY KEY AUTO_INCREMENT,
url VARCHAR(250),
idLibro INT,
fechaRegistro DATETIME DEFAULT NOW(),
FOREIGN KEY (idLibro) REFERENCES Libros(idLibros)
);

CREATE TABLE LibrosFavoritos
(
idLibroFavorito INT PRIMARY KEY AUTO_INCREMENT,
idLibro INT,
idUsuario INT,
FOREIGN KEY (idLibro) REFERENCES Libros(idLibros),
FOREIGN KEY (idUsuario) REFERENCES Usuarios(idUsuario)
);

CREATE TABLE LibrosPublicados
(
idLibrosPublicados INT PRIMARY KEY AUTO_INCREMENT,
idLibro INT,
idUsuario INT,
fechaPublicacion DATETIME DEFAULT NOW(),
FOREIGN KEY (idLibro) REFERENCES Libros(idLibros),
FOREIGN KEY (idUsuario) REFERENCES Usuarios(idUsuario)
);

CREATE TABLE Calificaciones
(
idCalificacion INT PRIMARY KEY AUTO_INCREMENT,
idLibro INT,
idUsuario INT,
fechaCalificacion DATETIME DEFAULT NOW(),
comentario VARCHAR(2000),
puntuacion DOUBLE(1,1),
FOREIGN KEY (idLibro) REFERENCES Libros(idLibros),
FOREIGN KEY (idUsuario) REFERENCES Usuarios(idUsuario)
);

CREATE TABLE EstadosTransacciones
(
idEstadoTransaccion INT PRIMARY KEY AUTO_INCREMENT,
estado VARCHAR(20)
);

CREATE TABLE Transacciones
(
idTransaccion INT PRIMARY KEY AUTO_INCREMENT,
idLibro INT,
idUsuario INT,
fechaTransaccion DATETIME DEFAULT NOW(),
total DECIMAL (10,2),
idEstadoTransaccion INT,
FOREIGN KEY (idEstadoTransaccion) REFERENCES EstadosTransacciones(idEstadoTransaccion),
FOREIGN KEY (idLibro) REFERENCES Libros(idLibros),
FOREIGN KEY (idUsuario) REFERENCES Usuarios(idUsuario)
);


