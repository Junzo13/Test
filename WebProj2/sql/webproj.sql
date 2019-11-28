drop database if exists webproj;
create database webproj;
use webproj;

create table users(
id int,
user_id int,
user_name varchar(255),
password varchar(255)
);

create table inquiry(
name varchar(255),
qtype varchar(255),
body varchar(255)
);

insert into users values
(1, 1, "taro", "123"),
(2, 2, "jiro", "456"),
(3, 3, "hanako", "789");