package app.ledger.demo.dao;

import app.ledger.demo.model.AppExpense;

import java.util.List;

public interface AppExpenseDao {
    //List<AppIncome> findAllExpense(String expenseId);

    AppExpense findExpense(String expenseId);

    void insertExpense(AppExpense expense);

    void removeExpense(AppExpense expense);

    void updateExpense(AppExpense expense);
}
