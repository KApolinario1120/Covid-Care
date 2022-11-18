package com.tegdihackathon.covidcare.model;

public class Symptom {

    private int symptomId;
    private String symptomName;

    private String symptomType;

    public Symptom(int symptomId, String symptomName, String symptomType) {
        this.symptomId = symptomId;
        this.symptomName = symptomName;
        this.symptomType = symptomType;
    }

    public Symptom() {
    }

    public int getSymptomId() {
        return this.symptomId;
    }

    public void setSymptomId(int symptomId) {
        this.symptomId = symptomId;
    }

    public String getSymptomName() {
        return this.symptomName;
    }

    public void setName(String symptomName) {
        this.symptomName = symptomName;
    }

    public void setSymptomName(String symptomName) { this.symptomName = symptomName; }

    public String getSymptomType() { return symptomType;}

    public void setSymptomType(String symptomType) { this.symptomType = symptomType; }

}
