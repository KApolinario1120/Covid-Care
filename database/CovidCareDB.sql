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

INSERT INTO public.symptom(symptom_name, symptom_type)
VALUES ('fatigue', 'general');
    
INSERT INTO public.symptom(symptom_name, symptom_type)
VALUES ('post-exertional malaise', 'general');
    
INSERT INTO public.symptom(symptom_name, symptom_type)
VALUES ('fever', 'general');

INSERT INTO public.symptom(symptom_name, symptom_type)
VALUES ('shortness of breath', 'respiratory, cardiovascular');

INSERT INTO public.symptom(symptom_name, symptom_type)
VALUES ('cough', 'respiratory, cardiovascular');

INSERT INTO public.symptom(symptom_name, symptom_type)
VALUES ('chest pain', 'respiratory, cardiovascular');

INSERT INTO public.symptom(symptom_name, symptom_type)
VALUES ('heart palpitations', 'respiratory, cardiovascular');

INSERT INTO public.symptom(symptom_name, symptom_type)
VALUES ('difficulty thinking or concentrating', 'neurological');

INSERT INTO public.symptom(symptom_name, symptom_type)
VALUES ('headache', 'neurological');

INSERT INTO public.symptom(symptom_name, symptom_type)
VALUES ('sleep problems', 'neurological');

INSERT INTO public.symptom(symptom_name, symptom_type)
VALUES ('dizziness', 'neurological');

INSERT INTO public.symptom(symptom_name, symptom_type)
VALUES ('dizziness when standing', 'neurological');

INSERT INTO public.symptom(symptom_name, symptom_type)
VALUES ('pins-and-needles', 'neurological');

INSERT INTO public.symptom(symptom_name, symptom_type)
VALUES ('change in taste or smell', 'neurological');

INSERT INTO public.symptom(symptom_name, symptom_type)
VALUES ('depression or anxiety', 'neurological');

INSERT INTO public.symptom(symptom_name, symptom_type)
VALUES ('diarrhea', 'digestive');

INSERT INTO public.symptom(symptom_name, symptom_type)
VALUES ('stomach pain', 'digestive');

INSERT INTO public.symptom(symptom_name, symptom_type)
VALUES ('joint or muscle pain', 'other');

INSERT INTO public.symptom(symptom_name, symptom_type)
VALUES ('rash', 'other');

INSERT INTO public.symptom(symptom_name, symptom_type)
VALUES ('changes in menstrual cycles', 'other');

COMMIT TRANSACTION;