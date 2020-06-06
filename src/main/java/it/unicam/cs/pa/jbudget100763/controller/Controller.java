package it.unicam.cs.pa.jbudget100763.controller;

import java.util.List;

import it.unicam.cs.pa.jbudget100763.model.*;

public class Controller {
    LedgerImpl ledger=new LedgerImpl();

    public List<Account> getAccounts(){
      return  ledger.getAccounts();
    }
    public Account newAccount(AccountType type, String name, String description, double openingBalance) {
        return ledger.addAccount(type, name, description, openingBalance);
    }
}
