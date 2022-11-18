package com.tegdihackathon.covidcare.model;

public class Symptom {

    private int symptomId;
    private String symptomName;
    private boolean hasSymptom;

    public Symptom(int symptomId, String symptomName, boolean symptom) {
        this.symptomId = symptomId;
        this.symptomName = symptomName;
        this.hasSymptom = symptom;
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

    public boolean hasSymptom() {
        return this.hasSymptom;
    }

    public void setHasSymptom(boolean hasSymptom) {
        this.hasSymptom = hasSymptom;
    }
}
