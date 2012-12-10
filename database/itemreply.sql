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

-- Dumping structure for table webobase.itemreply
DROP TABLE IF EXISTS `itemreply`;
CREATE TABLE IF NOT EXISTS `itemreply` (
  `itemId` int(11) NOT NULL,
  `replyerId` int(11) NOT NULL,
  `content` longtext NOT NULL,
  PRIMARY KEY (`itemId`),
  KEY `FK_itemreply_userinfo` (`replyerId`),
  CONSTRAINT `FK_itemreply_userinfo` FOREIGN KEY (`replyerId`) REFERENCES `userinfo` (`userId`),
  CONSTRAINT `FK_itemreply_communityitem` FOREIGN KEY (`itemId`) REFERENCES `communityitem` (`Itemid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- Dumping data for table webobase.itemreply: ~0 rows (approximately)
DELETE FROM `itemreply`;
/*!40000 ALTER TABLE `itemreply` DISABLE KEYS */;
/*!40000 ALTER TABLE `itemreply` ENABLE KEYS */;
/*!40014 SET FOREIGN_KEY_CHECKS=1 */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
