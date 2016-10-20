/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.peram_inclassexam;

/**
 *
 * @author S525754
 */
public class AccountDetails {
    private String firstName;
    private String lastName;
    private String accountNo;
    private double accountBalance;
    
    public AccountDetails(){
        
    }
    
    public AccountDetails(String firstName, String lastName, String accountNo, double accountBalance){
        this. firstName = firstName;
        this.lastName = lastName;
        this.accountNo = accountNo;
        this.accountBalance = accountBalance;
    } 

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getAccountNo() {
        return accountNo;
    }

    public double getAccountBalance() {
        return accountBalance;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setAccountNo(String accountNo) {
        this.accountNo = accountNo;
    }

    public void setAccountBalance(double accountBalance) {
        this.accountBalance = accountBalance;
    }
}
