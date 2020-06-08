import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

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

	@Test
	void addMovement() {
		Transaction trans = new TransactionImpl();
		Tag t = new TagImpl("AUTO", "spese effettuate per manutenzione e uso dell'auto");
		Account u = l.addAccount(AccountType.CASH, "Francesco", "prova", 100.0);
		Movement m = new MovementImpl(MovementType.INCOME, 200.60, trans, u);
		assertFalse(trans.getMovements().isEmpty());

		trans.removeMovement(m);
		assertTrue(trans.getMovements().isEmpty());

	}

	@Test
	void TransactionAddTag() {
		Transaction trans = new TransactionImpl();

		assertTrue(trans.getTags().isEmpty());

		Tag t=l.addTag("AUTO", "spese effettuate per manutenzione e uso dell'auto");
		Account u = l.addAccount(AccountType.CASH, "Francesco", "prova", 100.0);

		Movement m = new MovementImpl(MovementType.INCOME, 200.60, trans, u);

		assertFalse(trans.getMovements().isEmpty()); // devono esserci movimenti
		
		m.addTag(t);
		assertFalse(trans.getTags().isEmpty()); // devono esserci tag anche nella transazione

		Tag y = t;
		trans.addTag(y);
		assertTrue(trans.getTags().stream().count() == 1); // don't add the same tag twice

		Tag i = new TagImpl("VACANZA", "effettuate durante le ferie");
		trans.addTag(i);
		assertTrue(trans.getTags().parallelStream().count() == 2); // should be 2 tags

	}
	
	@Test
	void TransactionRemoveTag() {
	Transaction trans = new TransactionImpl();
	l.addTag("AUTO", "spese effettuate per manutenzione e uso dell'auto");
	Account u = l.addAccount(AccountType.CASH, "Francesco", "prova", 100.0);
	String s = "AUTO";
	Movement m = new MovementImpl(MovementType.INCOME, 200.60, trans, u);
	
	trans.removeTag((Tag) l.getTags()
			.stream()
			.filter(x -> x.getName().equals(s))
			.toArray()[0]);
	
	assertTrue(trans.getTags().isEmpty());
	l.getTransactions().clear();


	}

	@Test
	void getBalance() {
		Transaction trans = new TransactionImpl();
		Account u = l.addAccount(AccountType.CASH, "Francesco", "prova", 100.0);

		Movement m1 = new MovementImpl(MovementType.INCOME, 100, trans, u);
		Movement m2 = new MovementImpl(MovementType.INCOME, 200.40, trans, u);
		Movement m3 = new MovementImpl(MovementType.INCOME, 700.60, trans, u);

		double amount=trans.getTotalAmount();
		assertTrue(amount==1001);
		l.getTransactions().clear();

		
	}
}
