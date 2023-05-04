package com.solvd.laba.interfaces;

import com.solvd.laba.exceptions.TransactionException;

public interface IPayments {
    void makePayments() throws TransactionException;
}

