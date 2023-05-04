package com.solvd.laba.classes;

import com.solvd.laba.exceptions.AgeException;

public class Plumber extends Employee {

    public Plumber() {
    }

    public Plumber(String personName, int personAge, int salary) throws AgeException {
        super(personName, personAge, salary);
        if (personAge < 0 || personAge > 65) {
            throw new AgeException("Age is not correct! ");
        }
    }

    private boolean highEducation;

    public boolean isHighEducation() {
        return highEducation;
    }

}
