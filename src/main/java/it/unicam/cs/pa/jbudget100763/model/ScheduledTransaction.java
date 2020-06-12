package it.unicam.cs.pa.jbudget100763.model;

import java.util.GregorianCalendar;
import java.util.List;

/**
 * indica una transazione o una serie di transazioni schedulate (previste) ad
 * una certa data. La serie di transazioni termina quando il metodo
 * isCompleted() restituisce true.
 */
public interface ScheduledTransaction {

	GregorianCalendar getDate();

	String getDescription();

	List<Transaction> getTransactions();

	boolean isCompleted();

	void setDescription(String desc);

	boolean addTransaction(Transaction transaction);

}