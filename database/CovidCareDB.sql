BEGIN TRANSACTION;

DROP TABLE IF EXISTS public.journal_symptom, public.symptom, public.journal, public.care_user;

-- Table: public.care_user

CREATE TABLE IF NOT EXISTS public.care_user
(
    user_id serial NOT NULL,
    username character varying(40) COLLATE pg_catalog."default" NOT NULL,
    CONSTRAINT user_pkey PRIMARY KEY (user_id)
)

TABLESPACE pg_default;
	
-- Table: public.journal

CREATE TABLE IF NOT EXISTS public.journal
(
    journal_id serial NOT NULL,
    user_id integer NOT NULL,
    date date NOT NULL,
    tested_positive boolean DEFAULT false,
    notes character varying(300) COLLATE pg_catalog."default",
    temperature integer,
    CONSTRAINT journal_pkey PRIMARY KEY (journal_id),
    CONSTRAINT fk_journal_user_id_references_user_user_id FOREIGN KEY (user_id)
        REFERENCES public.care_user (user_id) 
)

TABLESPACE pg_default;
	
-- Table: public.symptom

CREATE TABLE IF NOT EXISTS public.symptom
(
    symptom_id serial NOT NULL,
    symptom_name character varying(100) COLLATE pg_catalog."default" NOT NULL,
    has_symptom boolean NOT NULL DEFAULT false,
    CONSTRAINT symptom_pkey PRIMARY KEY (symptom_id)
)

TABLESPACE pg_default;
	
CREATE TABLE IF NOT EXISTS public.journal_symptom
(
    journal_id integer NOT NULL,
    symptom_id integer NOT NULL,
    CONSTRAINT journal_symptom_pkey PRIMARY KEY (journal_id, symptom_id),
    CONSTRAINT fk_journal_symptom_journal_id_references_journal_journal_id FOREIGN KEY (journal_id)
        REFERENCES public.journal (journal_id),
    CONSTRAINT fk_journal_symptom_symptom_id_references_symptom_symptom_id FOREIGN KEY (symptom_id)
        REFERENCES public.symptom (symptom_id)
)

TABLESPACE pg_default;

COMMIT;