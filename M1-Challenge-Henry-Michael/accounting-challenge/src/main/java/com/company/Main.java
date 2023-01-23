package com.company;

import java.util.*;


public class Main {

    private static List<String[]> customerData = Arrays.asList(
            new String[] {"1","Wayne Enterprises","10000","12-01-2021"},
            new String[] {"2","Daily Planet","-7500","01-10-2022"},
            new String[] {"1","Wayne Enterprises","18000","12-22-2021"},
            new String[] {"3","Ace Chemical","-48000","01-10-2022"},
            new String[] {"3","Ace Chemical","-95000","12-15-2021"},
            new String[] {"1","Wayne Enterprises","175000","01-01-2022"},
            new String[] {"1","Wayne Enterprises","-35000","12-09-2021"},
            new String[] {"1","Wayne Enterprises","-64000","01-17-2022"},
            new String[] {"3","Ace Chemical","70000","12-29-2022"},
            new String[] {"2","Daily Planet","56000","12-13-2022"},
            new String[] {"2","Daily Planet","-33000","01-07-2022"},
            new String[] {"1","Wayne Enterprises","10000","12-01-2021"},
            new String[] {"2","Daily Planet","33000","01-17-2022"},
            new String[] {"3","Ace Chemical","140000","01-25-2022"},
            new String[] {"2","Daily Planet","5000","12-12-2022"},
            new String[] {"3","Ace Chemical","-82000","01-03-2022"},
            new String[] {"1","Wayne Enterprises","10000","12-01-2021"}
    );

    public static void main(String[] args) {
        //Update this

        // Initialize a map of Customer objects to hold customer objects
        HashMap<Integer, Customer> customerObjects = new HashMap<Integer, Customer>();
        List<Customer> listOfCustomers = new ArrayList<Customer>();

        // Read in the data to construct the customer objects
        for (int i = 0; i < customerData.size(); i++) {
            int curId = Integer.parseInt(customerData.get(i)[0]);
            if (!customerObjects.containsKey(curId)) {
                // initialize object
                Customer curCustomer = new Customer();
                curCustomer.setId(curId);
                String name = customerData.get(i)[1];
                curCustomer.setName(name);

                // add object to customerObjects
                customerObjects.put(curId, curCustomer);
                listOfCustomers.add(curCustomer);
            }
            // get current customer
            Customer currentCustomer = (Customer) customerObjects.get(curId);

            // update customer charges
            AccountRecord newAR = new AccountRecord();
            int curCharge = Integer.parseInt(customerData.get(i)[2]);
            String curDate = customerData.get(i)[3];
            newAR.setCharge(curCharge);
            newAR.setChargeDate(curDate);
            currentCustomer.curSum(curCharge);
            currentCustomer.getCharges().add(newAR);
        }

        System.out.println("Positive accounts:");
        for (Customer cust : listOfCustomers) {
            if (cust.getBalance() > 0) System.out.print(" " + cust.getName());
        }
        System.out.println();
        System.out.println("Negative accounts:");
        for (Customer cust : listOfCustomers) {
            if (cust.getBalance() < 0) System.out.print(" " + cust.getName());
        }

    }
}
