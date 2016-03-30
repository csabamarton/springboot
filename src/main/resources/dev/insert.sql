DROP TABLE IF EXISTS `device`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `device` (
  `deviceid` bigint(20) NOT NULL AUTO_INCREMENT,
  `token` varchar(100) COLLATE utf8_hungarian_ci NOT NULL,
  `devicetype` varchar(10) COLLATE utf8_hungarian_ci NOT NULL,
  `devicelang` varchar(5) COLLATE utf8_hungarian_ci NOT NULL,
  `regdate` datetime DEFAULT NULL,
  `userid` bigint(20) DEFAULT NULL,
  `devicetypedescription` text COLLATE utf8_hungarian_ci,
  `lastview` datetime DEFAULT NULL,
  PRIMARY KEY (`deviceid`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8 COLLATE=utf8_hungarian_ci;
/*!40101 SET character_set_client = @saved_cs_client */;
