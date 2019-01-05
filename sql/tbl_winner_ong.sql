DROP TABLE IF EXISTS `tbl_winner_ong`;
CREATE TABLE `tbl_winner_ong` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `lastbuyer` varchar(255) NOT NULL,
  `lastbuyerdividend` decimal(40,4) NOT NULL DEFAULT 0,
  `holdkeymost` varchar(255) NOT NULL,
  `holdkeymostdividend` decimal(40,4) NOT NULL DEFAULT 0,
  `mostactive` varchar(255) NOT NULL,
  `mostactivedividend` decimal(40,4) NOT NULL DEFAULT 0,
  `round` int(11) NOT NULL DEFAULT 0,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;