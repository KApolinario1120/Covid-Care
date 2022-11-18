package com.tegdihackathon.covidcare.dao;

import com.tegdihackathon.covidcare.model.Journal;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

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
    public Journal getJournalByUserId(int userId) {
        Journal journal = null;
        String sql = "SELECT * FROM journal WHERE user_id = ?;";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql, userId);
        while (results.next()) {
            journal = mapRowToJournal(results);
        }
        return journal;
    }

    @Override
    public boolean updateJournalEntry(Journal journal) {
        String sql = "UPDATE public.journal SET tested_positive = ?, notes = ?, temperature = ? WHERE journal_id = ?";
        int numberOfRows = jdbcTemplate.update(sql, journal.isTestedPositive(), journal.getNotes(), journal.getTemperature(), journal.getJournalId());
        return numberOfRows == 1;
    }

    @Override
    public Journal deleteJournal(int journalId) {
        return null;
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
