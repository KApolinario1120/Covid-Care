package com.tegdihackathon.covidcare.dao;

import com.tegdihackathon.covidcare.model.Symptom;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class JdbcSymptomDao implements SymptomDao {

    private JdbcTemplate jdbcTemplate;

    public JdbcSymptomDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }


    @Override
    public Symptom createSymptom(String symptomName) {
        return null;
    }

    @Override
    public List<Symptom> getAllSymptoms() {
        return null;
    }

    @Override
    public Symptom getSymptomById(int symptomId) {
        return null;
    }

    @Override
    public Symptom updateSymptomStatus(boolean hasSymptom) {
        return null;
    }

    @Override
    public Symptom deleteSymptom(String symptomName) {
        return null;
    }
}
