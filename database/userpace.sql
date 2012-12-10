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

-- Dumping structure for table webobase.userpace
DROP TABLE IF EXISTS `userpace`;
CREATE TABLE IF NOT EXISTS `userpace` (
  `userId` int(11) NOT NULL,
  `userpace` tinytext NOT NULL,
  `time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`userId`),
  UNIQUE KEY `userId_UNIQUE` (`userId`),
  CONSTRAINT `ID` FOREIGN KEY (`userID`) REFERENCES `userinfo` (`userId`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- Dumping data for table webobase.userpace: ~0 rows (approximately)
DELETE FROM `userpace`;
/*!40000 ALTER TABLE `userpace` DISABLE KEYS */;
INSERT INTO `userpace` (`userId`, `userpace`, `time`) VALUES
	(890902, '吐槽君刚刚加入了CTCommunity，快来围观哦！', '2012-12-10 14:13:07');
/*!40000 ALTER TABLE `userpace` ENABLE KEYS */;
/*!40014 SET FOREIGN_KEY_CHECKS=1 */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
