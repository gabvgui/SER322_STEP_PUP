CREATE TABLE CUSTOMER (
 EMAIL VARCHAR(30) NOT NULL,
 FIRST_NAME VARCHAR(30),
 MIDDLE_INITIAL CHAR(1),
 LAST_NAME VARCHAR(30),
 CC_NUMBER CHAR(16),
 ADDRESS VARCHAR(30),
 PRIMARY KEY (EMAIL));
 
 CREATE TABLE DOG (
 OWNER_EMAIL VARCHAR(30) NOT NULL,
 ID INTEGER NOT NULL,
 BREED VARCHAR(30),
 DOG_NAME VARCHAR(30),
 AGE INTEGER,
 FOREIGN KEY (OWNER_EMAIL) REFERENCES CUSTOMER (EMAIL),
 PRIMARY KEY (ID));
 
 CREATE TABLE EMPLOYEE (
 EMPLOYEE_ID INTEGER NOT NULL,
 FIRST_NAME  VARCHAR(30),
 LAST_NAME VARCHAR(30),
 AGE INTEGER,
 ADDRESS VARCHAR(30),
 PRIMARY KEY (EMPLOYEE_ID));
 
 CREATE TABLE MANAGER (
 EMPLOYEE_ID INTEGER NOT NULL,
  FIRST_NAME  VARCHAR(30),
  LAST_NAME VARCHAR(30),
  FOREIGN KEY (EMPLOYEE_ID) REFERENCES EMPLOYEE (EMPLOYEE_ID));
 
 
 CREATE TABLE ROUTE (
 DOG_ID INTEGER NOT NULL,
 ROUTE_ID INTEGER NOT NULL,
 EMPLOYEE_ID INTEGER NOT NULL,
 START_POINT VARCHAR(30),
 END_POINT VARCHAR(30),
 COST INTEGER,
 FOREIGN KEY (DOG_ID) REFERENCES DOG (ID),
 FOREIGN KEY (EMPLOYEE_ID) REFERENCES EMPLOYEE (EMPLOYEE_ID),
 PRIMARY KEY (ROUTE_ID));
 