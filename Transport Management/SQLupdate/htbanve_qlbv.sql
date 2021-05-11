-- MySQL dump 10.13  Distrib 8.0.22, for Win64 (x86_64)
--
-- Host: localhost    Database: htbanve
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
  `QLBVloaixe` varchar(45) NOT NULL,
  `QLBVngaykh` varchar(45) NOT NULL,
  `QLBVgiokh` varchar(45) NOT NULL,
  `QLBVgiave` varchar(45) NOT NULL,
  `QLBVghe` varchar(45) NOT NULL,
  `QLBVtennv` varchar(45) NOT NULL,
  `QLBVsdtnv` varchar(45) NOT NULL,
  `QLBVtenkh` varchar(45) NOT NULL,
  `QLBVsdtkh` varchar(45) NOT NULL,
  `idphanbiet` varchar(45) NOT NULL,
  PRIMARY KEY (`QLBVid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `qlbv`
--

LOCK TABLES `qlbv` WRITE;
/*!40000 ALTER TABLE `qlbv` DISABLE KEYS */;
INSERT INTO `qlbv` VALUES ('05ddd568-bd83-4b26-884f-57afeec34323','HCM -> Đà Lạt','52B - 54723','Ghế nằm','2021-05-26','01:00','210000','29','Dương','0925638573','Lê Thị Thùy','033853135','915169d1-54b4-484f-be24-4fe25ed928a7'),('2bf71706-f065-4d5d-ae1c-ccfc68b69b6b','Cần Thơ -> HCM','52G - 83473','Ghế nằm','2021-05-31','21:30','130000','45','Tuấn','097124843','Hoàng Trung Dũng','094724131','42d0d948-8421-49e0-8588-0b6656599c25'),('37f8408f-12ad-415c-835f-7c801efdd30b','Đà Lạt -> HCM','52B - 56332','Giường nằm','2021-05-22','19:30','240000','34','Dương','0925638573','Nguyễn Bình An','0983654682','002a4e0b-3530-4c85-9a50-ed6e0f771c38'),('3de46267-7f2a-4cb3-95db-90b6afc8ac27','Vũng Tàu -> Phan Thiết','52C - 65631','Giường nằm','2021-07-06','08:30','130000','29','Kiệt','0973458535','Lê Tuấn Huy','0327582320','946ed7d0-22b2-4825-978c-e68b2da191f2'),('7d8d37ca-784d-4c13-bf29-68092f0cf1e1','Phan Thiết -> HCM ','52G - 94830','Giường nằm','2021-05-27','19:00','140000','29','Mai','0327485437','Nguyễn Thị Ngọc','0912349531','9fffdd66-6534-4321-9b81-a8afa0ac9f2c');
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

-- Dump completed on 2021-05-10 23:03:17
