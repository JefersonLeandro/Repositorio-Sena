-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 03-09-2023 a las 01:37:37
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
(2, '34546e', 'MediCat', '3103434443', 'Medicat@gmail.com', 'San Jose de Pare-Boyaca'),
(15, 'asdf', 'asdf', '124', 'adf@af', 'wasdf'),
(18, 'asdf', 'asdf', 'asdf', 'asdf', 'asdf');

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
(456, 'Sin Marca');

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
(30, 'LUFFY', 'asdasdf', '22222222', 'lufy@adfg', '13213', 'a665a45920422f9d417e4867efdc4fb8a04a1f3fff1fa07e998e86f7f7a27ae3', 2),
(31, 'didilmo', 'asdf', '234234', 'Dildilmo@gmail.com', '23434', 'a665a45920422f9d417e4867efdc4fb8a04a1f3fff1fa07e998e86f7f7a27ae3', 1),
(32, 'Emilia', 'adfasdf', '123', 'Emilia@gmail.com', '12323', '2ac9a6746aca543af8dff39894cfe8173afba21eb01c6fae33d52947222855ef', 1),
(33, 'salting', 'asdfasf', '23123', 'sss@gmail.com', '123123', '$2a$10$byoQSRTVZC6jW2iugvV2Jeh6UFsta3NTdqSQcoAeuRh.K6G32XZT.', 1),
(34, 'pepito', 'asdfasdf', '2312323', 'pepito@gmail.com', '12323', '$2a$10$rpW2HlMmx0XSVKzs8gcZ3edNImSGQKNG1KL7C1KWla1WzecPYZVh2', 1),
(35, 'Valbuena', 'adfasf', '23123', 'Valbuena@gmail.com', '12323', '$2a$10$B0F6Okb0oxmAtWRvFA.v2OvwbQx461C8eMvMCrRVAyX/2HZEjsFA2', 1),
(36, 'tellez', 'asdfasf', 'q3424', 'tellez@gmail.com', '13123', '$2a$10$LGYZVl/L50BB3DM/J9zUmewRm9M71VtNPWvaCvz.P115mWBrWsx5.', 1),
(37, 'sofiaa', 'asdasdf', '2341', 'sofiaa@gmail.com', '23434', '$2a$10$uRpjPIA2jsB54yc2dZFwzOfcg9O8syvxHPFD2u442CBmYMs1FkYYS', 1),
(38, 'lubin', 'asdf', '123123', 'lubin@gmail.com', '123123', '$2a$10$Ky5Q21AuSfCdSuGGdl5Gje8ckFAfO/hlIOYRcmmCWQzZxdbG3DJxm', 1),
(40, 'Miguel', 'adsf', '12345', 'Miguel@gmail.com', '123213', '$2a$10$3hvZtu8VNM/OaQ94EfZYsuZ2YNjyT43LbMKMpbHnfnU8MU21kEqg2', 1),
(41, 'sam', 'asdfasdf', '1002', 'sam@gmail.com', '234234', '$2a$10$7fAB17a/twUTkgDEvtCgHe2OrBYMdx.zUCesLTCfRoEZUUxbE1xWm', 1),
(42, 'pepitoaaaaa', 'asdfasdf', '2312323', 'pepito@gmail.com', '12323', '123', 1),
(43, 'asdfasdf', 'asdfasdf', '123123', 'asdfasdf@aaaaaa', '123213', '$2a$10$XvAY7wCHz0z7pmHIgTnnP.47IFoKuJyTcziXCVc.cbY4pukm9pvFa', 1),
(44, 'asdf', 'asdfasdf', '2341234', 'asdfas', '1234123', '12312', 2),
(45, 'SSDF', 'ASDFADF', '12323', 'ASDF@SSS', '12323', '$2a$10$WQtJN/8pMZJA2cEIulo3d.ZXrExdvkaTSi5BF73Uzezmf96PD39a.', 2),
(46, 'didilmoaa', 'asdfaa', '23423433', 'Dildilmoa@gmail.com', '234343', '$2a$10$chbcNkWTv3Bs.mv56kpikeZe.SM7JMAKmWl1Pc21wzhmvyeGaTWoy', 2),
(48, 'nnn', 'adsa', '123456', 'nnn@gmail.com', '123123', '$2a$10$P0iwdANiwYGLAlTizpARVeKWrPXjx7LftVOjESQ13KQk0tdW5fOoy', 3),
(49, 'carolina', 'asdfasdf', '12345', 'carolina@gmail.com', '1234523423', '$2a$10$4pZy7HHy9qzoGP.vi3l56e9343wqG/gs0rA1Y6s1wYR.zKsBKx46u', 1),
(50, 'rrr', 'asaf', '666666', 'rrr@gmail.com', '123123', '$2a$10$5h64isQxI.0H4VSZxk3w.uGD8Oq/Czb9m3IBTGvHdvhfONESu2LRy', 3),
(51, 'prueba', '444ee', '23423', 'asdf', '123123', '$2a$10$oM/bGOOyU/i4lRIz.pHb/erKgfgVCIxnzrTXCEkan1lFohjXbr9yK', 2),
(52, 'joder', 'asdf', '23234', 'asdf', '3234234', '$2a$10$tz38z9Ttdkqqv1W5IN4yEenypQDSjm3k2edh39u4q/LJkQLYu/GCe', 235),
(53, 'adfasdfq', 'r234234', '333333', 'asdfasf', '234234', '$2a$10$5jop.3foo3dldbSNQdksZe74oS/pOknaG35SVJTLrbY7yduvG0bNO', 235);

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
  `nombreProducto` varchar(45) NOT NULL,
  `descripcionUnidad` varchar(45) NOT NULL,
  `descripcionProductoGeneral` mediumtext NOT NULL,
  `stockProducto` int(11) NOT NULL,
  `precioProducto` int(11) NOT NULL,
  `nombreImagen` varchar(255) NOT NULL,
  `idMarcaProducto` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci;

