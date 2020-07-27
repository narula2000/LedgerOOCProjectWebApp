package app.ledger.demo.Entities;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

public class Expense {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private String expenseId;
    private String userId;
    private double foods;
    private double transportation;
    private double car;
    private double entertainment;
    private double insurance;
    private double tax;
    private double telephone;
    private double health;
    private double education;
    private double travel;
    private double others;

    public void setExpenseId(String expenseId) {
        this.expenseId = expenseId;
    }

    public String getExpenseId() {
        return expenseId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUserId() {
        return userId;
    }

    public void setFoods(double foods) {
        this.foods = foods;
    }

    public double getFoods() {
        return foods;
    }

    public void setTransportation(double transportation) {
        this.transportation = transportation;
    }

    public double getTransportation() {
        return transportation;
    }

    public void setCar(double car) {
        this.car = car;
    }

    public double getCar() {
        return car;
    }

    public void setEntertainment(double entertainment) {
        this.entertainment = entertainment;
    }

    public double getEntertainment() {
        return entertainment;
    }

    public void setInsurance(double insurance) {
        this.insurance = insurance;
    }

    public double getInsurance() {
        return insurance;
    }

    public void setTax(double tax) {
        this.tax = tax;
    }

    public double getTax() {
        return tax;
    }

    public void setTelephone(double telephone) {
        this.telephone = telephone;
    }

    public double getTelephone() {
        return telephone;
    }

    public void setHealth(double health) {
        this.health = health;
    }

    public double getHealth() {
        return health;
    }

    public void setEducation(double education) {
        this.education = education;
    }

    public double getEducation() {
        return education;
    }

    public void setTravel(double travel) {
        this.travel = travel;
    }

    public double getTravel() {
        return travel;
    }

    public void setOthers(double others) {
        this.others = others;
    }

    public double getOthers() {
        return others;
    }
}

