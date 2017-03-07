-- MySQL dump 10.13  Distrib 5.6.17, for Win32 (x86)
--
-- Host: localhost    Database: risco_friends
-- ------------------------------------------------------
-- Server version	5.6.17

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `person`
--

DROP TABLE IF EXISTS `person`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `person` (
  `login` varchar(20) NOT NULL,
  `name` varchar(50) NOT NULL,
  `password` varchar(150) NOT NULL,
  `age` int(3) DEFAULT NULL,
  `salary` int(5) DEFAULT NULL,
  `birthDate` date DEFAULT NULL,
  PRIMARY KEY (`login`),
  UNIQUE KEY `login` (`login`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `person`
--

LOCK TABLES `person` WRITE;
/*!40000 ALTER TABLE `person` DISABLE KEYS */;
INSERT INTO `person` VALUES ('burak','Rafal Burak','$2a$10$lqE773IP.ZtkEH.geol0DOcTHyxS73W91Cbfr.74Yx.0gj4eoJMjW',36,15000,'1981-04-03'),('chrzan','Marcin Chrzan','$2a$10$4rwzoVNGkAuycP/Nr.8eievp/iEKsM.AVbdkDoIe3joJ94rVu6zfO',55,2500,'1962-03-14'),('cieciorka','Marlena Cieciorka','$2a$10$TeHjb6JIK69URS4OzBmqmur4Iya9cUaL6Sqhl1RhXrt5Y0LIElSva',36,8500,NULL),('cukinia','Angelika Cukinia','$2a$10$2AJC5Lj1KkgOM7WyV8zumeIm/R0WAu/xbF8PNMbSAelMX6namZ5zS',27,6000,'1990-09-24'),('dynia','Alfred Dynia','$2a$10$TPEfXdoRt3bLnMdqQ9Vqhu/el7teOJQSVXgg9jl5kDeYxnZV5oDlS',67,4000,'1950-10-02'),('kapar','Andrzej Kapar','$2a$10$vWD1kJrryZic4/GYLXmDEuAQWJq7NQaF8owsysPquXSh7pRXC9cRO',38,9000,'1979-01-14'),('ogorek','Michal Ogorek','$2a$10$VLaQe7G2zAd8OYTkdYmTauPR8SB0bBBATDS4508yoP0Twl/XfIRki',34,10000,NULL),('pomidor','Monika Pomidor','$2a$10$fZpcwWjulHfEy1EpoT.lVujRvducHZ4RxqEEySI2DGploR9cbODLC',35,4000,NULL),('szparag','Wladzia Szparag','$2a$10$Kbic518kSptbpC/f9OrzSunUAorKE5MkN2hlRQWpt9wK5EUlMpcc2',55,2500,'1962-02-20'),('ziemniak','Pawel Ziemniak','$2a$10$NV6n4uh6WzgMo7Yko5sUGuCVhNLOxJC3H2gVwGRFeDt9Hqo2fkJvS',45,12000,'1972-06-14');
/*!40000 ALTER TABLE `person` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `person_friend`
--

DROP TABLE IF EXISTS `person_friend`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `person_friend` (
  `userLogin` varchar(50) NOT NULL,
  `friendLogin` varchar(50) NOT NULL,
  PRIMARY KEY (`userLogin`,`friendLogin`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `person_friend`
--

LOCK TABLES `person_friend` WRITE;
/*!40000 ALTER TABLE `person_friend` DISABLE KEYS */;
/*!40000 ALTER TABLE `person_friend` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `phone`
--

DROP TABLE IF EXISTS `phone`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `phone` (
  `phoneNumber` varchar(12) NOT NULL,
  `userLogin` varchar(50) NOT NULL,
  PRIMARY KEY (`phoneNumber`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `phone`
--

LOCK TABLES `phone` WRITE;
/*!40000 ALTER TABLE `phone` DISABLE KEYS */;
INSERT INTO `phone` VALUES ('605100101','ogorek'),('605100105','ogorek'),('605200102','ziemniak'),('605300103','dynia'),('605400101','cukinia'),('605400103','cukinia'),('605500105','cieciorka'),('605500107','cieciorka'),('605600108','burak');
/*!40000 ALTER TABLE `phone` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2017-03-08  0:00:14
