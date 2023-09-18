-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 18-09-2023 a las 22:04:03
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
-- Base de datos: `universidadulp`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `alumno`
--

CREATE TABLE `alumno` (
  `idAlumno` int(11) NOT NULL,
  `dni` int(25) NOT NULL,
  `apellido` varchar(50) NOT NULL,
  `nombre` varchar(50) NOT NULL,
  `fechaNacimiento` date NOT NULL,
  `activo` tinyint(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `alumno`
--

INSERT INTO `alumno` (`idAlumno`, `dni`, `apellido`, `nombre`, `fechaNacimiento`, `activo`) VALUES
(20, 12345699, 'Garcia ', 'Maria X', '2010-11-22', 1),
(21, 23456789, 'Lopez', 'Carlos', '2001-03-20', 0),
(22, 34567890, 'Rodriguez', 'Andrea', '1999-09-10', 1),
(23, 45678901, 'Martinez', 'Juan', '2002-11-05', 0),
(24, 56789012, 'Perez', 'Laura', '2003-07-08', 1),
(25, 67890123, 'Gonzalez', 'Diego', '2000-12-25', 0),
(26, 78901234, 'Ramirez', 'Ana', '1998-04-30', 1),
(27, 89012345, 'Fernandez', 'Luis', '1997-02-14', 0),
(28, 90123456, 'Torres', 'Elena', '2004-08-12', 1),
(29, 11223344, 'Diaz', 'Roberto', '2002-06-18', 0),
(30, 22334455, 'Hernandez', 'Sofia', '1999-01-22', 1),
(31, 33445566, 'Sanchez', 'Javier', '2001-10-03', 0),
(32, 44556677, 'Vargas', 'Lucia', '2003-04-09', 1),
(33, 55667788, 'Gomez', 'Pedro', '2000-07-17', 0),
(34, 66778899, 'Castro', 'Valentina', '2002-03-01', 1),
(35, 77889900, 'Navarro', 'Ricardo', '1997-09-28', 0),
(36, 88990011, 'Romero', 'Isabella', '2001-12-07', 1),
(37, 99001122, 'Soto', 'Miguel', '1998-08-23', 0),
(38, 12340987, 'Chavez', 'Marina', '2004-05-02', 1),
(39, 23409876, 'Ortega', 'Alejandro', '2003-02-09', 0),
(40, 34509876, 'Guerra', 'Julia', '1999-06-14', 1),
(41, 45609876, 'Fuentes', 'Gabriel', '2000-09-28', 0),
(42, 56709876, 'Mendoza', 'Camila', '2002-07-11', 1),
(43, 67809876, 'Silva', 'Mateo', '2001-01-15', 0),
(44, 78909876, 'Rojas', 'Alicia', '1998-03-04', 1),
(45, 89009876, 'Valdez', 'Hugo', '2003-04-30', 0),
(46, 90109876, 'Acosta', 'Natalia', '2000-11-22', 1),
(47, 47330366, 'Sankara', 'Shion', '1991-08-31', 0);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `inscripcion`
--

CREATE TABLE `inscripcion` (
  `idInscripcion` int(11) NOT NULL,
  `nota` int(11) NOT NULL,
  `idAlumno` int(11) NOT NULL,
  `idMateria` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `inscripcion`
--

INSERT INTO `inscripcion` (`idInscripcion`, `nota`, `idAlumno`, `idMateria`) VALUES
(22, 9, 20, 37),
(23, 7, 20, 34),
(24, 6, 20, 30);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `materia`
--

CREATE TABLE `materia` (
  `idMateria` int(11) NOT NULL,
  `codigo` int(11) NOT NULL,
  `nombre` varchar(50) NOT NULL,
  `anioMateria` int(11) NOT NULL,
  `activo` tinyint(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `materia`
--

INSERT INTO `materia` (`idMateria`, `codigo`, `nombre`, `anioMateria`, `activo`) VALUES
(30, 1, 'Matemáticas', 1, 1),
(31, 2, 'Lengua', 1, 1),
(32, 3, 'Historia', 2, 1),
(33, 4, 'Ciencias Naturales', 2, 1),
(34, 5, 'Educación Física', 1, 1),
(35, 6, 'Música', 2, 1),
(36, 7, 'Artes Plásticas', 1, 1),
(37, 8, 'Geografía', 2, 1),
(38, 9, 'Religión', 1, 1),
(39, 10, 'Ética', 2, 1),
(40, 11, 'Tecnología', 1, 1),
(41, 12, 'Inglés', 2, 1),
(42, 13, 'Física', 3, 1),
(43, 14, 'Química', 3, 1),
(44, 15, 'Informática: Laboratorio', 3, 1);

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `alumno`
--
ALTER TABLE `alumno`
  ADD PRIMARY KEY (`idAlumno`),
  ADD UNIQUE KEY `dni` (`dni`);

--
-- Indices de la tabla `inscripcion`
--
ALTER TABLE `inscripcion`
  ADD PRIMARY KEY (`idInscripcion`),
  ADD KEY `inscripcion_materia` (`idMateria`),
  ADD KEY `inscripcion_alumno` (`idAlumno`);

--
-- Indices de la tabla `materia`
--
ALTER TABLE `materia`
  ADD PRIMARY KEY (`idMateria`),
  ADD UNIQUE KEY `codigo` (`codigo`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `alumno`
--
ALTER TABLE `alumno`
  MODIFY `idAlumno` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=48;

--
-- AUTO_INCREMENT de la tabla `inscripcion`
--
ALTER TABLE `inscripcion`
  MODIFY `idInscripcion` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=25;

--
-- AUTO_INCREMENT de la tabla `materia`
--
ALTER TABLE `materia`
  MODIFY `idMateria` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=45;

--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `inscripcion`
--
ALTER TABLE `inscripcion`
  ADD CONSTRAINT `inscripcion_alumno` FOREIGN KEY (`idAlumno`) REFERENCES `alumno` (`idAlumno`),
  ADD CONSTRAINT `inscripcion_materia` FOREIGN KEY (`idMateria`) REFERENCES `materia` (`idMateria`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
