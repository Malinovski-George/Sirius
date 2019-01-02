create table simpleattributes
(
	id int auto_increment
		primary key,
	flat int null,
	roomnumber smallint(6) not null,
	bednumber smallint(6) null,
	guestsNumber smallint(6) null,
	floor smallint(6) not null,
	multistorey int null,
	generalarea smallint(6) not null,
	lifearea smallint(6) not null,
	kitchenarea smallint(6) null,
	price int null,
	constraint simpleattributes_id_uindex
		unique (id)
)
;

