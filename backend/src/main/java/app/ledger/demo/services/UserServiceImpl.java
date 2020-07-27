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
    public boolean  addTransaction(double debit, double credit) {
        //take the total credit balance from the adding transaction
        //take the credit from from querying the data from the table
        return true;
    }
}
