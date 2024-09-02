CREATE DATABASE  IF NOT EXISTS `counter_directory`;
USE `counter_directory`;

--
-- Table structure for table `counter`
--

DROP TABLE IF EXISTS `counter`;

CREATE TABLE `counter` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `counter_name` varchar(45) DEFAULT NULL,
  `value` int DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
