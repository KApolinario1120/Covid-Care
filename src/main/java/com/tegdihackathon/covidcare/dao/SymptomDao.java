package com.tegdihackathon.covidcare.dao;

import com.tegdihackathon.covidcare.model.Symptom;

import java.util.List;

public interface SymptomDao {

    //Create a symptom
    Symptom createSymptom(String symptomName);

    //Retrieve a list of all symptoms
    List <Symptom> getAllSymptoms();

    //get a symptom by id
    Symptom getSymptomById(int symptomId);

    //Update symptom status
    Symptom updateSymptomStatus(boolean hasSymptom);

    //Delete a symptom
    Symptom deleteSymptom(String symptomName);
}
