SELECT * FROM avengers.countries;

select * from avengers.chatmessages;

select now();

INSERT INTO avengers.chatmessages VALUES 
	(now(),'ironman','spiderman','Be careful on your first mission, Pete!',1);
    
    INSERT INTO avengers.chatmessages VALUES 
	(now(),'spiderman','ironman','Will always follow you, Mr. Stark!',2);