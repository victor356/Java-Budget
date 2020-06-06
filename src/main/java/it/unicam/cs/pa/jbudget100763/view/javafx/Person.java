package it.unicam.cs.pa.jbudget100763.view.javafx;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class Person {
    String nome;
    Integer eta;

    public Person(String nome, Integer eta) {
        this.nome = nome;
        this.eta = eta;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Integer getEta() {
        return eta;
    }

    public void setEta(Integer eta) {
        this.eta = eta;
    }
    public static ObservableList<Person> list = FXCollections.observableArrayList(
        new Person("pippo",23),
        new Person("baaaaa",44)
        
    );
}