package app.ledger.demo.Services;

import java.util.List;

public interface UserService {
    double sum(List<Double> income, List<Double> expense);
    boolean addTransaction(String category, double amount);
    boolean editCategory(String initialCategory, String finalCategory, double amount);
    boolean removeTransactions(String transactionID);
}
