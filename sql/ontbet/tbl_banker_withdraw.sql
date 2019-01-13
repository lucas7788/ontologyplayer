DROP TABLE IF EXISTS `tbl_banker_withdraw`;
CREATE TABLE `tbl_banker_withdraw` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `funcname` varchar(32) NOT NULL DEFAULT "",
  `txhash` varchar(64) NOT NULL,
  `blocktime` int(11) NOT NULL,
  `banker` varchar(128) NOT NULL,
  `ongAmount` int(11) NOT NULL DEFAULT 0,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;