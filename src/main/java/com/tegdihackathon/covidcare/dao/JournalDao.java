package com.tegdihackathon.covidcare.dao;

import com.tegdihackathon.covidcare.model.Journal;

import java.util.List;

public interface JournalDao {

    //Create a journal entry
    void createJournal(Journal journal);

    //Retrieve a journal entry by id
    Journal getJournalByJournalId(int journalId);

    //Get all journals by user id
    List<Journal> getAllJournalsByUserId(int userId);

    //Get all journals
    List<Journal> getAllJournals();

    //Update a journal entry
    boolean updateJournalEntry(Journal journal);

    //Delete a journal entry
    void deleteJournal(int journalId);
}
