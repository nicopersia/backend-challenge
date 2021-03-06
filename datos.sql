-- MySQL Workbench Synchronization
-- Generated: 2020-10-02 17:40
-- Model: New Model
-- Version: 1.0
-- Project: Name of the project
-- Author: persiani

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

CREATE TABLE IF NOT EXISTS `pizzeria`.`PEDIDOS_CABECERA` (
  `ID` VARCHAR(200) NOT NULL,
  `DIRECCION` VARCHAR(200) NULL DEFAULT NULL,
  `EMAIL` VARCHAR(45) NULL DEFAULT NULL,
  `TELEFONO` VARCHAR(45) NULL DEFAULT NULL,
  `HORARIO` VARCHAR(45) NULL DEFAULT NULL,
  `FECHA_ALTA` DATE NULL DEFAULT NULL,
  `MONTO_TOTAL` DECIMAL(12,2) NULL DEFAULT NULL,
  `APLICO_DESCUENTO` TINYINT(4) NULL DEFAULT NULL,
  `ESTADO` VARCHAR(200) NULL DEFAULT NULL,
  PRIMARY KEY (`ID`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;

CREATE TABLE IF NOT EXISTS `pizzeria`.`PEDIDOS_DETALLE` (
  `ID` VARCHAR(200) NOT NULL,
  `CANTIDAD` FLOAT(11) NULL DEFAULT 0,
  `PRECIO_UNITARIO` DECIMAL(12,2) NULL DEFAULT 0.0,
  `PRODUCTOS_ID` VARCHAR(200) NOT NULL,
  `PEDIDOS_CABECERA_ID` VARCHAR(200) NOT NULL,
  PRIMARY KEY (`ID`),
  INDEX `fk_PEDIDOS_DETALLE_PRODUCTOS_idx` (`PRODUCTOS_ID` ASC) VISIBLE,
  INDEX `fk_PEDIDOS_DETALLE_PEDIDOS_CABECERA1_idx` (`PEDIDOS_CABECERA_ID` ASC) VISIBLE,
  CONSTRAINT `fk_PEDIDOS_DETALLE_PEDIDOS_CABECERA1`
    FOREIGN KEY (`PEDIDOS_CABECERA_ID`)
    REFERENCES `pizzeria`.`PEDIDOS_CABECERA` (`ID`),
  CONSTRAINT `fk_PEDIDOS_DETALLE_PRODUCTOS`
    FOREIGN KEY (`PRODUCTOS_ID`)
    REFERENCES `pizzeria`.`PRODUCTOS` (`ID`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;

CREATE TABLE IF NOT EXISTS `pizzeria`.`PRODUCTOS` (
  `ID` VARCHAR(200) NOT NULL,
  `NOMBRE` VARCHAR(100) NOT NULL,
  `DESCRIPCION_CORTA` VARCHAR(100) NOT NULL,
  `DESCRIPCION_LARGA` VARCHAR(200) NULL DEFAULT NULL,
  `PRECIO_UNITARIO` DECIMAL(12,2) NOT NULL DEFAULT 0.0,
  PRIMARY KEY (`ID`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;