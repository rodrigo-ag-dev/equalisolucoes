CREATE TABLE IF NOT EXISTS cities (
	state varchar(2) NULL,
	id int8 NOT NULL,
	"name" varchar(60) NULL,
	CONSTRAINT cities_pkey PRIMARY KEY (id)
);

CREATE TABLE IF NOT EXISTS users (
	id int8 NOT NULL,
	"password" varchar(50) NULL,
	"name" varchar(100) NULL,
	email varchar(200) NULL,
	CONSTRAINT users_pkey PRIMARY KEY (id)
);

CREATE TABLE IF NOT EXISTS customers (
	id int8 NOT NULL,
	"name" varchar(100) NULL,
	post_code int4 NULL,
	address varchar(200) NULL,
	"number" int4 NULL,
	district varchar(60) NULL,
	city_id int8 NULL,
	"document" varchar(30) NULL,
	CONSTRAINT customers_pkey PRIMARY KEY (id),
	CONSTRAINT fkcnjv7us3tih8hj2fonxov8gxw FOREIGN KEY (city_id) REFERENCES equalisolucoes.cities(id)
);

CREATE SEQUENCE IF NOT EXISTS cities_seq INCREMENT BY 50 MINVALUE 1 MAXVALUE 9223372036854775807 START 1 CACHE 1 NO CYCLE;

CREATE SEQUENCE IF NOT EXISTS customers_seq INCREMENT BY 50 MINVALUE 1 MAXVALUE 9223372036854775807 START 1 CACHE 1 NO CYCLE;

CREATE SEQUENCE IF NOT EXISTS users_seq INCREMENT BY 50 MINVALUE 1 MAXVALUE 9223372036854775807 START 1 CACHE 1 NO CYCLE;