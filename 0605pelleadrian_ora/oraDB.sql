CREATE DATABASE ora;

USE ora;

CREATE TABLE orabolt (
 ID INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
  megnevezes varchar(50) default NULL,
  tipus varchar(50) default NULL,
  ar decimal(7,0) default NULL,
  vizallo boolean();