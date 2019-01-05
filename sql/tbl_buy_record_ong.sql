DROP TABLE IF EXISTS `tbl_buy_record_ong`;
CREATE TABLE `tbl_buy_record_ong` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `txtime` int(11) NOT NULL DEFAULT 0,
  `buyer` varchar(255) NOT NULL DEFAULT '',
  `price` decimal(40,1) NOT NULL DEFAULT 0,
  `round` int(11) NOT NULL DEFAULT 0,
  `txhash` varchar(64) NOT NULL DEFAULT '',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;