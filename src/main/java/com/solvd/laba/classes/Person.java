package com.solvd.laba.classes;

import com.solvd.laba.exceptions.AgeException;
import com.solvd.laba.exceptions.PrintNullException;
import com.solvd.laba.interfaces.IPrintablle;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Objects;

public abstract class Person implements IPrintablle {

    private static final Logger LOGGER = LogManager.getLogger(Person.class);

    protected String personName;
    protected int personAge;

    public Person(String personName, int personAge){
        this.personName = personName;
        this.personAge = personAge;
    }

    public Person() {
    }

    public String getPersonName() {
        return personName;
    }

    public void setPersonName(String personName) {
        this.personName = personName;
    }

    public int getPersonAge() {
        return personAge;
    }

    public void setPersonAge(int personAge)  {
        if (personAge <= 0 || personAge > 65) {
            try {
                throw new AgeException("Age is not correct!!! ");
            } catch (AgeException e) {
                LOGGER.error(e.getMessage());
            }
        }
        this.personAge = personAge;
    }

    @Override
    public String toString() {
        return "Person{" +
                "personName='" + personName + '\'' +
                ", personAge=" + personAge +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return personAge == person.personAge && Objects.equals(personName, person.personName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(personName, personAge);
    }

    @Override
    public void printPersonalInfo(String s) throws PrintNullException {
        if (s == null) {
            throw new PrintNullException("Info is null !");
        }
    }
}
