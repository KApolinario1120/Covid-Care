package com.tegdihackathon.covidcare.dao;

import com.tegdihackathon.covidcare.model.Journal;

import java.util.List;

public interface JournalDao {
    //Create
    Journal createJournal(Journal journal);

    //Retrieve
    Journal getJournalByJournalId(int journalId);
    Journal getJournalByUserId(int userId);

    //Update
    Journal updateJournalEntry(String notes);

    //Delete
    Journal deleteJournal(Journal journal, int journalId);
}
