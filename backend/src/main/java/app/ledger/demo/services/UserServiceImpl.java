package app.ledger.demo.services;

import app.ledger.demo.dao.AppExpenseDao;
import app.ledger.demo.dao.AppIncomeDao;
import app.ledger.demo.dao.AppUserDao;
import app.ledger.demo.model.AppExpense;
import app.ledger.demo.model.AppIncome;
import app.ledger.demo.model.AppUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private AppIncomeDao incomeDao;

    @Autowired
    private AppExpenseDao expenseDao;

    @Autowired
    private AppUserDao userDao;

//    private final SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
//    private java.util.Date utilDateStart, utilDateEnd;

    /**
     * Add user's task
     * @param income
     * @param incomeId
     * @return true if adding task successfully, otherwise false
     */
    @Override
    public Boolean addIncome(AppIncome income, String incomeId) {
        Boolean success = false;
        AppUser user = this.userDao.findUserAccount(incomeId);
        income.setUserId(user.getUserId());
        try {
            //taskDateSetter(task);

            // End date need to be before start date
//            if (utilDateEnd.after(utilDateStart)) {
//                success = true;
//            }
            if (income != null){
                success = true;
            }

        } catch (NullPointerException e) {
            e.printStackTrace();
        } finally {
            if (success) this.incomeDao.insertIncome(income);
        }

        return success;
    }

    /**
     * Remove user's task
     *
     * @param income
     * @return true if task is removed successfully, otherwise false
     */
    @Override
    public Boolean removeIncome(AppIncome income) {
        if (this.incomeDao.findIncome(income.getIncomeId()) != null) incomeDao.removeIncome(income);
        else return false;
        return true;
    }

    /*
    ? Must observe how user will edit the task
     */
    @Override
    public Boolean updateIncome(AppIncome income, String incomeId) {
        Boolean success = false;
        AppIncome old = this.incomeDao.findIncome(incomeId);
        if (old == null) return false;
        try {
            //taskDateSetter(income);
            //old.setDateStart(task.getDateStart());
            //old.setDateEnd(task.getDateEnd());
            //old.setDescription(task.getDescription());
            //old.setTitle(task.getTitle());
            // End date need to be before start date
//            if (utilDateEnd.after(utilDateStart)) {
//                success = true;
//            }
            if (income != null){
                success = true;
            }

        } catch (NullPointerException e) {
            e.printStackTrace();
        } finally {
            if (success) this.incomeDao.updateIncome(old);
        }
        return success;
    }
    /**
     * Add user's task
     * @param expense
     * @param expenseId
     * @return true if adding task successfully, otherwise false
     */
    @Override
    public Boolean addExpense(AppExpense expense, String expenseId) {
        Boolean success = false;
        AppUser user = this.userDao.findUserAccount(expenseId);
        expense.setUserId(user.getUserId());
        try {
            //taskDateSetter(task);

            // End date need to be before start date
//            if (utilDateEnd.after(utilDateStart)) {
//                success = true;
//            }
            success = true;

        } catch (NullPointerException e) {
            e.printStackTrace();
        } finally {
            if (success) this.expenseDao.insertExpense(expense);
        }

        return success;
    }

    /**
     * Remove user's task
     *
     * @param expense
     * @return true if task is removed successfully, otherwise false
     */
    @Override
    public Boolean removeExpense(AppExpense expense) {
        if (this.expenseDao.findExpense(expense.getExpenseId()) != null) expenseDao.removeExpense(expense);
        else return false;
        return true;
    }

    /*
    ? Must observe how user will edit the task
     */
    @Override
    public Boolean updateExpense(AppExpense expense, String expenseId) {
        Boolean success = false;
        AppExpense old = this.expenseDao.findExpense(expenseId);
        if (old == null) return false;
        try {
            //taskDateSetter(income);
            //old.setDateStart(task.getDateStart());
            //old.setDateEnd(task.getDateEnd());
            //old.setDescription(task.getDescription());
            //old.setTitle(task.getTitle());
            // End date need to be before start date
//            if (utilDateEnd.after(utilDateStart)) {
//                success = true;
//            }
            if (expense != null){
                success = true;
            }

        } catch (NullPointerException e) {
            e.printStackTrace();
        } finally {
            if (success) this.expenseDao.updateExpense(old);
        }
        return success;
    }

//    @Override
//    public Boolean sum(AppExpense expense, AppIncome income){
//        Boolean success = false;
//        try {
//            //taskDateSetter(income);
//            //old.setDateStart(task.getDateStart());
//            //old.setDateEnd(task.getDateEnd());
//            //old.setDescription(task.getDescription());
//            //old.setTitle(task.getTitle());
//            // End date need to be before start date
////            if (utilDateEnd.after(utilDateStart)) {
////                success = true;
////            }
//            if (expense != null && income != null){
//                success = true;
//            }
//
//        } catch (NullPointerException e) {
//            e.printStackTrace();
//        } finally {
//            if (success) this..updateExpense(old);
//        }
//        return success;
//    }
//
//    @Override
//    public void taskDateSetter(AppTask task) throws ParseException {
//        utilDateStart = format.parse(task.getInputDateStart());
//        task.setDateStart(new Date(utilDateStart.getTime()));
//        utilDateEnd = format.parse(task.getInputDateEnd());
//        task.setDateEnd(new Date(utilDateEnd.getTime()));
//    }

//    /**
//     * Get all user's tasks
//     *
//     * @param username
//     * @return All user's tasks
//     */
//    @Override
//    public List<AppTask> getAllTasks(String username) {
//        AppUser user = this.userDao.findUserAccount(username);
//        return this.taskDao.findAllUserTasks(user.getId());
//    }
}

