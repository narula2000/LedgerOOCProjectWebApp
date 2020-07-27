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
}
