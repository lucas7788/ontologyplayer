DROP TABLE IF EXISTS `tbl_withdraw_record_ont`;
CREATE TABLE `tbl_withdraw_record_ont` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `address` varchar(255) NOT NULL,
  `dividend` decimal(40,4) NOT NULL DEFAULT 0,
  `invitedividend` decimal(40,4) NOT NULL DEFAULT 0,
  `round` int(11) NOT NULL DEFAULT 0,
  `txhash` varchar(64) NOT NULL DEFAULT '',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;