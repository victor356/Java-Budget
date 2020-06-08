package it.unicam.cs.pa.jbudget100763.model;

import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.List;
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
	List<Transaction> transactions = new ArrayList<Transaction>();
	List<Account> accounts = new ArrayList<Account>();
	List<Tag> tags = new ArrayList<Tag>();
	List<ScheduledTransaction> scheduledTransaction = new ArrayList<ScheduledTransaction>();
	ScheduledTransaction scheduled = new ScheduledTransactionImpl();

	private static LedgerImpl ledger;

	/**
	 * Singleton
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
	 * @param name       - nome tag
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

	public void addTransaction(Transaction t) {
		transactions.add(t);

	}

	public List<Account> getAccounts() {

		return accounts;
	}

	public List<Tag> getTags() {
		return tags;
	}

	public List<Transaction> getTransactions() {
		return transactions;
	}

	/**
	 * @param condition - Predicate che le transizioni devono rispettare
	 * @return ritorna la lista di transazioni che rispettano un certo predicato
	 */
	public List<Transaction> getTransactions(Predicate<Transaction> condition) {
		List<Transaction> temp = new ArrayList<Transaction>();

		for (Transaction t : this.getTransactions()) {
			if (condition.test(t)) {
				temp.add(t);

			}
		}
		return temp;
	}

	public ScheduledTransaction getScheduled() {
		return scheduled;
	}

	/**
	 * Aggiunge la Sch.Tran. alla lista
	 * 
	 * @param st - Scheduled Transaction
	 * 
	 */
	public void addScheduledTransaction(ScheduledTransaction st) {
		scheduledTransaction.add(st);
	}

	/**
	 * 
	 * @param st - scheduler di riferimento
	 * @param d  - data di riferimento Aggiunge una transazione prevista ad una data
	 *           futura ad una scheduled transaction
	 */
	public void schedule(GregorianCalendar d, ScheduledTransaction st) {

		for (Transaction t : transactions) {
			if (t.getDate() == d) {
				st.getTransactions().add(t);
			}
		}

	}

}