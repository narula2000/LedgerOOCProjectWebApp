package app.ledger.demo.services;


import app.ledger.demo.model.AppUser;

import java.util.List;

public interface AdminService {

    List<AppUser> findAll();

    AppUser getUser(String username);

    Boolean removeUser(AppUser user);

    Boolean checkExistedUser(AppUser user);

    Boolean addNewUser(AppUser user);

    Boolean addNewAdmin(AppUser user);

    Boolean updateUserInfo(String userName, AppUser user);

    AppUser getCurrentInfo(String username);

    Boolean checkMatching(AppUser user);

    List<String> getRoles(AppUser user);
}
