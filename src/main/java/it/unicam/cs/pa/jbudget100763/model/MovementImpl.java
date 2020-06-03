package it.unicam.cs.pa.jbudget100763.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class MovementImpl implements Movement {

	private String description;
	private MovementType type;
	private double amount;
	private Transaction transaction;
	private Account account;
	private int id;
	private Date date;
	List<Tag> tag=new ArrayList<Tag>();;

	public MovementImpl(MovementType type,double amount,Transaction trans,Account account) {
		this.type=type;
		this.amount=amount;
		this.transaction=trans;
		this.account=account;

		
		transaction.addMovement(this);
	}
	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public MovementType getType() {
		return this.type;
	}

	public void setType(MovementType type) {
		this.type = type;
	}

	public double getAmount() {
		return this.amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public Transaction getTransaction() {
		return this.transaction;
	}

	public void setTransaction(Transaction transaction) {
		this.transaction = transaction;
	}

	public Account getAccount() {
		return this.account;
	}

	public void setAccount(Account account) {
		this.account = account;
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Date getDate() {
		return this.date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public List<Tag> getTag() {
		return this.tag;
	}

	@Override
	public void addTag(Tag t) {
		this.tag.add(t);
	}

	@Override
	public void removeTag(Tag t) {
		this.tag.remove(t);
	}

	public MovementImpl(MovementType ty, double amo, Date da, Tag t, String desc, Account acc, Transaction trans) {
		type = ty;
		amount = amo;
		date = da;
		tag.add(t);
		description = desc;
		account = acc;
		transaction = trans;

	}

}