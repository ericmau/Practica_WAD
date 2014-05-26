SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

DROP SCHEMA IF EXISTS `WAD_P02` ;
CREATE SCHEMA IF NOT EXISTS `WAD_P02` DEFAULT CHARACTER SET utf8 COLLATE utf8_general_ci ;
USE `WAD_P02` ;

-- -----------------------------------------------------
-- Table `WAD_P02`.`CentroDeTrabajo`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `WAD_P02`.`CentroDeTrabajo` ;

CREATE TABLE IF NOT EXISTS `WAD_P02`.`CentroDeTrabajo` (
  `idCentroDeTrabajo` INT NOT NULL AUTO_INCREMENT,
  `nombreCentroTrabajo` VARCHAR(45) NULL,
  PRIMARY KEY (`idCentroDeTrabajo`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `WAD_P02`.`Carrera`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `WAD_P02`.`Carrera` ;

CREATE TABLE IF NOT EXISTS `WAD_P02`.`Carrera` (
  `idCarrera` INT NOT NULL AUTO_INCREMENT,
  `nombreCarrera` VARCHAR(45) NOT NULL,
  `duracion` INT NOT NULL,
  `CentroDeTrabajo_idCentroDeTrabajo` INT NOT NULL,
  PRIMARY KEY (`idCarrera`),
  INDEX `fk_Carrera_CentroDeTrabajo_idx` (`CentroDeTrabajo_idCentroDeTrabajo` ASC),
  CONSTRAINT `fk_Carrera_CentroDeTrabajo`
    FOREIGN KEY (`CentroDeTrabajo_idCentroDeTrabajo`)
    REFERENCES `WAD_P02`.`CentroDeTrabajo` (`idCentroDeTrabajo`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `WAD_P02`.`Alumnos`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `WAD_P02`.`Alumnos` ;

CREATE TABLE IF NOT EXISTS `WAD_P02`.`Alumnos` (
  `idAlumnos` INT NOT NULL AUTO_INCREMENT,
  `Nombre` VARCHAR(45) NOT NULL,
  `Paterno` VARCHAR(45) NOT NULL,
  `Materno` VARCHAR(45) NOT NULL,
  `email` VARCHAR(45) NOT NULL,
  `foto` LONGBLOB NULL,
  `tipoFoto` VARCHAR(45) NULL,
  `Carrera_idCarrera` INT NOT NULL,
  PRIMARY KEY (`idAlumnos`),
  INDEX `fk_Alumnos_Carrera1_idx` (`Carrera_idCarrera` ASC),
  CONSTRAINT `fk_Alumnos_Carrera1`
    FOREIGN KEY (`Carrera_idCarrera`)
    REFERENCES `WAD_P02`.`Carrera` (`idCarrera`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `WAD_P02`.`Materia`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `WAD_P02`.`Materia` ;

CREATE TABLE IF NOT EXISTS `WAD_P02`.`Materia` (
  `idMateria` INT NOT NULL AUTO_INCREMENT,
  `Nombre` VARCHAR(45) NOT NULL,
  `Creditos` INT NOT NULL,
  `Calificacion` INT NOT NULL DEFAULT 0,
  PRIMARY KEY (`idMateria`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `WAD_P02`.`Evaluacion`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `WAD_P02`.`Evaluacion` ;

CREATE TABLE IF NOT EXISTS `WAD_P02`.`Evaluacion` (
  `idEvaluacion` INT NOT NULL AUTO_INCREMENT,
  `Evaluacioncol` VARCHAR(45) NULL,
  `Materia_idMateria` INT NOT NULL,
  PRIMARY KEY (`idEvaluacion`),
  INDEX `fk_Evaluacion_Materia1_idx` (`Materia_idMateria` ASC),
  CONSTRAINT `fk_Evaluacion_Materia1`
    FOREIGN KEY (`Materia_idMateria`)
    REFERENCES `WAD_P02`.`Materia` (`idMateria`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `WAD_P02`.`Respuestas`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `WAD_P02`.`Respuestas` ;

CREATE TABLE IF NOT EXISTS `WAD_P02`.`Respuestas` (
  `idRespuestas` INT NOT NULL AUTO_INCREMENT,
  `RespuestaA` VARCHAR(150) NOT NULL,
  `RespuestaB` VARCHAR(150) NOT NULL,
  `RespuestaC` VARCHAR(150) NOT NULL,
  `RCorrecta` CHAR(1) NOT NULL,
  PRIMARY KEY (`idRespuestas`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `WAD_P02`.`Preguntas`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `WAD_P02`.`Preguntas` ;

CREATE TABLE IF NOT EXISTS `WAD_P02`.`Preguntas` (
  `idPreguntas` INT NOT NULL AUTO_INCREMENT,
  `Pregunta` VARCHAR(150) NOT NULL,
  `Evaluacion_idEvaluacion` INT NOT NULL,
  `Respuestas_idRespuestas` INT NOT NULL,
  PRIMARY KEY (`idPreguntas`),
  INDEX `fk_Preguntas_Evaluacion1_idx` (`Evaluacion_idEvaluacion` ASC),
  INDEX `fk_Preguntas_Respuestas1_idx` (`Respuestas_idRespuestas` ASC),
  CONSTRAINT `fk_Preguntas_Evaluacion1`
    FOREIGN KEY (`Evaluacion_idEvaluacion`)
    REFERENCES `WAD_P02`.`Evaluacion` (`idEvaluacion`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Preguntas_Respuestas1`
    FOREIGN KEY (`Respuestas_idRespuestas`)
    REFERENCES `WAD_P02`.`Respuestas` (`idRespuestas`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `WAD_P02`.`Alumnos_has_Materia`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `WAD_P02`.`Alumnos_has_Materia` ;

CREATE TABLE IF NOT EXISTS `WAD_P02`.`Alumnos_has_Materia` (
  `Alumnos_idAlumnos` INT NOT NULL,
  `Materia_idMateria` INT NOT NULL,
  PRIMARY KEY (`Alumnos_idAlumnos`, `Materia_idMateria`),
  INDEX `fk_Alumnos_has_Materia_Materia1_idx` (`Materia_idMateria` ASC),
  INDEX `fk_Alumnos_has_Materia_Alumnos1_idx` (`Alumnos_idAlumnos` ASC),
  CONSTRAINT `fk_Alumnos_has_Materia_Alumnos1`
    FOREIGN KEY (`Alumnos_idAlumnos`)
    REFERENCES `WAD_P02`.`Alumnos` (`idAlumnos`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Alumnos_has_Materia_Materia1`
    FOREIGN KEY (`Materia_idMateria`)
    REFERENCES `WAD_P02`.`Materia` (`idMateria`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
