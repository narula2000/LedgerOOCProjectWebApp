package app.ledger.demo.Services;

import java.util.List;

public interface UserService {
    double sum(List<Double> income, List<Double> expense);
    boolean addTransaction(String category, double amount);
    boolean editCategory(String transactionID, String initialCategory, String finalCategory, double amount);
    boolean editAmount(String transactionID, double finalAmount); //transactionIDs are either expense or income ids
    boolean removeTransactions(String transactionID);
}
