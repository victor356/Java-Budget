package it.unicam.cs.pa.jbudget100763.controller;

import java.util.Date;
import java.util.List;
import java.util.function.Predicate;

import it.unicam.cs.pa.jbudget100763.model.*;

/**
 * questa interfaccia è implementata dalle classi che hanno la responsabilità
 * di gestire tutti i dati dell’applicazione. E’ responsabile della
 * creazione dei conti, dell’aggiunta e cancellazione delle transazioni, della
 * creazione e cancellazione dei tag. Inoltre mantiene la lista delle
 * transazione schedulate. Si occupa di schedulare le transazioni ad una certa
 * data.
 */
public interface Ledger {

	List<Account> getAccounts();

	List<Transaction> getTransactions();

	void addTransaction(Transaction t);

	List<Transaction> getTransactions(List<Transaction> list,Predicate<Transaction> condition);

	List<Tag> getTags();

	Tag addTag(String name, String description);

	void removeTag(Tag t);

	List<Transaction> addScheduledTransaction(ScheduledTransaction st);

	void schedule(Date d, ScheduledTransaction st);

//	Account addAccount(AccountType type, String name, String description, double openingBalance);

	Account addAccount(AccountType cash, String string, String string2, double d);

}