package it.unicam.cs.pa.jbudget100763.view;

import java.io.IOException;

/**
 * Ha la responsabilità di indicare le direttive principali riguardo
 * l'interazione dell'utente con l'applicazione
 * 
 * @author Vittorio
 *
 */
public interface View {
	void manageAccount() throws IOException;

	void createAccount() throws IOException;

	void deleteAccount() throws IOException;

	void manageTag() throws IOException;

	void createTag() throws IOException;
}
