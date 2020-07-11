/*
This file is part of JBudget.

    JBudget is free software: you can redistribute it and/or modify
    it under the terms of the GNU General Public License as published by
    the Free Software Foundation, either version 3 of the License, or
    (at your option) any later version.

    JBudget is distributed in the hope that it will be useful,
    but WITHOUT ANY WARRANTY; without even the implied warranty of
    MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
    GNU General Public License for more details.

    You should have received a copy of the GNU General Public License
    along with JBudget.  If not, see <https://www.gnu.org/licenses/>.
*/
package it.unicam.cs.pa.jbudget100763.model;

import java.util.HashSet;
import java.util.Set;
import java.util.function.Predicate;
import java.util.stream.Collectors;

/**
 * 
 * @author Vittorio
 * 
 *         Permette di accedere e modificare le informazioni del conto:
 *         descrizione, saldo iniziale, tipologia. Consente inoltre di ottenere
 *         il saldo attuale. Inoltre, è possibile accedere alla lista
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

	public AccountImpl(int id) {
		this.id = id;
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
	 * I movimenti correlati a questo account hanno il riferimento nelle transazioni
	 * (e quindi nel ledger), successivamente questi vengono collegati all'account
	 * 
	 * @return ritorna la lista dei movimenti che si riferiscono a questo account
	 */
	public Set<Movement> getMovements() {
		Set<Movement> temp = new HashSet<Movement>();

		ledger.getTransactions().forEach(transaction -> {
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
		return this.getMovements().stream().filter(condition).collect(Collectors.toSet());
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