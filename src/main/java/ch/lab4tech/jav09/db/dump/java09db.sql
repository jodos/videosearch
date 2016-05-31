-- MySQL dump 10.13  Distrib 5.5.28, for Win32 (x86)
--
-- Host: localhost    Database: jav09db
-- ------------------------------------------------------
-- Server version	5.5.28

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
-- Table structure for table `tblcategories`
--

DROP TABLE IF EXISTS `tblcategories`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tblcategories` (
  `CategoryCode` int(11) NOT NULL,
  `Description` varchar(45) NOT NULL,
  PRIMARY KEY (`CategoryCode`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tblcategories`
--

LOCK TABLES `tblcategories` WRITE;
/*!40000 ALTER TABLE `tblcategories` DISABLE KEYS */;
INSERT INTO `tblcategories` VALUES (1,'Action/Aventure'),(2,'Drame'),(3,'Horreur'),(4,'Comédie'),(5,'Enfants'),(6,'Familial'),(7,'Science Fiction');
/*!40000 ALTER TABLE `tblcategories` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tblmovietitles`
--

DROP TABLE IF EXISTS `tblmovietitles`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tblmovietitles` (
  `TitleNo` int(11) NOT NULL,
  `Title` varchar(45) NOT NULL,
  `Description` varchar(50) NOT NULL,
  `Rating` varchar(10) NOT NULL,
  `CategoryCode` int(11) NOT NULL,
  `RetailPrice` varchar(45) NOT NULL,
  `RentalPrice` varchar(45) NOT NULL,
  `CopiesPurchased` int(11) NOT NULL,
  PRIMARY KEY (`TitleNo`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tblmovietitles`
--

LOCK TABLES `tblmovietitles` WRITE;
/*!40000 ALTER TABLE `tblmovietitles` DISABLE KEYS */;
INSERT INTO `tblmovietitles` VALUES (1,'Piège de Cristal','Bruce Willis dans un film d\'action et d\'aventure','R',1,'CHF 20.95','CHF 2.50',3),(2,'Dumb & Dumber','Film fou!','PG-13',4,'CHF 15.95','CHF 3.00',6),(5,'La liste de Schindler','Film très intense au sujet de l\'Holocauste.','R',2,'CHF 20.00','CHF 3.00',0),(6,'The Mask','De grands effets spéciaux basés sue une BD.','PG-13',4,'CHF 20.00','CHF 3.00',0),(7,'Balto','Animation au sujet de chiens d\'Alaska.','G',4,'CHF 25.00','CHF 3.00',0),(8,'Rapid Fire','Le meilleur film d\'arts martiaux de Brandon Lee.','R',1,'CHF 25.00','CHF 3.00',0),(9,'Star Trek V','The entreprise voyage dans le temps.','PG',7,'CHF 25.00','CHF 3.00',0),(10,'Crimson Tide','Mésaventures d\'un sous-marin.','R',2,'CHF 25.00','CHF 3.00',0),(11,'Monty Python et le sacré Graal','Folie à la cour du roi Arthur.','PG',4,'CHF 20.00','CHF 3.00',0),(18,'Piège de Cristal 2','Bruce Willis dans un film d\'action et d\'aventure.','PG-13',4,'CHF 0.00','CHF 0.00',0);
/*!40000 ALTER TABLE `tblmovietitles` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tblratings`
--

DROP TABLE IF EXISTS `tblratings`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tblratings` (
  `Rating` varchar(10) NOT NULL,
  `Description` varchar(150) DEFAULT NULL,
  PRIMARY KEY (`Rating`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tblratings`
--

LOCK TABLES `tblratings` WRITE;
/*!40000 ALTER TABLE `tblratings` DISABLE KEYS */;
INSERT INTO `tblratings` VALUES ('G','Audience Générale'),('NC-18','Interdit au moins de 18 ans'),('PG','Accompagnement parental suggéré'),('PG-13','Accompagnement parental suggéré pour les enfants de moins de 13 ans'),('R','Adulte requis pour les enfants de moins de 17 ans');
/*!40000 ALTER TABLE `tblratings` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2012-10-31 11:54:08
