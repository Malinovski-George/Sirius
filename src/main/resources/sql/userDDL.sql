create table user
(
	id int auto_increment
		primary key,
	email varchar(50) not null,
	password varchar(20) not null,
	name varchar(30) not null,
	phone1 varchar(15) null,
	phone2 varchar(15) null,
	phone3 varchar(15) null,
	phoneviber varchar(15) null,
	phonewatsup varchar(15) null,
	role_id int null
)
;