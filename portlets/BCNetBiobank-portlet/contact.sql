CREATE TABLE IF NOT EXISTS `lportal`.`Contact` (
  `contactId` bigint(20) NOT NULL AUTO_INCREMENT,
  `firstName` VARCHAR(100) NOT NULL COMMENT 'Textual string of letters denoting the first name of the Contact',
  `lastName` VARCHAR(100) NOT NULL COMMENT 'Textual string of letters denoting the last name of the Contact',
  `phone` VARCHAR(50) NULL COMMENT 'Phone to the Contact including international call prefix',
  `email` VARCHAR(255) NOT NULL,
  `address` VARCHAR(255) NULL,
  `zip` VARCHAR(10) NULL,
  `city` VARCHAR(255) NULL,
  `countryCode` VARCHAR(2) NOT NULL,
  `juristicPersonId` bigint(20) NOT NULL,
  `department` VARCHAR(255) NULL,
  `orcId` VARCHAR(45) NULL,
  PRIMARY KEY (`contactId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;


