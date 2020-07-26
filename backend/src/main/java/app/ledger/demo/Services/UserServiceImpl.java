package app.ledger.demo.Services;

import java.util.List;

public class UserServiceImpl implements UserService {
    @Override
    public double sum(List<Double> incomes, List<Double> expenses) {
        double sum = 0;
        for (double income : incomes){
            sum += income;
        }
        for (double expense : expenses){
            sum -= expense;
        }
        return sum;
    }
}
