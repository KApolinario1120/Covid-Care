BEGIN TRANSACTION;
DROP TABLE IF EXISTS journal_symptom, symptom, journal, care_user;

CREATE TABLE care_user (
    user_id serial NOT NULL primary key,
    username varchar(40) NOT NULL
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
    has_symptom boolean NOT NULL DEFAULT false
);
	
-- CREATE TABLE journal_symptom (
--     journal_id integer NOT NULL,
--     symptom_id integer NOT NULL,
--     CONSTRAINT journal_symptom_pkey PRIMARY KEY (journal_id, symptom_id),
--     CONSTRAINT fk_journal_symptom_journal_id_references_journal_journal_id FOREIGN KEY (journal_id)
--         REFERENCES public.journal (journal_id),
--     CONSTRAINT fk_journal_symptom_symptom_id_references_symptom_symptom_id FOREIGN KEY (symptom_id)
--         REFERENCES public.symptom (symptom_id)
-- )

CREATE TABLE journal_symptom (
    journal_id int NOT NULL primary key,
    symptom_id int NOT NULL primary key,
    CONSTRAINT journal_symptom_pkey PRIMARY KEY (journal_id, symptom_id),
    foreign key (journal_id) references journal (journal_id),
    foreign key (symptom_id) references symptom (symptom_id)
);

COMMIT TRANSACTION;