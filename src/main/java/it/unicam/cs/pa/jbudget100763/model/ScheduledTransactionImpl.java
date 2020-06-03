package it.unicam.cs.pa.jbudget100763.model;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class ScheduledTransactionImpl implements ScheduledTransaction {

	private String description;
	private List<Transaction> trans = new ArrayList<Transaction>();
	private Date date;

	public List<Transaction> getTrans() {
		return trans;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String desc) {
		this.description = desc;
	};

	@Override
	public List<Transaction> getTransactions(Date d) { // ritorna le trans ad una certa data
		List<Transaction> temp = new ArrayList<Transaction>();
		for (Transaction t : trans) {
			if (t.getDate() == d)
				temp.add(t);
		}
		return temp;
	}

	@Override
	public boolean isCompleted() {
		if (!trans.isEmpty()) { // per controllare se la serie di transazioni si è manifestata o meno,
								// controllare che la loro data sia maggiore ad oggi
			this.date = trans.get(0).getDate();
		} else {
			return false;
		}
		return this.date.after(Calendar.getInstance().getTime());

	}

	public void addTransaction(Transaction t) {

		this.trans.add(t);

	}
}