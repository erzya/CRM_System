CREATE SCHEMA 'crm' ;

CREATE TABLE 'crm'.'employees' (
  'id_emp' INT NOT NULL AUTO_INCREMENT,
  'name' VARCHAR(40) NOT NULL,
  'surname' VARCHAR(40) NOT NULL,
  'isActive' BIT(1) NULL,
  PRIMARY KEY ('id_emp'));

CREATE TABLE 'crm'.'transporters' (
  'id_tran' INT NOT NULL AUTO_INCREMENT,
  'name' VARCHAR(50) NOT NULL,
  'telephone' VARCHAR(15) NOT NULL,
  'type' VARCHAR(25) NOT NULL,
  'details' VARCHAR(150) NULL,
  PRIMARY KEY ('id_tran'),
  UNIQUE INDEX 'telephone_UNIQUE' ('telephone' ASC));

CREATE TABLE 'crm'.'clients' (
  'id_cl' INT NOT NULL AUTO_INCREMENT,
  'name' VARCHAR(100) NOT NULL,
  'telephone' VARCHAR(15) NOT NULL,
  'details' VARCHAR(150) NULL,
  PRIMARY KEY ('id_cl'),
  UNIQUE INDEX 'telephone_UNIQUE' ('telephone' ASC));

CREATE TABLE 'crm'.'orders' (
  'id_order' INT NOT NULL AUTO_INCREMENT,
  'orderscol' VARCHAR(45) NULL,
  'id_cl' INT NOT NULL,
  'id_emp' INT NOT NULL,
  'id_tran' INT NOT NULL,
  PRIMARY KEY ('id_order'),
  INDEX 'id_cl_idx' ('id_cl' ASC),
  INDEX 'id_emp_idx' ('id_emp' ASC),
  INDEX 'id_tran_idx' ('id_tran' ASC),
  CONSTRAINT 'id_cl'
  FOREIGN KEY ('id_cl')
  REFERENCES 'crm'.'clients' ('id_cl')
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT 'id_emp'
  FOREIGN KEY ('id_emp')
  REFERENCES 'crm'.'employees' ('id_emp')
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT 'id_tran'
  FOREIGN KEY ('id_tran')
  REFERENCES 'crm'.'transporters' ('id_tran')
    ON DELETE NO ACTION
    ON UPDATE NO ACTION);
