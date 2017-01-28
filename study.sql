/*
Navicat MySQL Data Transfer

Source Server         : localhost_3306
Source Server Version : 50711
Source Host           : localhost:3306
Source Database       : study

Target Server Type    : MYSQL
Target Server Version : 50711
File Encoding         : 65001

Date: 2016-07-11 17:00:53
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for admin
-- ----------------------------
DROP TABLE IF EXISTS `admin`;
CREATE TABLE `admin` (
  `admin_id` varchar(50) CHARACTER SET utf8 NOT NULL,
  `admin_name` varchar(50) CHARACTER SET utf8 DEFAULT NULL,
  `admin_password` varchar(50) CHARACTER SET utf8 DEFAULT NULL,
  PRIMARY KEY (`admin_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- ----------------------------
-- Records of admin
-- ----------------------------
INSERT INTO `admin` VALUES ('1', 'Admin1', '123');
INSERT INTO `admin` VALUES ('2', 'Admin2', '123');

-- ----------------------------
-- Table structure for course
-- ----------------------------
DROP TABLE IF EXISTS `course`;
CREATE TABLE `course` (
  `course_id` int(20) NOT NULL AUTO_INCREMENT,
  `course_name` varchar(50) CHARACTER SET utf8 DEFAULT NULL,
  `course_type` varchar(50) CHARACTER SET utf8 DEFAULT NULL,
  `teacher_id` varchar(50) CHARACTER SET utf8 DEFAULT NULL,
  `teacher_name` varchar(50) CHARACTER SET utf8 DEFAULT NULL,
  `term_id` int(50) DEFAULT NULL,
  `course_info` varchar(300) CHARACTER SET utf8 DEFAULT NULL,
  PRIMARY KEY (`course_id`),
  KEY `teacherId` (`teacher_id`),
  KEY `termId` (`term_id`),
  KEY `teacherName` (`teacher_name`),
  CONSTRAINT `sk_teacher_course_teacher_id` FOREIGN KEY (`teacher_id`) REFERENCES `teacher` (`teacher_id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `sk_term_course_term_id` FOREIGN KEY (`term_id`) REFERENCES `term` (`term_id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=latin1;

-- ----------------------------
-- Records of course
-- ----------------------------
INSERT INTO `course` VALUES ('1', 'English', 'obligatory course', '1', 'Teacher1', '1', 'C1');
INSERT INTO `course` VALUES ('2', 'Chinese', 'obligatory course', '1', 'Teacher1', '1', 'C1');
INSERT INTO `course` VALUES ('3', 'Math', 'obligatory course', '1', 'Teacher1', '1', '123');
INSERT INTO `course` VALUES ('4', 'Software', 'optional course', '2', 'Teacher2', '1', '123');

-- ----------------------------
-- Table structure for homework
-- ----------------------------
DROP TABLE IF EXISTS `homework`;
CREATE TABLE `homework` (
  `homework_id` int(50) NOT NULL AUTO_INCREMENT,
  `course_id` int(20) NOT NULL,
  `content` varchar(300) CHARACTER SET utf8 DEFAULT NULL,
  `deadline` timestamp NULL DEFAULT NULL,
  `resource_location` varchar(300) CHARACTER SET utf8 DEFAULT NULL,
  `homework_name` varchar(50) CHARACTER SET utf8 DEFAULT NULL,
  PRIMARY KEY (`homework_id`),
  KEY `courseId` (`course_id`),
  CONSTRAINT `sk_course_homework_course_id` FOREIGN KEY (`course_id`) REFERENCES `course` (`course_id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=17 DEFAULT CHARSET=latin1;

-- ----------------------------
-- Records of homework
-- ----------------------------
INSERT INTO `homework` VALUES ('4', '1', 'H1', '2016-07-08 05:30:05', 'R1', 'H1');
INSERT INTO `homework` VALUES ('5', '1', 'H2', '2016-07-08 00:00:00', 'R2', 'H2');
INSERT INTO `homework` VALUES ('6', '1', 'H3', '2016-07-08 00:00:00', 'R3', 'H3');
INSERT INTO `homework` VALUES ('7', '1', 'HC1', '2016-07-08 07:08:04', null, 'HN1');
INSERT INTO `homework` VALUES ('8', '1', '作业 一', '2016-07-12 15:27:23', null, '作业 一');
INSERT INTO `homework` VALUES ('9', '1', '111', '2016-07-15 15:06:54', null, '111');
INSERT INTO `homework` VALUES ('10', '1', '111', '2016-06-01 15:25:05', null, '1234');
INSERT INTO `homework` VALUES ('11', '1', '作业描述 ', '2016-07-18 15:49:44', null, 'GM');
INSERT INTO `homework` VALUES ('12', '1', '作业描述 ', '2016-07-19 09:49:29', null, '作业二');
INSERT INTO `homework` VALUES ('13', '1', '作业描述人 ', '2016-08-02 09:50:31', null, '从');
INSERT INTO `homework` VALUES ('14', '1', '作业描述 ', '2016-08-03 09:55:06', null, 'wwww');
INSERT INTO `homework` VALUES ('15', '1', '作业描述 ', '2016-08-02 09:57:30', '/homework/teacher/1/createTable.txt', 'wt');
INSERT INTO `homework` VALUES ('16', '1', '要求各个小组 ', '2016-07-12 13:20:00', '/homework/teacher/1/HMCL-2.1.9.exe', '第一次迭代开发');

-- ----------------------------
-- Table structure for message_board
-- ----------------------------
DROP TABLE IF EXISTS `message_board`;
CREATE TABLE `message_board` (
  `message_board_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `username` varchar(50) DEFAULT NULL,
  `identity` int(11) DEFAULT '0',
  `content` varchar(500) DEFAULT NULL,
  `time` timestamp NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  `courseId` int(11) DEFAULT NULL,
  PRIMARY KEY (`message_board_id`),
  KEY `fk_message_board_course` (`courseId`),
  CONSTRAINT `fk_message_board_course` FOREIGN KEY (`courseId`) REFERENCES `course` (`course_id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=24 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of message_board
-- ----------------------------
INSERT INTO `message_board` VALUES ('11', '1', '1', 'sb2', '2016-07-11 10:44:17', '1');
INSERT INTO `message_board` VALUES ('12', '1', '1', 'sb2', '2016-07-11 10:44:18', '1');
INSERT INTO `message_board` VALUES ('13', '1', '1', 'sb2', '2016-07-11 10:44:20', '1');
INSERT INTO `message_board` VALUES ('14', '1', '1', 'sb2', '2016-07-11 10:44:21', '1');
INSERT INTO `message_board` VALUES ('15', '1', '1', 'sb2', '2016-07-11 10:44:22', '1');
INSERT INTO `message_board` VALUES ('16', '1', '1', 'sb2', '2016-07-11 10:44:23', '1');
INSERT INTO `message_board` VALUES ('17', '1', '1', 'sb2', '2016-07-11 10:44:25', '1');
INSERT INTO `message_board` VALUES ('18', '1', '1', 'sb2', '2016-07-11 10:44:38', '1');
INSERT INTO `message_board` VALUES ('19', '1', '1', 'sb1', '2016-07-11 10:48:44', '1');
INSERT INTO `message_board` VALUES ('20', '1', '1', 'ssss', '2016-07-11 10:58:03', '1');
INSERT INTO `message_board` VALUES ('21', '1', '1', 'sb2', '2016-07-11 10:58:11', '1');
INSERT INTO `message_board` VALUES ('22', '1', '1', '1\n', '2016-07-11 11:00:56', '1');
INSERT INTO `message_board` VALUES ('23', '1', '1', '1222', '2016-07-11 11:01:05', '1');

-- ----------------------------
-- Table structure for resource
-- ----------------------------
DROP TABLE IF EXISTS `resource`;
CREATE TABLE `resource` (
  `resource_id` int(11) NOT NULL AUTO_INCREMENT,
  `resource_name` varchar(50) DEFAULT NULL,
  `resource_date` date DEFAULT NULL,
  `resource_path` varchar(300) DEFAULT NULL,
  `course_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`resource_id`),
  KEY `fk_resource_course` (`course_id`),
  CONSTRAINT `fk_resource_course` FOREIGN KEY (`course_id`) REFERENCES `course` (`course_id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of resource
-- ----------------------------
INSERT INTO `resource` VALUES ('1', 'R1', '2016-07-28', 'RPath1', '1');
INSERT INTO `resource` VALUES ('2', 'RN1', '2016-07-10', 'RP1', '1');
INSERT INTO `resource` VALUES ('3', 'createTable.txt', '2016-07-11', '/resource/1/createTable.txt', '1');
INSERT INTO `resource` VALUES ('4', 'study.sql', '2016-07-11', '/resource/1/study.sql', '1');
INSERT INTO `resource` VALUES ('5', 'HMCL-2.1.9.exe', '2016-07-11', '/resource/1/HMCL-2.1.9.exe', '1');

-- ----------------------------
-- Table structure for student
-- ----------------------------
DROP TABLE IF EXISTS `student`;
CREATE TABLE `student` (
  `student_id` varchar(50) CHARACTER SET utf8 NOT NULL,
  `student_name` varchar(50) CHARACTER SET utf8 DEFAULT NULL,
  `student_password` varchar(50) CHARACTER SET utf8 DEFAULT NULL,
  PRIMARY KEY (`student_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- ----------------------------
-- Records of student
-- ----------------------------
INSERT INTO `student` VALUES ('1', 'Student1', '123');
INSERT INTO `student` VALUES ('2', 'Student2', '123');

-- ----------------------------
-- Table structure for student_course
-- ----------------------------
DROP TABLE IF EXISTS `student_course`;
CREATE TABLE `student_course` (
  `sc_id` int(11) NOT NULL AUTO_INCREMENT,
  `student_id` varchar(50) NOT NULL,
  `course_id` int(50) NOT NULL,
  `term_id` int(50) NOT NULL,
  PRIMARY KEY (`sc_id`),
  KEY `fk_studentcourse_student` (`student_id`),
  KEY `fk_studentcourse_course` (`course_id`),
  KEY `fk_studentcourse_term` (`term_id`),
  CONSTRAINT `fk_studentcourse_course` FOREIGN KEY (`course_id`) REFERENCES `course` (`course_id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `fk_studentcourse_student` FOREIGN KEY (`student_id`) REFERENCES `student` (`student_id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `fk_studentcourse_term` FOREIGN KEY (`term_id`) REFERENCES `term` (`term_id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of student_course
-- ----------------------------
INSERT INTO `student_course` VALUES ('1', '1', '1', '1');
INSERT INTO `student_course` VALUES ('2', '1', '1', '1');
INSERT INTO `student_course` VALUES ('3', '1', '1', '1');

-- ----------------------------
-- Table structure for submit_homework
-- ----------------------------
DROP TABLE IF EXISTS `submit_homework`;
CREATE TABLE `submit_homework` (
  `student_id` varchar(50) CHARACTER SET utf8 NOT NULL,
  `homework_id` int(50) NOT NULL,
  `file_path` varchar(300) CHARACTER SET utf8 DEFAULT NULL,
  `score` int(50) DEFAULT NULL,
  `sh_id` int(11) NOT NULL AUTO_INCREMENT,
  PRIMARY KEY (`sh_id`),
  KEY `studentId` (`student_id`),
  KEY `homeworkId` (`homework_id`),
  CONSTRAINT `fk_submithome_homework` FOREIGN KEY (`homework_id`) REFERENCES `homework` (`homework_id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `fk_submithomework_student` FOREIGN KEY (`student_id`) REFERENCES `student` (`student_id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=latin1;

-- ----------------------------
-- Records of submit_homework
-- ----------------------------
INSERT INTO `submit_homework` VALUES ('1', '4', '/homework/student/4/1/teacher_resourse_list.html', '80', '1');
INSERT INTO `submit_homework` VALUES ('2', '5', 'F2', '22', '2');
INSERT INTO `submit_homework` VALUES ('2', '4', 'F3', '50', '3');
INSERT INTO `submit_homework` VALUES ('1', '16', '/homework/teacher/1/createTable.txt', null, '6');

-- ----------------------------
-- Table structure for teacher
-- ----------------------------
DROP TABLE IF EXISTS `teacher`;
CREATE TABLE `teacher` (
  `teacher_id` varchar(50) CHARACTER SET utf8 NOT NULL,
  `teacher_name` varchar(50) CHARACTER SET utf8 DEFAULT NULL,
  `teacher_password` varchar(50) CHARACTER SET utf8 DEFAULT NULL,
  PRIMARY KEY (`teacher_id`),
  KEY `teacherName` (`teacher_name`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- ----------------------------
-- Records of teacher
-- ----------------------------
INSERT INTO `teacher` VALUES ('1', 'Teacher1', '123');
INSERT INTO `teacher` VALUES ('2', 'Teacher2', '123');

-- ----------------------------
-- Table structure for term
-- ----------------------------
DROP TABLE IF EXISTS `term`;
CREATE TABLE `term` (
  `term_id` int(50) NOT NULL AUTO_INCREMENT,
  `year` varchar(50) CHARACTER SET utf8 DEFAULT NULL,
  `season` varchar(50) CHARACTER SET utf8 DEFAULT NULL,
  `week` varchar(50) CHARACTER SET utf8 DEFAULT NULL,
  PRIMARY KEY (`term_id`)
) ENGINE=InnoDB AUTO_INCREMENT=41 DEFAULT CHARSET=latin1;

-- ----------------------------
-- Records of term
-- ----------------------------
INSERT INTO `term` VALUES ('1', '2015', 'spring', '16');
INSERT INTO `term` VALUES ('2', '2015', 'autumn', '17');
INSERT INTO `term` VALUES ('3', '2016', 'spring', '16');
INSERT INTO `term` VALUES ('37', '2104', 'spring', '16');
INSERT INTO `term` VALUES ('38', '12', '123', '11');
INSERT INTO `term` VALUES ('39', '12111', '123', '11');
INSERT INTO `term` VALUES ('40', '2017', 'autumn', '18');
