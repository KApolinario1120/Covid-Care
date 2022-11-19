package com.tegdihackathon.covidcare.controller;

import com.tegdihackathon.covidcare.dao.JournalDao;
import com.tegdihackathon.covidcare.model.Journal;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.ArrayList;

import javax.validation.Valid;
import java.awt.*;

@CrossOrigin
@RestController
@RequestMapping("")
public class JournalController {

    private final JournalDao journalDao;

    public JournalController(JournalDao journalDao) {
        this.journalDao = journalDao;
    }

    //Retrieve a journal entry by id
    @RequestMapping(path = "journal/{journalId}", method = RequestMethod.GET)
    public Journal getJournalByJournalId(@PathVariable int journalId) {
        return journalDao.getJournalByJournalId(journalId);
    }

    //Get a journal entry by user id
    @RequestMapping(path = "journal/user/{userId}", method = RequestMethod.GET)
    public List<Journal> getAllJournalsByUserId(@PathVariable int userId) {
        return journalDao.getAllJournalsByUserId(userId);
    }

    @RequestMapping(path = "journal/all", method = RequestMethod.GET)
    public List<Journal> getAllJournals() {
        List<Journal> allJournals = journalDao.getAllJournals();
        if (allJournals == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "No journals could be found.");
        } else {
            return allJournals;
        }
    }

    //Update a journal entry
//  boolean updateJournalEntry(Journal journal);
    @RequestMapping(path = "journal/update/{journalId}", method = RequestMethod.PUT)
    public boolean updateJournalEntry(@Valid @RequestBody Journal journal) {
        return journalDao.updateJournalEntry(journal);
    }

    @RequestMapping(path = "journal/submit", method = RequestMethod.POST)
    public void createJournalEntry(@Valid @RequestBody Journal journal) {
        journalDao.createJournal(journal);
    }

    //Delete a journal entry
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @RequestMapping(path = "journal/delete/{journalId}", method = RequestMethod.DELETE)
    public void deleteJournalEntry(@PathVariable int journalId) {
        journalDao.deleteJournal(journalId);
    }

}
