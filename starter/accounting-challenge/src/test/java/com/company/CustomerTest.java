package com.company;
import org.junit.Test;
import java.util.List;
import java.util.ArrayList;
import static org.junit.Assert.assertEquals;

public class CustomerTest {

    @Test
    public void shouldCalculateBalance() {
        Customer customer = new Customer();
        List<AccountRecord> accounts = new ArrayList<AccountRecord>();
        customer.setName("Cam");
        customer.setId(1);
        customer.setCharges(accounts);

        for (int i = 0; i < 8; i++) {
            AccountRecord accountRecord = new AccountRecord();
            accountRecord.setChargeDate("12-01-2021");
            accountRecord.setCharge(10000);
            customer.curSum(10000);
            accounts.add(accountRecord);
        }
        customer.setCharges(accounts);
        assertEquals(80000, customer.getBalance());
    }

    @Test
    public void testToString() {
        Customer customer = new Customer();
        List<AccountRecord> accounts = new ArrayList<AccountRecord>();
        customer.setName("Cam");
        customer.setId(1);
        customer.setCharges(accounts);

        for (int i = 0; i < 8; i++) {
            AccountRecord accountRecord = new AccountRecord();
            accountRecord.setChargeDate("12-01-2021");
            accountRecord.setCharge(10000);
            customer.curSum(10000);
            accounts.add(accountRecord);
        }
        customer.setCharges(accounts);
        assertEquals("id: 1 name: Cam balance: 80000", customer.toString());

    }
}