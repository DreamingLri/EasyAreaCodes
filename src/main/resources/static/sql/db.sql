create table codes
(
	id int auto_increment
		primary key,
	code int not null,
	name varchar(20) not null,
	start int not null,
	end int null,
	constraint codes_uk
		unique (code, start)
);

create table details
(
	id int auto_increment
		primary key,
	text text not null
);

create table changes
(
	id int auto_increment
		primary key,
	code int not null,
	start int not null,
	new_code int not null,
	time int not null,
	details_id int null,
	constraint changes_uk
		unique (start, time, new_code, code),
	constraint changes_fk
		foreign key (details_id) references details (id)
);
