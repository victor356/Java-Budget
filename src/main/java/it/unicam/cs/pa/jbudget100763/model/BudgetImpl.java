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
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.function.Predicate;

/**
 * Ogni budget associa ad ogni tag un importo che indica l'ammontare di
 * spesa/guadagno previsto per il particolare tag. Ogni budget, inoltre,
 * costruisce il predicato per considerare solo le transazioni di interesse.
 * 
 * @author Vittorio
 *
 */
public class BudgetImpl implements Budget {

	private Map<Tag, Double> report = new HashMap<Tag, Double>();

	/**
	 * @param t - Tag di cui si desidera sapere il budget
	 * @return la cifra accantonata (prevista) per quel tag
	 */
	@Override
	public double getBalance(Tag t) {
		if (report.containsKey(t)) {

			return report.get(t);
		}
		return 0;
	}

	/**
	 * aggiunge un nuovo tag e relativo accantonamento previsto, al report
	 */
	@Override
	public void setBalance(Tag t, Double expected) {
		report.put(t, expected);
	}

	/**
	 * 
	 * @param condition - Predicate da rispettare
	 * @return ritorna i tag utilizzati nelle transazioni che rispettano una certa
	 *         condizione (es: avvenute in un determinato periodo di tempo)
	 */
	@Override
	public Set<Tag> tags(Predicate<Transaction> condition) {
		Set<Tag> tags = new HashSet<Tag>();

		LedgerImpl.getInstance().getTransactions(condition).parallelStream().forEach(trans -> {
			trans.getTags().parallelStream().forEach(t -> {
				tags.add(t);
			});
		});

		return tags;

	}

	/**
	 * @return lambda expression per definire una transazione avvenuta dopo la certa
	 *         data
	 */
	@Override
	public Predicate<Transaction> after(GregorianCalendar date) {
		return (transaction -> transaction.getDate().after(date));

	}

	/**
	 * @return lambda expression per definire una transazione avvenuta prima della
	 *         certa data
	 */
	@Override
	public Predicate<Transaction> before(GregorianCalendar date) {
		return (transaction -> transaction.getDate().before(date));

	}

}