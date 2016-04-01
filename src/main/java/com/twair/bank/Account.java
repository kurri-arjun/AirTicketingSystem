package com.twair.bank;

/**
 * Created by sangeeth on 01-04-2016.
 */
public class Account
{
    private Double  balance;
    private String accId = null;
    public Account(String accId, Double balAmt) {
        this.accId = accId;
        this.balance = balAmt;
    }

    public void withDrawAmount(double amt) throws Exception {
        validateAmount(amt);
        if(amt > this.balance)
        {
            throw new Exception("Insufficient funds in account");
        }
        this.balance -= amt;
    }

    public double getBalance() {
        return balance;
    }

    public void deposit(double amt) throws IllegalArgumentException {
        validateAmount(amt);
        this.balance += amt;
    }

    private void validateAmount(Double amt) throws IllegalArgumentException
    {
        if(amt <= 0)
        {
            throw new IllegalArgumentException("Invliad amount specified. Please correct.");
        }
    }
}