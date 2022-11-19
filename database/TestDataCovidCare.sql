-- TEST DATA
BEGIN TRANSACTION;

INSERT INTO public.care_user(username, user_password)
VALUES ('kassib', 'password');

INSERT INTO public.care_user(username, user_password)
VALUES ('brittanyw', 'password');

INSERT INTO public.care_user(username, user_password)
VALUES ('kevina', 'password');

INSERT INTO public.care_user(username, user_password)
VALUES ('davids', 'password');

INSERT INTO public.journal(user_id, journal_date, tested_positive, notes, temperature)
VALUES (1, '11/17/2022', false, 'feeling excited about this cloud-based database', 98.2);

INSERT INTO public.journal(user_id, journal_date, tested_positive, notes, temperature)
VALUES (2, '11/17/2022', false, 'adds years to our lives by saving us from technical problems', 98.2);

INSERT INTO public.journal(user_id, journal_date, tested_positive, notes, temperature)
VALUES (3, '11/17/2022', false, 'supposedly a supreme maker of mac and cheese though evidence has not yet been provided to substantiate this claim', 98.2);

INSERT INTO public.journal(user_id, journal_date, tested_positive, notes, temperature)
VALUES (3, '11/17/2022', false, 'expert-level user of Notepad', 98.2);
	
INSERT INTO public.journal_symptom(journal_id, symptom_id)
VALUES (1, 2);
	
INSERT INTO public.journal_symptom(journal_id, symptom_id)
VALUES (1, 4);
	
INSERT INTO public.journal_symptom(journal_id, symptom_id)
VALUES (1, 6);
	
INSERT INTO public.journal_symptom(journal_id, symptom_id)
VALUES (2, 1);
	
INSERT INTO public.journal_symptom(journal_id, symptom_id)
VALUES (2, 4);
	
INSERT INTO public.journal_symptom(journal_id, symptom_id)
VALUES (2, 6);
	
INSERT INTO public.journal_symptom(journal_id, symptom_id)
VALUES (3, 2);

INSERT INTO public.journal_symptom(journal_id, symptom_id)
VALUES (3, 3);
	
INSERT INTO public.journal_symptom(journal_id, symptom_id)
VALUES (3, 5);

COMMIT;