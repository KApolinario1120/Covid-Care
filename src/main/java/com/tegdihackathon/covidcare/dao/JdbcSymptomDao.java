package com.tegdihackathon.covidcare.dao;

import com.tegdihackathon.covidcare.model.Symptom;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class JdbcSymptomDao implements SymptomDao {

    private JdbcTemplate jdbcTemplate;

    public JdbcSymptomDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }


//    @Override//
//    public Symptom createSymptom(String symptomName) {
//        Symptom symptom = null;
//        String sql = "INSERT INTO symptom (symptom_name) VALUES (?) RETURNING symptom_name";
//        String newSymptom = jdbcTemplate.queryForObject(sql, String.class, symptomName)
//                if (newSymptom == null) {
//                    ;
//                }
//    }

    @Override
    public List<Symptom> getAllSymptoms() {
        return null;
    }

    @Override
    public void insertSymptomIntoJournalSymptom(int journalId, int symptomId) {

    }

    @Override
    public List<Symptom> getAllSymptomsByJournalId(int journalId) {
        return null;
    }

    @Override
    public Symptom getSymptomById(int symptomId) {
        return null;
    }

//    @Override//
//    public Symptom updateSymptomStatus(boolean hasSymptom) {
//        return null;
//    }
//
//    @Override
//    public Symptom deleteSymptom(String symptomName) {
//        return null;
//    }

    public Symptom mapRowToSymptom(SqlRowSet result) {
        Symptom symptom = new Symptom();
        symptom.setSymptomId(result.getInt("symptom_id"));
        symptom.setName(result.getString("symptom_name"));
        symptom.setSymptomType(result.getString("symptom_type"));
        return symptom;
    }
}
