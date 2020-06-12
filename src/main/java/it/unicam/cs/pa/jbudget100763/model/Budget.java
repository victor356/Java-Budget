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