package com.company;

public class Main {

    public static void main(String[] args) {
	// write your code here
        Bank bank = new Bank("Bank Of India");
        bank.addBranch("Sadar");
        bank.addCustomer("Sadar","Yasir",2800.00);
        bank.addCustomer("Sadar","Aman",1500.00);
        bank.addCustomer("Sadar","Ashish",1300.00);

        bank.addCustomerTranscation("Sadar","Yasir",1300.00);
        bank.listCustomer("Sadar",true);
    }
}
