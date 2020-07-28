package app.ledger.demo.mapper;

import app.ledger.demo.model.AppIncome;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class IncomeMapper implements RowMapper<AppIncome> {
    public static final String BASE_SQL
            = "SELECT * From APP_INCOME u ";
    /**
     * Mapping string into object
     * @param rs
     * @param rowNum
     * @return
     * @throws SQLException
     */
    @Override
    public AppIncome mapRow(ResultSet rs, int rowNum) throws SQLException {
        AppIncome appIncome = new AppIncome();
        appIncome.setUserId(rs.getString("userId"));
        appIncome.setIncomeId(rs.getString("incomeId"));
        appIncome.setSalary(rs.getDouble("salary"));
        appIncome.setAwards(rs.getDouble("awards"));
        appIncome.setGrants(rs.getDouble("grants"));
        appIncome.setSales(rs.getDouble("sales"));
        appIncome.setRental(rs.getDouble("rental"));
        appIncome.setRefunds(rs.getDouble("refunds"));
        appIncome.setCoupons(rs.getDouble("coupons"));
        appIncome.setLottery(rs.getDouble("lottery"));
        appIncome.setDividends(rs.getDouble("dividends"));
        appIncome.setInvestments(rs.getDouble("investment"));
        appIncome.setOthers(rs.getDouble("others"));
        return appIncome;
    }
}
