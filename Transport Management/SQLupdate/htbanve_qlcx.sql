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
-- Table structure for table `qlcx`
--

DROP TABLE IF EXISTS `qlcx`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `qlcx` (
  `idQLCX` int NOT NULL,
  `QLCXtencx` varchar(45) NOT NULL,
  `QLCXbsx` varchar(45) NOT NULL,
  `QLCXloaixe` varchar(45) NOT NULL,
  `QLCXngaykh` varchar(45) NOT NULL,
  `QLCXgiokh` varchar(45) NOT NULL,
  `QLCXgiave` varchar(45) NOT NULL,
  `QLCXghe` varchar(45) NOT NULL,
  `QLCXtennv` varchar(45) NOT NULL,
  `QLCXsdtnv` varchar(45) NOT NULL,
  `idphanbiet` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`idQLCX`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `qlcx`
--

LOCK TABLES `qlcx` WRITE;
/*!40000 ALTER TABLE `qlcx` DISABLE KEYS */;
INSERT INTO `qlcx` VALUES (1,'HCM -> Đà Lạt','52B - 19578','Giường nằm','2021-05-22','23:00','240000','20','Dương','0925638573','c645ed6c-c34a-4050-a100-bcea9a2a5f4a'),(3,'Đà Lạt -> HCM','52B - 53475','Phòng nằm','2021-05-26','21:00','270000','29','Dương','0925638573','bfbc5d7a-2651-4dc2-b081-d218dad6a0a1'),(4,'Đà Lạt -> HCM','52B - 56332','Giường nằm','2021-05-22','19:30','240000','29','Dương','0925638573','cb99b522-97b7-452a-915b-3cbbf547dfe0'),(6,'HCM -> Cần Thơ','52B - 83752','Giuờng nằm','2021-06-02','07:30','150000','29','Tuấn','0987124843','c7e7a0a2-03b7-443c-b1b5-b477e71057e4'),(7,'Cần Thơ -> HCM','52G - 83473','Giường nằm','2021-06-05','21:30','150000','29','Tuấn','097124843','86ecd62a-1a6e-483d-973f-7dd47fde7e1a'),(8,'Cần Thơ -> HCM','52G - 83473','Ghế nằm','2021-05-31','21:30','130000','44','Tuấn','097124843','0efe473d-48ce-4610-90b2-ceb899dff620'),(9,'HCM -> Phan Thiết','52G - 27422','Giường nằm cao cấp','2021-05-12','01:30','180000','29','Mai','0327485437','b2756b4c-0eef-4000-8b87-11ae0d8050af'),(10,'HCM -> Phan Thiết','52G - 27422','Giường nằm','2021-05-12','23:30','140000','29','Mai','0327485437','99ee7304-d179-4f30-a5e9-b64bf5634633'),(11,'Phan Thiết -> HCM ','52G - 94830','Giường nằm','2021-05-27','19:00','140000','28','Mai','0327485437','85beb1c5-fdff-479e-9153-a24cefedafdc'),(12,'Phan Thiết -> HCM ','52G - 48352','Ghế nằm','2021-06-03','19:00','110000','45','Mai','0327485437','97a3a2ec-2260-45fc-9c5e-8bb76b9362c2'),(13,'Phan Thiết -> Vũng Tàu','52G - 65372','Giường nằm cao cấp','2021-05-20','21:30','150000','28','Kiệt','0973458535','fcdf5d97-309d-4755-866f-b9f3ba3e7c23'),(14,'Vũng Tàu -> Phan Thiết','52C - 00128','Giường nằm','2021-05-20','13:00','130000','29','Kiệt','097458535','24dc9df7-a961-450f-a304-abb95f5347d2');
/*!40000 ALTER TABLE `qlcx` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2021-05-10 23:31:28
