package app.ledger.demo.services;



import app.ledger.demo.model.AppExpense;
import app.ledger.demo.model.AppIncome;

import java.text.ParseException;
import java.util.List;

public interface UserService {

    Boolean addIncome(AppIncome income, String incomeId);
    Boolean removeIncome(AppIncome income);
    Boolean updateIncome(AppIncome income, String incomeId);
    Boolean addExpense(AppExpense expense, String expenseId);
    Boolean removeExpense(AppExpense expense);
    Boolean updateExpense(AppExpense expense, String expenseId);

    //void taskDateSetter(AppTask task) throws ParseException;

    //List<AppTask> getAllTasks(String username);
}
