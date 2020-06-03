import static org.junit.Assert.assertFalse;

import org.junit.jupiter.api.Test;

import it.unicam.cs.pa.jbudget100763.controller.Ledger;
import it.unicam.cs.pa.jbudget100763.controller.LedgerImpl;
import it.unicam.cs.pa.jbudget100763.model.Account;
import it.unicam.cs.pa.jbudget100763.model.AccountType;
import it.unicam.cs.pa.jbudget100763.model.Movement;
import it.unicam.cs.pa.jbudget100763.model.MovementImpl;
import it.unicam.cs.pa.jbudget100763.model.MovementType;
import it.unicam.cs.pa.jbudget100763.model.Transaction;
import it.unicam.cs.pa.jbudget100763.model.TransactionImpl;

public class AccountTest {

	
	@Test
	void getMovimentsTest() {

	Ledger l = LedgerImpl.getInstance();
	Account u = l.addAccount(AccountType.CASH, "Vittorio", "prova", 0.0);
	Transaction trans = new TransactionImpl();
	Movement moviment1 = new MovementImpl(MovementType.CREDIT, 200.60, trans, u);
	Movement moviment2= new MovementImpl(MovementType.CREDIT, 1000.60, trans, u);
	
	Transaction trans2 = new TransactionImpl();
	Movement moviment3= new MovementImpl(MovementType.DEBIT, 1000.60, trans2, u);
	

		assertFalse(u.getMovements().isEmpty());
	}
	

	@Test
	void getBalance() {
		Ledger l = LedgerImpl.getInstance();
		Account u = l.addAccount(AccountType.CASH, "Vittorio", "prova", 0.0);
		Transaction trans = new TransactionImpl();
		Movement moviment1 = new MovementImpl(MovementType.CREDIT, 200.60, trans, u);
		Movement moviment2= new MovementImpl(MovementType.CREDIT, 1000.60, trans, u);
		
		Transaction trans2 = new TransactionImpl();
		Movement moviment3= new MovementImpl(MovementType.DEBIT, 1000.60, trans2, u);
		
		assertFalse(u.getBalance()==0);

	}
}
