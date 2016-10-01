# the-example-datasource
the example of datasource, dbcp,c3p0 and dbutils

# About Database
    The Database is bash MySql.
## build database
```
create database test;
```
## use
```
use test;
```
## create table
```
create table users (
    id int(11) primary key auto_increment,
    username varchar(20) not null,
    password varchar(20) not null
);
```
## insert some data
```
insert into users values(null, 'zs', '123456');
insert into users values(null, 'ls', '123456');
insert into users values(null, 'ww', '654321');
```
