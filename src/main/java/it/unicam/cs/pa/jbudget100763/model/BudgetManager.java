package it.unicam.cs.pa.jbudget100763.model;

import it.unicam.cs.pa.jbudget100763.controller.Ledger;

/**
 * BudgetManager: ha la responsabilità di costruire il BudgetReport associato ad
 * un Budget ed ad un Ledger.
 */
public interface BudgetManager {

    BudgetReport generateReport(Ledger l, Budget b);
    
}