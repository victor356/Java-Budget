package it.unicam.cs.pa.jbudget100763.model;

import java.util.List;
import java.util.Date;

/**
 * indica una transazione o una serie di transazioni schedulate (previste) ad
 * una certa data. La serie di transazioni termina quando il metodo
 * isCompleted() restituisce true.
 */
public interface ScheduledTransaction {

	List<Transaction> getTrans();

	String getDescription();

	List<Transaction> getTransactions(Date d);

	boolean isCompleted();

	void setDescription(String desc);

}