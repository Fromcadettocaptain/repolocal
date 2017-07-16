Create table users(
id INTEGER PRIMARY key,
  username varchar(20),
password varchar(20) not NULL,
email varchar(50) not NULL UNIQUE,
PRIMARY KEY (username));

CREATE TABLE roles(
id INTEGER AUTO_INCREMENT,
role_type VARCHAR (20),
PRIMARY KEY (id));

