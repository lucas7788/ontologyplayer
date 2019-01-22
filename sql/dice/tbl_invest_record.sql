DROP TABLE IF EXISTS `tbl_invest_record`;
CREATE TABLE `tbl_invest_record` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `investTime` timestamp NOT NULL default current_timestamp,
  `address` varchar(128) NOT NULL,
  `amount` decimal(40,4) NOT NULL DEFAULT '0.0000',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;