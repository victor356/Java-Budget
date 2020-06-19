/*
This file is part of JBudget.

    JBudget is free software: you can redistribute it and/or modify
    it under the terms of the GNU General Public License as published by
    the Free Software Foundation, either version 3 of the License, or
    (at your option) any later version.

    Foobar is distributed in the hope that it will be useful,
    but WITHOUT ANY WARRANTY; without even the implied warranty of
    MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
    GNU General Public License for more details.

    You should have received a copy of the GNU General Public License
    along with Foobar.  If not, see <https://www.gnu.org/licenses/>.
*/
package it.unicam.cs.pa.jbudget100763.model;

import java.util.GregorianCalendar;
import java.util.List;

/**
 * indica una transazione o una serie di transazioni schedulate (previste) ad
 * una certa data. La serie di transazioni termina quando il metodo
 * isCompleted() restituisce true.
 */
public interface ScheduledTransaction {

	GregorianCalendar getDate();

	String getDescription();

	List<Transaction> getTransactions();

	boolean isCompleted();

	void setDescription(String desc);

	boolean addTransaction(Transaction transaction);

}