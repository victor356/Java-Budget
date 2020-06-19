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
import java.util.function.Predicate;

/**
 * ha la responsabilit� di rappresentare e gestire un particolare budget. Ogni
 * budget associa ad ogni tag un importo che indica l'ammontare di
 * spesa/guadagno previsto per il particolare tag. Ogni budget, inoltre,
 * costruisce il predicato per selezionare le transazioni di interesse.
 */
public interface Budget {

	double getBalance(Tag t);

	void setBalance(Tag t, Double expected);

	Predicate<Transaction> after(GregorianCalendar date);

	Predicate<Transaction> before(GregorianCalendar date);

	Set<Tag> tags(Predicate<Transaction> condition);

}