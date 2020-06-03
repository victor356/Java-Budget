package it.unicam.cs.pa.jbudget100763.model;

import it.unicam.cs.pa.jbudget100763.controller.Ledger;

public class BudgetManagerImpl implements BudgetManager {

    @Override
    public BudgetReport generateReport(Ledger l, Budget b) {
        return new BudgetReportImpl(l,b);
    }

	

}