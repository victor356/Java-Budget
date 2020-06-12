package it.unicam.cs.pa.jbudget100763.model;

import java.util.HashSet;
import java.util.Set;
import java.util.Map;
import java.util.function.Predicate;

/**
 * 
 * @author Vittorio
 * 
 *         Permette di accedere e modificare le informazioni del conto:
 *         descrizione, saldo iniziale, tipologia. Consente inoltre di ottenere
 *         il saldo attuale a runtime. Inoltre, � possibile accedere alla lista
 *         dei movimenti associati e quelli che soddisfano un determinato
 *         predicato.
 */
public class AccountImpl implements Account {

	Ledger ledger = LedgerImpl.getInstance();
	private int id;
	private String description;
	private String name;
	private double openingBalance;
	private AccountType type;

	public AccountImpl(AccountType type2, String name, double openingBalance2, String description2) {
		this.type = type2;
		this.name = name;
		this.openingBalance = openingBalance2;
		this.description = description2;

	}
	public AccountImpl(int id){
		this.id=id;
	}
	private static Map<Integer, AccountImpl>registry;

	public static AccountImpl getInstance(int id) {
		if (registry.containsKey(id)) {
			return registry.get(id);
		} else {
			return new AccountImpl(id);
		}

	}

	/**
	 * @return aggiorna in runtime il saldo attuale partendo da quello iniziale e
	 *         sommando di volta in volta tutti i movimenti avvenuti
	 */
	public double getBalance() {
		double balance = 0;
		for (Transaction t : ledger.getTransactions()) {
			for (Movement m : t.getMovements()) {
				if (m.getAccount().getName() == getName()) {
					balance += m.getAmount();
				}
			}
		}

		return getOpeningBalance() + balance;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	/**
	 * I movimenti correlati a questo account sono inclusi nelle transazioni (e
	 * quindi nel ledger), successivamente questi vengono collegati all'account
	 * 
	 * @return ritorna la lista dei movimenti che si riferiscono a questo account
	 */
	public Set<Movement> getMovements() {
		Set<Movement> temp = new HashSet<Movement>();

		ledger.getTransactions().parallelStream().forEach(transaction -> {
			transaction.getMovements().forEach(mov -> {
				if (mov.getAccount().getName() == this.getName())
					temp.add(mov);
			});
		});

		return temp;
	}

	/**
	 * @param condition - Predicato da rispettare
	 * @return ritorna la lista dei movimenti di questo account che rispettano il
	 *         predicato
	 */
	@Override
	public Set<Movement> getMovements(Predicate<Movement> condition) {
		Set<Movement> temp = new HashSet<Movement>();

		for (Movement t : this.getMovements()) {
			if (condition.test(t)) {
				temp.add(t);

			}
		}
		return temp;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getOpeningBalance() {
		return this.openingBalance;
	}

	public void setOpeningBalance(double openingBalance) {
		this.openingBalance = openingBalance;
	}

	public AccountType getType() {
		return this.type;
	}

	public void setType(AccountType type) {
		this.type = type;
	}

}