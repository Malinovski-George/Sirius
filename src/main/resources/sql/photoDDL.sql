create table flat_photo
(
	id int auto_increment
		primary key,
	image longblob not null,
	flat int not null,
	constraint flatFotos_id_uindex
		unique (id)
)
;

