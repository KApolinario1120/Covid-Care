package com.tegdihackathon.covidcare.dao;

import com.tegdihackathon.covidcare.model.Journal;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;
import java.util.List;
import java.util.ArrayList;

@Component
public class JdbcJournalDao implements JournalDao {

    private JdbcTemplate jdbcTemplate;

    public JdbcJournalDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public void createJournal(Journal journal) {
        String sql = "INSERT INTO public.journal(user_id, journal_date, tested_positive, notes, temperature) VALUES (?,?,?,?,?)";
        jdbcTemplate.update(sql, journal.getUserId(), journal.getJournalDate(), journal.isTestedPositive(), journal.getNotes(), journal.getTemperature());
    }

    @Override
    public Journal getJournalByJournalId(int journalId) {
        Journal journal = null;
        String sql = "SELECT * FROM journal WHERE journal_id = ?;";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql, journalId);
        while (results.next()) {
            journal = mapRowToJournal(results);
        }
        return journal;
    }

    @Override
    public List<Journal> getAllJournalsByUserId(int userId) {
        List<Journal> allJournals = new ArrayList<>();
        String sql = "SELECT * FROM journal WHERE user_id = ?;";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql, userId);
        while (results.next()) {
            Journal journal = mapRowToJournal(results);
            allJournals.add(journal);
        }
        return allJournals;
    }

    @Override
    public List<Journal> getAllJournals() {
        List<Journal> allJournals = new ArrayList<>();
        String sql = "SELECT * FROM journal;";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql);
        while (results.next()) {
            Journal journal = mapRowToJournal(results);
            allJournals.add(journal);
        }
        return allJournals;
    }

    @Override
    public boolean updateJournalEntry(Journal journal) {
        String sql = "UPDATE public.journal SET tested_positive = ?, notes = ?, temperature = ? WHERE journal_id = ?";
        int numberOfRows = jdbcTemplate.update(sql, journal.isTestedPositive(), journal.getNotes(), journal.getTemperature(), journal.getJournalId());
        return numberOfRows == 1;
    }

    @Override
    public void deleteJournal(int journalId) {
        String sqlJournalSymptom = "DELETE FROM journal_symptom WHERE journal_id = ?";
        String sqlJournal = "DELETE FROM journal WHERE journal_id = ?";
        jdbcTemplate.update(sqlJournalSymptom + sqlJournal, journalId);
    }

    private Journal mapRowToJournal(SqlRowSet result) {
        Journal journal = new Journal();
        journal.setJournalId(result.getInt("journal_id"));
        journal.setUserId(result.getInt("user_id"));
        journal.setJournalDate(result.getDate("journal_date").toLocalDate());
        journal.setTestedPositive(result.getBoolean("tested_positive"));
        journal.setNotes(result.getString("notes"));
        journal.setTemperature(result.getDouble("temperature"));
        return journal;

    }

}
