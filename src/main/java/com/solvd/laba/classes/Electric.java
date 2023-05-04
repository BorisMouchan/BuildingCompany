package com.solvd.laba.classes;

import com.solvd.laba.exceptions.AgeException;

import java.util.Objects;

public class Electric extends Employee {

    private boolean insurance;
    private int worksYearExperience;

    public Electric() {
    }

    public Electric(String personName, int personAge, int salary, boolean insurance, int worksYearExperience) throws AgeException {
        super(personName, personAge, salary);
        this.insurance = insurance;
        this.worksYearExperience = worksYearExperience;
    }

    public boolean isInsurance() {
        return insurance;
    }

    public void setInsurance(boolean insurance) {
        this.insurance = insurance;
    }

    public int getWorksYearExperience() {
        return worksYearExperience;
    }

    public void setWorksYearExperience(int worksYearExperience) {
        this.worksYearExperience = worksYearExperience;
    }


    @Override
    public String toString() {
        return "Electric{" +
                "insurance=" + insurance +
                ", worksYearExperience=" + worksYearExperience +
                ", salary=" + salary +
                ", personName='" + personName + '\'' +
                ", personAge=" + personAge +
                "} " + super.toString();
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), insurance, worksYearExperience);
    }

    @Override
    public void printPersonalInfo(String s) {
        System.out.println("My electric info: " + getPersonName() + " " + getPersonAge() + " Expirience: " + getWorksYearExperience());
    }
}
