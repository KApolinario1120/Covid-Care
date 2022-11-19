package com.tegdihackathon.covidcare.dao;

import com.tegdihackathon.covidcare.model.Symptom;

import java.util.List;

public interface SymptomDao {

    //Retrieve a list of all symptoms by Id
    List <Symptom> getAllSymptomsByJournalId(int journalId);

    //get a symptom by id
    Symptom getSymptomById(int symptomId);

    //Retrieve a list of all symptoms
    List <Symptom> getAllSymptoms();

    //Update symptom status
    void populateJournalSymptomTable(int journalId, List<Symptom> symptomList);

}
