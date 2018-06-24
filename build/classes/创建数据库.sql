/*
SQLyog Ultimate v12.4.1 (64 bit)
MySQL - 5.7.20-log : Database - 18-02-22-ssh框架整合
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`18-02-22-ssh框架整合` /*!40100 DEFAULT CHARACTER SET utf8 */;

USE `18-02-22-ssh框架整合`;

/*Table structure for table `base_dict` */

DROP TABLE IF EXISTS `base_dict`;

CREATE TABLE `base_dict` (
  `dict_id` varchar(255) NOT NULL,
  `dict_type_code` varchar(255) DEFAULT NULL,
  `dict_type_name` varchar(255) DEFAULT NULL,
  `dict_item_name` varchar(255) DEFAULT NULL,
  `dict_item_code` varchar(255) DEFAULT NULL,
  `dict_sort` int(11) DEFAULT NULL,
  `dict_enable` char(1) DEFAULT NULL,
  `dict_memo` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`dict_id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

/*Data for the table `base_dict` */

insert  into `base_dict`(`dict_id`,`dict_type_code`,`dict_type_name`,`dict_item_name`,`dict_item_code`,`dict_sort`,`dict_enable`,`dict_memo`) values 
('1','001','客户行业','教育培训 ',NULL,1,'1',NULL),
('10','003','公司性质','民企',NULL,3,'1',NULL),
('12','004','年营业额','1-10万',NULL,1,'1',NULL),
('13','004','年营业额','10-20万',NULL,2,'1',NULL),
('14','004','年营业额','20-50万',NULL,3,'1',NULL),
('15','004','年营业额','50-100万',NULL,4,'1',NULL),
('16','004','年营业额','100-500万',NULL,5,'1',NULL),
('17','004','年营业额','500-1000万',NULL,6,'1',NULL),
('18','005','客户状态','基础客户',NULL,1,'1',NULL),
('19','005','客户状态','潜在客户',NULL,2,'1',NULL),
('2','001','客户行业','电子商务',NULL,2,'1',NULL),
('20','005','客户状态','成功客户',NULL,3,'1',NULL),
('21','005','客户状态','无效客户',NULL,4,'1',NULL),
('22','006','客户级别','普通客户',NULL,1,'1',NULL),
('23','006','客户级别','VIP客户',NULL,2,'1',NULL),
('24','007','商机状态','意向客户',NULL,1,'1',NULL),
('25','007','商机状态','初步沟通',NULL,2,'1',NULL),
('26','007','商机状态','深度沟通',NULL,3,'1',NULL),
('27','007','商机状态','签订合同',NULL,4,'1',NULL),
('3','001','客户行业','对外贸易',NULL,3,'1',NULL),
('30','008','商机类型','新业务',NULL,1,'1',NULL),
('31','008','商机类型','现有业务',NULL,2,'1',NULL),
('32','009','商机来源','电话营销',NULL,1,'1',NULL),
('33','009','商机来源','网络营销',NULL,2,'1',NULL),
('34','009','商机来源','推广活动',NULL,3,'1',NULL),
('4','001','客户行业','酒店旅游',NULL,4,'1',NULL),
('5','001','客户行业','房地产',NULL,5,'1',NULL),
('6','002','客户信息来源','电话营销',NULL,1,'1',NULL),
('7','002','客户信息来源','网络营销',NULL,2,'1',NULL),
('8','003','公司性质','合资',NULL,1,'1',NULL),
('9','003','公司性质','国企',NULL,2,'1',NULL);

/*Table structure for table `cst_customer` */

DROP TABLE IF EXISTS `cst_customer`;

CREATE TABLE `cst_customer` (
  `cust_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `cust_name` varchar(255) DEFAULT NULL,
  `cust_linkman` varchar(255) DEFAULT NULL,
  `cust_phone` varchar(255) DEFAULT NULL,
  `cust_mobile` varchar(255) DEFAULT NULL,
  `cust_source` varchar(255) DEFAULT NULL,
  `cust_industry` varchar(255) DEFAULT NULL,
  `cust_level` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`cust_id`),
  KEY `FKeh5g36duab8g1h051pdjfwcgd` (`cust_source`),
  KEY `FK2xhr3arwp3tkuae1da4lqv352` (`cust_industry`),
  KEY `FKrty52nvbjg1echf0se39eng49` (`cust_level`)
) ENGINE=MyISAM AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

/*Data for the table `cst_customer` */

insert  into `cst_customer`(`cust_id`,`cust_name`,`cust_linkman`,`cust_phone`,`cust_mobile`,`cust_source`,`cust_industry`,`cust_level`) values 
(1,NULL,NULL,NULL,NULL,NULL,NULL,NULL),
(2,'c2',NULL,NULL,NULL,NULL,NULL,NULL),
(3,NULL,NULL,NULL,NULL,NULL,NULL,NULL);

/*Table structure for table `cst_linkman` */

DROP TABLE IF EXISTS `cst_linkman`;

