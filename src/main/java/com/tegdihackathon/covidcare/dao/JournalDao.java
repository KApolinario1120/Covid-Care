package com.tegdihackathon.covidcare.dao;

import com.tegdihackathon.covidcare.model.Journal;

import java.util.List;

public interface JournalDao {

    //Create a journal entry
    Journal createJournal(Journal journal);

    //Retrieve a journal entry by id
    Journal getJournalByJournalId(int journalId);

    //Get a journal entry by user id
    Journal getJournalByUserId(int userId);

    //Update a journal entry
    Journal updateJournalEntry(String notes);

    //Delete a journal entry
    Journal deleteJournal(Journal journal, int journalId);
}
