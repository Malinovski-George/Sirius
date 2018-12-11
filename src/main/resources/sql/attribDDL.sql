create table flatattributes
(
	id integer not null
		constraint flatattributes_pkey
			primary key,
	roomnumber smallint not null,
	bednumber smallint,
	floor smallint not null,
	multistorey integer,
	generalarea smallint not null,
	lifearea smallint not null,
	kitchenarea smallint,
	hasbalcony boolean,
	istoiletcombined boolean,
	hasfridge boolean,
	hasdishes boolean,
	hasmicrowaveoven boolean,
	hassmallequipment boolean,
	haswasher boolean,
	hastv boolean,
	hashairdryer boolean,
	hasairconditioning boolean,
	haswifi boolean,
	hasfurniture boolean,
	hasbuiltinwardrobes boolean,
	hasdomoff boolean,
	haselevator boolean,
	iswindowstoyard boolean,
	hasdoubleglazedwindows boolean,
	cansmoke boolean,
	ispossiblepets boolean,
	canspendholidays boolean,
	hasfireplace boolean,
	hasjacuzzi boolean,
	hascomputer boolean,
	haspool boolean,
	hasdryingmachine boolean,
	hasiron boolean,
	hasironingboard boolean,
	hasdryer boolean,
	hastouletaccessories boolean,
	hasshampoo boolean,
	isseparateentrance boolean,
	hasreceptionist boolean,
	priceday boolean not null,
	pricenight boolean,
	pricehour boolean
)
;

create unique index flatattributes_id_uindex
	on flatattributes (id)
;

