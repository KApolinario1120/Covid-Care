package com.tegdihackathon.covidcare.controller;

import com.tegdihackathon.covidcare.model.Symptom;
import com.tegdihackathon.covidcare.dao.SymptomDao;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController

@RequestMapping("symptom")
public class SymptomController {

    SymptomDao symptomDao;

    public SymptomController(SymptomDao symptomDao) {
        this.symptomDao = symptomDao;
    }
    @RequestMapping(path = "", method = RequestMethod.GET)
    public List<Symptom> getAllSymptoms() {
        return symptomDao.getAllSymptoms();
    }

    @RequestMapping(path = "s/{journalId}", method = RequestMethod.GET)
    public List<Symptom> getAllSymptomsByJournalId(@PathVariable int journalId){
        return symptomDao.getAllSymptomsByJournalId(journalId);
    }

    @RequestMapping(path = "/{symptomId}", method = RequestMethod.GET)
    public Symptom getSymptomById(@PathVariable int symptomId){
        return symptomDao.getSymptomById(symptomId);
    }

    @RequestMapping(path = "/{insert}", method = RequestMethod.POST)
    void insertSymptomIntoJournalSymptom(@PathVariable int journalId, @PathVariable int symptomId){
        symptomDao.insertSymptomIntoJournalSymptom(journalId, symptomId);
    }
}
