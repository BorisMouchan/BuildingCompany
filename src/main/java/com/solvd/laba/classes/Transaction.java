package com.solvd.laba.classes;

import com.solvd.laba.exceptions.TransactionException;
import com.solvd.laba.interfaces.IPayments;
import com.solvd.laba.enums.CurrencyType;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public final class Transaction extends BankDetails implements IPayments {

    private static final Logger LOGGER = LogManager.getLogger(Transaction.class);

    public Transaction(String billNumber, String city, String postAdress, String bankName, CurrencyType currencyType, String description, int amount) {
        super(billNumber, city, postAdress, bankName, currencyType);
        this.description = description;
        this.amount = amount;
    }

    private String description;
    private int amount;

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    HashSet<Transaction> allTransactionsClass = new HashSet<>();


    public Transaction() {
    }

    @Override
    public String toString() {
        return "Transaction{" +
                "currencyType=" + currencyType +
                ", description='" + description + '\'' +
                ", amount=" + amount +
                '}';
    }

    public final String getTotalTransactions() {
        return "Total Transactions list: " + toString();
    }


    @Override
    public void makePayments() throws TransactionException {
        if (amount < 0) {
            throw new TransactionException("The amount of transaction is incorrect!");
        }
    }

    public HashSet<Transaction> addTransaction(Transaction transaction) {
        allTransactionsClass.add(transaction);
        return allTransactionsClass;
    }

}
