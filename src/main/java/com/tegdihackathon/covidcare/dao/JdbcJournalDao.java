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
    public Journal createJournal(Journal journal) {
        String sql = "INSERT INTO public.journal(journal_id, user_id, journal_date, tested_positive, notes, temperature) VALUES (?,?,?,?,?,?)";
        return null;
    }

    @Override
    public Journal getJournalByJournalId(int journalId) {
        return null;
    }

    @Override
    public Journal getJournalByUserId(int userId) {
        return null;
    }

    @Override
    public Journal updateJournalEntry(Journal journal) {
        String sql = "UPDATE public.journal SET journal_id = ?, user_id = ?, tested_positive = ?, notes = ?, temperature = ? WHERE journal_id = ?";
        int numberOfRows = jdbcTemplate.update(sql, journal.getJournalId(), journal.getUserId(), journal.isTestedPositive(), journal.getNotes(), journal.getTemperature(), journal.)

        return null;
    }

    @Override
    public Journal deleteJournal(Journal journal, int journalId) {
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
