package com.company;

import java.util.ArrayList;

public class Bank {
    private String name;
    private ArrayList<Branch> branches;

    public Bank(String name){
        this.name = name;
        this.branches = new ArrayList<>();
    }

    public boolean addBranch(String branchName){
        if (findBranch(branchName)==null) {
            this.branches.add(new Branch(branchName));
            return true;
        }
        return false;
    }

    public boolean addCustomer(String branchName, String customerName , double initialAmount){
        Branch branch = findBranch(branchName);
        if (branch != null){
            return branch.addCustomer(customerName, initialAmount);
        }
        return false;
    }
    public boolean addCustomerTranscation(String branchName, String customerName, double initialAmount){
        Branch branch = findBranch(branchName);
        if (branch != null){
            return branch.addCustomerTransaction(customerName,initialAmount);
        }
        return false;
    }
    private Branch findBranch(String branchName){
        for (int i=0; i < this.branches.size(); i++){
            Branch existingBranch = this.branches.get(i);
            if (existingBranch.getName().equals(branchName)){
                return existingBranch;
            }
        }
        return null;
    }

    public boolean listCustomer(String branchName, boolean showTransaction){
        Branch branch = findBranch(branchName);
        if (branch != null){
            System.out.println("Customer details for branch " + branch.getName());

            ArrayList<Customers> branchCustomers = branch.getCustomers();
            for (int i = 0; i < branchCustomers.size(); i++) {
                Customers branchCustomer = branchCustomers.get(i);
                System.out.println("Customer Name : " + branchCustomer.getName() + " [" + (i+1) + "]");
                if (showTransaction){
                    ArrayList<Double> transactions = branchCustomer.getTransactions();
                    for (int j = 0; j < transactions.size() ; j++) {
                        double transaction = transactions.get(j);
                        System.out.println("Transaction Details : " + (j+1) + " . " + transaction);
                    }
                }
            }
            return true;
        }else
        return false;
    }
}
