drop table clients CASCADE CONSTRAINTS;
drop table temperature;
drop table medicine;

create table clients(
clientId number(10) NOT NULL PRIMARY KEY,
firstName varchar2(30), 
lastName varchar2(30),
age number(10));

create table temperature(
tempId number(10) NOT NULL, 
temp number(5,1),
tempTaken varchar2(30),
CONSTRAINT tId FOREIGN KEY(tempId) REFERENCES clients(clientId)
);

create table medicine(
medId number(10) NOT NULL,
doses number(10),
frequency number(10),
dura number(10),
CONSTRAINT mId FOREIGN KEY(medId) REFERENCES clients(clientId)
);

select * from clients;