package it.unicam.cs.pa.jbudget100763.model;

import java.util.List;
import java.util.Map;
import java.util.function.Predicate;

/* ha la responsabilit� di mostrare il saldo di spesa/guadagno 
 * di uno o pi� Tag. 
*/
public interface TagBudgetReport {

	List<Tag> totalTags();

	Map<Tag, Double> getTagBalance(List<Transaction> transactions);

	Map<Tag, Double> report(Predicate<Transaction> condition);
}