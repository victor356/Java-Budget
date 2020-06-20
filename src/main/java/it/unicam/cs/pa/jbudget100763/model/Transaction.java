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

import java.util.GregorianCalendar;
import java.util.Set;

/**
 * questa interfaccia è implementata dalle classi che hanno la responsabilità
 * di gestire una transazione. Permette di accedere e modificare la informazioni
 * associate ad una transazione: lista dei tag, data, movimento. Un tag
 * associato (o rimosso) ad una transazione viene aggiunto (o rimosso) ad ogni
 * movimento della transazione. La transazione ha anche un saldo (ottenibile
 * tramite il metodo getTotalAmount()) che permette di ottenere la variazione
 * totale dei movimenti della transazione.
 */
public interface Transaction {

	int getId();

	Set<Movement> getMovements();

	void addMovement(Movement m);

	void removeMovement(Movement m);

	double getTotalAmount();

	Set<Tag> getTags();

	void addTag(Tag t);

	void removeTag(Tag t);

	GregorianCalendar getDate();

	void setDate(GregorianCalendar d);

}