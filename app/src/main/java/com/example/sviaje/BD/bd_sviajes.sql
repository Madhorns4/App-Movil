CREATE DATABASE  IF NOT EXISTS `bd_sviajes` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;
USE `bd_sviajes`;
-- MySQL dump 10.13  Distrib 8.0.19, for Win64 (x86_64)
--
-- Host: localhost    Database: bd_sviajes
-- ------------------------------------------------------
-- Server version	8.0.17

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
-- Dumping data for table `ciudad`
--

LOCK TABLES `ciudad` WRITE;
/*!40000 ALTER TABLE `ciudad` DISABLE KEYS */;
INSERT INTO `ciudad` VALUES (1,'Guayaquil',10),(2,'Duran',10),(3,'Milagro',10);
/*!40000 ALTER TABLE `ciudad` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `lugar_turistico`
--

LOCK TABLES `lugar_turistico` WRITE;
/*!40000 ALTER TABLE `lugar_turistico` DISABLE KEYS */;
INSERT INTO `lugar_turistico` VALUES (1,'Malecon 2000','El Malecón 2000 es considerado uno de los pro',NULL,'20',1),(2,'Parque Historico','El Parque Histórico de Guayaquil con sus atra',NULL,'10',1),(3,'Isla Santay','En La Isla Santay cree en la existencia de pi',NULL,'14',1),(4,'Zoologico El Pantanal','El Zoológico El Pantanal cuenta con una gran ',NULL,'20',1),(5,'Jardin Botanico','En el Jardín Botanico encontrarás unas 324 es',NULL,'13',1),(6,'Cerro Santa Ana','En el Cerro Santa Ana se mezcla la vida turís',NULL,'15',1),(7,'Hacienda La Danesa','La Hacienda La Danesa es un ambiente rodeado ',NULL,'16',1),(8,'Parque Lago','Parque Lago brinda un espacio lleno de fauna ',NULL,'18',1);
/*!40000 ALTER TABLE `lugar_turistico` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `pais`
--

LOCK TABLES `pais` WRITE;
/*!40000 ALTER TABLE `pais` DISABLE KEYS */;
INSERT INTO `pais` VALUES (1,'Ecuador');
/*!40000 ALTER TABLE `pais` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `plan_viaje`
--

LOCK TABLES `plan_viaje` WRITE;
/*!40000 ALTER TABLE `plan_viaje` DISABLE KEYS */;
/*!40000 ALTER TABLE `plan_viaje` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `provincia`
--

LOCK TABLES `provincia` WRITE;
/*!40000 ALTER TABLE `provincia` DISABLE KEYS */;
INSERT INTO `provincia` VALUES (1,'Azuay','https://img.goraymi.com/2019/09/20/a710c4548f687c209e8d61301495de87_lg.jpg',1),(2,'Bolivar','https://sites.google.com/site/conociendobolivarmdfs/_/rsrc/1495579428803/4-desarrollo-de-contenidos/b-cantones-de-la-provincia/cantones.jpg',1),(3,'Cañar','https://upload.wikimedia.org/wikipedia/commons/thumb/f/f9/Cantones_de_Ca%C3%B1ar.png/300px-Cantones_de_Ca%C3%B1ar.png',1),(4,'Carchi','https://upload.wikimedia.org/wikipedia/commons/thumb/c/cf/Cantones_de_Carchi.png/300px-Cantones_de_Carchi.png',1),(5,'Chimborazo','https://upload.wikimedia.org/wikipedia/commons/thumb/4/44/Chimborazo.JPG/300px-Chimborazo.JPG',1),(6,'Cotopaxi','https://upload.wikimedia.org/wikipedia/commons/thumb/f/fb/Cantones_de_la_Provincia_de_Cotopaxi.JPG/300px-Cantones_de_la_Provincia_de_Cotopaxi.JPG',1),(7,'El Oro','https://4.bp.blogspot.com/-PnK2fmB9S_c/UUoO4Th4AJI/AAAAAAAAABc/WxdWcbz5dmU/s1600/el+oro.jpg',1),(8,'Esmeraldas','https://mapas.owje.com/img620/t-14165-Cantones-de-Esmeraldas-2011.png',1),(9,'Galapagos','https://upload.wikimedia.org/wikipedia/commons/thumb/b/bf/Cantones_de_Gal%C3%A1pagos.png/300px-Cantones_de_Gal%C3%A1pagos.png',1),(10,'Guayas','https://www.gifex.com/images/0X0/2011-11-03-14792/Cantones_del_Guayas.jpg',1),(11,'Imbabura','https://upload.wikimedia.org/wikipedia/commons/thumb/7/71/Cantones_de_Imbabura.png/300px-Cantones_de_Imbabura.png',1),(12,'Loja','https://mapas.owje.com/img620/t-14167-Cantones-de-Loja-2011.png',1),(13,'Los Rios','https://upload.wikimedia.org/wikipedia/commons/thumb/e/e6/Cantones_de_Los_R%C3%ADos.png/250px-Cantones_de_Los_R%C3%ADos.png',1),(14,'Manabi','https://www.manabi.gob.ec/images2010/2010/03/mapa-manabi.jpg',1),(15,'Morona Santiago','https://upload.wikimedia.org/wikipedia/commons/thumb/3/37/Cantones_de_Morona_Santiago.png/300px-Cantones_de_Morona_Santiago.png',1),(16,'Napo','https://1.bp.blogspot.com/-X_fCDaeF7xU/T6LHamQQtqI/AAAAAAAAADQ/0AeVw8fq8TY/s1600/JJJ.jpeg',1),(17,'Orellana','https://upload.wikimedia.org/wikipedia/commons/thumb/2/26/Cantones_de_Orellana.png/350px-Cantones_de_Orellana.png',1),(18,'Pastaza','https://upload.wikimedia.org/wikipedia/commons/thumb/4/4d/Cantones_de_Pastaza.png/350px-Cantones_de_Pastaza.png',1),(19,'Pichincha','https://upload.wikimedia.org/wikipedia/commons/thumb/5/52/Pichincha.png/350px-Pichincha.png',1),(20,'Santa Elena','https://mapas.owje.com/img620/t-14766-Mapa-de-Santa-Elena.jpg',1),(21,'Santo Domingo','https://sertou.files.wordpress.com/2012/03/mapa_de_santo_domingo_de_los_colorados.jpg',1),(22,'Sucumbios','https://upload.wikimedia.org/wikipedia/commons/thumb/4/46/Cantones_de_Sucumb%C3%ADos.png/350px-Cantones_de_Sucumb%C3%ADos.png',1),(23,'Tungurahua','https://upload.wikimedia.org/wikipedia/commons/thumb/3/32/Cantones_de_Tungurahua.png/300px-Cantones_de_Tungurahua.png',1),(24,'Zamora Chimchipe','https://upload.wikimedia.org/wikipedia/commons/thumb/b/b0/Cantones_de_Zamora_Chinchipe.png/387px-Cantones_de_Zamora_Chinchipe.png',1);
/*!40000 ALTER TABLE `provincia` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `usuario`
--

LOCK TABLES `usuario` WRITE;
/*!40000 ALTER TABLE `usuario` DISABLE KEYS */;
INSERT INTO `usuario` VALUES (1,'Cristhofer','Peralta','cristof','verde21000'),(2,'Erika','Peralta','erika01','123456'),(8,'anderson','Sinaluisa','a','1'),(10,'alex','asa','alex','1234');
/*!40000 ALTER TABLE `usuario` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping events for database 'bd_sviajes'
--

--
-- Dumping routines for database 'bd_sviajes'
--
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2020-04-06  0:17:20
