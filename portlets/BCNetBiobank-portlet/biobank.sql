CREATE TABLE IF NOT EXISTS `lportal`.`Biobank` (
  `biobankDbId` bigint(20) NOT NULL AUTO_INCREMENT,
  `biobankId` VARCHAR(100) NOT NULL COMMENT 'Textual string of letters starting with the country code (according to standard ISO1366 alpha2) followed by the underscore â€œ_â€� and post-fixed by a biobank ID or name specified by its juristic person (nationally speci' /* comment truncated */ /*ic)
*/,
  `acronym` VARCHAR(45) NULL COMMENT 'Textual string of short name in use for the biobank. If applicable',
  `name` VARCHAR(100) NOT NULL COMMENT 'Textual string of letters denoting the name of the biobank in english',
  `url` VARCHAR(255) NULL COMMENT 'Textual string of letters with the complete http-address for the biobank URL',
  `juristicPersonId` bigint(20) NOT NULL,
  `countryCode` VARCHAR(2) NOT NULL,
  `description` TEXT NULL COMMENT 'Textual string of letters with a description about the biobank in english. Max. 255 char.',
  `backup` TINYINT(1) NULL COMMENT 'Yes, No (no clear what is being backed-up)',
  `trainingCourses` TINYINT(1) NULL COMMENT 'Yes, no',
  PRIMARY KEY (`biobankDbId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;



