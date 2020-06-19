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
package it.unicam.cs.pa.jbudget100763.view.javafx;

import it.unicam.cs.pa.jbudget100763.controller.Controller;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class TagController {

    /**
     * new Tag scene
     */

    @FXML
    private TextField TagNameField = new TextField();

    @FXML
    private TextField TagDescriptionField = new TextField();

    @FXML
    private Button alertButton;

    @FXML
    private Button closeButton;

    private Controller controller = new Controller();

    @FXML
    void newTag() {
      
        controller.addTag(TagNameField.getText(), TagDescriptionField.getText());
        
        Stage stage = (Stage) closeButton.getScene().getWindow();
        stage.close();

    }

    @FXML
    private void closeButtonAction() {

        Stage stage = (Stage) closeButton.getScene().getWindow();
        stage.close();
    }

}