CREATE TABLE `cst_linkman` (
  `lKm_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `lkm_gender` char(1) DEFAULT NULL,
  `lkm_name` varchar(255) DEFAULT NULL,
  `lkm_phone` varchar(255) DEFAULT NULL,
  `lkm_email` varchar(255) DEFAULT NULL,
  `lkm_qq` varchar(255) DEFAULT NULL,
  `lkm_mobile` varchar(255) DEFAULT NULL,
  `lkm_memo` varchar(255) DEFAULT NULL,
  `lkm_position` varchar(255) DEFAULT NULL,
  `lkm_cust_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`lKm_id`),
  KEY `FKh9yp1nql5227xxcopuxqx2e7q` (`lkm_cust_id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

/*Data for the table `cst_linkman` */

/*Table structure for table `sale_visit` */

DROP TABLE IF EXISTS `sale_visit`;

CREATE TABLE `sale_visit` (
  `visit_id` varchar(255) NOT NULL,
  `visit_time` datetime DEFAULT NULL,
  `visit_interviewee` varchar(255) DEFAULT NULL,
  `visit_addr` varchar(255) DEFAULT NULL,
  `visit_detail` varchar(255) DEFAULT NULL,
  `visit_nexttime` datetime DEFAULT NULL,
  `visit_cust_id` bigint(20) DEFAULT NULL,
  `visit_user_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`visit_id`),
  KEY `FKgr4aivocixwcvkwxcmc0b4css` (`visit_cust_id`),
  KEY `FKc92iepd26mixxfiris92hccjx` (`visit_user_id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

/*Data for the table `sale_visit` */

insert  into `sale_visit`(`visit_id`,`visit_time`,`visit_interviewee`,`visit_addr`,`visit_detail`,`visit_nexttime`,`visit_cust_id`,`visit_user_id`) values 
('9ebcaaa6-b158-4f8b-90f7-ee8bdc3966dd','2018-03-07 00:00:00','发射点','士大夫','风格的','2018-03-21 00:00:00',NULL,1);

/*Table structure for table `sys_user` */

DROP TABLE IF EXISTS `sys_user`;

CREATE TABLE `sys_user` (
  `user_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `user_code` varchar(255) DEFAULT NULL,
  `user_name` varchar(255) DEFAULT NULL,
  `user_password` varchar(255) DEFAULT NULL,
  `user_state` char(1) DEFAULT NULL,
  PRIMARY KEY (`user_id`)
) ENGINE=MyISAM AUTO_INCREMENT=57 DEFAULT CHARSET=utf8;

/*Data for the table `sys_user` */

insert  into `sys_user`(`user_id`,`user_code`,`user_name`,`user_password`,`user_state`) values 
(1,'1','1','1',NULL),
(2,'2','2','2',NULL),
(3,'33','33','33',NULL),
(6,'1','这是拦截器里面的自动登陆','1',NULL),
(10,'7',NULL,NULL,NULL),
(11,'8',NULL,NULL,NULL),
(12,'9',NULL,NULL,NULL),
(13,'10',NULL,NULL,NULL),
(14,'11',NULL,NULL,NULL),
(15,'12',NULL,NULL,NULL),
(16,'13',NULL,NULL,NULL),
(17,'14',NULL,NULL,NULL),
(18,'15',NULL,NULL,NULL),
(19,'16',NULL,NULL,NULL),
(20,'17',NULL,NULL,NULL),
(21,'18',NULL,NULL,NULL),
(22,'19',NULL,NULL,NULL),
(23,'20',NULL,NULL,NULL),
(24,'21',NULL,NULL,NULL),
(25,'22',NULL,NULL,NULL),
(26,'23',NULL,NULL,NULL),
(27,'24',NULL,NULL,NULL),
(28,'25',NULL,NULL,NULL),
(29,'26',NULL,NULL,NULL),
(30,'27',NULL,NULL,NULL),
(31,'28',NULL,NULL,NULL),
(32,'29',NULL,NULL,NULL),
(33,'30',NULL,NULL,NULL),
(34,'31',NULL,NULL,NULL),
(35,'32',NULL,NULL,NULL),
(36,'33',NULL,NULL,NULL),
(37,'34',NULL,NULL,NULL),
(38,'35',NULL,NULL,NULL),
(39,'36',NULL,NULL,NULL),
(40,'37',NULL,NULL,NULL),
(41,'38',NULL,NULL,NULL),
(42,'39',NULL,NULL,NULL),
(43,'40',NULL,NULL,NULL),
(44,'41',NULL,NULL,NULL),
(45,'42',NULL,NULL,NULL),
(46,'43',NULL,NULL,NULL),
(47,'44',NULL,NULL,NULL),
(48,'45',NULL,NULL,NULL),
(49,'46',NULL,NULL,NULL),
(50,'47',NULL,NULL,NULL),
(51,'48',NULL,NULL,NULL),
(52,'49',NULL,NULL,NULL),
(53,'50',NULL,NULL,NULL),
(54,'111','111','111',NULL),
(55,'222','222','222',NULL),
(56,'','','',NULL);

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
