import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.List;

import org.junit.jupiter.api.Test;

import it.unicam.cs.pa.jbudget100763.model.Account;
import it.unicam.cs.pa.jbudget100763.model.AccountType;
import it.unicam.cs.pa.jbudget100763.model.Ledger;
import it.unicam.cs.pa.jbudget100763.model.LedgerImpl;
import it.unicam.cs.pa.jbudget100763.model.ScheduledTransactionImpl;
import it.unicam.cs.pa.jbudget100763.model.Tag;
import it.unicam.cs.pa.jbudget100763.model.Transaction;
import it.unicam.cs.pa.jbudget100763.model.TransactionImpl;

public class LedgerTest {

	Ledger l = LedgerImpl.getInstance();

	@Test
	void addAccount() {

		Account u = l.addAccount(AccountType.CASH, "Vittorio", "prova", 0.0);
		assertTrue(!l.getAccounts().isEmpty());
	}

	@Test
	void addTag() {

		Tag t = l.addTag("AUTO", "spese effettuate per manutenzione e uso dell'auto");
		assertFalse(l.getTags().isEmpty());

		l.removeTag(t);
		assertTrue(l.getTags().isEmpty());

	}

	@Test
	void addTransaction() {
		Transaction trans = new TransactionImpl();

		assertFalse(l.getTransactions().isEmpty());
		l.getTransactions().clear();

	}

	@Test
	void PredicateTransaction() throws ParseException {
		GregorianCalendar d = new GregorianCalendar();
		d.set(2015, 10, 5);
		GregorianCalendar d1 = new GregorianCalendar();
		d1.set(2015, 10, 5);

		Transaction trans = new TransactionImpl();
		trans.setDate(d);
		System.out.println(trans.getDate());
		List<Transaction> list = new ArrayList<Transaction>();
		list.addAll(l.getTransactions((x) -> x.getDate().compareTo(d1) == 0));
		assertFalse(list.isEmpty());
	}

	@Test
	void addScheduled() throws ParseException {

		Transaction trans = new TransactionImpl();
		GregorianCalendar d = new GregorianCalendar();
		d.set(2015, 10, 5);
		trans.setDate(d);

		ScheduledTransactionImpl scheduledNow = new ScheduledTransactionImpl();

		scheduledNow.addTransaction(trans);
		l.addScheduledTransaction(scheduledNow);

		l.getTransactions().clear();

	}

	@Test
	void schedule() throws ParseException {
		GregorianCalendar d = new GregorianCalendar();
		d.set(2015, 10, 5);
		Transaction trans = new TransactionImpl();
		trans.setDate(d);

		ScheduledTransactionImpl scheduledNow = new ScheduledTransactionImpl();
		l.schedule(d, scheduledNow);

		assertFalse(scheduledNow.getTransactions().isEmpty());
		l.getTransactions().clear();

	}
}
