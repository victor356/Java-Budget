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
import java.util.Set;

/**
 * questa interfaccia � implementata dalle classi che hanno la responsabilit�
 * di gestire un singolo movimento. Permette di accedere e modificare le
 * informazioni associate al movimento: descrizione, importo, account associato,
 * lista dei tag associati al movimento. Le operazioni di lettura e modifica di
 * queste operazioni vengono effettuate per mezzo degli opportuni getter e
 * setter. I movimento � associato ad una transazione da cui deriva la data.
 */
public interface Movement {

	double getAmount();

	int getId();

	String getDescription();

	Transaction getTransaction();

	Account getAccount();

	void setAccount(Account a);

	GregorianCalendar getDate();

	Set<Tag> getTag();

	void addTag(Tag t);

	void removeTag(Tag t);

}