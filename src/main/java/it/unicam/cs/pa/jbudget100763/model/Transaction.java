package it.unicam.cs.pa.jbudget100763.model;

import java.util.GregorianCalendar;
import java.util.List;

/**
 * questa interfaccia è implementata dalle classi che hanno la responsabilità 
 * di gestire una transazione. Permette di accedere e modificare la informazioni
 * associate ad una transazione: lista dei tag, data, movimento. Un tag
 * associato (o rimosso) ad una transazione viene aggiunto (o rimosso) ad ogni
 * movimento della transazione. La transazione ha anche un saldo (ottenibile
 * tramite il metodo getTotalAmount()) che permette di ottenere la variazione
 * totale dei movimenti della transazione.
 */
public interface Transaction {

	int getId();

	List<Movement> getMovements();

	void addMovement(Movement m);

	void removeMovement(Movement m);

	double getTotalAmount();

	List<Tag> getTags();

	void addTag(Tag t);

	void removeTag(Tag t);

	GregorianCalendar getDate();

	void setDate(GregorianCalendar d);

}