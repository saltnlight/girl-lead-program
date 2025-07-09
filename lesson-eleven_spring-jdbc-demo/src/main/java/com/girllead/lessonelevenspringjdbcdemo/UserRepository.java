package com.girllead.lessonelevenspringjdbcdemo;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class UserRepository {

    private final JdbcTemplate jdbcTemplate;

    public UserRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public void insertUser(Girl girl) {
        String sql = "INSERT INTO girls (name, email) VALUES (?, ?)";

        jdbcTemplate.update(sql, girl.getName(), girl.getEmail());
    }

    public List<Girl> findAllUsers() {
        String sql = "SELECT * FROM girls";
        RowMapper<Girl> rowMapper = (rs, rowNum) -> new Girl(
                rs.getInt("id"),
                rs.getString("name"),
                rs.getString("email")
        );
        return jdbcTemplate.query(sql, rowMapper);
    }
}
