package com.solvd.laba.classes;

import com.solvd.laba.interfaces.IPayments;

public class PaymentsDepartment extends Department implements IPayments {

    private int dayOfSalary = 15;
    private static final int daysInYear = 365;

    public PaymentsDepartment() {
    }

    public PaymentsDepartment(String structureName, int employersNumber, int dayOfSalary, int monthSalary) {
        super(structureName);
        this.dayOfSalary = dayOfSalary;
    }

    public int getDayOfSalary() {
        return dayOfSalary;
    }

    public void setDayOfSalary(int dayOfSalary) {
        this.dayOfSalary = dayOfSalary;
    }

    @Override
    public void makePayments() {
//        if (dayOfSalary == LocalDate.EPOCH.getDayOfMonth()) {
//            System.out.println("Payments done! ");
//        } else {
//            System.out.println("Its not salary day :( ");
//        }


    }

    @Override
    protected void getResultsOfMonth() {
        System.out.println("Total month salary ");
    }
}
