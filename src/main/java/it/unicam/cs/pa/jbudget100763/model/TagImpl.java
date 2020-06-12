package it.unicam.cs.pa.jbudget100763.model;

import java.util.Map;

/**
 * ha la responsabilit� di definire una categoria di spesa/guadagno.
 * 
 * @author Vittorio
 *
 */
public class TagImpl implements Tag {

	private int id;
	private String name;
	private String description;

	private static Map<Integer, AccountImpl>registry;

	public static AccountImpl getInstance(int id) {
		if (registry.containsKey(id)) {
			return registry.get(id);
		} else {
			return new AccountImpl(id);
		}

	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public TagImpl(String name, String description) {
		this.name = name;
		this.description = description;
	}

}