package app.ledger.demo.dao;


import app.ledger.demo.mapper.UserMapper;
import app.ledger.demo.model.AppUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.PostConstruct;
import javax.sql.DataSource;
import java.util.List;

@Repository
@Transactional
public class AppUserDaoImpl extends JdbcDaoSupport implements AppUserDao  {

    private final UserMapper mapper = new UserMapper();

    @Autowired
    public DataSource dataSource;

    @PostConstruct
    public void init(){
        setDataSource(dataSource);
    }

    /**
     * Find user account
     * @param userName
     * @return user information
     */
    @Override
    public AppUser findUserAccount(String username) {
        String sql = UserMapper.BASE_SQL + " where u.username = ? ";

        Object[] params = new Object[] { username };
        try {
            AppUser appUserInfo = getJdbcTemplate().queryForObject(sql, params, mapper);
            return appUserInfo;
        } catch (EmptyResultDataAccessException e) {
            return null;
        }
    }

    /**
     * Get all users
     * @return list of user
     */
    @Override
    public List<AppUser> getAllUsers() {
        String sql = UserMapper.BASE_SQL;
        List<AppUser> resultList;
        try{
            resultList = getJdbcTemplate().query(sql, mapper);

        }catch(EmptyResultDataAccessException e){
            System.out.println("Null!");
            resultList = null;
        }
        return resultList;
    }

    /*
     * find total count and then insert to every table
     */
    @Override
    public void insertUser(AppUser user, int authority){
        String sqlForCount = "select max(userId) from APP_USER";
        String sqlForCount2 = "select max(userId) from USER_ROLE";
        String sqlForInsert1 = "insert into APP_USER (userId, " +
                "username, " +
                "ENCRYPTED_PASSWORD, ENABLED, "+
                "values (? , ? , ? , 1)";
        String sqlForInsert2 = "insert into USER_ROLE (ID, userId, ROLE_ID)\n" +
                "values (?, ?, ?)";
        try{
            Long lastId = getJdbcTemplate().queryForObject(sqlForCount, Long.class)+1;
            Long lastRole = getJdbcTemplate().queryForObject(sqlForCount2, Long.class)+1;
            Object[] params = new Object[]{ lastId, user.getUsername(), user.getPassword()};
            getJdbcTemplate().update(sqlForInsert1, params);

            if(authority>0){
                params = new Object[]{ lastRole, lastId, 1};
                getJdbcTemplate().update(sqlForInsert2, params);
                lastRole++;
            }
            params = new Object[]{ lastRole, lastId, 2};
            getJdbcTemplate().update(sqlForInsert2, params);
        }catch(EmptyResultDataAccessException e){
            System.out.println("Null!");
        }
    }

    /*
     * Remove user from both tables
     */
    @Override
    public void removeUser(AppUser user){

        String sqlForRemove1 = "delete from APP_USER where userId = ?;";
        String sqlForRemove2 = "delete from USER_ROLE where userId = ?;";
        try{
            Object[] params = new Object[]{ user.getUserId() };
            getJdbcTemplate().update(sqlForRemove2, params);
            getJdbcTemplate().update(sqlForRemove1, params);
        }catch(EmptyResultDataAccessException e){
            System.out.println("Null!");
        }
    }

    /*
     * Update user info
     */
    @Override
    public void updateUser(AppUser user){

        String sqlForUpdate = "update APP_USER set username = ?" +
                "where userId = ?";
        try{
            Object[] params = new Object[]{user.getUsername(),user.getUserId() };
            getJdbcTemplate().update(sqlForUpdate, params);
        }catch(EmptyResultDataAccessException e){
            System.out.println("Null!");
        }
    }

}
