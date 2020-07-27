package app.ledger.demo.Services;

import java.util.List;

public class UserServiceImpl implements app.ledger.demo.Services.UserService {
    @Override
    public double sum(List<Double> incomes, List<Double> expenses) {
        double sum = 0;
        for (double income : incomes) {
            sum += income;
        }
        for (double expense : expenses) {
            sum -= expense;
        }
        return sum;
    }

    @Override
    public boolean  addTransaction(String debit, double credit) {
        //take the total credit balance from the adding transaction
        //take the credit from from querying the data from the table
        return true;
    }

    @Override
    public boolean editCategory(String initialCategory, String finalCategory, double amount) {
        return false;
    }

    @Override
    public boolean removeTransactions(String transactionID) {
        return false;
    }
}
