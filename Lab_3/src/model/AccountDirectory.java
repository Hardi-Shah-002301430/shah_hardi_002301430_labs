/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.util.ArrayList;

/**
 *
 * @author hardishah
 */
public class AccountDirectory {
    ArrayList<Account> accounts;
    public Account addAccount;
    
    public AccountDirectory(){
        this.accounts = new ArrayList<Account>();
    }

    public ArrayList<Account> getAccounts() {
        return accounts;
    }

    public void setAccounts(ArrayList<Account> accounts) {
        this.accounts = accounts;
    }
    
   public Account addAccount(){
       Account a = new Account();
       accounts.add(a);
       return a;
   }
   
   public void deleteAccount(Account account){
       accounts.remove(account);
   }
   
   public Account searchAccount(String accountNumber) {
    for (Account a : accounts) {
        if (a.getAccountNumber () .contains (accountNumber) ) {
        return a;
        }
    }
        return null;
}
}