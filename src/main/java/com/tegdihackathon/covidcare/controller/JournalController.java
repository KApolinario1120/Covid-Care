package com.tegdihackathon.covidcare.controller;

import com.tegdihackathon.covidcare.dao.JournalDao;
import com.tegdihackathon.covidcare.model.Journal;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;

@RequestMapping("journal")
public class JournalController {

    private final JournalDao journalDao;

    public JournalController(JournalDao journalDao) {
        this.journalDao = journalDao;
    }

    @RequestMapping(path = "/submit", method = RequestMethod.POST)
    public void createJournalEntry(@Valid @RequestBody Journal journal) {
        journalDao.createJournal(journal);
    }



//
//    //Retrieve a journal entry by id
//    Journal getJournalByJournalId(int journalId);
//
//    //Get a journal entry by user id
//    Journal getJournalByUserId(int userId);
//
//    //Update a journal entry
//    boolean updateJournalEntry(Journal journal);
//
//    //Delete a journal entry
//    Journal deleteJournal(Journal journal, int journalId);

}
