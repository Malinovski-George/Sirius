create table user
(
	id integer not null
			primary key,
	email varchar(50) not null,
	password varchar(20) not null,
	name varchar(30) not null,
	phone1 varchar(15),
	phone2 varchar(15),
	phone3 varchar(15),
	phoneviber varchar(15),
	phonewatsup varchar(15)
)
;