DROP TABLE IF EXISTS `tbl_activity_ong`;
CREATE TABLE `tbl_activity_ong` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `isshow` int(1) NOT NULL DEFAULT 0,
  `activetime` int NOT NULL DEFAULT 0,
  `activename` varchar(255) NOT NULL DEFAULT '',
  `activecontent` varchar(510) NOT NULL DEFAULT 0,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;