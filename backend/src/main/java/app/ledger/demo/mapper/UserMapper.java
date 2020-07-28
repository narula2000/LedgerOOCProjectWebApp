package app.ledger.demo.mapper;


import app.ledger.demo.model.AppUser;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class UserMapper implements RowMapper<AppUser> {

    public static final String BASE_SQL
            = "SELECT * From APP_USER u ";

    /**
     * Mapping string into object
     * @param rs
     * @param rowNum
     * @return
     * @throws SQLException
     */
    @Override
    public AppUser mapRow(ResultSet rs, int rowNum) throws SQLException {
        AppUser appUser = new AppUser();
        appUser.setUserId( rs.getString("userId"));
        appUser.setUsername(rs.getString("userName"));
        appUser.setPassword(rs.getString("ENCRYPTED_PASSWORD"));
        return appUser;
    }
}
