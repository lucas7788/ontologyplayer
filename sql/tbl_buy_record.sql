DROP TABLE IF EXISTS `tbl_buy_record`;
CREATE TABLE `tbl_buy_record` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `txtime` int(11) NOT NULL DEFAULT 0,
  `buyer` varchar(255) NOT NULL DEFAULT '',
  `price` int(11) NOT NULL DEFAULT 0,
  `round` int(11) NOT NULL DEFAULT 0,
  `txhash` varchar(64) NOT NULL DEFAULT '',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;