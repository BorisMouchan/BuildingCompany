package com.solvd.laba.classes;

import com.solvd.laba.exceptions.AgeException;
import com.solvd.laba.exceptions.PrintNullException;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Client extends Person {

    List<Client> allClients = new ArrayList<>();

    private String surname;
    private String companyName;
    private int telephoneNumber;

    public Client() {
    }

    public Client(String personName, int personAge, int id, String personSurname, String companyName, int telephoneNumber) throws AgeException {
        super(personName, personAge);
        this.surname = personSurname;
        this.companyName = companyName;
        this.telephoneNumber = telephoneNumber;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public int getTelephoneNumber() {
        return telephoneNumber;
    }

    public void setTelephoneNumber(int telephoneNumber) {
        this.telephoneNumber = telephoneNumber;
    }

    @Override
    public String toString() {
        return "personSurname " + surname + "\n" +
                "companyName " + companyName + "\n" +
                "telephoneNumber " + telephoneNumber + "\n"
                + "name " + getPersonName() + "\n" + "age " + getPersonAge() + "\n";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Client client = (Client) o;
        return telephoneNumber == client.telephoneNumber && Objects.equals(surname, client.surname) && Objects.equals(companyName, client.companyName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), surname, companyName, telephoneNumber);
    }

    @Override
    public void printPersonalInfo(String s) {
        System.out.println("Were is my project?");
    }

    @Override
    public void printPersonalInfo() throws PrintNullException {
    }

    public List<Client> addClient(Client client) {
        allClients.add(client);
        return allClients;
    }
}

