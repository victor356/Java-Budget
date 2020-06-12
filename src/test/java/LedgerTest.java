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
public class LedgerTest {

	static Ledger l = LedgerImpl.getInstance();

	static boolean insert() {

		return l.addTransaction(new GregorianCalendar());
	}
	Transaction first() {
		return l.getTransactions().stream().findFirst().get();
	}

	@Test
	void addAccount() {

		Account u = l.addAccount(AccountType.CASH, "Vittorio", "prova", 0.0);
		assertTrue(!l.getAccounts().isEmpty());
	}

	@Test
	void addTag() {
		insert();
		Tag t = l.addTag("AUTO", "spese effettuate per manutenzione e uso dell'auto");
		assertFalse(l.getTags().isEmpty());

		l.removeTag(t);
		assertTrue(l.getTags().isEmpty());

	}

	@Test
	void addTransaction() {
		assertTrue(insert());
		l.getTransactions().clear();

	}

	@Test
	void PredicateTransaction() throws ParseException {
		GregorianCalendar d = new GregorianCalendar(2015, 10, 5);
		GregorianCalendar d1 = new GregorianCalendar(2015, 10, 5);
		insert();
		first().setDate(d);
		System.out.println(first().getDate());
		List<Transaction> list = new ArrayList<Transaction>();
		list.addAll(l.getTransactions((x) -> x.getDate().equals(d1)));
		assertFalse(list.isEmpty());
	}

	@Test
	void addScheduled() throws ParseException {
		insert();
		GregorianCalendar d = new GregorianCalendar(2015, 10, 5);

		first().setDate(d);

		ScheduledTransactionImpl scheduledNow = new ScheduledTransactionImpl(d);

		assertTrue(scheduledNow.addTransaction(first()));
	}

	@Test
	void schedule() throws ParseException {
		GregorianCalendar d = new GregorianCalendar(2015, 10, 5);
		insert();
		first().setDate(d);
		ScheduledTransactionImpl scheduledNow = new ScheduledTransactionImpl(d);
		l.schedule(scheduledNow);
		assertFalse(scheduledNow.getTransactions().isEmpty());

	}
}
