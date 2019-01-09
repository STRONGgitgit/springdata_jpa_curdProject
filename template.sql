/*
Navicat MySQL Data Transfer

Source Server         : localhost_3306
Source Server Version : 50714
Source Host           : localhost:3306
Source Database       : template

Target Server Type    : MYSQL
Target Server Version : 50714
File Encoding         : 65001

Date: 2018-12-18 22:30:37
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for addr
-- ----------------------------
DROP TABLE IF EXISTS `addr`;
CREATE TABLE `addr` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of addr
-- ----------------------------
INSERT INTO `addr` VALUES ('1', '湖南');
INSERT INTO `addr` VALUES ('2', '深圳');
INSERT INTO `addr` VALUES ('3', '云南');

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `birthday` date DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `sex` int(11) DEFAULT NULL,
  `state` int(11) DEFAULT NULL,
  `addr_id` int(11) DEFAULT NULL,
  `addr` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKoe75c7978jjebp6lechwxi3fs` (`addr_id`),
  CONSTRAINT `FKoe75c7978jjebp6lechwxi3fs` FOREIGN KEY (`addr_id`) REFERENCES `addr` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=26 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('3', '2018-07-26', '123@qq.com', '刘2352', '123', '1', '1', '1', null);
INSERT INTO `user` VALUES ('4', '2018-07-26', '123@qq.com', '吕', '123', '1', '1', '2', null);
INSERT INTO `user` VALUES ('5', '2018-07-26', '123@qq.com', '李', '123', '2', '1', '1', null);
INSERT INTO `user` VALUES ('6', '2018-07-26', '123@qq.com', '林', '123', '1', '1', '1', null);
INSERT INTO `user` VALUES ('7', '2018-07-26', '123@qq.com', '杜', '123', '1', '1', '1', null);
INSERT INTO `user` VALUES ('9', '2018-07-26', '123@qq.com', '熊2', '123', '1', '1', '1', null);
INSERT INTO `user` VALUES ('10', '2018-07-26', '123@qq.com', '熊3', '123', '2', '1', '1', null);
INSERT INTO `user` VALUES ('11', '2018-07-26', '123@qq.com', '熊5', '123', '3', '1', '1', null);
INSERT INTO `user` VALUES ('12', '2018-07-26', '123@qq.com', '熊6', '123', '3', '1', '1', null);
INSERT INTO `user` VALUES ('13', '2018-07-26', '', '熊sdfgsg', '', '1', null, '1', null);
INSERT INTO `user` VALUES ('14', '2018-07-26', '123@qq.com', '熊7', '123', '3', '1', '1', null);
INSERT INTO `user` VALUES ('15', '2018-07-26', '123@qq.com', '熊8', '123', '3', '1', '1', null);
INSERT INTO `user` VALUES ('16', '2018-07-26', '123@qq.com', '熊9', '123', '3', '1', '1', null);
INSERT INTO `user` VALUES ('17', '2018-07-26', '123@qq.com', '熊10', '123', '3', '1', '1', null);
INSERT INTO `user` VALUES ('18', null, null, null, null, null, null, '1', null);
INSERT INTO `user` VALUES ('19', '2018-07-26', '123@qq.com', '熊11', '123', '3', '1', '1', null);
INSERT INTO `user` VALUES ('20', '2018-07-26', '123@qq.com', '熊12', '123', '3', '1', '1', null);
INSERT INTO `user` VALUES ('21', '2018-08-07', '10244@qqcom', 'sdg', '', '2', '0', '1', null);
INSERT INTO `user` VALUES ('22', '1998-07-02', '10244@qqcom', 'lili', '123456', '2', null, '1', null);
INSERT INTO `user` VALUES ('23', '2018-12-12', '235', '23523', '35', '1', null, '1', null);
INSERT INTO `user` VALUES ('25', '2018-12-12', 'sd', '温格也', '35', '1', null, '1', null);
