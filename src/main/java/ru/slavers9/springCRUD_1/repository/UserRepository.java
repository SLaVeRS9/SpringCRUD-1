package ru.slavers9.springCRUD_1.repository;

import lombok.AllArgsConstructor;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import ru.slavers9.springCRUD_1.models.UserModel;

import java.util.List;

@Repository
@AllArgsConstructor
public class UserRepository {
    JdbcTemplate jdbcTemplate;

    public List<UserModel> getAllUsers() {
        String query = "SELECT * FROM Users";
        return jdbcTemplate.query(query, new BeanPropertyRowMapper<>(UserModel.class));
    }

    public UserModel getUserById(Long id) {
        String query = "SELECT * FROM Users WHERE id=?";
        return jdbcTemplate.query(query, new BeanPropertyRowMapper<>(UserModel.class), id)
                .stream().findAny().orElseThrow();
    }

    public void editUser(UserModel user, Long id) {
        String query = "UPDATE Users SET name=?, age=?, email=? WHERE id=?";
        jdbcTemplate.update(query, user.getName(), user.getAge(), user.getEmail(), id);
    }

    public void addUser(UserModel user) {
        String query = "INSERT INTO Users VALUES (default, ?, ?, ?)";
        jdbcTemplate.update(query, user.getName(), user.getAge(), user.getEmail());
    }

    public void deleteUser(Long id) {
        String query = "DELETE FROM Users WHERE id=?";
        jdbcTemplate.update(query, id);
    }
}
