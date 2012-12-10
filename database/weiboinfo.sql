-- --------------------------------------------------------
-- Host:                         127.0.0.1
-- Server version:               5.5.28 - MySQL Community Server (GPL)
-- Server OS:                    Win32
-- HeidiSQL version:             7.0.0.4053
-- Date/time:                    2012-12-10 14:27:13
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8 */;
/*!40014 SET FOREIGN_KEY_CHECKS=0 */;

-- Dumping structure for table webobase.weiboinfo
DROP TABLE IF EXISTS `weiboinfo`;
CREATE TABLE IF NOT EXISTS `weiboinfo` (
  `userId` int(10) NOT NULL AUTO_INCREMENT,
  `weiboId` char(20) NOT NULL,
  `accessToken` char(64) NOT NULL,
  `refreshToken` varchar(45) DEFAULT NULL,
  `expireTime` char(20),
  PRIMARY KEY (`weiboId`),
  UNIQUE KEY `weiboId_UNIQUE` (`weiboId`),
  UNIQUE KEY `accessToken_UNIQUE` (`accessToken`),
  UNIQUE KEY `userId_UNIQUE` (`userId`),
  UNIQUE KEY `refreshToken_UNIQUE` (`refreshToken`),
  CONSTRAINT `FK_weiboinfo_userinfo` FOREIGN KEY (`userId`) REFERENCES `userinfo` (`userId`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- Dumping data for table webobase.weiboinfo: ~0 rows (approximately)
DELETE FROM `weiboinfo`;
/*!40000 ALTER TABLE `weiboinfo` DISABLE KEYS */;
/*!40000 ALTER TABLE `weiboinfo` ENABLE KEYS */;
/*!40014 SET FOREIGN_KEY_CHECKS=1 */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
