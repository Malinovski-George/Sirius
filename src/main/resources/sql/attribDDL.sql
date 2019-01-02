create table flat_attributes
(
	id int auto_increment
		primary key,
	flat int null,
	hasbalcony tinyint(1) null,
	istoiletcombined tinyint(1) null,
	hasfridge tinyint(1) null,
	hasdishes tinyint(1) null,
	hasmicrowaveoven tinyint(1) null,
	hassmallequipment tinyint(1) null,
	haswasher tinyint(1) null,
	hastv tinyint(1) null,
	hashairdryer tinyint(1) null,
	hasairconditioning tinyint(1) null,
	haswifi tinyint(1) null,
	hasfurniture tinyint(1) null,
	hasbuiltinwardrobes tinyint(1) null,
	hasdomoff tinyint(1) null,
	haselevator tinyint(1) null,
	iswindowstoyard tinyint(1) null,
	hasdoubleglazedwindows tinyint(1) null,
	cansmoke tinyint(1) null,
	ispossiblepets tinyint(1) null,
	canspendholidays tinyint(1) null,
	hasfireplace tinyint(1) null,
	hasjacuzzi tinyint(1) null,
	hascomputer tinyint(1) null,
	haspool tinyint(1) null,
	hasdryingmachine tinyint(1) null,
	hasiron tinyint(1) null,
	hasironingboard tinyint(1) null,
	hasdryer tinyint(1) null,
	hastouletaccessories tinyint(1) null,
	hasshampoo tinyint(1) null,
	isseparateentrance tinyint(1) null,
	hasreceptionist tinyint(1) null,
	price int null,
	constraint flatattributes_id_uindex
		unique (id)
)
;

/*


create unique index flatattributes_id_uindex
	on flat_attributes (id)
;
*/

