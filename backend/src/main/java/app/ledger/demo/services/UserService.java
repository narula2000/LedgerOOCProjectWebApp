package app.ledger.demo.Services;

import java.util.List;

public interface UserService {
    double sum(List<Double> income, List<Double> expense);
    boolean addTransaction(double debit, double credit);
}
