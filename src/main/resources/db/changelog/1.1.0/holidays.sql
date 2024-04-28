-- liquibase formatted sql
-- changeset yuekukhtina@edu.hse.ru:1 logicalFilePath:1.1.0/holidays.sql
create table holidays_by_country_year
(
    id   uuid default gen_random_uuid(),
    country varchar(255),
    year integer,
    holiday_data text
);

create table holidays_by_date_country
(
    id   uuid default gen_random_uuid(),
    country varchar(255),
    year integer,
    month integer,
    day integer,
    holiday_data text
);

create table holidays_by_type_country_year
(
    id   uuid default gen_random_uuid(),
    country varchar(255),
    year integer,
    type varchar(255),
    holiday_data text
);

create table holidays_upcoming_by_country
(
    id   uuid default gen_random_uuid(),
    country varchar(255),
    year integer,
    month integer,
    holiday_data text
);
-- rollback delete holidays_by_country_year;
-- rollback drop table holidays_by_date_country;
-- rollback drop table holidays_by_type_country_year;
-- rollback drop table holidays_upcoming_by_country;
