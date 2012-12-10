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

-- Dumping structure for table webobase.communitymember
DROP TABLE IF EXISTS `communitymember`;
CREATE TABLE IF NOT EXISTS `communitymember` (
  `userId` int(11) NOT NULL,
  `communityId` int(11) NOT NULL,
  PRIMARY KEY (`userId`),
  KEY `FK_communitymember_community` (`communityId`),
  CONSTRAINT `FK_communitymember_community` FOREIGN KEY (`communityId`) REFERENCES `community` (`communityId`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `FK_communitymember_userinfo` FOREIGN KEY (`userId`) REFERENCES `userinfo` (`userId`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- Dumping data for table webobase.communitymember: ~0 rows (approximately)
DELETE FROM `communitymember`;
/*!40000 ALTER TABLE `communitymember` DISABLE KEYS */;
/*!40000 ALTER TABLE `communitymember` ENABLE KEYS */;
/*!40014 SET FOREIGN_KEY_CHECKS=1 */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
