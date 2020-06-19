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
package it.unicam.cs.pa.jbudget100763.view;

import java.io.IOException;

/**
 * Ha la responsabilit� di indicare le direttive principali riguardo
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
