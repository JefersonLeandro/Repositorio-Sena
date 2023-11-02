-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 02-11-2023 a las 19:29:04
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
-- Base de datos: `proyectoformativof`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `detallefactura`
--

CREATE TABLE `detallefactura` (
  `idDetalleFactura` int(11) NOT NULL,
  `cantidadDetalleF` varchar(45) NOT NULL,
  `subtotalDetalleF` varchar(45) NOT NULL,
  `idProducto` int(11) NOT NULL,
  `idFactura` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `factura`
--

CREATE TABLE `factura` (
  `idFactura` int(11) NOT NULL,
  `idPersona` int(11) NOT NULL,
  `totalCompra` float NOT NULL,
  `fechaCompra` date NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `farmacia`
--

CREATE TABLE `farmacia` (
  `idFarmacia` int(11) NOT NULL,
  `nitFarmacia` varchar(45) NOT NULL,
  `nombreFarmacia` varchar(45) NOT NULL,
  `telefonoFarmacia` varchar(45) NOT NULL,
  `correoFarmacia` varchar(45) NOT NULL,
  `ubicacionFarmacia` varchar(45) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci;

--
-- Volcado de datos para la tabla `farmacia`
--

INSERT INTO `farmacia` (`idFarmacia`, `nitFarmacia`, `nombreFarmacia`, `telefonoFarmacia`, `correoFarmacia`, `ubicacionFarmacia`) VALUES
(1, '24562a', 'Farmacit', '3143842657', 'Farmacit@gmail.com', 'Velez-Santander'),
(2, '34546e', 'MediCat', '3103434443', 'Medicat@gmail.com', 'San Jose de Pare-Boyaca');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `imagen`
--

CREATE TABLE `imagen` (
  `idImagen` int(11) NOT NULL,
  `nombreImagen` varchar(255) NOT NULL DEFAULT 'registro.png',
  `tipoImagen` int(11) DEFAULT NULL,
  `idProducto` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci;

--
-- Volcado de datos para la tabla `imagen`
--

INSERT INTO `imagen` (`idImagen`, `nombreImagen`, `tipoImagen`, `idProducto`) VALUES
(12, 'Benet-gomas-zinc-vitamina-c.webp', 0, 1),
(13, 'Aspirina100-1.jpg', 0, 2),
(14, 'GastroFast.jpg', 0, 3),
(15, 'ibuflash.jpg', 0, 4),
(16, 'Lumbal.png', 0, 5),
(17, 'nospirin1.jpg', 0, 6),
(18, 'Noraver.png', 0, 7),
(19, 'sulzinc.png', 0, 8),
(34, 'edificio.png', 1, 39),
(39, 'carrito-de-compras.png', 1, 41),
(43, 'carrito-de-compras.png', 0, 45);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `marcaproducto`
--

CREATE TABLE `marcaproducto` (
  `idMarcaProducto` int(11) NOT NULL,
  `nombreMarca` varchar(45) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci;

--
-- Volcado de datos para la tabla `marcaproducto`
--

INSERT INTO `marcaproducto` (`idMarcaProducto`, `nombreMarca`) VALUES
(1, 'Benet'),
(2, 'Bayer'),
(3, 'GastroFast'),
(4, 'Ibuflash'),
(5, 'Nospirin'),
(6, 'Lumbal'),
(7, 'Noraver'),
(8, 'Sulzinc'),
(456, 'Sin Marca'),
(460, 'miMarca');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `metodopago`
--

CREATE TABLE `metodopago` (
  `idMetodoPago` int(11) NOT NULL,
  `nombreMetodoPago` varchar(45) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `persona`
--

CREATE TABLE `persona` (
  `idPersona` int(11) NOT NULL,
  `nombrePersona` varchar(45) NOT NULL,
  `apellidoPersona` varchar(45) NOT NULL,
  `identificacionPersona` varchar(45) NOT NULL,
  `correoPersona` varchar(45) NOT NULL,
  `telefonoPersona` varchar(45) NOT NULL,
  `contrasenaPersona` varchar(256) NOT NULL,
  `idTipoPersona` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci;

--
-- Volcado de datos para la tabla `persona`
--

INSERT INTO `persona` (`idPersona`, `nombrePersona`, `apellidoPersona`, `identificacionPersona`, `correoPersona`, `telefonoPersona`, `contrasenaPersona`, `idTipoPersona`) VALUES
(1, 'Jeferson leandro', 'Fajardo Rodriguez', '1002723384', 'admin@gmail.com', '3143842657', '$2a$10$7L32ui9aGgnDetH/ndQM1uGhEQoO9XJZ7nrTaAy3E5WX6bEsJQn3C', 3),
(293, 'Juan', 'Venegas', '1234567890', 'Juan@gmail.com', '3122222222', '$2a$10$6ze48GzyWme0.EUmAAdWleghP1ECfe4NB7eWT8W7Nv2nKxFUGmhjC', 1),
(295, 'rex', 'sfsdf234234234', '2323423234234', 'Rex@gmail.com', '12312323423432', '$2a$10$q7xY9UgwpAATl.dSxLPI7u.e5zfMZKwDftSDGh/HsJdR6U2oiDfeW', 2),
(296, 'gus', 'sdfsdf', '23123123132', 'Gus@gmail.com', '123123', '$2a$10$XAS48ZKRxJ1vj08e.NmMneTVquIHgkqC83cQwAsr.GWDm33VhL0LK', 1),
(314, 'Jeferson leandro12231', 'Fajardo Rodriguez1212', '23412323112124', 'adsf@ddd', '3143842657', '$2a$10$yIfNsyjFNHFXFx9FUAw3X.YUzF9ewd3AcG1/NqGx5Qr6kYC2u0q3q', 2),
(315, 'jose', 'asdfasdf', '1', 'Jose@gmail.com', '123123123', '$2a$10$1VC25MVVPRiWEhJoAlZ6turKqI.T7iv1jzv.VdYTi8nPXYSkapOny', 1),
(317, 'Miguel', 'Tejedor', '123456', 'MIguel@gmail.com', '12312324123', '$2a$10$zfOvoAUHs0l0ea1rWnY11OyBa17qF2IxvkJu2DEglPjGfo4iwKr26', 3);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `personalfarmacia`
--

CREATE TABLE `personalfarmacia` (
  `idPersona` int(11) NOT NULL,
  `idFarmacia` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `producto`
--

CREATE TABLE `producto` (
  `idProducto` int(11) NOT NULL,
  `nombreProducto` varchar(60) DEFAULT NULL,
  `descripcionUnidad` varchar(45) NOT NULL,
  `descripcionProductoGeneral` mediumtext NOT NULL,
  `stockProducto` int(11) NOT NULL,
  `precioProducto` double DEFAULT NULL,
  `idMarcaProducto` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci;

--
-- Volcado de datos para la tabla `producto`
--

INSERT INTO `producto` (`idProducto`, `nombreProducto`, `descripcionUnidad`, `descripcionProductoGeneral`, `stockProducto`, `precioProducto`, `idMarcaProducto`) VALUES
(1, 'Benet- Vitamina C', 'Tarro x 60 gomas', 'Lorem ipsum dolor sit amet consectetur adipisicing elit. Temporibus tenetur voluptatum, harum reprehenderit eveniet provident, reiciendis dignissimos nostrum consequatur, architecto assumenda suscipit. Eligendi quod laboriosam blanditiis ipsum suscipit impedit facere?', 30, 23000, 1),
(2, 'Aspirinas cardiovasculares ', 'Caja x 140 Tabletas', 'Lorem ipsum dolor sit amet consectetur adipisicing elit. Temporibus tenetur voluptatum, harum reprehenderit eveniet provident, reiciendis dignissimos nostrum consequatur, architecto assumenda suscipit. Eligendi quod laboriosam blanditiis ipsum suscipit impedit facere?', 45, 30000, 2),
(3, 'GastroFast alivio imediato', '10 Bolsitas-10 ml', 'Lorem ipsum dolor sit amet consectetur adipisicing elit. Temporibus tenetur voluptatum, harum reprehenderit eveniet provident, reiciendis dignissimos nostrum consequatur, architecto assumenda suscipit. Eligendi quod laboriosam blanditiis ipsum suscipit impedit facere?', 28, 10000, 3),
(4, 'Ibuflash-dolores de cabeza', '18 Capsulas Liquidas', 'Lorem ipsum dolor sit amet consectetur adipisicing elit. Temporibus tenetur voluptatum, harum reprehenderit eveniet provident, reiciendis dignissimos nostrum consequatur, architecto assumenda suscipit. Eligendi quod laboriosam blanditiis ipsum suscipit impedit facere?', 8, 24000, 4),
(5, 'Lumbal Forte', 'Caja x 37 tabletas', 'Lorem ipsum dolor sit amet consectetur adipisicing elit. Temporibus tenetur voluptatum, harum reprehenderit eveniet provident, reiciendis dignissimos nostrum consequatur, architecto assumenda suscipit. Eligendi quod laboriosam blanditiis ipsum suscipit impedit facere?', 33, 15300, 6),
(6, 'Nospirin plus-dia-noche', 'Caja x 12 capsulas', 'Lorem ipsum dolor sit amet consectetur adipisicing elit. Temporibus tenetur voluptatum, harum reprehenderit eveniet provident, reiciendis dignissimos nostrum consequatur, architecto assumenda suscipit. Eligendi quod laboriosam blanditiis ipsum suscipit impedit facere?', 45, 12560, 5),
(7, 'Noraver-gripa-tos', '6 Capsulas Liquidas', 'Lorem ipsum dolor sit amet consectetur adipisicing elit. Temporibus tenetur voluptatum, harum reprehenderit eveniet provident, reiciendis dignissimos nostrum consequatur, architecto assumenda suscipit. Eligendi quod laboriosam blanditiis ipsum suscipit impedit facere?', 34, 18300, 7),
(8, 'sulzinc', 'caja x 120ml', 'Lorem ipsum dolor sit amet consectetur adipisicing elit. Temporibus tenetur voluptatum, harum reprehenderit eveniet provident, reiciendis dignissimos nostrum consequatur, architecto assumenda suscipit. Eligendi quod laboriosam blanditiis ipsum suscipit impedit facere', 34, 27999, 8),
(35, 'qwerwerwer', 'sdfsdfsdf', 'sdfasdfasdf', 234, 67.9, 2),
(36, 'ssss', 'qqw', 'qqqq', 123, 34890, 8),
(39, 'miproducto', 'sdfsdfsdf', 'sdfsdf', 12, 45567, 456),
(40, 'un nuevo producto', 'qweqweqwe', 'sddfsdfsdf', 45, 123123, 3),
(41, 'ewrwer', 'sddfsdf111', '111', 121, 67.9000015258783, 6),
(43, 'qqqqqqqqq', '123123', '2323', 1234, 23323, 5),
(45, 'Acetaminofen', '100 tabletas caja', 'sdfsdfsfsfsf ', 32, 25000, 2);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `productocarrito`
--

CREATE TABLE `productocarrito` (
  `idProductoCarrito` int(11) NOT NULL,
  `idPersona` int(11) NOT NULL,
  `idProducto` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `productodeseado`
--

CREATE TABLE `productodeseado` (
  `idProductoD` int(11) NOT NULL,
  `idPersona` int(11) NOT NULL,
  `idProducto` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci;

--
-- Volcado de datos para la tabla `productodeseado`
--

INSERT INTO `productodeseado` (`idProductoD`, `idPersona`, `idProducto`) VALUES
(73, 317, 1),
(74, 317, 2),
(75, 317, 3);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `tipodolor`
--

CREATE TABLE `tipodolor` (
  `idtipoDolor` int(11) NOT NULL,
  `nombreTipoDolor` varchar(45) NOT NULL,
  `idProducto` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `tipoimagen`
--

CREATE TABLE `tipoimagen` (
  `idTipoImagen` int(11) NOT NULL,
  `nombreTipoImagen` varchar(45) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `tipopersona`
--

CREATE TABLE `tipopersona` (
  `idTipoPersona` int(11) NOT NULL,
  `nombreTipoPersona` varchar(45) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci;

--
-- Volcado de datos para la tabla `tipopersona`
--

INSERT INTO `tipopersona` (`idTipoPersona`, `nombreTipoPersona`) VALUES
(1, 'Cliente'),
(2, 'Proveedor'),
(3, 'Administrador');

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `detallefactura`
--
ALTER TABLE `detallefactura`
  ADD PRIMARY KEY (`idDetalleFactura`),
  ADD KEY `fk_DetalleFactura_Producto1_idx` (`idProducto`),
  ADD KEY `fk_DetalleFactura_Factura1_idx` (`idFactura`);

--
-- Indices de la tabla `factura`
--
ALTER TABLE `factura`
  ADD PRIMARY KEY (`idFactura`),
  ADD KEY `fk_Cliente_has_Medicamento_Cliente1_idx` (`idPersona`);

--
-- Indices de la tabla `farmacia`
--
ALTER TABLE `farmacia`
  ADD PRIMARY KEY (`idFarmacia`);

--
-- Indices de la tabla `imagen`
--
ALTER TABLE `imagen`
  ADD PRIMARY KEY (`idImagen`),
  ADD KEY `fk_Imagenes_Producto1_idx` (`idProducto`);

--
-- Indices de la tabla `marcaproducto`
--
ALTER TABLE `marcaproducto`
  ADD PRIMARY KEY (`idMarcaProducto`);

--
-- Indices de la tabla `metodopago`
--
ALTER TABLE `metodopago`
  ADD PRIMARY KEY (`idMetodoPago`);

--
-- Indices de la tabla `persona`
--
ALTER TABLE `persona`
  ADD PRIMARY KEY (`idPersona`),
  ADD KEY `fk_Persona_TipoPersona1_idx` (`idTipoPersona`);

--
-- Indices de la tabla `personalfarmacia`
--
ALTER TABLE `personalfarmacia`
  ADD KEY `fk_Cliente_has_Farmacia_Farmacia1_idx` (`idFarmacia`),
  ADD KEY `fk_Cliente_has_Farmacia_Cliente1_idx` (`idPersona`);

--
-- Indices de la tabla `producto`
--
ALTER TABLE `producto`
  ADD PRIMARY KEY (`idProducto`),
  ADD KEY `fk_Producto_MarcaProducto1_idx` (`idMarcaProducto`);

--
-- Indices de la tabla `productocarrito`
--
ALTER TABLE `productocarrito`
  ADD PRIMARY KEY (`idProductoCarrito`),
  ADD KEY `fk_productoCarrito_Persona1_idx` (`idPersona`),
  ADD KEY `fk_productoCarrito_Producto1_idx` (`idProducto`);

--
-- Indices de la tabla `productodeseado`
--
ALTER TABLE `productodeseado`
  ADD PRIMARY KEY (`idProductoD`),
  ADD KEY `fk_productoDeseado_Cliente1_idx` (`idPersona`),
  ADD KEY `fk_productoDeseado_Producto1_idx` (`idProducto`);

--
-- Indices de la tabla `tipodolor`
--
ALTER TABLE `tipodolor`
  ADD PRIMARY KEY (`idtipoDolor`),
  ADD KEY `fk_tipoDolor_Producto1_idx` (`idProducto`);

--
-- Indices de la tabla `tipoimagen`
--
ALTER TABLE `tipoimagen`
  ADD PRIMARY KEY (`idTipoImagen`);

--
-- Indices de la tabla `tipopersona`
--
ALTER TABLE `tipopersona`
  ADD PRIMARY KEY (`idTipoPersona`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `detallefactura`
--
ALTER TABLE `detallefactura`
  MODIFY `idDetalleFactura` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `factura`
--
ALTER TABLE `factura`
  MODIFY `idFactura` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `farmacia`
--
ALTER TABLE `farmacia`
  MODIFY `idFarmacia` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=93;

--
-- AUTO_INCREMENT de la tabla `imagen`
--
ALTER TABLE `imagen`
  MODIFY `idImagen` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=44;

--
-- AUTO_INCREMENT de la tabla `marcaproducto`
--
ALTER TABLE `marcaproducto`
  MODIFY `idMarcaProducto` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=461;

--
-- AUTO_INCREMENT de la tabla `metodopago`
--
ALTER TABLE `metodopago`
  MODIFY `idMetodoPago` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `persona`
--
ALTER TABLE `persona`
  MODIFY `idPersona` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=318;

--
-- AUTO_INCREMENT de la tabla `producto`
--
ALTER TABLE `producto`
  MODIFY `idProducto` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=46;

--
-- AUTO_INCREMENT de la tabla `productocarrito`
--
ALTER TABLE `productocarrito`
  MODIFY `idProductoCarrito` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `productodeseado`
--
ALTER TABLE `productodeseado`
  MODIFY `idProductoD` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=76;

--
-- AUTO_INCREMENT de la tabla `tipodolor`
--
ALTER TABLE `tipodolor`
  MODIFY `idtipoDolor` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `tipopersona`
--
ALTER TABLE `tipopersona`
  MODIFY `idTipoPersona` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=254;

--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `detallefactura`
--
ALTER TABLE `detallefactura`
  ADD CONSTRAINT `fk_DetalleFactura_Factura1` FOREIGN KEY (`idFactura`) REFERENCES `factura` (`idFactura`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `fk_DetalleFactura_Producto1` FOREIGN KEY (`idProducto`) REFERENCES `producto` (`idProducto`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Filtros para la tabla `factura`
--
ALTER TABLE `factura`
  ADD CONSTRAINT `fk_Cliente_has_Medicamento_Cliente1` FOREIGN KEY (`idPersona`) REFERENCES `persona` (`idPersona`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Filtros para la tabla `imagen`
--
ALTER TABLE `imagen`
  ADD CONSTRAINT `fk_Imagenes_Producto1` FOREIGN KEY (`idProducto`) REFERENCES `producto` (`idProducto`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Filtros para la tabla `persona`
--
ALTER TABLE `persona`
  ADD CONSTRAINT `fk_Persona_TipoPersona1` FOREIGN KEY (`idTipoPersona`) REFERENCES `tipopersona` (`idTipoPersona`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Filtros para la tabla `personalfarmacia`
--
ALTER TABLE `personalfarmacia`
  ADD CONSTRAINT `fk_Cliente_has_Farmacia_Cliente1` FOREIGN KEY (`idPersona`) REFERENCES `persona` (`idPersona`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `fk_Cliente_has_Farmacia_Farmacia1` FOREIGN KEY (`idFarmacia`) REFERENCES `farmacia` (`idFarmacia`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Filtros para la tabla `producto`
--
ALTER TABLE `producto`
  ADD CONSTRAINT `fk_Producto_MarcaProducto1` FOREIGN KEY (`idMarcaProducto`) REFERENCES `marcaproducto` (`idMarcaProducto`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Filtros para la tabla `productocarrito`
--
ALTER TABLE `productocarrito`
  ADD CONSTRAINT `fk_productoCarrito_Persona1` FOREIGN KEY (`idPersona`) REFERENCES `persona` (`idPersona`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `fk_productoCarrito_Producto1` FOREIGN KEY (`idProducto`) REFERENCES `producto` (`idProducto`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Filtros para la tabla `productodeseado`
--
ALTER TABLE `productodeseado`
  ADD CONSTRAINT `fk_productoDeseado_Cliente1` FOREIGN KEY (`idPersona`) REFERENCES `persona` (`idPersona`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `fk_productoDeseado_Producto1` FOREIGN KEY (`idProducto`) REFERENCES `producto` (`idProducto`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Filtros para la tabla `tipodolor`
--
ALTER TABLE `tipodolor`
  ADD CONSTRAINT `fk_tipoDolor_Producto1` FOREIGN KEY (`idProducto`) REFERENCES `producto` (`idProducto`) ON DELETE NO ACTION ON UPDATE NO ACTION;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
