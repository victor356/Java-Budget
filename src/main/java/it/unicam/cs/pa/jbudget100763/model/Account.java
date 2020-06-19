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

import java.util.Set;
import java.util.function.Predicate;

/**
 * questa interfaccia è implementata dalle classi che hanno la responsabilit�
 * di gestire un conto. Permette di accedere e modificare le informazioni del
 * conto: descrizione, saldo iniziale, tipologia. Consente inoltre di ottenere
 * il saldo attuale. Inoltre, � possibile accedere alla lista dei movimenti e
 * quelli che soddisfano un determinato predicato.
 */
public interface Account {
	String getName();

	String getDescription();

	int getId();

	double getOpeningBalance();

	double getBalance();

	Set<Movement> getMovements();

	Set<Movement> getMovements(Predicate<Movement> p);

	AccountType getType();

	void setType(AccountType a);

}