import org.junit.jupiter.api.Test;

import static org.junit.Assert.*;

import java.util.Date;

import it.unicam.cs.pa.jbudget100763.controller.*;
import it.unicam.cs.pa.jbudget100763.model.*;

public class TransactionTest {
	Ledger l = LedgerImpl.getInstance();

	@Test
	void addMovement() {
		Transaction trans = new TransactionImpl();
		Tag t = new TagImpl("AUTO", "spese effettuate per manutenzione e uso dell'auto");
		Account u = l.addAccount(AccountType.CASH, "Francesco", "prova", 100.0);
		Movement m = new MovementImpl(MovementType.CREDIT, 200.60, trans, u);
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

		Movement m = new MovementImpl(MovementType.CREDIT, 200.60, trans, u);

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
	Movement m = new MovementImpl(MovementType.CREDIT, 200.60, trans, u);
	
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

		Movement m1 = new MovementImpl(MovementType.CREDIT, 100, trans, u);
		Movement m2 = new MovementImpl(MovementType.CREDIT, 200.40, trans, u);
		Movement m3 = new MovementImpl(MovementType.CREDIT, 700.60, trans, u);

		double amount=trans.getTotalAmount();
		assertTrue(amount==1001);
		l.getTransactions().clear();

		
	}
}
