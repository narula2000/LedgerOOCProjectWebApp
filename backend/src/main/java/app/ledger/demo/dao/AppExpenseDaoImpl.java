package app.ledger.demo.dao;

import app.ledger.demo.mapper.ExpenseMapper;
import app.ledger.demo.model.AppExpense;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.PostConstruct;
import javax.sql.DataSource;
@Repository
@Transactional
public class AppExpenseDaoImpl extends JdbcDaoSupport implements AppExpenseDao {
        private final ExpenseMapper mapper = new ExpenseMapper();
        @Autowired
        public DataSource dataSource;

        @PostConstruct
        public void init(){
            setDataSource(dataSource);
        }
        /**
         * Find task
         * @param expenseId
         * @return expense
         */
        @Override
        public AppExpense findExpense(String expenseId) {
            String sql = ExpenseMapper.BASE_SQL + " where u.expenseId = ? ";

            Object[] params = new Object[] { expenseId };
            try {
                AppExpense expense = getJdbcTemplate().queryForObject(sql, params, mapper);
                return expense;
            } catch (EmptyResultDataAccessException e) {
                return null;
            }
        }
    @Override
    public void insertExpense(AppExpense expense){
        String sqlForInsert1 = "insert into APP_EXPENSE(expenseId, userId, foods, transportation, car, entertainment, insurance, tax, telephone, health, education, travel, others)\n" +
                "    value (?,?,?,?,?,?,?,?,?,?,?,?,?);";
        try{
            Object[] params = new Object[]{ expense.getExpenseId(),expense.getUserId(),
                    expense.getFoods(), expense.getTransportation(), expense.getCar(), expense.getEntertainment(), expense.getInsurance(), expense.getTax(), expense.getTelephone(), expense.getHealth(), expense.getEducation(), expense.getTravel(), expense.getOthers()};
            getJdbcTemplate().update(sqlForInsert1, params);
        }catch(EmptyResultDataAccessException e){
            System.out.println("Null!");
        }
    }
    @Override
    public void removeExpense(AppExpense expense){
        String sqlForInsert1 = "delete from APP_EXPENSE where expenseId = ?";
        try{
            Object[] params = new Object[]{ expense.getExpenseId() };
            getJdbcTemplate().update(sqlForInsert1, params);
        }catch(EmptyResultDataAccessException e){
            System.out.println("Null!");
        }
    }
    @Override
    public void updateExpense(AppExpense expense){
        String sqlForUpdate = " update APP_EXPENSE " +
                "set expenseId = ?, userId = ?, foods = ?, transportation = ?, car = ?, entertainment = ?, insurance = ?, tax = ?, telephone = ?, health = ?, education = ?, travel = ?, others = ? " +
                "where expenseId = ?";
        try{
            Object[] params = new Object[] {expense.getExpenseId(),expense.getUserId(),
                    expense.getFoods(), expense.getTransportation(), expense.getCar(), expense.getEntertainment(), expense.getInsurance(), expense.getTax(), expense.getTelephone(), expense.getHealth(), expense.getEducation(), expense.getTravel(), expense.getOthers()};
            getJdbcTemplate().update(sqlForUpdate, params);
//          getJdbcTemplate().update(sqlForRemove1, params);
        }catch(EmptyResultDataAccessException e){
            System.out.println("Null!");
        }
    }
}
