package app.ledger.demo.dao;

import app.ledger.demo.model.AppIncome;

import java.util.List;

public interface AppIncomeDao {
    //List<AppIncome> findAllIncome(String incomeId);

    AppIncome findIncome(String incomeId);

    void insertIncome(AppIncome income);

    void removeIncome(AppIncome income);

    void updateIncome(AppIncome income);
}
