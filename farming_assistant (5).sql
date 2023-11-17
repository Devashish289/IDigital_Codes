-- MySQL dump 10.13  Distrib 8.0.21, for Win64 (x86_64)
--
-- Host: localhost    Database: farming_assistant
-- ------------------------------------------------------
-- Server version	8.0.21

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
-- Table structure for table `advertisement`
--

DROP TABLE IF EXISTS `advertisement`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `advertisement` (
  `advertisement_Id` varchar(20) NOT NULL,
  `advertisement_Price_Per_Quintal` int NOT NULL,
  `advertisement_Crop_Id` varchar(45) NOT NULL,
  `quantity_In_Quintals` varchar(45) NOT NULL,
  `purpose` varchar(45) NOT NULL,
  `targeted_Audience` varchar(45) NOT NULL,
  `advertisement_Owner_Id` varchar(45) NOT NULL,
  PRIMARY KEY (`advertisement_Id`),
  KEY `ad_Owner_id_idx` (`advertisement_Owner_Id`),
  KEY `ad_Crop_Id_idx` (`advertisement_Crop_Id`),
  CONSTRAINT `ad_Crop_Id` FOREIGN KEY (`advertisement_Crop_Id`) REFERENCES `msp` (`crop_Id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `ad_Owner_id` FOREIGN KEY (`advertisement_Owner_Id`) REFERENCES `profile` (`user_Id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `advertisement`
--

LOCK TABLES `advertisement` WRITE;
/*!40000 ALTER TABLE `advertisement` DISABLE KEYS */;
INSERT INTO `advertisement` VALUES ('Ad10001',2000,'C10001','200','Purchase','Farmer','S10001'),('Ad10002',3000,'C10002','300','Purchase','Farmer','S10002');
/*!40000 ALTER TABLE `advertisement` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `chatbox`
--

DROP TABLE IF EXISTS `chatbox`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `chatbox` (
  `msg_Id` varchar(20) NOT NULL,
  `seller_Id` varchar(45) NOT NULL,
  `buyer_Id` varchar(45) NOT NULL,
  `message` varchar(45) NOT NULL,
  `message_Status` varchar(45) NOT NULL,
  PRIMARY KEY (`msg_Id`),
  KEY `seller_Profile_Id_idx` (`seller_Id`),
  KEY `buyer_Profile_Id_idx` (`buyer_Id`),
  CONSTRAINT `buyer_Profile_Id` FOREIGN KEY (`buyer_Id`) REFERENCES `profile` (`user_Id`),
  CONSTRAINT `seller_Profile_Id` FOREIGN KEY (`seller_Id`) REFERENCES `profile` (`user_Id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `chatbox`
--

LOCK TABLES `chatbox` WRITE;
/*!40000 ALTER TABLE `chatbox` DISABLE KEYS */;
INSERT INTO `chatbox` VALUES ('C10001','S10001','R10001','Hi','Pending'),('C10002','S10001','R10001','Hlo','Pending');
/*!40000 ALTER TABLE `chatbox` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `complain`
--

DROP TABLE IF EXISTS `complain`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `complain` (
  `complain_Id` varchar(20) NOT NULL,
  `user_Id` varchar(20) NOT NULL,
  `alleged_Person_Id` varchar(20) DEFAULT NULL,
  `complain_Statement` varchar(145) DEFAULT NULL,
  `resolution_Statement` varchar(145) DEFAULT NULL,
  `complain_Status` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`complain_Id`),
  KEY `complain_Userid_idx` (`user_Id`),
  CONSTRAINT `complain_Userid` FOREIGN KEY (`user_Id`) REFERENCES `profile` (`user_Id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `complain`
--

LOCK TABLES `complain` WRITE;
/*!40000 ALTER TABLE `complain` DISABLE KEYS */;
/*!40000 ALTER TABLE `complain` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `login`
--

DROP TABLE IF EXISTS `login`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `login` (
  `user_Id` varchar(16) NOT NULL,
  `password` varchar(20) NOT NULL,
  `role` varchar(15) NOT NULL,
  PRIMARY KEY (`user_Id`),
  CONSTRAINT `login_user_Id` FOREIGN KEY (`user_Id`) REFERENCES `profile` (`user_Id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `login`
--

LOCK TABLES `login` WRITE;
/*!40000 ALTER TABLE `login` DISABLE KEYS */;
/*!40000 ALTER TABLE `login` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `msp`
--

DROP TABLE IF EXISTS `msp`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `msp` (
  `crop_Id` varchar(20) NOT NULL,
  `crop_Name` varchar(45) NOT NULL,
  `msp_Price` int DEFAULT NULL,
  PRIMARY KEY (`crop_Id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `msp`
--

LOCK TABLES `msp` WRITE;
/*!40000 ALTER TABLE `msp` DISABLE KEYS */;
INSERT INTO `msp` VALUES ('C10001','Wheat',2000),('C10002','Rice',2500);
/*!40000 ALTER TABLE `msp` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `offer`
--

DROP TABLE IF EXISTS `offer`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `offer` (
  `offer_Id` int NOT NULL,
  `offered_Price_Per_Quintal` int NOT NULL,
  `status` varchar(45) NOT NULL,
  `offeror_Id` varchar(45) NOT NULL,
  `offer_Reciever_Id` varchar(45) NOT NULL,
  PRIMARY KEY (`offer_Id`),
  KEY `offeror_userid_idx` (`offeror_Id`),
  KEY `offer_Recieverid_idx` (`offer_Reciever_Id`),
  CONSTRAINT `offer_Recieverid` FOREIGN KEY (`offer_Reciever_Id`) REFERENCES `profile` (`user_Id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `offeror_userid` FOREIGN KEY (`offeror_Id`) REFERENCES `profile` (`user_Id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `offer`
--

LOCK TABLES `offer` WRITE;
/*!40000 ALTER TABLE `offer` DISABLE KEYS */;
/*!40000 ALTER TABLE `offer` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `profile`
--

DROP TABLE IF EXISTS `profile`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `profile` (
  `user_Id` varchar(20) NOT NULL,
  `user_Name` varchar(45) NOT NULL,
  `phone_Number` varchar(45) NOT NULL,
  `address` varchar(45) NOT NULL,
  `location` varchar(45) NOT NULL,
  `role` varchar(45) NOT NULL,
  PRIMARY KEY (`user_Id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `profile`
--

LOCK TABLES `profile` WRITE;
/*!40000 ALTER TABLE `profile` DISABLE KEYS */;
INSERT INTO `profile` VALUES ('F10001','Dheeraj','7885665555','gokuldham colony','Mumbai','Farmer'),('F10002','Ketan','8555588844','chetan colony','Pune','Farmer'),('R10001','Amit','7894563214','giriraj colony','Bathinda','Retailer'),('R10002','Gagan','6542589634','rm colony','Meerut','Retailer'),('S10001','Shivam','1122334455','azar colony','Noida','Supplier'),('S10002','Sahil','6655445561','singla colony','Mansa','Supplier');
/*!40000 ALTER TABLE `profile` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `stock`
--

DROP TABLE IF EXISTS `stock`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `stock` (
  `supplier_Id` varchar(20) NOT NULL,
  `crop_Id` varchar(20) NOT NULL,
  `crop_Name` varchar(45) NOT NULL,
  `stock_In_Quintals` varchar(45) NOT NULL,
  PRIMARY KEY (`supplier_Id`,`crop_Id`),
  KEY `supplierId` (`supplier_Id`,`crop_Id`),
  KEY `cropid_idx` (`crop_Id`),
  CONSTRAINT `cropid` FOREIGN KEY (`crop_Id`) REFERENCES `msp` (`crop_Id`),
  CONSTRAINT `supplier_Userid` FOREIGN KEY (`supplier_Id`) REFERENCES `profile` (`user_Id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `stock`
--

LOCK TABLES `stock` WRITE;
/*!40000 ALTER TABLE `stock` DISABLE KEYS */;
INSERT INTO `stock` VALUES ('S10001','C10001','Wheat','170'),('S10001','C10002','Rice','150');
/*!40000 ALTER TABLE `stock` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2020-11-02 20:16:21
