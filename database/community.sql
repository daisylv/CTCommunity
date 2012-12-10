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

-- Dumping structure for table webobase.community
DROP TABLE IF EXISTS `community`;
CREATE TABLE IF NOT EXISTS `community` (
  `communityId` int(11) NOT NULL AUTO_INCREMENT,
  `communityName` varchar(45) NOT NULL,
  `communityIntroduce` mediumtext,
  `communityType` varchar(45) DEFAULT NULL,
  `ownerId` int(10) DEFAULT NULL,
  PRIMARY KEY (`communityId`),
  UNIQUE KEY `communityId_UNIQUE` (`communityId`),
  KEY `FK_community_userinfo` (`ownerId`),
  CONSTRAINT `FK_community_userinfo` FOREIGN KEY (`ownerId`) REFERENCES `userinfo` (`userId`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=8907888 DEFAULT CHARSET=utf8;

-- Dumping data for table webobase.community: ~8 rows (approximately)
DELETE FROM `community`;
/*!40000 ALTER TABLE `community` DISABLE KEYS */;
INSERT INTO `community` (`communityId`, `communityName`, `communityIntroduce`, `communityType`, `ownerId`) VALUES
	(8907867, 'hello', 'hello world', 'social', 890897),
	(8907868, 'hehe', 'no words', 'talk', 542456),
	(8907880, '聂蓉', '秦时明月官方CP', '动画片', 890898),
	(8907881, '空手道', '空手道交流社区', '运动', 890898),
	(8907884, '足球', '', '运动', 890898),
	(8907885, '雪糕', '秦时明月', '动画片', 890897),
	(8907886, '海贼王', '好看的动画片', '动画片', 890897),
	(8907887, '秦时明月外挂', '动画片里的各种外挂', '动画片', 890897);
/*!40000 ALTER TABLE `community` ENABLE KEYS */;
/*!40014 SET FOREIGN_KEY_CHECKS=1 */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
