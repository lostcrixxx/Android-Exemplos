create database photo_gallery;

use photo_gallery;

create table photos(
	id int(11) primary key auto_increment,
	photo_name text,
	photo_url text,
	caption text
);