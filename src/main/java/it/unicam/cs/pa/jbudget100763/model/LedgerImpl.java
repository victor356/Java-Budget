/*
This file is part of JBudget.

    JBudget is free software: you can redistribute it and/or modify
    it under the terms of the GNU General Public License as published by
    the Free Software Foundation, either version 3 of the License, or
    (at your option) any later version.

    Foobar is distributed in the hope that it will be useful,
    but WITHOUT ANY WARRANTY; without even the implied warranty of
    MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
    GNU General Public License for more details.

    You should have received a copy of the GNU General Public License
    along with Foobar.  If not, see <https://www.gnu.org/licenses/>.
*/
package it.unicam.cs.pa.jbudget100763.model;

import java.util.GregorianCalendar;
import java.util.HashSet;
import java.util.Set;
import java.util.function.Predicate;

/**
 * ha la responsabilità di gestire tutti i dati dell'applicazione. è
 * responsabile della creazione dei conti, dell'aggiunta e cancellazione delle
 * transazioni, della creazione e cancellazione dei tag. Inoltre mantiene la
 * lista delle transazione schedulate. Si occupa di schedulare le transazioni ad
 * una certa data.
 * 
 * @author Vittorio
 *
 */
public class LedgerImpl implements Ledger {
	Set<Transaction> transactions = new HashSet<Transaction>();
	Set<Account> accounts = new HashSet<Account>();
	Set<Tag> tags = new HashSet<Tag>();
	Set<ScheduledTransaction> scheduledTransaction = new HashSet<ScheduledTransaction>();

	private static LedgerImpl ledger;

	/**
	 * Singleton implementation
	 * 
	 * @return ledger
	 */
	public static LedgerImpl getInstance() {
		if (ledger == null) {
			return ledger = new LedgerImpl();
		}
		return ledger;
	}

	/**
	 * Crea un nuovo account nell'applicazione
	 * 
	 * @param type           - tipo di account
	 * @param name           - nome dell'account
	 * @param description    - descrizione dell'account
	 * @param openingBalance - cifra iniziale
	 * @return nuovo account instanziato ed inserito nella lista
	 */
	public Account addAccount(AccountType type, String name, String description, double openingBalance) {
		Account u = new AccountImpl(type, name, openingBalance, description);
		if (!accounts.contains(u))
			accounts.add(u);
		return u;
	}

	/**
	 * Crea un nuovo tag nell'applicazione
	 * 
	 * @param name        - nome tag
	 * @param description - descrizione del tag
	 * @return nuovo tag instanziato ed inserito nella lista
	 */
	public Tag addTag(String name, String description) {
		Tag t = new TagImpl(name, description);

		if (!tags.contains(t)) {
			tags.add(t);
		}
		return t;

	}

	/**
	 * @param t - tag da rimuovere
	 */
	public void removeTag(Tag t) {

		tags.remove(t);
	}

	public boolean addTransaction(GregorianCalendar date) {
		return transactions.add(new TransactionImpl(date));
	}

	public Set<Account> getAccounts() {

		return accounts;
	}

	public Set<Tag> getTags() {
		return tags;
	}

	public Set<Transaction> getTransactions() {
		return transactions;
	}

	/**
	 * @param condition - Predicate che le transizioni devono rispettare
	 * @return ritorna la lista di transazioni che rispettano un certo predicato
	 */
	public Set<Transaction> getTransactions(Predicate<Transaction> condition) {
		Set<Transaction> temp = new HashSet<Transaction>();

		for (Transaction t : this.getTransactions()) {
			if (condition.test(t)) {
				temp.add(t);

			}
		}
		return temp;
	}

	/**
	 * 
	 * @return all the scheduled Transactions
	 */
	public Set<ScheduledTransaction> getScheduled() {
		return scheduledTransaction;
	}

	/**
	 * 
	 * @param d data in input
	 * @return la specifica scheduled transaction fissata a quella data
	 */
	public ScheduledTransaction searchScheduledTransaction(GregorianCalendar d) {
		return scheduledTransaction.stream().filter((ScheduledTransaction st) -> st.getDate() == d).findAny()
				.orElse(null);
	}

	/**
	 * Aggiunge l'istanza Sch.Tran. alla lista "contenitore" dell'applicazione
	 * presente nel ledger
	 * 
	 * @param st - Scheduled Transaction
	 * 
	 */
	public void addScheduledTransaction(ScheduledTransaction st) {
		scheduledTransaction.add(st);
	}

	/**
	 * Combina (aggiunge) una transazione prevista ad una data futura con una
	 * scheduled transaction
	 *
	 * @param st - scheduler di riferimento
	 * 
	 */
	public void schedule(ScheduledTransaction st) {

		for (Transaction t : transactions) {
			if (t.getDate() == st.getDate()) {
				st.getTransactions().add(t);
			}
		}
	}

	/**
	 * Combina manualmente una transazione con una Sched.Transaction, vale ancora il
	 * requisito che debbano manifestarsi lo stesso momento
	 * 
	 * @param transaction transazione da inserire
	 * @param st          Sched.Trans. da accoppiare
	 * @return se l'operazione è andata a buon fine
	 */
	public boolean scheduleSpecificTransaction(Transaction transaction, ScheduledTransaction st) {
		return st.addTransaction(transaction);

	}

}