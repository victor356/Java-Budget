package it.unicam.cs.pa.jbudget100763.model;

import java.util.List;
import java.util.function.Predicate;

/**
 * ha la responsabilità di rappresentare e gestire un particolare budget. Ogni
 * budget associa ad ogni tag un importo che indica l’ammontare di
 * spesa/guadagno per il particolare tag. Ogni budget, inoltre, costruisce il
 * predicato per selezionare i movimenti di interesse. E’ responsabilità delle
 * sottoclassi definire i criteri per la selezione dei movimenti.
 */
public interface Budget {

    List<Tag> tags();

    double getBalance(Tag t);

    void setBalance(Tag t, Double expected);

    Predicate<Transaction> getPredicate();
}