package it.unicam.cs.pa.jbudget100763.model;

public class TagImpl implements Tag {

    private int id;
    private String name;
    private String description;

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

    public TagImpl(String name, String description){
        this.name=name;
        this.description=description;
    }
    
}