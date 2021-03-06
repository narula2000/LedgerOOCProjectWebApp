package app.ledger.demo.services;

import app.ledger.demo.dao.AppRoleDao;
import app.ledger.demo.dao.AppUserDao;
import app.ledger.demo.model.AppUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

// Connect with bean to check user who try to login to server
@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private AppUserDao appUserDAO;

    @Autowired
    private AppRoleDao roleDao;

    /**
     * Load the user from the database
     * @param userName
     * @return the user detail if user exists
     * @throws UsernameNotFoundException
     */
    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
        AppUser appUser = this.appUserDAO.findUserAccount(userName);

        if (appUser == null) {
            System.out.println("AppUser not found! " + userName);
            throw new UsernameNotFoundException("AppUser " + userName + " was not found in the database");
        }

        System.out.println("Found AppUser: " + appUser);

        // [ROLE_USER, ROLE_ADMIN,..]
        List<String> roleNames = this.roleDao.getRoleNames(appUser.getUserId());

        List<GrantedAuthority> grantList = new ArrayList<>();
        if (roleNames != null) {
            for (String role : roleNames) {
                // ROLE_USER, ROLE_ADMIN,..
                GrantedAuthority authority = new SimpleGrantedAuthority(role);
                grantList.add(authority);
            }
        }

        UserDetails userDetails = new User(appUser.getUsername(), //
                appUser.getPassword(), grantList);

        return userDetails;
    }
}
