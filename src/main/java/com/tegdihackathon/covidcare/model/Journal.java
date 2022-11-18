package com.tegdihackathon.covidcare.model;

import java.time.LocalDate;

public class Journal {

    private int journalId;
    private int userId;
    private double temperature;
    private LocalDate journalDate;
    private boolean testedPositive;
    private String notes;

    public Journal() {

    }

    public Journal(int journalId, int userId, double temperature, LocalDate journalDate, boolean testedPositive, String notes) {
        this.journalId = journalId;
        this.userId = userId;
        this.temperature = temperature;
        this.journalDate = journalDate;
        this.testedPositive = testedPositive;
        this.notes = notes;
    }

    public int getJournalId() {
        return this.journalId;
    }

    public void setJournalId(int journalId) {
        this.journalId = journalId;
    }

    public int getUserId() {
        return this.userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public double getTemperature() {
        return this.temperature;
    }

    public void setTemperature(double temperature) {
        this.temperature = temperature;
    }

    public LocalDate getJournalDate() {
        return this.journalDate;
    }

    public void setJournalDate(LocalDate journalDate) {
        this.journalDate = journalDate;
    }

    public boolean isTestedPositive() {
        return this.testedPositive;
    }

    public void setTestedPositive(boolean testedPositive) {
        this.testedPositive = testedPositive;
    }

    public String getNotes() {
        return this.notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }
}
