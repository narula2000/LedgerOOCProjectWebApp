package app.ledger.demo.mapper;

import app.ledger.demo.model.AppExpense;
import app.ledger.demo.model.AppIncome;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ExpenseMapper implements RowMapper<AppExpense> {
    public static final String BASE_SQL
            = "SELECT * From APP_EXPENSE u ";
    /**
     * Mapping string into object
     * @param rs
     * @param rowNum
     * @return
     * @throws SQLException
     */
    @Override
    public AppExpense mapRow(ResultSet rs, int rowNum) throws SQLException {
        AppExpense appExpense = new AppExpense();
        appExpense.setExpenseId(rs.getString("expenseId"));
        appExpense.setUserId(rs.getString("userId"));
        appExpense.setFoods(rs.getDouble("foods"));
        appExpense.setTransportation(rs.getDouble("transportation"));
        appExpense.setCar(rs.getDouble("car"));
        appExpense.setEntertainment(rs.getDouble("entertainment"));
        appExpense.setInsurance(rs.getDouble("insurance"));
        appExpense.setTax(rs.getDouble("tax"));
        appExpense.setTelephone(rs.getDouble("telephone"));
        appExpense.setHealth(rs.getDouble("health"));
        appExpense.setEducation(rs.getDouble("education"));
        appExpense.setTravel(rs.getDouble("travel"));
        appExpense.setOthers(rs.getDouble("others"));
        return appExpense;
    }
}
