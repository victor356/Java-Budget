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

import java.util.HashMap;
import java.util.Set;
import java.util.Map;
import java.util.function.Predicate;

/**
 * ha la responsabilità di mostrare il saldo di positivo/negativo di uno o più
 * Tag.
 * 
 * @author Vittorio
 *
 */
public class TagBudgetReportImpl implements TagBudgetReport {

	public TagBudgetReportImpl() {
	}

	/**
	 * @param transactions - lista delle transazioni da analizzare
	 * @return report - saldo complessivo di ogni distinto tag trovato nelle
	 *         transizioni in input
	 * 
	 */
	@Override
	public Map<Tag, Double> getTagBalance(Set<Transaction> transactions) {
		Map<Tag, Double> report = new HashMap<Tag, Double>();

		for (Tag ta : totalTags()) {
			double result = transactions.stream().filter(w -> w.getTags().contains((Tag) ta))
					.mapToDouble(x -> x.getTotalAmount()).sum();
			report.putIfAbsent(ta, result);
		}
		return report;
	}

	/**
	 * @return ritorna tutti i tag creati nell'applicazione
	 */
	@Override
	public Set<Tag> totalTags() {

		return LedgerImpl.getInstance().getTags();
	}

	/**
	 * @param condition - Predicate che le transazioni devono rispettare
	 * @return ritorna il bilancio di tutti i tag, ovvero di quelli trovati nelle
	 *         transazioni che rispettano il Predicato
	 */
	@Override
	public Map<Tag, Double> report(Predicate<Transaction> condition) {

		return getTagBalance(LedgerImpl.getInstance().getTransactions(condition));
	}

}