DROP TABLE IF EXISTS `tbl_activity_ong`;
CREATE TABLE `tbl_activity_ong` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `isshow` int(1) NOT NULL DEFAULT 0,
  `datetime` timestamp NOT NULL DEFAULT current_timestamp,
  `activename` varchar(255) NOT NULL DEFAULT '',
  `activecontent` varchar(1020) NOT NULL DEFAULT 0,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;