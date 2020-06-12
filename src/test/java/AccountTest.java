import static org.junit.Assert.assertFalse;

import java.util.GregorianCalendar;

import org.junit.jupiter.api.Test;

import it.unicam.cs.pa.jbudget100763.model.Account;
import it.unicam.cs.pa.jbudget100763.model.AccountType;
import it.unicam.cs.pa.jbudget100763.model.Ledger;
import it.unicam.cs.pa.jbudget100763.model.LedgerImpl;
import it.unicam.cs.pa.jbudget100763.model.Movement;
import it.unicam.cs.pa.jbudget100763.model.MovementImpl;
import it.unicam.cs.pa.jbudget100763.model.MovementType;
import it.unicam.cs.pa.jbudget100763.model.Transaction;

public class AccountTest {
	static Ledger l = LedgerImpl.getInstance();

	static boolean insert() {
		return l.addTransaction(new GregorianCalendar(2020, 6, 12));
	}

	static boolean again() {
		return l.addTransaction(new GregorianCalendar(2019, 2, 22));
	}

	Transaction first() {
		return l.getTransactions().stream().findFirst().get();
	}

	@Test
	void getMovimentsTest() {
		insert();
		Account u = l.addAccount(AccountType.CASH, "Vittorio", "prova", 0.0);
		Movement moviment1 = new MovementImpl(MovementType.INCOME, 200.60, first(), u);
		Movement moviment2 = new MovementImpl(MovementType.INCOME, 1000.60, first(), u);

		assertFalse(u.getMovements().isEmpty());
	}

	@Test
	void getBalance() {
		insert();

		Account u = l.addAccount(AccountType.CASH, "Vittorio", "prova", 0.0);
		Movement moviment1 = new MovementImpl(MovementType.INCOME, 200.60, first(), u);
		Movement moviment2 = new MovementImpl(MovementType.INCOME, 1000.60, first(), u);

		again();
		Movement moviment3 = new MovementImpl(MovementType.OUTCOME, 1000.60,
				l.getTransactions().stream().findAny().get(), u);
		assertFalse(u.getBalance() == 0);
	}

}
