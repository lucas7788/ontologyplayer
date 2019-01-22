DROP TABLE IF EXISTS `tbl_open_record`;
CREATE TABLE `tbl_open_record` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `num1` int(1) NOT NULL,
  `num2` int(1) NOT NULL,
  `num3` int(1) NOT NULL,
  `address` varchar(128) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;