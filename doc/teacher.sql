/*
Navicat MySQL Data Transfer

Source Server         : dddd
Source Server Version : 50716
Source Host           : localhost:3306
Source Database       : teacher

Target Server Type    : MYSQL
Target Server Version : 50716
File Encoding         : 65001

Date: 2018-08-16 10:54:42
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for account
-- ----------------------------
DROP TABLE IF EXISTS `account`;
CREATE TABLE `account` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `account` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of account
-- ----------------------------
INSERT INTO `account` VALUES ('1', '85219994', '123');

-- ----------------------------
-- Table structure for teacher
-- ----------------------------
DROP TABLE IF EXISTS `teacher`;
CREATE TABLE `teacher` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `teacher_name` varchar(50) DEFAULT NULL,
  `teacher_birthday` datetime DEFAULT NULL,
  `teacher_sex` varchar(20) DEFAULT NULL,
  `teacher_salary` double DEFAULT NULL,
  `teacher_email` varchar(100) DEFAULT NULL,
  `teacher_type` varchar(100) DEFAULT NULL,
  `teacher_level` varchar(50) DEFAULT NULL,
  `teacher_address` varchar(100) DEFAULT NULL,
  `remark` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of teacher
-- ----------------------------
