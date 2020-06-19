/*
This file is part of JBudget.

    JBudget is free software: you can redistribute it and/or modify
    it under the terms of the GNU General Public License as published by
    the Free Software Foundation, either version 3 of the License, or
    (at your option) any later version.

    Foobar is distributed in the hope that it will be useful,
    but WITHOUT ANY WARRANTY; without even the implied warranty of
    MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
    GNU General Public License for more details.

    You should have received a copy of the GNU General Public License
    along with Foobar.  If not, see <https://www.gnu.org/licenses/>.
*/
package it.unicam.cs.pa.jbudget100763.model;

import java.util.Map;

/**
 * ha la responsabilità di definire una categoria di spesa/guadagno.
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