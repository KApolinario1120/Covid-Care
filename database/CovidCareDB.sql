BEGIN TRANSACTION;
DROP TABLE IF EXISTS journal_symptom, symptom, journal, care_user;

CREATE TABLE care_user (
    user_id serial NOT NULL primary key,
    username varchar(40) NOT NULL,
	user_password varchar(100) 
);

CREATE TABLE journal (
    journal_id serial NOT NULL primary key,
    user_id int NOT NULL,
    journal_date date NOT NULL,
    tested_positive boolean DEFAULT false,
    notes varchar(1000),
    temperature numeric,
    FOREIGN KEY (user_id) references care_user (user_id)
);

CREATE TABLE symptom (
    symptom_id serial NOT NULL primary key,
    symptom_name varchar(100) NOT NULL,
    symptom_type varchar(100) NOT NULL
);

CREATE TABLE journal_symptom (
    journal_id int NOT NULL,
    symptom_id int NOT NULL,
    CONSTRAINT journal_symptom_pkey PRIMARY KEY (journal_id, symptom_id),
    foreign key (journal_id) references journal (journal_id),
    foreign key (symptom_id) references symptom (symptom_id)
);

COMMIT TRANSACTION;