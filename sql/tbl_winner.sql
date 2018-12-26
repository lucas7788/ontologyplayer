DROP TABLE IF EXISTS `tbl_winner`;
CREATE TABLE `tbl_winner` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `lastbuyer` varchar(255) NOT NULL,
  `holdkeymost` varchar(255) NOT NULL,
  `round` int(11) NOT NULL DEFAULT 0,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;