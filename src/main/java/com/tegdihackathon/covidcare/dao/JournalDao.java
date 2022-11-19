package com.tegdihackathon.covidcare.dao;

import com.tegdihackathon.covidcare.model.Journal;

public interface JournalDao {

    //Create a journal entry
    void createJournal(Journal journal);

    //Retrieve a journal entry by id
    Journal getJournalByJournalId(int journalId);

    //Get a journal entry by user id
    Journal getJournalByUserId(int userId);

    //Update a journal entry
    boolean updateJournalEntry(Journal journal);

    //Delete a journal entry
    void deleteJournal(int journalId);
}
