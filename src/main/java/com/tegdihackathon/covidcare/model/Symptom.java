package com.tegdihackathon.covidcare.model;

public class Symptom {

    private int symptomId;
    private int journalId;
    private String name;
    private boolean symptom;

    public Symptom(int symptomId, int journalId, String name, boolean symptom) {
        this.symptomId = symptomId;
        this.journalId = journalId;
        this.name = name;
        this.symptom = symptom;
    }

    public int getSymptomId() {
        return this.symptomId;
    }

    public void setSymptomId(int symptomId) {
        this.symptomId = symptomId;
    }

    public int getJournalId() {
        return this.journalId;
    }

    public void setJournalId(int journalId) {
        this.journalId = journalId;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isSymptom() {
        return this.symptom;
    }

    public void setSymptom(boolean symptom) {
        this.symptom = symptom;
    }
}
