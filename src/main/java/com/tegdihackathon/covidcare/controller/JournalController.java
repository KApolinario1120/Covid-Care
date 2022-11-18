package com.tegdihackathon.covidcare.controller;

import com.tegdihackathon.covidcare.dao.JournalDao;
import com.tegdihackathon.covidcare.model.Journal;
import org.springframework.web.bind.annotation.PathVariable;
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

    //Retrieve a journal entry by id
    @RequestMapping(path = "/{journalId}", method = RequestMethod.GET)
    public Journal getJournalByJournalId(@PathVariable int journalId) {
        return journalDao.getJournalByJournalId(journalId);
    }

    //Get a journal entry by user id
    @RequestMapping(path = "/user/{userId}", method = RequestMethod.GET)
    public Journal getJournalByUserId(@PathVariable int userId) {
        return journalDao.getJournalByUserId(userId);
    }

    //Update a journal entry
//  boolean updateJournalEntry(Journal journal);
    @RequestMapping(path = "/update/{journalId}", method = RequestMethod.PUT)
    public boolean updateJournalEntry(@Valid @RequestBody Journal journal) {
        return journalDao.updateJournalEntry(journal);
    }

    @RequestMapping(path = "/submit", method = RequestMethod.POST)
    public void createJournalEntry(@Valid @RequestBody Journal journal) {
        journalDao.createJournal(journal);
    }

//    //Update a journal entry
//    boolean updateJournalEntry(Journal journal);
//
//    //Delete a journal entry
//    Journal deleteJournal(Journal journal, int journalId);

}
