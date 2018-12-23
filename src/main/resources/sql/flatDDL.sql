use booki;

create table flat
(
	flatowner integer not null,
	flatattributes integer not null,
	descriptionshort varchar(200),
	city varchar(25) ,
	street varchar(45) ,
	ownername varchar(45) ,
	house varchar(10),
	created timestamp ,
	modified timestamp,
	id integer not null
		PRIMARY KEY
)
;

create unique index flat_id_uindex
	on flat (id)
;


