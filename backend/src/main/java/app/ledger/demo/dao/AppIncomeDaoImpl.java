package app.ledger.demo.dao;

import app.ledger.demo.mapper.IncomeMapper;
import app.ledger.demo.model.AppIncome;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.PostConstruct;
import javax.sql.DataSource;

@Repository
@Transactional
public class AppIncomeDaoImpl extends JdbcDaoSupport implements AppIncomeDao{
    private final IncomeMapper mapper = new IncomeMapper();
    @Autowired
    public DataSource dataSource;

    @PostConstruct
    public void init(){
        setDataSource(dataSource);
    }

//    /**
//     * Find all user's task
//     * @param incomeId
//     * @return all tasks
//     */
//    @Override
//    public List<AppIncome> findAllUserTasks(String incomeId) {
//        String sql = IncomeMapper.BASE_SQL + " where u.incomeId = ? ";
//
//        Object[] params = new Object[] { incomeId };
//        try {
//            List<AppIncome> incomes = getJdbcTemplate().query(sql, params, mapper);
//            return incomes;
//        } catch (EmptyResultDataAccessException e) {
//            return null;
//        }
//    }
    /**
     * Find task
     * @param incomeId
     * @return income
     */
    @Override
    public AppIncome findIncome(String incomeId) {
        String sql = IncomeMapper.BASE_SQL + " where u.incomeId = ? ";

        Object[] params = new Object[] { incomeId };
        try {
            AppIncome income = getJdbcTemplate().queryForObject(sql, params, mapper);
            return income;
        } catch (EmptyResultDataAccessException e) {
            return null;
        }
    }
    @Override
    public void insertIncome(AppIncome income){
        String sqlForInsert1 = "insert into APP_INCOME(incomeID, userId, salary, awards, grants, sales, rental, refunds, coupons, lottery, dividens, investments, others)\n" +
                "    value (?,?,?,?,?,?,?,?,?,?,?,?,?);";
        try{
            Object[] params = new Object[]{ income.getIncomeId(),income.getUserId(),
                    income.getSalary(), income.getAwards(), income.getGrants(), income.getSales(), income.getRental(), income.getRefunds(), income.getCoupons(), income.getLottery(), income.getDividends(), income.getInvestments(), income.getOthers()};
            getJdbcTemplate().update(sqlForInsert1, params);
        }catch(EmptyResultDataAccessException e){
            System.out.println("Null!");
        }
    }
    @Override
    public void removeIncome(AppIncome income){
        String sqlForInsert1 = "delete from APP_INCOME where incomeId = ?";
        try{
            Object[] params = new Object[]{ income.getIncomeId() };
            getJdbcTemplate().update(sqlForInsert1, params);
        }catch(EmptyResultDataAccessException e){
            System.out.println("Null!");
        }
    }
    @Override
    public void updateIncome(AppIncome income){
        String sqlForUpdate = " update APP_INCOME " +
                "set incomeId = ?, userId = ?, salary = ?, awards = ?, grants = ?, sales = ?, rental = ?, refunds = ?, coupons = ?, lottery = ?, dividens = ?, investments = ?, others = ? " +
                "where incomeId = ?";
        try{
            Object[] params = new Object[] {income.getIncomeId(),income.getUserId(),
                    income.getSalary(), income.getAwards(), income.getGrants(), income.getSales(), income.getRental(), income.getRefunds(), income.getCoupons(), income.getLottery(), income.getDividends(), income.getInvestments(), income.getOthers()};
            getJdbcTemplate().update(sqlForUpdate, params);
//          getJdbcTemplate().update(sqlForRemove1, params);
        }catch(EmptyResultDataAccessException e){
            System.out.println("Null!");
        }
    }
}