--
-- Volcado de datos para la tabla `producto`
--

INSERT INTO `producto` (`idProducto`, `nombreProducto`, `descripcionUnidad`, `descripcionProductoGeneral`, `stockProducto`, `precioProducto`, `nombreImagen`, `idMarcaProducto`) VALUES
(1, 'Benet- Vitamina C', 'Tarro x 60 gomas', 'Lorem ipsum dolor sit amet consectetur adipisicing elit. Temporibus tenetur voluptatum, harum reprehenderit eveniet provident, reiciendis dignissimos nostrum consequatur, architecto assumenda suscipit. Eligendi quod laboriosam blanditiis ipsum suscipit impedit facere?', 30, 23000, 'Benet-gomas-zinc-vitamina-c.webp', 1),
(2, 'Aspirinas cardiovasculares ', 'Caja x 140 Tabletas', 'Lorem ipsum dolor sit amet consectetur adipisicing elit. Temporibus tenetur voluptatum, harum reprehenderit eveniet provident, reiciendis dignissimos nostrum consequatur, architecto assumenda suscipit. Eligendi quod laboriosam blanditiis ipsum suscipit impedit facere?', 45, 30000, 'Aspirina100-1.jpg', 2),
(3, 'GastroFast alivio imediato', '10 Bolsitas-10 ml', 'Lorem ipsum dolor sit amet consectetur adipisicing elit. Temporibus tenetur voluptatum, harum reprehenderit eveniet provident, reiciendis dignissimos nostrum consequatur, architecto assumenda suscipit. Eligendi quod laboriosam blanditiis ipsum suscipit impedit facere?', 28, 10000, 'GastroFast.jpg', 3),
(4, 'Ibuflash-dolores de cabeza', '18 Capsulas Liquidas', 'Lorem ipsum dolor sit amet consectetur adipisicing elit. Temporibus tenetur voluptatum, harum reprehenderit eveniet provident, reiciendis dignissimos nostrum consequatur, architecto assumenda suscipit. Eligendi quod laboriosam blanditiis ipsum suscipit impedit facere?', 8, 24000, 'ibuflash.jpg', 4),
(5, 'Lumbal Forte', 'Caja x 37 tabletas', 'Lorem ipsum dolor sit amet consectetur adipisicing elit. Temporibus tenetur voluptatum, harum reprehenderit eveniet provident, reiciendis dignissimos nostrum consequatur, architecto assumenda suscipit. Eligendi quod laboriosam blanditiis ipsum suscipit impedit facere?', 33, 15300, 'Lumbal.png', 6),
(6, 'Nospirin plus-dia-noche', 'Caja x 12 capsulas', 'Lorem ipsum dolor sit amet consectetur adipisicing elit. Temporibus tenetur voluptatum, harum reprehenderit eveniet provident, reiciendis dignissimos nostrum consequatur, architecto assumenda suscipit. Eligendi quod laboriosam blanditiis ipsum suscipit impedit facere?', 45, 12560, 'nospirin1.jpg', 5),
(7, 'Noraver-gripa-tos', '6 Capsulas Liquidas', 'Lorem ipsum dolor sit amet consectetur adipisicing elit. Temporibus tenetur voluptatum, harum reprehenderit eveniet provident, reiciendis dignissimos nostrum consequatur, architecto assumenda suscipit. Eligendi quod laboriosam blanditiis ipsum suscipit impedit facere?', 34, 18300, 'Noraver.png', 7),
(8, 'Sulzin-solucion oral', 'caja x 120ml', 'Lorem ipsum dolor sit amet consectetur adipisicing elit. Temporibus tenetur voluptatum, harum reprehenderit eveniet provident, reiciendis dignissimos nostrum consequatur, architecto assumenda suscipit. Eligendi quod laboriosam blanditiis ipsum suscipit impedit facere?', 15, 27999, 'sulzinc.png', 8),
(10, 'asdf', 'asdfasdf', 'asdfadf', 23, 34344, 'logo.png', 8),
(19, 'asdf', 'asd', 'fasdf', 23, 444444, 'CaarritoF.png', 5),
(20, 'asdfasf', 'asdfasdf', 'asdfa', 34, 44444, 'modern_logo_letter_u_abstract_gradient_color.eps', 5),
(21, 'asdfasdf', 'adfasdf', 'asdfasdf', 23, 123, 'asf', 8),
(22, 'asdfasdf', 'asdfasdf', 'asdfasdf', 34, 23444, 'adfasdf.jpg', 456),
(23, 'wwww', 'wwwwww', 'wwwwww', 234, 67890, 'asdfsfa.png', 456);

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
(3, 'Administrador'),
(235, 'Negociante');

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
  MODIFY `idFarmacia` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=19;

--
-- AUTO_INCREMENT de la tabla `marcaproducto`
--
ALTER TABLE `marcaproducto`
  MODIFY `idMarcaProducto` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=457;

--
-- AUTO_INCREMENT de la tabla `metodopago`
--
ALTER TABLE `metodopago`
  MODIFY `idMetodoPago` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `persona`
--
ALTER TABLE `persona`
  MODIFY `idPersona` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=56;

--
-- AUTO_INCREMENT de la tabla `producto`
--
ALTER TABLE `producto`
  MODIFY `idProducto` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=24;

--
-- AUTO_INCREMENT de la tabla `productocarrito`
--
ALTER TABLE `productocarrito`
  MODIFY `idProductoCarrito` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `productodeseado`
--
ALTER TABLE `productodeseado`
  MODIFY `idProductoD` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `tipodolor`
--
ALTER TABLE `tipodolor`
  MODIFY `idtipoDolor` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `tipopersona`
--
ALTER TABLE `tipopersona`
  MODIFY `idTipoPersona` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=236;

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
