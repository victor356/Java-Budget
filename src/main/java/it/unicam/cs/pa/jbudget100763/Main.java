/*
This file is part of JBudget.

    JBudget is free software: you can redistribute it and/or modify
    it under the terms of the GNU General Public License as published by
    the Free Software Foundation, either version 3 of the License, or
    (at your option) any later version.

    JBudget is distributed in the hope that it will be useful,
    but WITHOUT ANY WARRANTY; without even the implied warranty of
    MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
    GNU General Public License for more details.

    You should have received a copy of the GNU General Public License
    along with JBudget.  If not, see <https://www.gnu.org/licenses/>.
*/
package it.unicam.cs.pa.jbudget100763;

import it.unicam.cs.pa.jbudget100763.view.javafx.App;

import javafx.application.Application;
/**
 * Main eseguibile dell'applicazione
 * @author Vittorio
 * 
 */
public class Main {

	private static void launchGui() {
		Application.launch(App.class);
	}

	public static void main(String[] args) {
		launchGui();
	}

}