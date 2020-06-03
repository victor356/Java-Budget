package it.unicam.cs.pa.jbudget100763.model;

import java.util.List;
import java.util.function.Predicate;

/**
 * questa interfaccia è implementata dalle classi che hanno la responsabilità di
 * gestire un conto. Permette di accedere e modificare le informazioni del
 * conto: descrizione, saldo iniziale, tipologia. Consente inoltre di ottenere
 * il saldo attuale. Inoltre, è possibile accedere alla lista dei movimenti e
 * quelli che soddisfano un determinato predicato.
 */
public interface Account {
    String getName();

    String getDescription();

    int getId();

    double getOpeningBalance();

    double getBalance();

    List<Movement> getMovements();

    List<Movement> getMovements(Predicate<Movement> p);

    AccountType getType();

    void setType(AccountType a);

}