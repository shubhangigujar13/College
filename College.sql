create database JDBCDemo;
use JDBCDemo;
create table student
( 	
	rollno int primary key auto_increment,
    sname varchar(45) not null,
    phno varchar(20) unique not null,
    address varchar(45) not null,
    add_date timestamp default current_timestamp, 
    last_update timestamp default current_timestamp on update current_timestamp
);
describe student;
select * from student;