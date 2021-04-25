-- MySQL dump 10.13  Distrib 8.0.22, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: htbanve
-- ------------------------------------------------------
-- Server version	8.0.22

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
-- Table structure for table `qlbv`
--

DROP TABLE IF EXISTS `qlbv`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `qlbv` (
  `QLBVid` varchar(45) NOT NULL,
  `QLBVtencx` varchar(45) NOT NULL,
  `QLBVbsx` varchar(45) NOT NULL,
  `QLBVgiokh` varchar(45) NOT NULL,
  `QLBVngaykh` varchar(45) NOT NULL,
  `QLBVgiave` varchar(45) NOT NULL,
  `QLBVloaixe` varchar(45) NOT NULL,
  `QLBVtenkh` varchar(45) NOT NULL,
  `QLBVsdtkh` varchar(45) NOT NULL,
  `QLBVtennv` varchar(45) NOT NULL,
  `QLBVsdtnv` varchar(45) NOT NULL,
  `QLBVghe` varchar(45) NOT NULL,
  `idphanbiet` varchar(45) NOT NULL,
  PRIMARY KEY (`QLBVid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `qlbv`
--

LOCK TABLES `qlbv` WRITE;
/*!40000 ALTER TABLE `qlbv` DISABLE KEYS */;
INSERT INTO `qlbv` VALUES ('24569783-a412-43ec-a284-a136c1e4a5bc','HN->BMT','H1765','09:48','2020-12-13','150.000','Vip','Tung','123456','Tung','0823771887','','659a966a-cf7e-4dc7-8d06-af5dd4438971'),('604cdf70-980c-4cc3-8657-a6380a8b0be9','HN->SG','H11564AS','09:41','2020-12-13','150.000','Thuong','Quang Tung','033605115','Tung','0823771887','A02','c70f85b4-b598-4f41-a540-ae7427da23a6');
/*!40000 ALTER TABLE `qlbv` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2020-12-14  4:07:25
