package com.tegdihackathon.covidcare.dao;

import com.tegdihackathon.covidcare.model.Symptom;

import java.util.List;

public interface SymptomDao {
    //Create
    Symptom createSymptom(String symptomName);

    //Retrieve
    List <Symptom> getAllSymptoms();
    Symptom getSymptomById(int symptomId);

    //Update
    Symptom updateSymptomStatus(boolean hasSymptom);

    //Delete
    Symptom deleteSymptom(String symptomName);
}
