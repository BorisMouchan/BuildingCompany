package com.solvd.laba.classes;

import com.solvd.laba.exceptions.AgeException;

import java.util.Objects;

public class Electric extends Employee {

    private boolean insurance;
    private int worksYearExperience;

    public Electric() {
    }

    public Electric(String personName, int personAge, int salary, int worksYearExperience) {
        super(personName, personAge, salary);
        this.worksYearExperience = worksYearExperience;
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
                ", worksYearExperience=" + worksYearExperience +
                ", salary=" + salary +
                ", personName='" + personName + '\'' +
                ", personAge=" + personAge +
                "} " + super.toString();
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), worksYearExperience);
    }

    @Override
    public void printPersonalInfo(String s) {
        System.out.println("My electric info: " + getPersonName() + " " + getPersonAge() + " Expirience: " + getWorksYearExperience());
    }
}
