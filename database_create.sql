create table emprego (id bigint not null, descricao varchar(255), empresa varchar(255), titulo varchar(255), primary key (id)) engine=InnoDB;
create table hibernate_sequence (next_val bigint) engine=InnoDB;
insert into hibernate_sequence values ( 1 );
create table owners (id bigint not null auto_increment, first_name varchar(255), last_name varchar(255), address varchar(255), city varchar(255), telephone varchar(255), primary key (id)) engine=InnoDB;
create table pets (id bigint not null auto_increment, birth_date date, name varchar(255), owner_id bigint, type_id bigint, primary key (id)) engine=InnoDB;
create table role (id bigint not null, role varchar(255), primary key (id)) engine=InnoDB;
create table specialties (id bigint not null auto_increment, description varchar(255), primary key (id)) engine=InnoDB;
create table types (id bigint not null auto_increment, name varchar(255), primary key (id)) engine=InnoDB;
create table user (id bigint not null, email varchar(255) not null, enable bit, last_name varchar(255), name varchar(255), password varchar(255), username varchar(255), primary key (id)) engine=InnoDB;
create table user_roles (user_id bigint not null, role_id bigint not null) engine=InnoDB;
create table vet_specialties (vet_id bigint not null, specialty_id bigint not null, primary key (vet_id, specialty_id)) engine=InnoDB;
create table vets (id bigint not null auto_increment, first_name varchar(255), last_name varchar(255), primary key (id)) engine=InnoDB;
create table visits (id bigint not null auto_increment, visit_date date, description varchar(255), pet_id bigint, primary key (id)) engine=InnoDB;
alter table role add constraint UK_bjxn5ii7v7ygwx39et0wawu0q unique (role);
alter table pets add constraint FK6teg4kcjcnjhduguft56wcfoa foreign key (owner_id) references owners (id);
alter table pets add constraint FKtmmh1tq8pah5vxf8kuqqplo4p foreign key (type_id) references types (id);
alter table user_roles add constraint FKrhfovtciq1l558cw6udg0h0d3 foreign key (role_id) references role (id);
alter table user_roles add constraint FK55itppkw3i07do3h7qoclqd4k foreign key (user_id) references user (id);
alter table vet_specialties add constraint FK35uiboyrpfn1bndrr5jorcj0m foreign key (specialty_id) references specialties (id);
alter table vet_specialties add constraint FKby1c0fbaa0byaifi63vt18sx9 foreign key (vet_id) references vets (id);
alter table visits add constraint FK6jcifhlqqlsfseu67utlouauy foreign key (pet_id) references pets (id);
create table emprego (id bigint not null, descricao varchar(255), empresa varchar(255), titulo varchar(255), primary key (id)) engine=InnoDB
create table hibernate_sequence (next_val bigint) engine=InnoDB
insert into hibernate_sequence values ( 1 )
create table owners (id bigint not null auto_increment, first_name varchar(255), last_name varchar(255), address varchar(255), city varchar(255), telephone varchar(255), primary key (id)) engine=InnoDB
create table pets (id bigint not null auto_increment, birth_date date, name varchar(255), owner_id bigint, type_id bigint, primary key (id)) engine=InnoDB
create table role (id bigint not null, role varchar(255), primary key (id)) engine=InnoDB
create table specialties (id bigint not null auto_increment, description varchar(255), primary key (id)) engine=InnoDB
create table types (id bigint not null auto_increment, name varchar(255), primary key (id)) engine=InnoDB
create table user (id bigint not null, email varchar(255) not null, enable bit, last_name varchar(255), name varchar(255), password varchar(255), username varchar(255), primary key (id)) engine=InnoDB
create table user_roles (user_id bigint not null, role_id bigint not null) engine=InnoDB
create table vet_specialties (vet_id bigint not null, specialty_id bigint not null, primary key (vet_id, specialty_id)) engine=InnoDB
create table vets (id bigint not null auto_increment, first_name varchar(255), last_name varchar(255), primary key (id)) engine=InnoDB
create table visits (id bigint not null auto_increment, visit_date date, description varchar(255), pet_id bigint, primary key (id)) engine=InnoDB
alter table role add constraint UK_bjxn5ii7v7ygwx39et0wawu0q unique (role)
alter table pets add constraint FK6teg4kcjcnjhduguft56wcfoa foreign key (owner_id) references owners (id)
alter table pets add constraint FKtmmh1tq8pah5vxf8kuqqplo4p foreign key (type_id) references types (id)
alter table user_roles add constraint FKrhfovtciq1l558cw6udg0h0d3 foreign key (role_id) references role (id)
alter table user_roles add constraint FK55itppkw3i07do3h7qoclqd4k foreign key (user_id) references user (id)
alter table vet_specialties add constraint FK35uiboyrpfn1bndrr5jorcj0m foreign key (specialty_id) references specialties (id)
alter table vet_specialties add constraint FKby1c0fbaa0byaifi63vt18sx9 foreign key (vet_id) references vets (id)
alter table visits add constraint FK6jcifhlqqlsfseu67utlouauy foreign key (pet_id) references pets (id)
create table emprego (id bigint not null, descricao varchar(255), empresa varchar(255), titulo varchar(255), primary key (id)) engine=InnoDB
create table hibernate_sequence (next_val bigint) engine=InnoDB
insert into hibernate_sequence values ( 1 )
create table owners (id bigint not null auto_increment, first_name varchar(255), last_name varchar(255), address varchar(255), city varchar(255), telephone varchar(255), primary key (id)) engine=InnoDB
create table pets (id bigint not null auto_increment, birth_date date, name varchar(255), owner_id bigint, type_id bigint, primary key (id)) engine=InnoDB
create table role (id bigint not null, role varchar(255), primary key (id)) engine=InnoDB
create table specialties (id bigint not null auto_increment, description varchar(255), primary key (id)) engine=InnoDB
create table types (id bigint not null auto_increment, name varchar(255), primary key (id)) engine=InnoDB
create table user (id bigint not null, email varchar(255) not null, enable bit, last_name varchar(255), name varchar(255), password varchar(255), username varchar(255), primary key (id)) engine=InnoDB
create table user_roles (user_id bigint not null, role_id bigint not null) engine=InnoDB
create table vet_specialties (vet_id bigint not null, specialty_id bigint not null, primary key (vet_id, specialty_id)) engine=InnoDB
create table vets (id bigint not null auto_increment, first_name varchar(255), last_name varchar(255), primary key (id)) engine=InnoDB
create table visits (id bigint not null auto_increment, visit_date date, description varchar(255), pet_id bigint, primary key (id)) engine=InnoDB
alter table role add constraint UK_bjxn5ii7v7ygwx39et0wawu0q unique (role)
alter table pets add constraint FK6teg4kcjcnjhduguft56wcfoa foreign key (owner_id) references owners (id)
alter table pets add constraint FKtmmh1tq8pah5vxf8kuqqplo4p foreign key (type_id) references types (id)
alter table user_roles add constraint FKrhfovtciq1l558cw6udg0h0d3 foreign key (role_id) references role (id)
alter table user_roles add constraint FK55itppkw3i07do3h7qoclqd4k foreign key (user_id) references user (id)
alter table vet_specialties add constraint FK35uiboyrpfn1bndrr5jorcj0m foreign key (specialty_id) references specialties (id)
alter table vet_specialties add constraint FKby1c0fbaa0byaifi63vt18sx9 foreign key (vet_id) references vets (id)
alter table visits add constraint FK6jcifhlqqlsfseu67utlouauy foreign key (pet_id) references pets (id)
create table emprego (id bigint not null, descricao varchar(255), empresa varchar(255), titulo varchar(255), primary key (id)) engine=InnoDB
create table hibernate_sequence (next_val bigint) engine=InnoDB
insert into hibernate_sequence values ( 1 )
create table owners (id bigint not null auto_increment, first_name varchar(255), last_name varchar(255), address varchar(255), city varchar(255), telephone varchar(255), primary key (id)) engine=InnoDB
create table pets (id bigint not null auto_increment, birth_date date, name varchar(255), owner_id bigint, type_id bigint, primary key (id)) engine=InnoDB
create table role (id bigint not null, role varchar(255), primary key (id)) engine=InnoDB
create table specialties (id bigint not null auto_increment, description varchar(255), primary key (id)) engine=InnoDB
create table types (id bigint not null auto_increment, name varchar(255), primary key (id)) engine=InnoDB
create table user (id bigint not null, email varchar(255) not null, enable bit, last_name varchar(255), name varchar(255), password varchar(255), username varchar(255), primary key (id)) engine=InnoDB
create table user_roles (user_id bigint not null, role_id bigint not null) engine=InnoDB
create table vet_specialties (vet_id bigint not null, specialty_id bigint not null, primary key (vet_id, specialty_id)) engine=InnoDB
create table vets (id bigint not null auto_increment, first_name varchar(255), last_name varchar(255), primary key (id)) engine=InnoDB
create table visits (id bigint not null auto_increment, visit_date date, description varchar(255), pet_id bigint, primary key (id)) engine=InnoDB
alter table role add constraint UK_bjxn5ii7v7ygwx39et0wawu0q unique (role)
alter table pets add constraint FK6teg4kcjcnjhduguft56wcfoa foreign key (owner_id) references owners (id)
alter table pets add constraint FKtmmh1tq8pah5vxf8kuqqplo4p foreign key (type_id) references types (id)
alter table user_roles add constraint FKrhfovtciq1l558cw6udg0h0d3 foreign key (role_id) references role (id)
alter table user_roles add constraint FK55itppkw3i07do3h7qoclqd4k foreign key (user_id) references user (id)
alter table vet_specialties add constraint FK35uiboyrpfn1bndrr5jorcj0m foreign key (specialty_id) references specialties (id)
alter table vet_specialties add constraint FKby1c0fbaa0byaifi63vt18sx9 foreign key (vet_id) references vets (id)
alter table visits add constraint FK6jcifhlqqlsfseu67utlouauy foreign key (pet_id) references pets (id)
