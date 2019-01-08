use booki;

create table flat
(
	flatowner int not null,
	flatattributes int null,
	descriptionshort varchar(2000) null,
	city varchar(25) null,
	street varchar(45) null,
	ownername varchar(45) null,
	house varchar(10) null,
	created timestamp null,
	modified timestamp null,
	id int auto_increment
		primary key,
	simpleAttributes int null,
	phone1 varchar(15) null,
	phone2 varchar(15) null,
	phone3 varchar(15) null,
	constraint flat_id_uindex
		unique (id)
)
;




/*

create unique index flat_id_uindex
	on flat (id)
;
*/


