USE `avengers`;

CREATE TABLE `users` (
  `username` varchar(50) NOT NULL,
  `password` varchar(200) NOT NULL,
  `enabled` tinyint(1) DEFAULT NULL,
  PRIMARY KEY (`username`)
);

CREATE TABLE `authorities` (
  `username` varchar(50) NOT NULL,
  `authority` varchar(200) NOT NULL
);

ALTER TABLE authorities
ADD CONSTRAINT FK_Authorities
FOREIGN KEY (username) REFERENCES users(username);

INSERT INTO `users` VALUES 
	('ironman','{noop}ironman',1),
	('spiderman','{noop}spiderman',1),
    ('captainamerica','{noop}captainamerica',1)
    ;

Insert into users values ('nickfury','{noop}nickfury',1)    ;

Insert into users values ('abhijath','{noop}abhijath',1)    ;

INSERT INTO `authorities` VALUES 
	('ironman','ROLE_SUPERHERO'),
	('spiderman','ROLE_SUPERHERO'),
    ('captainamerica','ROLE_SUPERHERO'),
    ('nickfury','ROLE_SUPERMANAGER'),
    ('abhijath','ROLE_EMPLOYEE')
    ;
    
CREATE TABLE `countries` (
  `name` varchar(50) NOT NULL,
  `code` varchar(10) NOT NULL
);

INSERT INTO `countries` VALUES 
	('India','IN'),
	('Italy','IT'),
    ('Canada','CA'),
    ('Egypt','EG'),
    ('Japan','JP'),
    ('Argentina','AR');
    
CREATE TABLE `chatmessages` (
  `loggedtime` datetime NOT NULL,
  `from_user` varchar(50) NOT NULL,
  `to_user` varchar(50) NOT NULL,
  `message` varchar(500) NOT NULL
);

ALTER TABLE chatmessages
ADD CONSTRAINT FK_chatmessages_fromuser
FOREIGN KEY (from_user) REFERENCES users(username);

ALTER TABLE chatmessages
ADD CONSTRAINT FK_chatmessages_touser
FOREIGN KEY (to_user) REFERENCES users(username);

ALTER TABLE chatmessages
ADD COLUMN id INT NOT NULL PRIMARY KEY;

