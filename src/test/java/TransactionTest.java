import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.GregorianCalendar;

import org.junit.jupiter.api.Test;

import it.unicam.cs.pa.jbudget100763.model.Account;
import it.unicam.cs.pa.jbudget100763.model.AccountType;
import it.unicam.cs.pa.jbudget100763.model.Ledger;
import it.unicam.cs.pa.jbudget100763.model.LedgerImpl;
import it.unicam.cs.pa.jbudget100763.model.Movement;
import it.unicam.cs.pa.jbudget100763.model.MovementImpl;
import it.unicam.cs.pa.jbudget100763.model.MovementType;
import it.unicam.cs.pa.jbudget100763.model.Tag;
import it.unicam.cs.pa.jbudget100763.model.TagImpl;
import it.unicam.cs.pa.jbudget100763.model.Transaction;
import it.unicam.cs.pa.jbudget100763.model.TransactionImpl;

public class TransactionTest {
	Ledger l = LedgerImpl.getInstance();
	boolean insert = l.addTransaction(new GregorianCalendar());

	Transaction first() {
		return l.getTransactions().stream().findFirst().get();
	}

	@Test
	void addMovement() {
		if (insert) {

			Tag t = new TagImpl("AUTO", "spese effettuate per manutenzione e uso dell'auto");
			Account u = l.addAccount(AccountType.CASH, "Francesco", "prova", 100.0);
			Movement m = new MovementImpl(MovementType.INCOME, 200.60, first(), u);
			assertFalse(first().getMovements().isEmpty());

			first().removeMovement(m);
			assertTrue(first().getMovements().isEmpty());
		}
	}

	@Test
	void TransactionAddTag() {
		if (insert) {

			assertTrue(first().getTags().isEmpty());

			Tag t = l.addTag("AUTO", "spese effettuate per manutenzione e uso dell'auto");
			Account u = l.addAccount(AccountType.CASH, "Francesco", "prova", 100.0);

			Movement m = new MovementImpl(MovementType.INCOME, 200.60, first(), u);

			assertFalse(first().getMovements().isEmpty()); // devono esserci movimenti

			m.addTag(t);
			assertFalse(first().getTags().isEmpty()); // devono esserci tag anche nella transazione

			Tag y = t;
			first().addTag(y);
			assertTrue(first().getTags().stream().count() == 1); // don't add the same tag twice

			Tag i = new TagImpl("VACANZA", "effettuate durante le ferie");
			first().addTag(i);
			assertTrue(first().getTags().parallelStream().count() == 2); // should be 2 tags
		}
	}

	@Test
	void TransactionRemoveTag() {
		if (insert) {
			l.addTag("AUTO", "spese effettuate per manutenzione e uso dell'auto");
			Account u = l.addAccount(AccountType.CASH, "Francesco", "prova", 100.0);
			String s = "AUTO";
			Movement m = new MovementImpl(MovementType.INCOME, 200.60, first(), u);

			first().removeTag((Tag) l.getTags().stream().filter(x -> x.getName().equals(s)).toArray()[0]);

			assertTrue(first().getTags().isEmpty());
			l.getTransactions().clear();
		}
	}

	@Test
	void getBalance() {
		if (insert) {
			Account u = l.addAccount(AccountType.CASH, "Francesco", "prova", 100.0);

			Movement m1 = new MovementImpl(MovementType.INCOME, 100, first(), u);
			Movement m2 = new MovementImpl(MovementType.INCOME, 200.40, first(), u);
			Movement m3 = new MovementImpl(MovementType.INCOME, 700.60, first(), u);

			double amount = first().getTotalAmount();
			assertTrue(amount == 1001);
			l.getTransactions().clear();
		}
	}
}
