package it.unicam.cs.pa.jbudget100763.model;
/**tipologia di movimento (DEBITS, CREDITS). La tipologia di movimento determina l’effetto di un movimento su un conto. Infatti, il saldo d'un conto di tipo ASSET crescerà con movimenti di tipo CREDITS e diminuirà con movimenti di tipo DEBITS.  Viceversa, il saldo d’un conto di tipo LIABILITIES aumenterà con movimenti di tipo DEBITS e diminuirà con movimenti di tipo CREDITS. All’interno di una transazione i movimenti DEBITS saranno trattati sempre come negativi, quelli CREDITS come positivi. 
 */
public enum MovementType {
    DEBIT,
    CREDIT;
}