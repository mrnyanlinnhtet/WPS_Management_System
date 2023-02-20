/*For Website Category*/
INSERT INTO website_categories(name)VALUES('Foods'),('Electronics');

/*For Password Category*/
INSERT INTO password_categories(name)VALUES('Website'),('Social Media');

/*For Password*/
INSERT INTO passwords (name,username,password,description,password_categories_id) 
VALUES ('github','mrnyanlinnhtet13','iamironman','account1',1),
('facebook','nyanlinnhtet.stark@gmail.com','fac','Eugene Account',2),
('chat gpt','nyanlinnhtet','chatgptshit','',1),
('youtube','stark123','youtube1','personal',2);