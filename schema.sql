CREATE DATABASE IF NOT EXISTS gestion_turistica;
USE gestion_turistica;

SET FOREIGN_KEY_CHECKS = 0;
SET FOREIGN_KEY_CHECKS = 1;

-- MySQL dump 10.13  Distrib 8.0.45, for macos15 (arm64)
--
-- Host: 127.0.0.1    Database: gestion_turistica
-- ------------------------------------------------------
-- Server version	8.0.45

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `categoria`
--

DROP TABLE IF EXISTS `categoria`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `categoria` (
  `id_categoria` int NOT NULL AUTO_INCREMENT,
  `nombre` varchar(100) DEFAULT NULL,
  `descripcion` text,
  PRIMARY KEY (`id_categoria`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `cliente`
--

DROP TABLE IF EXISTS `cliente`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `cliente` (
  `id_cliente` int NOT NULL AUTO_INCREMENT,
  `nombre` varchar(100) DEFAULT NULL,
  `correo` varchar(100) DEFAULT NULL,
  `telefono` varchar(20) DEFAULT NULL,
  `documento` varchar(50) DEFAULT NULL,
  `nacionalidad` varchar(50) DEFAULT NULL,
  `fecha_nacimiento` date DEFAULT NULL,
  `contacto_emergencia` varchar(100) DEFAULT NULL,
  `fecha_registro` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id_cliente`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `disponibilidad`
--

DROP TABLE IF EXISTS `disponibilidad`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `disponibilidad` (
  `id_disponibilidad` int NOT NULL AUTO_INCREMENT,
  `id_tour` int DEFAULT NULL,
  `fecha_especifica` date DEFAULT NULL,
  `cupo_maximo` int DEFAULT NULL,
  `cupo_disponible` int DEFAULT NULL,
  `precio_especial` decimal(10,2) DEFAULT NULL,
  PRIMARY KEY (`id_disponibilidad`),
  UNIQUE KEY `id_tour` (`id_tour`,`fecha_especifica`),
  CONSTRAINT `disponibilidad_ibfk_1` FOREIGN KEY (`id_tour`) REFERENCES `tour` (`id_tour`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `guia`
--

DROP TABLE IF EXISTS `guia`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `guia` (
  `id_guia` int NOT NULL AUTO_INCREMENT,
  `id_usuario` int DEFAULT NULL,
  `especialidad` varchar(100) DEFAULT NULL,
  `idiomas` varchar(100) DEFAULT NULL,
  `telefono` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`id_guia`),
  UNIQUE KEY `id_usuario` (`id_usuario`),
  CONSTRAINT `guia_ibfk_1` FOREIGN KEY (`id_usuario`) REFERENCES `usuario` (`id_usuario`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `guia_tour`
--

DROP TABLE IF EXISTS `guia_tour`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `guia_tour` (
  `id_guia_tour` int NOT NULL AUTO_INCREMENT,
  `id_guia` int DEFAULT NULL,
  `id_tour` int DEFAULT NULL,
  `fecha_asignacion` date DEFAULT NULL,
  `disponible` tinyint(1) DEFAULT '1',
  `descripcion` text,
  `agencia` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`id_guia_tour`),
  KEY `id_guia` (`id_guia`),
  KEY `id_tour` (`id_tour`),
  CONSTRAINT `guia_tour_ibfk_1` FOREIGN KEY (`id_guia`) REFERENCES `guia` (`id_guia`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `guia_tour_ibfk_2` FOREIGN KEY (`id_tour`) REFERENCES `tour` (`id_tour`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `historial`
--

DROP TABLE IF EXISTS `historial`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `historial` (
  `id_historial` int NOT NULL AUTO_INCREMENT,
  `id_reserva` int DEFAULT NULL,
  `id_usuario` int DEFAULT NULL,
  `accion` varchar(50) DEFAULT NULL,
  `descripcion` text,
  `fecha_cambio` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id_historial`),
  KEY `id_reserva` (`id_reserva`),
  KEY `id_usuario` (`id_usuario`),
  CONSTRAINT `historial_ibfk_1` FOREIGN KEY (`id_reserva`) REFERENCES `reserva` (`id_reserva`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `historial_ibfk_2` FOREIGN KEY (`id_usuario`) REFERENCES `usuario` (`id_usuario`) ON DELETE SET NULL ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `opcion_tour`
--

DROP TABLE IF EXISTS `opcion_tour`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `opcion_tour` (
  `id_opcion` int NOT NULL AUTO_INCREMENT,
  `id_tour` int DEFAULT NULL,
  `tipo_acomodacion` enum('pareja','multiple') DEFAULT NULL,
  `precio_base` decimal(10,2) DEFAULT NULL,
  `precio_transporte` decimal(10,2) DEFAULT NULL,
  `activo` tinyint(1) DEFAULT '1',
  PRIMARY KEY (`id_opcion`),
  UNIQUE KEY `id_tour` (`id_tour`,`tipo_acomodacion`),
  CONSTRAINT `opcion_tour_ibfk_1` FOREIGN KEY (`id_tour`) REFERENCES `tour` (`id_tour`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `pago`
--

DROP TABLE IF EXISTS `pago`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `pago` (
  `id_pago` int NOT NULL AUTO_INCREMENT,
  `metodo_pago` enum('efectivo','transferencia','tarjeta') DEFAULT NULL,
  `monto` decimal(10,2) DEFAULT NULL,
  `estado_pago` enum('pendiente','completado','fallido') DEFAULT NULL,
  `referencia_pago` varchar(100) DEFAULT NULL,
  `fecha_transaccion` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id_pago`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `reserva`
--

DROP TABLE IF EXISTS `reserva`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `reserva` (
  `id_reserva` int NOT NULL AUTO_INCREMENT,
  `codigo_reserva` varchar(20) DEFAULT NULL,
  `id_cliente` int DEFAULT NULL,
  `id_disponibilidad` int DEFAULT NULL,
  `id_opcion` int DEFAULT NULL,
  `fecha_reserva` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  `hora_tour` time DEFAULT NULL,
  `cantidad_personas` int DEFAULT NULL,
  `precio_total` decimal(10,2) DEFAULT NULL,
  `descuento` decimal(10,2) DEFAULT NULL,
  `estado` enum('pendiente','confirmada','cancelada') DEFAULT NULL,
  `notas` text,
  `creado_por` int DEFAULT NULL,
  PRIMARY KEY (`id_reserva`),
  UNIQUE KEY `codigo_reserva` (`codigo_reserva`),
  KEY `id_cliente` (`id_cliente`),
  KEY `id_disponibilidad` (`id_disponibilidad`),
  KEY `id_opcion` (`id_opcion`),
  KEY `creado_por` (`creado_por`),
  CONSTRAINT `reserva_ibfk_1` FOREIGN KEY (`id_cliente`) REFERENCES `cliente` (`id_cliente`) ON DELETE RESTRICT ON UPDATE CASCADE,
  CONSTRAINT `reserva_ibfk_2` FOREIGN KEY (`id_disponibilidad`) REFERENCES `disponibilidad` (`id_disponibilidad`) ON DELETE RESTRICT ON UPDATE CASCADE,
  CONSTRAINT `reserva_ibfk_3` FOREIGN KEY (`id_opcion`) REFERENCES `opcion_tour` (`id_opcion`) ON DELETE RESTRICT ON UPDATE CASCADE,
  CONSTRAINT `reserva_ibfk_4` FOREIGN KEY (`creado_por`) REFERENCES `usuario` (`id_usuario`) ON DELETE SET NULL ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `reseña`
--

DROP TABLE IF EXISTS `reseña`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `reseña` (
  `id_reseña` int NOT NULL AUTO_INCREMENT,
  `id_cliente` int DEFAULT NULL,
  `id_tour` int DEFAULT NULL,
  `puntuacion` int DEFAULT NULL,
  `comentario` text,
  `fecha` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id_reseña`),
  KEY `id_cliente` (`id_cliente`),
  KEY `id_tour` (`id_tour`),
  CONSTRAINT `reseña_ibfk_1` FOREIGN KEY (`id_cliente`) REFERENCES `cliente` (`id_cliente`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `reseña_ibfk_2` FOREIGN KEY (`id_tour`) REFERENCES `tour` (`id_tour`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `reseña_chk_1` CHECK ((`puntuacion` between 1 and 5))
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `tour`
--

DROP TABLE IF EXISTS `tour`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tour` (
  `id_tour` int NOT NULL AUTO_INCREMENT,
  `id_categoria` int DEFAULT NULL,
  `nombre` varchar(150) DEFAULT NULL,
  `descripcion` text,
  `duracion` varchar(50) DEFAULT NULL,
  `punto_encuentro` varchar(150) DEFAULT NULL,
  `nivel_dificultad` enum('bajo','medio','alto') DEFAULT NULL,
  `requisitos` text,
  `incluye` text,
  `estado` enum('activo','inactivo') DEFAULT NULL,
  `fecha_creacion` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id_tour`),
  KEY `id_categoria` (`id_categoria`),
  CONSTRAINT `tour_ibfk_1` FOREIGN KEY (`id_categoria`) REFERENCES `categoria` (`id_categoria`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `usuario`
--

DROP TABLE IF EXISTS `usuario`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `usuario` (
  `id_usuario` int NOT NULL AUTO_INCREMENT,
  `nombre` varchar(100) DEFAULT NULL,
  `correo` varchar(100) DEFAULT NULL,
  `contraseña` varchar(255) DEFAULT NULL,
  `rol` enum('superadmin','admin','guia') DEFAULT NULL,
  `estado` enum('activo','inactivo') DEFAULT 'activo',
  `fecha_creacion` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id_usuario`),
  UNIQUE KEY `correo` (`correo`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2026-04-22 19:18:47
