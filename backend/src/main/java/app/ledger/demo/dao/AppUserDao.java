package app.ledger.demo.dao;



import app.ledger.demo.model.AppUser;

import java.util.List;

public interface AppUserDao {

    AppUser findUserAccount(String userName);


    List<AppUser> getAllUsers();

    void insertUser(AppUser user, int authority);

    void removeUser(AppUser user);

    void updateUser(AppUser user);
}

