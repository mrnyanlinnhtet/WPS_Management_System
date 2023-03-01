/*For Website Category*/
INSERT INTO website_categories(name)VALUES('Foods'),('Electronics');

/*For Password Category*/
INSERT INTO password_categories(name)VALUES('Website'),('Social Media');

/*For Password*/
INSERT INTO passwords (name,username,password,description,password_categories_id) 
VALUES ('Github','mrnyanlinnhtet13','iamironman','account1',1),
('Gacebook','Nyanlinnhtet.stark@gmail.com','fac','Eugene Account',2),
('Chat gpt','Nyanlinnhtet','chatgptshit','',1),
('Youtube','Stark123','youtube1','personal',2);