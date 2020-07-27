<<<<<<< HEAD
package app.ledger.demo.Services;

import java.util.List;

public interface UserService {
    double sum(List<Double> income, List<Double> expense);
    boolean addTransaction(String category, double amount);
    boolean editCategory(String transactionID, String initialCategory, String finalCategory, double amount);
    boolean editAmount(String transactionID, double finalAmount); //transactionIDs are either expense or income ids
    boolean removeTransactions(String transactionID);
=======
package app.ledger.demo.services;



import app.ledger.demo.model.AppTask;

import java.text.ParseException;
import java.util.List;

public interface UserService {

    Boolean addTask(AppTask task, String username);
    Boolean removeTask(AppTask task);
    Boolean updateTask(AppTask task, long tid);

    void taskDateSetter(AppTask task) throws ParseException;

    List<AppTask> getAllTasks(String username);
>>>>>>> work
}
