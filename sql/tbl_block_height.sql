DROP TABLE IF EXISTS `tbl_block_height`;
CREATE TABLE `tbl_block_height` (
  `blockheight` int NOT NULL DEFAULT 0,
  PRIMARY KEY (`blockheight`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;