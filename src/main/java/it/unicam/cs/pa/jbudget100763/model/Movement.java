package it.unicam.cs.pa.jbudget100763.model;

import java.util.GregorianCalendar;
import java.util.List;

/**
 * questa interfaccia è implementata dalle classi che hanno la responsabilità
 * di gestire un singolo movimento. Permette di accedere e modificare le
 * informazioni associate al movimento: descrizione, importo, account associato,
 * lista dei tag associati al movimento. Le operazioni di lettura e modifica di
 * queste operazioni vengono effettuate per mezzo degli opportuni getter e
 * setter. I movimento è associato ad una transazione da cui deriva la data.
 */
public interface Movement {

	double getAmount();

	int getId();

	String getDescription();

	Transaction getTransaction();

	Account getAccount();

	void setAccount(Account a);

	GregorianCalendar getDate();

	List<Tag> getTag();

	void addTag(Tag t);

	void removeTag(Tag t);

}