package it.unicam.cs.pa.jbudget100763.model;

import java.util.List;
import java.util.Map;

import it.unicam.cs.pa.jbudget100763.controller.Ledger;

public class BudgetReportImpl implements BudgetReport {

	// private double balance;
	private Ledger l;
	private Budget b;

	public BudgetReportImpl(Ledger l, Budget b) {
		this.l = l;
		this.b = b;
	}

	@Override
	public double getBalance(Tag t) {
		double result = 0;

		result = l.getTransactions().parallelStream().filter(w -> w.getTags().contains((Tag) t)) // filtra tutte le transazioni che hanno quel tag
				.mapToDouble(x -> x.getTotalAmount()) 											// somma l'importo di tutte queste transazioni
				.sum();

		return result; // ritorna amount
	}

	@Override
	public Budget getBudget() {
		return this.b;
	}

	@Override
	public Map<Tag, Double> report() {
		Map<Tag, Double> report = Map.of();		//ottenere tag distinti ed il loro totale

		for (Tag ta : tags()) {
			report.putIfAbsent(ta, getBalance(ta));	//calcolare il bilancio di ogni tag
		}

		return report;
	}

	@Override
	public List<Tag> tags() {
		return l.getTags();
	}

}