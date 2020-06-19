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
import java.util.Map;
import java.util.function.Predicate;

/* ha la responsabilità di mostrare il saldo di spesa/guadagno 
 * di uno o più Tag. 
*/
public interface TagBudgetReport {

	Set<Tag> totalTags();

	Map<Tag, Double> getTagBalance(Set<Transaction> transactions);

	Map<Tag, Double> report(Predicate<Transaction> condition);
}