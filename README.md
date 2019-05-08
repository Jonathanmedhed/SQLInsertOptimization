# SQLInsertOptimization
Optimizing an SQL insertion using a for loop in java

Before running the code make sure you create the database and
also the table:

Create database oop;

CREATE TABLE company (
	id INT(11) NOT NULL AUTO_INCREMENT,
	name VARCHAR(50) NOT NULL,
	shareNumber INT(11) NOT NULL DEFAULT 0,
	sharesSold INT(11) NOT NULL DEFAULT 0,
	sharePrice DOUBLE NOT NULL DEFAULT 0,
	PRIMARY KEY (id)
)
