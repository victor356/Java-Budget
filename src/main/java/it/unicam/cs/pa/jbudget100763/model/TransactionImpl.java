package it.unicam.cs.pa.jbudget100763.model;

import java.util.HashSet;
import java.util.GregorianCalendar;
import java.util.Set;

/**
 * ha la responsabilità di gestire una transazione. Permette di accedere e
 * modificare la informazioni associate ad una transazione: lista dei tag, data,
 * movimenti. Un tag associato (o rimosso) ad una transazione viene aggiunto (o
 * rimosso) ad ogni movimento della transazione. La transazione ha anche un
 * saldo (ottenibile tramite il metodo getTotalAmount()) che permette di
 * ottenere la somma totale dei movimenti interni alla transazione.
 * 
 * @author Vittorio
 *
 */
public class TransactionImpl implements Transaction {

	private int id;
	private Set<Movement> movements = new HashSet<Movement>();
	private GregorianCalendar date;

	/**
	 * La classe viene inserita automaticamente nella lista del ledger -- da
	 * rimuovere
	 */
	public TransactionImpl( GregorianCalendar date) {
		this.date = date;
		this.id=date.hashCode();
		
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Set<Movement> getMovements() {
		return this.movements;
	}

	public GregorianCalendar getDate() {
		return this.date;
	}

	public void setDate(GregorianCalendar date) {
		this.date = date;
	}

	@Override
	public void addMovement(Movement m) {
		movements.add(m);
	}

	@Override
	public void removeMovement(Movement m) {
		movements.remove(m);
	}

	/**
	 * @return Get a distinct tags list from all the movements
	 */
	public Set<Tag> getTags() {
		Set<Tag> tags = new HashSet<Tag>();

		movements.parallelStream().forEach(mov -> {
			mov.getTag().parallelStream().forEach(tag -> {
				if (!tags.contains(tag))
					tags.add(tag);
			});
		});
		return tags;
	}

	/**
	 * @param t - Tag da inserire a tutti i movimenti della transazione e
	 *          automaticamente alla transazione stessa
	 * 
	 */
	@Override
	public void addTag(Tag t) {
		movements.parallelStream().forEach(m -> {
			if (!m.getTag().contains((Tag) t))
				m.addTag(t);
		});

	}

	@Override
	public void removeTag(Tag t) {
		for (Movement m : movements) {
			if (m.getTag().contains((Tag) t))
				m.removeTag(t);
		}
	}

	/**
	 * @return somma algebrica del valore di tutti i movimenti contenuti
	 */
	@Override
	public double getTotalAmount() {
		double total = 0;
		for (Movement m : movements) {
			total += m.getAmount();
		}

		return total;
	}

}