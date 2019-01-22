DROP TABLE IF EXISTS `tbl_bet_record`;
CREATE TABLE `tbl_bet_record` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `betTime` timestamp NOT NULL default current_timestamp,
  `address` varchar(128) NOT NULL,
  `betType` int(1) NOT NULL,
  `betAmount` int(11) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;