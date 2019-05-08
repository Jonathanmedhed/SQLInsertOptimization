# SQLInsertOptimization
Optimizing an SQL insertion using a for loop in java

This code will allow you to insert an Array of objects into a database in a more efficient way,
Using a for loop to construct the query, in order to insert thousands of rows using only one insert
query; here is an example of the console results:

Inserting 1000 rows. 
Time taken insert All Once: 0.263 seconds .
Time taken one by one: 48.777 seconds .
Inserting 10000 rows.
Time taken insert All Once: 7.808 seconds.
Inserting 15000 rows.
Time taken insert All Once: 28.57 seconds.
BUILD SUCCESSFUL (total time: 1 minute 27 seconds).

Have a look at the 'database' package and then the 'saveCompanies' method in the 'MySQLOopDAO.java'
to understand how the for loop builds the query.

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
