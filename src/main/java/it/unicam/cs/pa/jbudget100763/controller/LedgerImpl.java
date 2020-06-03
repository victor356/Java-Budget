package it.unicam.cs.pa.jbudget100763.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.function.Predicate;

import it.unicam.cs.pa.jbudget100763.model.*;

public class LedgerImpl implements Ledger {

	// HashMap<AccountType, String, String , Double> accountDb = new
	// HashMap<AccountType , String , String , Double>();
	// HashMap<String, String> tagdb= new Hashmap<String, String>();
	static List<Transaction> transactions = new ArrayList<Transaction>();
	static List<Account> accounts = new ArrayList<Account>();
	static List<Tag> tags = new ArrayList<Tag>();
	static ScheduledTransaction scheduled = new ScheduledTransactionImpl();
	/*
	 * private LedgerImpl(List<Transaction> transactions,List<Account>
	 * accounts,List<Tag> tags) { LedgerImpl.transactions=List.of();
	 * LedgerImpl.accounts=List.of(); LedgerImpl.tags=List.of();
	 * 
	 * }
	 */
	private static LedgerImpl ledger;

	public static LedgerImpl getInstance() {
		if (ledger == null) {
			ledger = new LedgerImpl();
		}
		return ledger;
	}

	public Account addAccount(AccountType type, String name, String description, double openingBalance) {
		Account u = new AccountImpl(type, name, openingBalance, description);
		accounts.add(u);
		return u;
	}

	public Tag addTag(String name, String description) {
		Tag t = new TagImpl(name, description);
		HashSet<Tag> temp = new HashSet<Tag>();

		temp.addAll(tags);
		temp.add(t); // take all the distinct tags (hashSet works in this way)

		tags.clear();
		tags.addAll(temp); // put them back in this.list

		return t;

	}

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

	public List<Transaction> getTransactions(List<Transaction> list,Predicate<Transaction> condition) {
		List<Transaction> temp = new ArrayList<Transaction>();

		for (Transaction t : list) {
			if (t.getDate()!=null && condition.test(t)) {
				temp.add(t);

			}
		}
		return temp;
	}

	public ScheduledTransaction getScheduled() {
		return scheduled;
	}

	public List<Transaction> addScheduledTransaction(ScheduledTransaction st) {
		return st.getTrans();
		// this.scheduled.trans.add((Transaction) st);
	}

	public void schedule(Date d, ScheduledTransaction st) {

//		addScheduledTransaction(st).addAll(
		for (Transaction t : transactions) {
			if (t.getDate() == d) {
				addScheduledTransaction(st).add(t);
			}
		}
		// transactions.stream().map( t -> t.getDate() ==
		// d).forEachOrdered(st.getTrans()::add);

//		if (addScheduledTransaction(st).isEmpty()) {
//			return false;
//		} else
//			return true;
	}

}