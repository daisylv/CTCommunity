-- --------------------------------------------------------
-- Host:                         127.0.0.1
-- Server version:               5.5.28 - MySQL Community Server (GPL)
-- Server OS:                    Win64
-- HeidiSQL version:             7.0.0.4053
-- Date/time:                    2012-12-29 20:00:10
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8 */;
/*!40014 SET FOREIGN_KEY_CHECKS=0 */;

-- Dumping structure for table weicom.community
DROP TABLE IF EXISTS `community`;
CREATE TABLE IF NOT EXISTS `community` (
  `communityId` int(11) NOT NULL AUTO_INCREMENT,
  `picpath` longtext,
  `communityName` varchar(45) NOT NULL,
  `communityIntroduce` mediumtext,
  `communityType` varchar(45) DEFAULT NULL,
  `ownerId` int(10) DEFAULT NULL,
  `pic` longtext,
  PRIMARY KEY (`communityId`),
  UNIQUE KEY `communityId_UNIQUE` (`communityId`),
  KEY `FK_community_userinfo` (`ownerId`),
  CONSTRAINT `FK_community_userinfo` FOREIGN KEY (`ownerId`) REFERENCES `userinfo` (`userId`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=8907915 DEFAULT CHARSET=utf8;

-- Dumping data for table weicom.community: ~35 rows (approximately)
DELETE FROM `community`;
/*!40000 ALTER TABLE `community` DISABLE KEYS */;
INSERT INTO `community` (`communityId`, `picpath`, `communityName`, `communityIntroduce`, `communityType`, `ownerId`, `pic`) VALUES
	(8907867, NULL, 'hello', 'hello world', '其他', 890897, NULL),
	(8907868, NULL, 'hehe', 'no words', '其他', 542456, NULL),
	(8907880, NULL, '聂蓉', '秦时明月官方CP', '动画片', 890898, NULL),
	(8907881, NULL, '空手道', '空手道交流社区', '运动', 890898, NULL),
	(8907884, NULL, '足球', '', '运动', 890898, NULL),
	(8907885, NULL, '雪糕', '秦时明月', '动画片', 890897, NULL),
	(8907886, NULL, '海贼王', '好看的动画片', '动画片', 890897, NULL),
	(8907887, NULL, '秦时明月外挂', '动画片里的各种外挂', '动画片', 890897, NULL),
	(8907888, NULL, '剑谱排行榜', '秦时明月？大名剑', '动画片', 890897, NULL),
	(8907889, NULL, '国产动画', '优秀国产国画讨论', '动画片', 890903, NULL),
	(8907890, NULL, '薛凯琪', '欣赏薛凯琪的歌', '音乐', 890903, NULL),
	(8907891, NULL, '粤语', '大家一起学粤语', '语言', 890897, NULL),
	(8907892, NULL, '请问额', '地热污染', '非主流', 890898, NULL),
	(8907893, NULL, 'D', '', '非主流', 123456, NULL),
	(8907894, NULL, 'w', '', '', 123456, NULL),
	(8907895, NULL, 'x', '', '', 123456, NULL),
	(8907896, NULL, 'b', '', '', 123456, NULL),
	(8907897, NULL, 's', '', '', 123456, NULL),
	(8907898, NULL, 'a', '', '', 123456, NULL),
	(8907899, NULL, 'a', '', '', 123456, NULL),
	(8907900, NULL, 'as', '', '', 123456, NULL),
	(8907901, NULL, 'asdd', '', '', 123456, NULL),
	(8907902, NULL, 'qwe', '', '', 123456, NULL),
	(8907903, NULL, '阿德', '囧人囧事', '其他', 123456, NULL),
	(8907904, NULL, '日语爱好者', '大家一起学习日语', '语言', 890898, NULL),
	(8907905, NULL, 'Java', '谈论java编程', 'IT', 123456, NULL),
	(8907906, NULL, 'ds', '', '', 890904, NULL),
	(8907907, NULL, 's', '', '', 890904, NULL),
	(8907908, NULL, '过年', '放假了', '情感', 123456, NULL),
	(8907909, NULL, '少年派', '电影谈论区', '电影', 123456, NULL),
	(8907910, NULL, '少年派', '电影谈论区', '电影', 123456, NULL),
	(8907911, NULL, '第三方的', '发vdasf ', '其他', 123456, NULL),
	(8907912, NULL, '大水法', '发送', '-1', 123456, NULL),
	(8907913, NULL, '小提琴', '初级开始练习', '音乐', 890898, NULL),
	(8907914, NULL, '八卦', '各种八卦汇集', '其他', 890898, NULL);
/*!40000 ALTER TABLE `community` ENABLE KEYS */;


-- Dumping structure for table weicom.communityitem
DROP TABLE IF EXISTS `communityitem`;
CREATE TABLE IF NOT EXISTS `communityitem` (
  `topicId` int(11) NOT NULL AUTO_INCREMENT,
  `userId` int(11) NOT NULL,
  `communityId` int(11) NOT NULL,
  `tpContent` text,
  `tpPic` text,
  `tpTitle` char(60) NOT NULL,
  `createTime` timestamp NULL DEFAULT NULL,
  PRIMARY KEY (`topicId`),
  UNIQUE KEY `topicId_UNIQUE` (`topicId`),
  KEY `fk_userId_idx` (`userId`),
  KEY `fk_communityId_idx` (`communityId`),
  CONSTRAINT `fk_communityId` FOREIGN KEY (`communityId`) REFERENCES `community` (`communityId`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_userId` FOREIGN KEY (`userId`) REFERENCES `userinfo` (`userId`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=27 DEFAULT CHARSET=utf8;

-- Dumping data for table weicom.communityitem: ~12 rows (approximately)
DELETE FROM `communityitem`;
/*!40000 ALTER TABLE `communityitem` DISABLE KEYS */;
INSERT INTO `communityitem` (`topicId`, `userId`, `communityId`, `tpContent`, `tpPic`, `tpTitle`, `createTime`) VALUES
	(1, 890904, 8907907, 'content', NULL, 'name', '2012-12-29 01:04:05'),
	(13, 123456, 8907893, 'content', NULL, 'name', '2012-12-28 23:14:40'),
	(17, 123456, 8907893, 'content', NULL, 'name', '2012-12-28 23:34:22'),
	(18, 123456, 8907893, 'content', NULL, 'name', '2012-12-28 23:38:21'),
	(19, 123456, 8907893, 'content', NULL, 'name', '2012-12-28 23:48:18'),
	(20, 123456, 8907893, 'content', NULL, 'name', '2012-12-29 00:36:00'),
	(21, 123456, 8907893, 'content', NULL, 'name', '2012-12-29 00:36:03'),
	(22, 123456, 8907881, 'content', NULL, 'name', '2012-12-29 15:49:15'),
	(23, 123456, 8907910, 'content', NULL, 'name', '2012-12-29 16:20:29'),
	(24, 123456, 8907911, 'content', NULL, 'name', '2012-12-29 16:25:35'),
	(25, 123456, 8907912, 'content', NULL, 'name', '2012-12-29 16:30:18'),
	(26, 890898, 8907914, '我把数据库搞错了，怪不得没插入数据', NULL, '今天的囧事', '2012-12-29 19:44:44');
/*!40000 ALTER TABLE `communityitem` ENABLE KEYS */;


-- Dumping structure for table weicom.communitymember
DROP TABLE IF EXISTS `communitymember`;
CREATE TABLE IF NOT EXISTS `communitymember` (
  `userId` int(11) NOT NULL,
  `communityId` int(11) NOT NULL,
  KEY `FK_communitymember_userinfo` (`userId`),
  KEY `FK_communitymember_community` (`communityId`),
  CONSTRAINT `FK_communitymember_community` FOREIGN KEY (`communityId`) REFERENCES `community` (`communityId`),
  CONSTRAINT `FK_communitymember_userinfo` FOREIGN KEY (`userId`) REFERENCES `userinfo` (`userId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- Dumping data for table weicom.communitymember: ~16 rows (approximately)
DELETE FROM `communitymember`;
/*!40000 ALTER TABLE `communitymember` DISABLE KEYS */;
INSERT INTO `communitymember` (`userId`, `communityId`) VALUES
	(890897, 8907867),
	(542456, 8907868),
	(123456, 8907893),
	(890904, 8907906),
	(890904, 8907907),
	(890898, 8907881),
	(890898, 8907884),
	(123456, 8907881),
	(123456, 8907908),
	(890898, 8907892),
	(123456, 8907909),
	(123456, 8907910),
	(123456, 8907911),
	(123456, 8907912),
	(890898, 8907913),
	(890898, 8907914);
/*!40000 ALTER TABLE `communitymember` ENABLE KEYS */;


-- Dumping structure for table weicom.itemreply
DROP TABLE IF EXISTS `itemreply`;
CREATE TABLE IF NOT EXISTS `itemreply` (
  `replyId` int(11) NOT NULL AUTO_INCREMENT,
  `rpContent` text NOT NULL,
  `userId` int(11) NOT NULL,
  `topicId` int(11) NOT NULL,
  `rpPic` varchar(45) DEFAULT NULL,
  `username` varchar(45) NOT NULL,
  `communityId` int(11) NOT NULL,
  `targetId` int(11) DEFAULT NULL,
  `createTime` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`replyId`),
  KEY `fk_userId3_idx` (`userId`),
  KEY `fk_communityId_idx` (`communityId`),
  KEY `fk_itemId_idx` (`topicId`),
  CONSTRAINT `fk_communityId2` FOREIGN KEY (`communityId`) REFERENCES `community` (`communityId`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_itemId` FOREIGN KEY (`topicId`) REFERENCES `communityitem` (`topicId`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_userId3` FOREIGN KEY (`userId`) REFERENCES `userinfo` (`userId`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8;

-- Dumping data for table weicom.itemreply: ~11 rows (approximately)
DELETE FROM `itemreply`;
/*!40000 ALTER TABLE `itemreply` DISABLE KEYS */;
INSERT INTO `itemreply` (`replyId`, `rpContent`, `userId`, `topicId`, `rpPic`, `username`, `communityId`, `targetId`, `createTime`) VALUES
	(1, 'dsfsd', 123456, 21, NULL, 'DDD', 8907893, NULL, '2012-12-29 00:41:31'),
	(2, '三', 123456, 21, NULL, 'DDD', 8907893, 1, '2012-12-29 00:41:40'),
	(3, 'dd', 890904, 21, NULL, '梦落檀香', 8907893, NULL, '2012-12-29 01:05:25'),
	(4, '肉骨头让他', 123456, 22, NULL, 'DDD', 8907881, NULL, '2012-12-29 15:49:35'),
	(5, '喂！', 890898, 22, NULL, 'Daisy', 8907881, 4, '2012-12-29 15:50:25'),
	(6, '地方撒地方', 123456, 24, NULL, 'DDD', 8907911, NULL, '2012-12-29 16:25:44'),
	(7, '地方撒', 123456, 24, NULL, 'DDD', 8907911, NULL, '2012-12-29 16:25:51'),
	(8, '额。。。', 123456, 26, NULL, 'DDD', 8907914, NULL, '2012-12-29 19:45:57'),
	(9, '好吧。。。', 123456, 26, NULL, 'DDD', 8907914, NULL, '2012-12-29 19:46:10'),
	(10, '…………………………', 123456, 26, NULL, 'DDD', 8907914, NULL, '2012-12-29 19:46:27'),
	(11, '这。。。 ', 890897, 26, NULL, 'OOO', 8907914, NULL, '2012-12-29 19:47:29');
/*!40000 ALTER TABLE `itemreply` ENABLE KEYS */;


-- Dumping structure for table weicom.msglist
DROP TABLE IF EXISTS `msglist`;
CREATE TABLE IF NOT EXISTS `msglist` (
  `senderId` int(11) NOT NULL,
  `receiverId` int(11) NOT NULL,
  `communityId` int(11) NOT NULL,
  `content` text NOT NULL,
  `msgId` int(11) NOT NULL AUTO_INCREMENT,
  PRIMARY KEY (`msgId`),
  KEY `FK_msglist_userinfo` (`senderId`),
  KEY `FK_msglist_userinfo_2` (`receiverId`),
  KEY `FK_msglist_community` (`communityId`),
  CONSTRAINT `FK_msglist_community` FOREIGN KEY (`communityId`) REFERENCES `community` (`communityId`),
  CONSTRAINT `FK_msglist_userinfo` FOREIGN KEY (`senderId`) REFERENCES `userinfo` (`userId`),
  CONSTRAINT `FK_msglist_userinfo_2` FOREIGN KEY (`receiverId`) REFERENCES `userinfo` (`userId`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- Dumping data for table weicom.msglist: ~1 rows (approximately)
DELETE FROM `msglist`;
/*!40000 ALTER TABLE `msglist` DISABLE KEYS */;
INSERT INTO `msglist` (`senderId`, `receiverId`, `communityId`, `content`, `msgId`) VALUES
	(123456, 890898, 8907914, 'DDD申请加入社区：八卦', 1);
/*!40000 ALTER TABLE `msglist` ENABLE KEYS */;


-- Dumping structure for table weicom.notice
DROP TABLE IF EXISTS `notice`;
CREATE TABLE IF NOT EXISTS `notice` (
  `noticeId` int(11) NOT NULL AUTO_INCREMENT,
  `toUserId` int(11) NOT NULL,
  `topicId` int(11) NOT NULL,
  `replyId` int(11) DEFAULT NULL,
  `topicUrl` text NOT NULL,
  `fromUsername` varchar(45) NOT NULL,
  `noticed` int(11) NOT NULL,
  `tpTitle` varchar(60) NOT NULL,
  PRIMARY KEY (`noticeId`),
  KEY `fk_toUserId_idx` (`toUserId`),
  KEY `fk_replyId_idx` (`replyId`),
  KEY `fk_topicId2_idx` (`topicId`),
  CONSTRAINT `fk_replyId` FOREIGN KEY (`replyId`) REFERENCES `itemreply` (`replyId`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `fk_topicId2` FOREIGN KEY (`topicId`) REFERENCES `communityitem` (`topicId`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `fk_toUserId` FOREIGN KEY (`toUserId`) REFERENCES `userinfo` (`userId`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8;

-- Dumping data for table weicom.notice: ~7 rows (approximately)
DELETE FROM `notice`;
/*!40000 ALTER TABLE `notice` DISABLE KEYS */;
INSERT INTO `notice` (`noticeId`, `toUserId`, `topicId`, `replyId`, `topicUrl`, `fromUsername`, `noticed`, `tpTitle`) VALUES
	(1, 123456, 21, NULL, 'localhost:8080/CTCommunity/communityAction/Reply.action?topicId=21', '梦落檀香', 0, 'name'),
	(2, 123456, 22, NULL, 'localhost:8080/CTCommunity/communityAction/Reply.action?topicId=22', 'Daisy', 0, 'name'),
	(3, 123456, 22, 4, 'localhost:8080/CTCommunity/communityAction/Reply.action?topicId=22', 'Daisy', 0, 'name'),
	(4, 890898, 26, NULL, 'localhost:8080/CTCommunity/communityAction/Reply.action?topicId=26', 'DDD', 1, '今天的囧事'),
	(5, 890898, 26, NULL, 'localhost:8080/CTCommunity/communityAction/Reply.action?topicId=26', 'DDD', 1, '今天的囧事'),
	(6, 890898, 26, NULL, 'localhost:8080/CTCommunity/communityAction/Reply.action?topicId=26', 'DDD', 1, '今天的囧事'),
	(7, 890898, 26, NULL, 'localhost:8080/CTCommunity/communityAction/Reply.action?topicId=26', 'OOO', 1, '今天的囧事');
/*!40000 ALTER TABLE `notice` ENABLE KEYS */;


-- Dumping structure for table weicom.topicinfo
DROP TABLE IF EXISTS `topicinfo`;
CREATE TABLE IF NOT EXISTS `topicinfo` (
  `topicId` int(11) NOT NULL,
  `updateTime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `replyNum` int(11) NOT NULL DEFAULT '0',
  `replier` varchar(45) DEFAULT NULL,
  `author` varchar(45) NOT NULL,
  `hitNum` int(11) NOT NULL DEFAULT '0',
  PRIMARY KEY (`topicId`),
  UNIQUE KEY `topicId_UNIQUE` (`topicId`),
  CONSTRAINT `fk_itemId2` FOREIGN KEY (`topicId`) REFERENCES `communityitem` (`topicId`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- Dumping data for table weicom.topicinfo: ~12 rows (approximately)
DELETE FROM `topicinfo`;
/*!40000 ALTER TABLE `topicinfo` DISABLE KEYS */;
INSERT INTO `topicinfo` (`topicId`, `updateTime`, `replyNum`, `replier`, `author`, `hitNum`) VALUES
	(1, '2012-12-29 01:04:05', 0, NULL, '梦落檀香', 0),
	(13, '2012-12-28 23:27:03', 0, NULL, 'DDD', 0),
	(17, '2012-12-28 23:34:22', 0, NULL, 'DDD', 0),
	(18, '2012-12-28 23:38:21', 0, NULL, 'DDD', 0),
	(19, '2012-12-28 23:48:18', 0, NULL, 'DDD', 0),
	(20, '2012-12-29 00:36:00', 0, NULL, 'DDD', 0),
	(21, '2012-12-29 01:05:25', 3, '梦落檀香', 'DDD', 0),
	(22, '2012-12-29 15:50:25', 2, 'Daisy', 'DDD', 0),
	(23, '2012-12-29 16:20:29', 0, NULL, 'DDD', 0),
	(24, '2012-12-29 16:26:00', 2, 'DDD', 'DDD', 0),
	(25, '2012-12-29 16:30:18', 0, NULL, 'DDD', 0),
	(26, '2012-12-29 19:47:29', 4, 'OOO', 'Daisy', 0);
/*!40000 ALTER TABLE `topicinfo` ENABLE KEYS */;


-- Dumping structure for table weicom.userinfo
DROP TABLE IF EXISTS `userinfo`;
CREATE TABLE IF NOT EXISTS `userinfo` (
  `userId` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(45) DEFAULT '',
  `usergender` varchar(45) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT '',
  `password` varchar(45) DEFAULT '',
  `picpath` longtext,
  PRIMARY KEY (`userId`),
  UNIQUE KEY `userId_UNIQUE` (`userId`)
) ENGINE=InnoDB AUTO_INCREMENT=890906 DEFAULT CHARSET=utf8;

-- Dumping data for table weicom.userinfo: ~10 rows (approximately)
DELETE FROM `userinfo`;
/*!40000 ALTER TABLE `userinfo` DISABLE KEYS */;
INSERT INTO `userinfo` (`userId`, `username`, `usergender`, `password`, `picpath`) VALUES
	(123456, 'DDD', 'F', '111', '/CTCommunity/upload/1356762180096.jpg'),
	(542456, 'KKK', 'M', NULL, '/CTCommunity/jsp/res/headpic.jpg'),
	(678798, 'PPP', 'F', NULL, '/CTCommunity/jsp/res/headpic.jpg'),
	(890897, 'OOO', 'F', '12', '/CTCommunity/jsp/res/headpic.jpg'),
	(890898, 'Daisy', '女', '12345', '/CTCommunity/jsp/res/headpic.jpg'),
	(890900, '二逼', '男', '1212', '/CTCommunity/jsp/res/headpic.jpg'),
	(890902, '吐槽君', '男', '2222', NULL),
	(890903, 'Newers', '男', 'zxcvbnm', NULL),
	(890904, '梦落檀香', '', '', 'http://tp3.sinaimg.cn/1303889782/180/39998117551/0'),
	(890905, '123qwewer', '2', '1234567', NULL);
/*!40000 ALTER TABLE `userinfo` ENABLE KEYS */;


-- Dumping structure for table weicom.userpace
DROP TABLE IF EXISTS `userpace`;
CREATE TABLE IF NOT EXISTS `userpace` (
  `userId` int(11) NOT NULL,
  `userpace` tinytext NOT NULL,
  `time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `paceId` int(11) NOT NULL,
  PRIMARY KEY (`paceId`),
  KEY `ID` (`userId`),
  CONSTRAINT `ID` FOREIGN KEY (`userId`) REFERENCES `userinfo` (`userId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- Dumping data for table weicom.userpace: ~10 rows (approximately)
DELETE FROM `userpace`;
/*!40000 ALTER TABLE `userpace` DISABLE KEYS */;
INSERT INTO `userpace` (`userId`, `userpace`, `time`, `paceId`) VALUES
	(123456, 'DDD刚刚申请了加入社区：空手道，快来围观哦！', '2012-12-29 02:07:37', 1),
	(123456, 'DDD刚刚在CTCommunity新建了社区：过年，快来围观哦！', '2012-12-29 14:39:13', 2),
	(890905, '123qwewer刚刚加入了CTCommunity，快来围观哦！', '2012-12-29 14:44:24', 3),
	(123456, 'DDD刚刚在CTCommunity新建了社区：少年派，快来围观哦！', '2012-12-29 16:05:25', 4),
	(123456, 'DDD刚刚在CTCommunity新建了社区：少年派，快来围观哦！', '2012-12-29 16:19:59', 5),
	(123456, 'DDD刚刚在CTCommunity新建了社区：第三方的，快来围观哦！', '2012-12-29 16:25:12', 6),
	(123456, 'DDD刚刚在CTCommunity新建了社区：大水法，快来围观哦！', '2012-12-29 16:30:09', 7),
	(890898, 'Daisy刚刚在CTCommunity新建了社区：小提琴，快来围观哦！', '2012-12-29 19:13:12', 8),
	(890898, 'Daisy刚刚在CTCommunity新建了社区：八卦，快来围观哦！', '2012-12-29 19:39:35', 9),
	(123456, 'DDD刚刚申请了加入社区：八卦，快来围观哦！', '2012-12-29 19:51:17', 10);
/*!40000 ALTER TABLE `userpace` ENABLE KEYS */;


-- Dumping structure for table weicom.weiboinfo
DROP TABLE IF EXISTS `weiboinfo`;
CREATE TABLE IF NOT EXISTS `weiboinfo` (
  `userId` int(11) NOT NULL DEFAULT '0',
  `weiboId` char(20) NOT NULL,
  `accessToken` char(64) NOT NULL,
  `refreshToken` varchar(45) DEFAULT NULL,
  `expireTime` char(20) DEFAULT NULL,
  `weiboName` varchar(45) NOT NULL,
  `picpath` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`userId`),
  UNIQUE KEY `weiboId_UNIQUE` (`weiboId`),
  UNIQUE KEY `accessToken_UNIQUE` (`accessToken`),
  UNIQUE KEY `userId_UNIQUE` (`userId`),
  UNIQUE KEY `refreshToken_UNIQUE` (`refreshToken`),
  KEY `fk_pk_idx` (`userId`),
  CONSTRAINT `fk_pk` FOREIGN KEY (`userId`) REFERENCES `userinfo` (`userId`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- Dumping data for table weicom.weiboinfo: ~1 rows (approximately)
DELETE FROM `weiboinfo`;
/*!40000 ALTER TABLE `weiboinfo` DISABLE KEYS */;
INSERT INTO `weiboinfo` (`userId`, `weiboId`, `accessToken`, `refreshToken`, `expireTime`, `weiboName`, `picpath`) VALUES
	(890904, '1303889782', '2.003SzO7BpOSBMC4bf203ab1cPUWm6D', NULL, '157679999', '梦落檀香', 'http://tp3.sinaimg.cn/1303889782/180/39998117551/0');
/*!40000 ALTER TABLE `weiboinfo` ENABLE KEYS */;


-- Dumping structure for trigger weicom.userConn
DROP TRIGGER IF EXISTS `userConn`;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='STRICT_TRANS_TABLES,NO_AUTO_CREATE_USER,NO_ENGINE_SUBSTITUTION';
DELIMITER //
CREATE TRIGGER `userConn` BEFORE INSERT ON `weiboinfo` FOR EACH ROW BEGIN
declare uid int;
    INSERT INTO userinfo SET username = NEW.weiboName, picpath = NEW.picpath;
SELECT max(userId) into uid from userinfo;
set new.userId = uid;
END//
DELIMITER ;
SET SQL_MODE=@OLD_SQL_MODE;
/*!40014 SET FOREIGN_KEY_CHECKS=1 */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
