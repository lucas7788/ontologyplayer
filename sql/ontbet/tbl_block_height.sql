DROP TABLE IF EXISTS `tbl_blk_height`;
CREATE TABLE `tbl_blk_height` (
  `blkheight` int NOT NULL DEFAULT 0,
  PRIMARY KEY (`blkheight`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;