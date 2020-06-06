package it.unicam.cs.pa.jbudget100763.model;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

import it.unicam.cs.pa.jbudget100763.controller.Ledger;
import it.unicam.cs.pa.jbudget100763.controller.LedgerImpl;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class AccountImpl implements Account {

	Ledger ledger = LedgerImpl.getInstance();
	private double balance;
	private String description;
	private int id;
	private List<Movement> movements=new ArrayList<Movement>();
	private String name;
	private double openingBalance;
	private AccountType type;

	public AccountImpl(AccountType type2, String name, double openingBalance2, String description2) {
		this.type = type2;
		this.name = name;
		this.openingBalance = openingBalance2;
		this.balance = openingBalance2;
		this.description = description2;

	}
	public static ObservableList<Account> list=FXCollections.observableArrayList(
        new AccountImpl(AccountType.ASSETS,"pippo",23,"ci si prova"),
		new AccountImpl(AccountType.CASH,"minni",53,"ci si prova")
        
    );

	public double getBalance() {
		for (Transaction t: ledger.getTransactions()) {
			for (Movement m: t.getMovements()) {
				if(m.getAccount().getName()==this.getName()) {
					this.balance+=m.getAmount();
				}
			}
		}
			
		return this.balance;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public List<Movement> getMovements() { // i movimenti a cui è correlato questo account verranno raccolti nella lista
											// personale di questo account (essi fanno parte delle transazioni e quindi
											// sono raccolti nel ledger)
		List<Movement> temp= new ArrayList<Movement>();
		for (Transaction trans : ledger.getTransactions()) {
			for (Movement mov : trans.getMovements()) {
				if (mov.getAccount().getName() == this.getName())
					temp.add(mov);
			}
		}
		this.movements.addAll(temp);
		return this.movements;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getOpeningBalance() {
		return this.openingBalance;
	}

	public void setOpeningBalance(double openingBalance) {
		this.openingBalance = openingBalance;
	}

	public AccountType getType() {
		return this.type;
	}

	public void setType(AccountType type) {
		this.type = type;
	}

	@Override
	public List<Movement> getMovements(Predicate<Movement> condition) {
		List<Movement> temp = new ArrayList<Movement>();

		for (Movement t : this.getMovements()) {
			if (t.getDate()!=null && condition.test(t)) {
				temp.add(t);

			}
		}
		return temp;
	}

}