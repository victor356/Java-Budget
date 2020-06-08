package it.unicam.cs.pa.jbudget100763.model;

import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Predicate;

/**
 * Ogni budget associa ad ogni tag un importo che indica l'ammontare di
 * spesa/guadagno previsto per il particolare tag. Ogni budget, inoltre,
 * costruisce il predicato per selezionare le transazioni di interesse.
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
	 * aggiunge un nuovo tag e relativo accantonamento al report
	 */
	@Override
	public void setBalance(Tag t, Double expected) {
		report.put(t, expected);
	}

	/**
	 * 
	 * @param condition - Predicate da rispettare
	 * @return i tag utilizzati nelle transazioni che rispettano una certa
	 *         condizione (es: avvenute in un determinato periodo di tempo)
	 */
	@Override
	public List<Tag> tags(Predicate<Transaction> condition) {
		List<Transaction> transactions = new ArrayList<Transaction>();
		List<Tag> tags = new ArrayList<Tag>();

		transactions.addAll(LedgerImpl.getInstance().getTransactions(condition));
		transactions.parallelStream().forEach(trans -> {
			trans.getTags().parallelStream().forEach(t -> {
				if (!tags.contains(t))
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