package it.unicam.cs.pa.jbudget100763.model;

import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.List;

/**
 * indica una transazione o una serie di transazioni schedulate (previste) ad
 * una certa data. La serie di transazioni termina quando il metodo
 * isCompleted() restituisce true.
 * 
 * @author Vittorio
 *
 */
public class ScheduledTransactionImpl implements ScheduledTransaction {

	private String description;
	private List<Transaction> trans = new ArrayList<Transaction>();
	private GregorianCalendar date;

	public ScheduledTransactionImpl(GregorianCalendar d) {
		this.date = d;
	}

	public GregorianCalendar getDate() {
		return this.date;
	}

	public void setDate(GregorianCalendar date) {
		this.date = date;
	};

	public List<Transaction> getTransactions() {
		return trans;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String desc) {
		this.description = desc;
	};



	/**
	 * @return conferma se la serie di transazioni si sia manifestata o meno
	 */
	@Override
	public boolean isCompleted() {

		return this.date.after(GregorianCalendar.getInstance());

	}

	/**
	 * 
	 * @param t transazione da schedulare
	 * @return se la transazione da inserire rispetta i requisiti della
	 *         scheduledTransaction
	 */
	public boolean addTransaction(Transaction t) {

		return (t.getDate() == getDate() ? getTransactions().add(t) : false);
	}
}