create table flat
(
	flatowner integer not null,
	flatattributes integer not null,
	descriptionshort varchar(200),
	city varchar(25) not null,
	street varchar(45) not null,
	house varchar(10),
	created timestamp not null,
	modified timestamp,
	id integer not null
		constraint flat_id_pk
			primary key
)
;

create unique index flat_id_uindex
	on flat (id)
;

