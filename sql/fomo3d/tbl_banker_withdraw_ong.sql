DROP TABLE IF EXISTS `tbl_banker_withdraw_ong`;
CREATE TABLE `tbl_banker_withdraw_ong` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `txtime` int(11) NOT NULL DEFAULT 0,
  `banker` varchar(255) NOT NULL DEFAULT '',
  `bankerDividend` decimal(40,1) NOT NULL DEFAULT 0,
  `txhash` varchar(64) NOT NULL DEFAULT '',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;