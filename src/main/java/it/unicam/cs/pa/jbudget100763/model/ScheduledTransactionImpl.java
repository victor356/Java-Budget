/*
This file is part of JBudget.

    JBudget is free software: you can redistribute it and/or modify
    it under the terms of the GNU General Public License as published by
    the Free Software Foundation, either version 3 of the License, or
    (at your option) any later version.

    JBudget is distributed in the hope that it will be useful,
    but WITHOUT ANY WARRANTY; without even the implied warranty of
    MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
    GNU General Public License for more details.

    You should have received a copy of the GNU General Public License
    along with JBudget.  If not, see <https://www.gnu.org/licenses/>.
*/
package it.unicam.cs.pa.jbudget100763.model;

import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.List;

/**
 * indica una transazione o una serie di transazioni schedulate (previste) ad
 * una certa data. La serie di transazioni termina quando il metodo
 * isCompleted() restituisce true.
 * 
 * @author Vittorio
 *
 */
public class ScheduledTransactionImpl implements ScheduledTransaction {

	private String description;
	private List<Transaction> trans = new ArrayList<Transaction>();
	private GregorianCalendar date;

	public ScheduledTransactionImpl(GregorianCalendar d) {
		this.date = d;
	}

	public GregorianCalendar getDate() {
		return this.date;
	}

	public void setDate(GregorianCalendar date) {
		this.date = date;
	};

	public List<Transaction> getTransactions() {
		return trans;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String desc) {
		this.description = desc;
	};



	/**
	 * @return conferma se la serie di transazioni si sia manifestata o meno
	 */
	@Override
	public boolean isCompleted() {

		return this.date.after(GregorianCalendar.getInstance());

	}

	/**
	 * 
	 * @param t transazione da schedulare
	 * @return se la transazione da inserire rispetta i requisiti della
	 *         scheduledTransaction
	 */
	public boolean addTransaction(Transaction t) {

		return (t.getDate() == getDate() ? getTransactions().add(t) : false);
	}
}