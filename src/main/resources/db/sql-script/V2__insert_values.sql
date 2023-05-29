use.eshop;

SET FOREIGN_KEY_CHECKS=0;
# (user)
insert into users (active, image_id, date_of_created, email, name, password, phone_number)
values (true, 1, '2022-08-25', 'user@gmail.com', 'user', 'user', '0660871999');
insert into user_role (user_id, roles)
values (2, 'ROLE_USER');

# (user)
insert into users (active, image_id, date_of_created, email, name, password, phone_number)
values (true, 2, '2022-09-11', 'user1@gmail.com', 'user1', '$2a$08$k10wSQTUaaY378a6UUYQbun5rorWpyifhswQHVwbKojWNMsoOgwly', '099645278');
insert into user_role (user_id, roles)
values (3, 'ROLE_USER');

# (admin)
insert into users (active, image_id, date_of_created, email, name, password, phone_number)
values (true, 3, '2020-011-09', 'admin@gmail.com', 'admin', '$2a$08$ldfspcfM0fX5KIPudEQQK.11arcu7wdfuC5TC.mcAVHtCfQDi.T5S', 'none');
insert into user_role (user_id, roles)
values (3, 'ROLE_ADMIN');



# (product1)
insert into products (city, date_of_created, description, preview_image_id, price, title, user_id, id)
values ('Киев','2020-011-09' ,'Рекомендую к использованию', 1, 10000, 'Ps5', 2, 1);
insert into images (bytes, content_type, is_preview_image, name, original_file_name, product_id, size,id)
values ('','image/png' ,true , 'file1', 'originalfilename', 1, 1, 1);

# (product2)
insert into products (city, date_of_created, description, preview_image_id, price, title, user_id, id)
values ('Харьков}','2014-04-11' ,'Б/у, есть маленькая царапина на корпусе. Только личная встреча', 1, 250000, 'Игровой компьютер', 2, 2);

insert into images (bytes, content_type, is_preview_image, name, original_file_name, product_id, size,id)
values ('','' ,true , 'file1', 'originalfilename', 2, 1, 2);