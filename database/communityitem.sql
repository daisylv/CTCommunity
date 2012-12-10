-- --------------------------------------------------------
-- Host:                         127.0.0.1
-- Server version:               5.5.28 - MySQL Community Server (GPL)
-- Server OS:                    Win32
-- HeidiSQL version:             7.0.0.4053
-- Date/time:                    2012-12-10 14:27:12
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8 */;
/*!40014 SET FOREIGN_KEY_CHECKS=0 */;

-- Dumping structure for table webobase.communityitem
DROP TABLE IF EXISTS `communityitem`;
CREATE TABLE IF NOT EXISTS `communityitem` (
  `Itemid` int(11) NOT NULL AUTO_INCREMENT,
  `ItemCountent` longtext,
  `ownerId` int(11) NOT NULL,
  `communityId` int(11) NOT NULL,
  `ItemName` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`Itemid`),
  UNIQUE KEY `Itemid_UNIQUE` (`Itemid`),
  KEY `FK_communityitem_userinfo` (`ownerId`),
  KEY `FK_communityitem_community` (`communityId`),
  CONSTRAINT `FK_communityitem_userinfo` FOREIGN KEY (`ownerId`) REFERENCES `userinfo` (`userId`),
  CONSTRAINT `FK_communityitem_community` FOREIGN KEY (`communityId`) REFERENCES `community` (`communityId`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8;

-- Dumping data for table webobase.communityitem: ~4 rows (approximately)
DELETE FROM `communityitem`;
/*!40000 ALTER TABLE `communityitem` DISABLE KEYS */;
INSERT INTO `communityitem` (`Itemid`, `ItemCountent`, `ownerId`, `communityId`, `ItemName`) VALUES
	(4, 'Hello, I\'d like to know you.', 123456, 8907867, ''),
	(5, 'Hehe, I have no words', 890897, 8907868, ''),
	(6, 'Let\'s talk about love.', 890897, 8907880, ''),
	(10, '大叔你太面瘫了吧！', 890897, 8907880, '郁闷');
/*!40000 ALTER TABLE `communityitem` ENABLE KEYS */;
/*!40014 SET FOREIGN_KEY_CHECKS=1 */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
