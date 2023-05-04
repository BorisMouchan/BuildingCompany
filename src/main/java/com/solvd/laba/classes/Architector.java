package com.solvd.laba.classes;

import com.solvd.laba.exceptions.AgeException;

import java.util.Objects;

public class Architector extends Employee {

    private int projectDone;

    public Architector() {
    }

    public Architector(String personName, int personAge, int projectDone) throws AgeException {
        super(personName, personAge);
        if (personAge < 0 || personAge > 65) {
            throw new AgeException("Age is not correct! ");
        }
        this.projectDone = projectDone;
    }

    public Architector(String personName, int personAge) throws AgeException {
        super(personName, personAge);
    }

    public int getProjectDone() {
        return projectDone;
    }

    public void setProjectDone(int projectDone) {
        this.projectDone = projectDone;
    }

    @Override
    public String toString() {
        return "Name: " + getPersonName() + "\n" +
                "Age: " + getPersonAge() + "\n" +
                "ProjectDone: " + projectDone + "\n" +
                "Salary: " + salary;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Architector that = (Architector) o;
        return personAge == that.personAge && salary == that.salary && projectDone == that.projectDone && Objects.equals(personName, that.personName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), personName, personAge, salary, projectDone);
    }
}
