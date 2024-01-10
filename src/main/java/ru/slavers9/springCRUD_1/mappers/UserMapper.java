package ru.slavers9.springCRUD_1.mappers;

import org.springframework.jdbc.core.RowMapper;
import ru.slavers9.springCRUD_1.models.UserModel;

import java.sql.ResultSet;
import java.sql.SQLException;

public class UserMapper implements RowMapper<UserModel> {
    @Override
    public UserModel mapRow(ResultSet rs, int rowNum) throws SQLException {
        UserModel user = new UserModel();
        user.setId((long) rs.getInt("id"));
        user.setName(rs.getString("name"));
        user.setAge(rs.getInt("age"));
        user.setEmail(rs.getString("email"));
        return user;
    }
}
