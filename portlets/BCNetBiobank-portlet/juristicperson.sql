CREATE TABLE IF NOT EXISTS `lportal`.`juristicperson` (
  `juristicPersonId` bigint(20) NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(255) NOT NULL,
  `url` VARCHAR(255) DEFAULT NULL,
  `address` VARCHAR(255) NOT NULL,
  PRIMARY KEY (`juristicPersonId`))
ENGINE=InnoDB DEFAULT CHARSET=utf8;


