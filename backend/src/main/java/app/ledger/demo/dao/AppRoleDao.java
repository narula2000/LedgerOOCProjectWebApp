package app.ledger.demo.dao;

import java.util.List;

public interface AppRoleDao {
    List<String> getRoleNames(String userId);
}
