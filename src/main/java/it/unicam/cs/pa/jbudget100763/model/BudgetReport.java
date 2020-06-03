package it.unicam.cs.pa.jbudget100763.model;

import java.util.List;
import java.util.Map;
import java.util.function.Predicate;

/*BudgetReport: ha la responsabilità di mostrare gli scostamenti di spesa/guadagno 
rispetto ad un particolare budget.Il BudgetReport viene costruito da un BudgetManager. 
*/
public interface BudgetReport {

	double balance = 0;

	List<Tag> tags();

	Map<Tag, Double> report();

	Budget getBudget();

	double getBalance(Tag t);

}