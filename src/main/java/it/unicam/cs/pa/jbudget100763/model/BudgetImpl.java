package it.unicam.cs.pa.jbudget100763.model;

import java.util.List;
import java.util.function.Predicate;

public class BudgetImpl implements Budget {
    @Override
    public double getBalance(Tag t) {
    	
    	return 0;
    }
    @Override
    public void setBalance(Tag t, Double expected) {
        // TODO Auto-generated method stub

    }

    @Override
    public List<Tag> tags() {
        // TODO Auto-generated method stub
        return null;
    }
    @Override
    public Predicate<Transaction> getPredicate() {
        // TODO Auto-generated method stub
        return null;
    }
}