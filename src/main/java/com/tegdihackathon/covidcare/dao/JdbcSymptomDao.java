package com.tegdihackathon.covidcare.dao;

import com.tegdihackathon.covidcare.model.Symptom;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class JdbcSymptomDao implements SymptomDao {

    private JdbcTemplate jdbcTemplate;

    public JdbcSymptomDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<Symptom> getAllSymptoms() {
        String sql = "SELECT * FROM symptom;";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql);
        List<Symptom> symptoms = new ArrayList<>();
        while(results.next()){
            symptoms.add(mapRowToSymptom(results));
        }
        return symptoms;
    }

    @Override
    public void populateJournalSymptomTable(int journalId, List<Symptom> symptomList){
        for (Symptom symptom: symptomList) {
            String sql = "INSERT INTO journal_table (journal_id, symptom_id) VALUES (?, ?);";
            jdbcTemplate.update(sql, journalId, symptom.getSymptomId());
        }
    }

    @Override
    public List<Symptom> getAllSymptomsByJournalId(int journalId) {
        String sql =
        "SELECT symptom.symptom_id, symptom.symptom_name, symptom.symptom_type FROM symptom " +
        "JOIN journal_symptom ON symptom.symptom_id = journal_symptom.symptom_id " +
        "JOIN journal ON journal_symptom.journal_id = journal.journal_id " +
        "WHERE journal.journal_id = ?;";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql, journalId);
        List<Symptom> symptoms = new ArrayList<>();
        while (results.next()){
            symptoms.add(mapRowToSymptom(results));
        }
        return symptoms;
    }

    @Override
    public Symptom getSymptomById(int symptomId) {
        String sql = "SELECT * FROM symptom WHERE symptom_id = ?";
        SqlRowSet result = jdbcTemplate.queryForRowSet(sql, symptomId);
        Symptom symptom = new Symptom();
        if (result.next()){
            symptom = mapRowToSymptom(result);
        }
        return symptom;
    }

    public Symptom mapRowToSymptom(SqlRowSet result) {
        Symptom symptom = new Symptom();
        symptom.setSymptomId(result.getInt("symptom_id"));
        symptom.setName(result.getString("symptom_name"));
        symptom.setSymptomType(result.getString("symptom_type"));
        return symptom;
    }
}
