package it.unicam.cs.pa.jbudget100763.model;

import java.util.HashMap;
import java.util.Set;
import java.util.Map;
import java.util.function.Predicate;

/**
 * ha la responsabilit� di mostrare il saldo di positivo/negativo di uno o pi�
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
	 * @return report - saldo complessivo di ogni tag distinto trovato nelle transizioni in input
	 * 
	 */
	@Override
	public Map<Tag, Double> getTagBalance(Set<Transaction> transactions) {
		Map<Tag, Double> report = new HashMap<Tag, Double>();

		for (Tag ta : totalTags()) {
			double result = transactions.parallelStream().filter(w -> w.getTags().contains((Tag) ta))
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
	 * @return ritorna il bilancio di tutti i tag, ovvero quelli trovati nelle
	 *         transazioni che rispettano il Predicato
	 */
	@Override
	public  Map<Tag, Double> report(Predicate<Transaction> condition) {

		Set<Transaction> temp = LedgerImpl.getInstance().getTransactions(condition);

		return getTagBalance(temp);
	}

}