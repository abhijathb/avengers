SELECT * FROM avengers.countries;

select * from avengers.chatmessages;

ALTER TABLE avengers.chatmessages AUTO_INCREMENT = 3;

alter table avengers.chatmessages drop column chatmessage;

select now();

INSERT INTO avengers.chatmessages VALUES 
	(now(),'ironman','spiderman','Be careful on your first mission, Pete!',1);
    
    INSERT INTO avengers.chatmessages VALUES 
	(now(),'spiderman','ironman','Will always follow you, Mr. Stark!',2);
    
drop table avengers.chatmessage;