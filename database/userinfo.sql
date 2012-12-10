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

-- Dumping structure for table webobase.userinfo
DROP TABLE IF EXISTS `userinfo`;
CREATE TABLE IF NOT EXISTS `userinfo` (
  `userId` int(11) NOT NULL AUTO_INCREMENT,
  `sinaId` int(11) unsigned zerofill DEFAULT '00000000000',
  `username` varchar(45) DEFAULT '',
  `usergender` varchar(45) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT '',
  `password` varchar(45) DEFAULT '',
  PRIMARY KEY (`userId`),
  UNIQUE KEY `userId_UNIQUE` (`userId`)
) ENGINE=InnoDB AUTO_INCREMENT=890904 DEFAULT CHARSET=utf8;

-- Dumping data for table webobase.userinfo: ~7 rows (approximately)
DELETE FROM `userinfo`;
/*!40000 ALTER TABLE `userinfo` DISABLE KEYS */;
INSERT INTO `userinfo` (`userId`, `sinaId`, `username`, `usergender`, `password`) VALUES
	(111111, 00000999999, 'LLL', 'M', NULL),
	(123456, 00000654321, 'DDD', 'F', NULL),
	(542456, 00000764252, 'KKK', 'M', NULL),
	(678798, 00000678687, 'PPP', 'F', NULL),
	(890897, 00000678699, 'OOO', 'F', '12'),
	(890898, 00000000000, 'Daisy', '女', '12345'),
	(890900, 00000000000, '二逼', '男', '1212'),
	(890902, 00000000000, '吐槽君', '男', '2222');
/*!40000 ALTER TABLE `userinfo` ENABLE KEYS */;
/*!40014 SET FOREIGN_KEY_CHECKS=1 */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
