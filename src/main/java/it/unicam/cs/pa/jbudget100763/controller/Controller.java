/*
This file is part of JBudget.

    JBudget is free software: you can redistribute it and/or modify
    it under the terms of the GNU General Public License as published by
    the Free Software Foundation, either version 3 of the License, or
    (at your option) any later version.

    JBudget is distributed in the hope that it will be useful,
    but WITHOUT ANY WARRANTY; without even the implied warranty of
    MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
    GNU General Public License for more details.

    You should have received a copy of the GNU General Public License
    along with JBudget.  If not, see <https://www.gnu.org/licenses/>.
*/
package it.unicam.cs.pa.jbudget100763.controller;

import java.util.GregorianCalendar;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.function.Predicate;

import it.unicam.cs.pa.jbudget100763.model.Account;
import it.unicam.cs.pa.jbudget100763.model.AccountType;
import it.unicam.cs.pa.jbudget100763.model.Budget;
import it.unicam.cs.pa.jbudget100763.model.Ledger;
import it.unicam.cs.pa.jbudget100763.model.LedgerImpl;
import it.unicam.cs.pa.jbudget100763.model.ScheduledTransaction;
import it.unicam.cs.pa.jbudget100763.model.ScheduledTransactionImpl;
import it.unicam.cs.pa.jbudget100763.model.Tag;
import it.unicam.cs.pa.jbudget100763.model.TagBudgetReport;
import it.unicam.cs.pa.jbudget100763.model.Transaction;

/**
 * Ha la responsabilità di ricevere i comandi della vista e di attuarli
 * modificando lo stato del Model
 * 
 * @author Vittorio
 *gradl
 */
public class Controller {
	private TagBudgetReport tagBudgetReport;
	private Budget budgetImpl;
	private Ledger ledger=LedgerImpl.getInstance();

	public Account addAccount(AccountType type, String name, String description, double openingBalance) {

		if (name.isEmpty()) {
			throw new IllegalArgumentException("Inserire nome!!!!");
		}
		return ledger.addAccount(Objects.requireNonNull(type), name, description,
				Objects.requireNonNull(openingBalance));
	}

	public void removeAccount(Account o) {
		this.getAccounts().remove(Objects.requireNonNull(o));
	}

	public Tag addTag(String name, String description) {
		if (name.isEmpty() || description.isEmpty()) {
			throw new IllegalArgumentException("Inserire nome o Descrizione!!!!");
		}
		return ledger.addTag(name, description);
	}

	public void removeTag(Tag t) {
		this.getTags().remove(Objects.requireNonNull(t));
	}

	public Set<Account> getAccounts() {
		return ledger.getAccounts();
	}

	public void addTransaction(GregorianCalendar date) {

		ledger.addTransaction(Objects.requireNonNull(date));
	}

	public Set<Tag> getTags() {
		return ledger.getTags();
	}

	public Set<Transaction> getTransactions() {
		return ledger.getTransactions();
	}

	public Set<Transaction> getTransactions(Predicate<Transaction> condition) {
		return ledger.getTransactions(Objects.requireNonNull(condition));
	}

	public Set<ScheduledTransaction> getScheduled() {
		return ledger.getScheduled();
	}

	public Set<ScheduledTransaction> spotScheduledTransaction(GregorianCalendar d) {

		return ledger.searchScheduledTransaction(Objects.requireNonNull(d));
	}

	public void schedule(ScheduledTransaction st) {
		ledger.schedule(Objects.requireNonNull(st));
	}

	public Map<Tag, Double> report(Predicate<Transaction> condition) {

		return (Objects.nonNull(condition)) ? tagBudgetReport.report(condition)
				: tagBudgetReport.getTagBalance(getTransactions());
	}

	public double getBalance(Tag t) {
		return budgetImpl.getBalance(Objects.requireNonNull(t));
	}

	public void setBalance(Tag t, Double expected) {
		budgetImpl.setBalance(Objects.requireNonNull(t), Objects.requireNonNull(expected));
	}

	public Set<Tag> tags(Predicate<Transaction> condition) {
		return budgetImpl.tags(Objects.requireNonNull(condition));
	}

	public void scheduleSpecificTransaction(Transaction transaction, ScheduledTransactionImpl st) {
		if (!ledger.scheduleSpecificTransaction(Objects.requireNonNull(transaction), Objects.requireNonNull(st)))
			throw new IllegalArgumentException();
	}

}
