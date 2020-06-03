package it.unicam.cs.pa.jbudget100763.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;

import it.unicam.cs.pa.jbudget100763.controller.LedgerImpl;

public class TransactionImpl implements Transaction {

	private int id;
	private List<Movement> movements = new ArrayList<Movement>();
	private List<Tag> tags = new ArrayList<Tag>();
	private Date date;

	public TransactionImpl() {

		LedgerImpl.getInstance().addTransaction(this);
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public List<Movement> getMovements() {
		return this.movements;
	}

	public Date getDate() {
		return this.date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	@Override
	public void addMovement(Movement m) {
		movements.add(m);
	}

	@Override
	public void removeMovement(Movement m) {
		movements.remove(m);
	}

	public List<Tag> getTags() { // get the distinct tags of every mov
		HashSet<Tag> temp = new HashSet<Tag>();
		for (Movement m : movements) { // for every mov

			temp.addAll(m.getTag()); // take all the distinct tags (hashSet works in this way)
		}
		this.tags.clear();
		this.tags.addAll(temp); // put them in class list

		return this.tags;
	}

	@Override
	public void addTag(Tag t) {
		for (Movement m : movements) { // add the tag in every mov of the trans if not already present,
			if (!m.getTag().contains((Tag) t)) // AND in this list
				m.addTag(t);
		}

	}

	@Override
	public void removeTag(Tag t) {
		for (Movement m : movements) {
			if (m.getTag().contains((Tag) t))
				m.removeTag(t);
		}
	}

	@Override
	public double getTotalAmount() {
		double total = 0;
		for (Movement m : movements) {
			total += m.getAmount();
		}

		return total;
	}

}