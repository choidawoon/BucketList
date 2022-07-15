-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------
-- -----------------------------------------------------
-- Schema bucketlist
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema bucketlist
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `bucketlist` DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci ;
USE `bucketlist` ;

-- -----------------------------------------------------
-- Table `bucketlist`.`member`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `bucketlist`.`member` (
  `id` VARCHAR(15) NOT NULL,
  `image` VARCHAR(200) NULL,
  `name` VARCHAR(20) NOT NULL,
  `is_deleted` TINYINT(2) NOT NULL DEFAULT 0,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `bucketlist`.`post`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `bucketlist`.`post` (
  `id` BIGINT NOT NULL,
  `content` TEXT NOT NULL,
  `member_id` VARCHAR(15) NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_post_member1_idx` (`member_id` ASC) VISIBLE,
  CONSTRAINT `fk_post_member1`
    FOREIGN KEY (`member_id`)
    REFERENCES `bucketlist`.`member` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `bucketlist`.`bucketlist`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `bucketlist`.`bucketlist` (
  `id` BIGINT NOT NULL,
  `member_id` VARCHAR(15) NOT NULL,
  `title` VARCHAR(45) NOT NULL,
  `content` VARCHAR(45) NOT NULL,
  `type` TINYINT NOT NULL,
  `category` VARCHAR(10) NOT NULL,
  `total_count` INT NULL,
  `count` INT NULL,
  `hashtag` VARCHAR(45) NULL,
  `status` TINYINT(2) NOT NULL DEFAULT 0,
  `post_id` BIGINT NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_bucketlist_member_idx` (`member_id` ASC) VISIBLE,
  INDEX `fk_bucketlist_post1_idx` (`post_id` ASC) VISIBLE,
  CONSTRAINT `fk_bucketlist_member`
    FOREIGN KEY (`member_id`)
    REFERENCES `bucketlist`.`member` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_bucketlist_post1`
    FOREIGN KEY (`post_id`)
    REFERENCES `bucketlist`.`post` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `bucketlist`.`post_image`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `bucketlist`.`post_image` (
  `id` BIGINT NOT NULL,
  `post_id` BIGINT NOT NULL,
  `path` VARCHAR(200) NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_post_image_post1_idx` (`post_id` ASC) VISIBLE,
  CONSTRAINT `fk_post_image_post1`
    FOREIGN KEY (`post_id`)
    REFERENCES `bucketlist`.`post` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `bucketlist`.`bookmark`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `bucketlist`.`bookmark` (
  `id` BIGINT NOT NULL,
  `member_id` VARCHAR(15) NOT NULL,
  `bucketlist_id` BIGINT NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_bookmark_member1_idx` (`member_id` ASC) VISIBLE,
  INDEX `fk_bookmark_bucketlist1_idx` (`bucketlist_id` ASC) VISIBLE,
  CONSTRAINT `fk_bookmark_member1`
    FOREIGN KEY (`member_id`)
    REFERENCES `bucketlist`.`member` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_bookmark_bucketlist1`
    FOREIGN KEY (`bucketlist_id`)
    REFERENCES `bucketlist`.`bucketlist` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
