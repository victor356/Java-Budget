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

}