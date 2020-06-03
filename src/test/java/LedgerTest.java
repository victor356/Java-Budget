import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.jupiter.api.Test;

import it.unicam.cs.pa.jbudget100763.controller.Ledger;
import it.unicam.cs.pa.jbudget100763.controller.LedgerImpl;
import it.unicam.cs.pa.jbudget100763.model.Account;
import it.unicam.cs.pa.jbudget100763.model.AccountType;
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
		Date d = new SimpleDateFormat("yyyyMMdd").parse("20210520");
		Date d1 = new SimpleDateFormat("yyyyMMdd").parse("20210520");

		Transaction trans = new TransactionImpl();
		trans.setDate(d);
		System.out.println(trans.getDate());
		List<Transaction> list = new ArrayList<Transaction>();
		list.addAll(l.getTransactions(l.getTransactions(),
				(x) -> x.getDate().getYear()==d1.getYear() && x.getDate().getMonth()==d1.getMonth() && x.getDate().getDay()==d1.getDay()));
		assertFalse(list.isEmpty());
	}

	@Test
	void addScheduled() throws ParseException {

		Transaction trans = new TransactionImpl();
		Date d = new SimpleDateFormat("yyyyMMdd").parse("20210520");
		trans.setDate(d);

		ScheduledTransactionImpl scheduledNow = new ScheduledTransactionImpl();

		scheduledNow.addTransaction(trans);
		l.addScheduledTransaction(scheduledNow);

		l.getTransactions().clear();

	}

	@Test
	void schedule() throws ParseException {
		Date d = new SimpleDateFormat("yyyyMMdd").parse("20210520");
		Transaction trans = new TransactionImpl();
		trans.setDate(d);

		ScheduledTransactionImpl scheduledNow = new ScheduledTransactionImpl();
		l.schedule(d, scheduledNow);

		assertFalse(scheduledNow.getTrans().isEmpty());
		l.getTransactions().clear();

	}
}
