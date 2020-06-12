package it.unicam.cs.pa.jbudget100763.model;

import java.util.HashSet;
import java.util.GregorianCalendar;
import java.util.Set;

/**
 * questa classe implementa la responsabilit� di gestire un singolo movimento.
 * Permette di accedere e modificare le informazioni associate al movimento:
 * descrizione, importo, account associato, lista dei tag associati al
 * movimento. Le operazioni di lettura e modifica di queste operazioni vengono
 * effettuate per mezzo degli opportuni getter e setter. Il movimento � associato
 * ad una transazione da cui deriva la data. I tag inseriti nei movimenti vengono
 * raccolti senza ripetersi dalla transazione, i tag aggiunti alla transazione
 * vengono distribuiti a tutti i movimenti a lei associati
 * 
 * @author Vittorio
 *
 */
public class MovementImpl implements Movement {

	private String description;
	private MovementType type;
	private double amount;
	private Transaction transaction;
	private Account account;
	private int id;
	private GregorianCalendar date;
	Set<Tag> tag = new HashSet<Tag>();

	/**
	 * Costruttore del movimento, esso viene automaticamente collegato alla
	 * transazione ed inserito nella sua lista
	 * 
	 * @param type    - tipo di movimento
	 * @param amount  - ammontare
	 * @param trans   - transazione di cui fa parte
	 * @param account - conto di cui fa parte
	 */
	public MovementImpl(MovementType type, double amount, Transaction trans, Account account) {
		this.type = type;
		this.amount = amount;
		this.transaction = trans;
		this.account = account;
		transaction.addMovement(this);
		this.date = trans.getDate();
	}

	public MovementImpl(MovementType ty, double amo, GregorianCalendar da, Tag t, String desc, Account acc,
			Transaction trans) {
		type = ty;
		amount = amo;
		date = da;
		tag.add(t);
		description = desc;
		account = acc;
		transaction = trans;
		trans.addMovement(this);
		this.date = trans.getDate();

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

	public GregorianCalendar getDate() {
		return this.date;
	}

	public void setDate(GregorianCalendar date) {
		this.date = date;
	}

	public Set<Tag> getTag() {
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

}