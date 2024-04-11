CREATE TABLE IF NOT EXISTS `login_msg` (
  `login_id` int AUTO_INCREMENT  PRIMARY KEY,
  `name` varchar(100) NOT NULL,
  `logintime` TIMESTAMP NOT NULL
 );