package app.ledger.demo.model;

public class AppIncome {
    private String incomeId;
    private String userId;
    private double salary;
    private double awards;
    private double grants;
    private double sales;
    private double rental;
    private double refunds;
    private double coupons;
    private double lottery;
    private double dividends;
    private double investments;
    private double others;
    public void setIncomeId(String incomeId){
        this.incomeId = incomeId;
    }
    public String getIncomeId(){
        return incomeId;
    }
    public void setUserId(String userId){
        this.userId = userId;
    }
    public String getUserId(){
        return userId;
    }
    public void setSalary(double salary){
        this.salary = salary;
    }
    public double getSalary(){
        return salary;
    }
    public void setAwards(double awards){
        this.awards = awards;
    }
    public double getAwards(){
        return awards;
    }
    public void setGrants(double grants){
        this.grants = grants;
    }
    public double getGrants(){
        return grants;
    }
    public void setSales(double sales){
        this.sales = sales;
    }
    public double getSales(){
        return sales;
    }
    public void setRental(double rental){
        this.rental = rental;
    }
    public double getRental(){
        return rental;
    }
    public void setRefunds(double refunds){
        this.refunds = refunds;
    }
    public double getRefunds(){
        return this.refunds;
    }
    public void setCoupons(double coupons){
        this.coupons = coupons;
    }
    public double getCoupons(){
        return this.coupons;
    }
    public void setLottery(double lottery){
        this.lottery = lottery;
    }
    public double getLottery(){
        return lottery;
    }
    public void setDividends(double dividends){
        this.dividends = dividends;
    }
    public double getDividends(){
        return dividends;
    }
    public void setInvestments(double investments) {
        this.investments = investments;
    }
    public double getInvestments() {
        return investments;
    }
    public void setOthers(double others) {
        this.others = others;
    }
    public double getOthers() {
        return others;
    }
}
