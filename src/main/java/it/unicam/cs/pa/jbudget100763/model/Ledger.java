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
package it.unicam.cs.pa.jbudget100763.model;

import java.util.GregorianCalendar;
import java.util.Set;
import java.util.function.Predicate;

/**
 * questa interfaccia è implementata dalle classi che hanno la responsabilità di
 * gestire tutti i dati dell'applicazione. è responsabile della creazione dei
 * conti, dell'aggiunta e cancellazione delle transazioni, della creazione e
 * cancellazione dei tag. Inoltre mantiene la lista delle transazione
 * schedulate. Si occupa di schedulare le transazioni ad una certa data.
 */
public interface Ledger {

    
	Set<Account> getAccounts();

	Set<Transaction> getTransactions();

	boolean addTransaction(GregorianCalendar date);

	Set<Transaction> getTransactions(Predicate<Transaction> condition);

	Set<Tag> getTags();

	Tag addTag(String name, String description);

	void removeTag(Tag t);

	void addScheduledTransaction(ScheduledTransaction st);

	void schedule(ScheduledTransaction st);

    Account addAccount(AccountType cash, String string, String string2, double d);

    Set<ScheduledTransaction> getScheduled();

    Set<ScheduledTransaction> searchScheduledTransaction(GregorianCalendar d);

    boolean scheduleSpecificTransaction(Transaction transaction, ScheduledTransaction st);

}