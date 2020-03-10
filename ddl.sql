create table agency
(
    agency_id   CHAR(16) FOR BIT DATA not null,
    agency_type integer,
    primary key (agency_id)
);
create table service
(
    service_id   CHAR(16) FOR BIT DATA not null,
    notes        varchar(255),
    service_type integer,
    agency_id    CHAR(16) FOR BIT DATA,
    primary key (service_id)
);
create table user_profile
(
    user_id            CHAR(16) FOR BIT DATA not null,
    email              varchar(1024),
    family_unit_number integer,
    name               varchar(1024)         not null,
    oauth_key          varchar(50)           not null,
    phone_number       bigint,
    agency_id          CHAR(16) FOR BIT DATA,
    primary key (user_id)
);
create index IDXhwj1idblnqhrrmj7w2aq9sncx on user_profile (name);
create index IDXjxt2h1iv42xrx0a2eenkj2jox on user_profile (phone_number);
create index IDXtcks72p02h4dp13cbhxne17ad on user_profile (email);
alter table user_profile
    add constraint UK_6f815wi5o4jq8p1q1w63o4mhd unique (oauth_key);
alter table service
    add constraint FKmrviynn7g21iivifn5qr31cyp foreign key (agency_id) references agency;
alter table user_profile
    add constraint FKlv49shtr8g8j2aivkstvfdjh8 foreign key (agency_id) references agency
