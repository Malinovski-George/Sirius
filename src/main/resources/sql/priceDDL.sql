create table price
(
	priceNight int null,
	priceHour int null,
	priceDay int null,
	id int auto_increment
		primary key,
	constraint price_id_uindex
		unique (id)
)
;

