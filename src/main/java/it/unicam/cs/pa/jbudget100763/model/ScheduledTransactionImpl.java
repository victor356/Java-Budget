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
	 * @return ritorna le transazioni che sono state programmate ad una certa data
	 */
	@Override
	public List<Transaction> getTransactions(GregorianCalendar d) {
		List<Transaction> temp = new ArrayList<Transaction>();
		for (Transaction t : trans) {
			if (t.getDate() == d)
				temp.add(t);
		}
		return temp;
	}

	/**
	 * @return conferma se la serie di transazioni si sia manifestata o meno
	 */
	@Override
	public boolean isCompleted() {
		if (!trans.isEmpty()) {
			this.date = trans.get(0).getDate();
		} else {
			return false;
		}
		return this.date.after(GregorianCalendar.getInstance());

	}

	public void addTransaction(Transaction t) {
		this.trans.add(t);

	}
}