package it.unicam.cs.pa.jbudget100763.controller;

import java.util.GregorianCalendar;
import java.util.List;
import java.util.Map;
import java.util.function.Predicate;

import it.unicam.cs.pa.jbudget100763.model.*;

/**
 * Ha la responsabilità di ricevere i comandi dell'utente e di attuarli
 * modificando lo stato degli altri due componenti del MVC
 * 
 * @author Vittorio
 *
 */
public class Controller {
	private TagBudgetReportImpl tagBudgetReport;
	private BudgetImpl budgetImpl;
	private ScheduledTransactionImpl scheduledTransactionImpl;

	public Account addAccount(AccountType type, String name, String description, double openingBalance) {
		return LedgerImpl.getInstance().addAccount(type, name, description, openingBalance);
	}

	public Tag addTag(String name, String description) {
		return LedgerImpl.getInstance().addTag(name, description);
	}

	public void removeTag(Tag t) {
		LedgerImpl.getInstance().removeTag(t);
	}

	public List<Account> getAccounts() {
		return LedgerImpl.getInstance().getAccounts();
	}

	public void addTransaction(Transaction t) {
		LedgerImpl.getInstance().addTransaction(t);
	}

	public List<Tag> getTags() {
		return LedgerImpl.getInstance().getTags();
	}

	public List<Transaction> getTransactions() {
		return LedgerImpl.getInstance().getTransactions();
	}

	public List<Transaction> getTransactions(Predicate<Transaction> condition) {
		return LedgerImpl.getInstance().getTransactions(condition);
	}

	public ScheduledTransaction getScheduled() {
		return LedgerImpl.getInstance().getScheduled();
	}

	public void schedule(GregorianCalendar d, ScheduledTransaction st) {
		LedgerImpl.getInstance().schedule(d, st);
	}

	public Map<Tag, Double> report(Predicate<Transaction> condition) {
		return tagBudgetReport.report(condition);
	}

	public double getBalance(Tag t) {
		return budgetImpl.getBalance(t);
	}

	public void setBalance(Tag t, Double expected) {
		budgetImpl.setBalance(t, expected);
	}

	public List<Tag> tags(Predicate<Transaction> condition) {
		return budgetImpl.tags(condition);
	}

	public List<Transaction> getTransactions(GregorianCalendar d) {
		return scheduledTransactionImpl.getTransactions(d);
	}

}
