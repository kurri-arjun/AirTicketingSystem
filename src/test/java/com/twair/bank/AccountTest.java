package com.twair.bank;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * Created by sangeeth on 01-04-2016.
 */
public class AccountTest {
    private Account acc = null;
    @Before
    public void setUp()
    {
        String accId = "test123";
        Double amt = 15000.0;
        acc = new Account(accId, amt);
    }

    @Test
    public void testWithDrawShouldDeductAmountFromAccBalance() throws Exception
    {
        acc.withDrawAmount(10000.0);
        Assert.assertEquals(5000.0, acc.getBalance(), 0);
    }

    @Test(expected = Exception.class)
    public void testWithDrawMoreAmountThanAccBalance() throws Exception
    {
        acc.withDrawAmount(16000.0);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testInvalidAmountPassedForDeduction() throws Exception {
        acc.withDrawAmount(-1000.0);
    }

    @Test
    public void testDeposit()
    {
        acc.deposit(10000.0);
        Assert.assertEquals(25000.0, acc.getBalance(), 0.0);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testDepositInvalidAmountThrowException()
    {
        acc.deposit(-1000.0);
    }
}
