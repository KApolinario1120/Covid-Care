package com.tegdihackathon.covidcare.controller;

import com.tegdihackathon.covidcare.model.Symptom;
import com.tegdihackathon.covidcare.dao.SymptomDao;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("")
public class SymptomController {

    SymptomDao symptomDao;

    public SymptomController(SymptomDao symptomDao) {
        this.symptomDao = symptomDao;
    }
    @RequestMapping(path = "symptom", method = RequestMethod.GET)
    public List<Symptom> getAllSymptoms() {
        return symptomDao.getAllSymptoms();
    }

    @RequestMapping(path = "symptom/all/{journalId}", method = RequestMethod.GET)
    public List<Symptom> getAllSymptomsByJournalId(@PathVariable int journalId){
        return symptomDao.getAllSymptomsByJournalId(journalId);
    }

    @RequestMapping(path = "symptom/{symptomId}", method = RequestMethod.GET)
    public Symptom getSymptomById(@PathVariable int symptomId){
        return symptomDao.getSymptomById(symptomId);
    }

    @RequestMapping(path = "symptom/journalId/{journalId}", method = RequestMethod.POST)
    void insertSymptomIntoJournalSymptom(@PathVariable int journalId, @Valid @RequestBody List<Symptom> symptomList){
        symptomDao.populateJournalSymptomTable(journalId, symptomList);
    }
}
