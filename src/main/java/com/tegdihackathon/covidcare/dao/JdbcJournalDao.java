package com.tegdihackathon.covidcare.dao;

import com.tegdihackathon.covidcare.model.Journal;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

@Component
public class JdbcJournalDao implements JournalDao {

    private JdbcTemplate jdbcTemplate;

    public JdbcJournalDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }



    @Override
    public Journal createJournal(Journal journal) {
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
    public Journal updateJournalEntry(String notes) {
        return null;
    }

    @Override
    public Journal deleteJournal(Journal journal, int journalId) {
        return null;
    }
}
