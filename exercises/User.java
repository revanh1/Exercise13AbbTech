package org.abbtech.lesson2.exercises;

public class User {
    private Long id;
    private String name;
    private boolean isActive;

    //constructor
    public User(Long id, String name, boolean isActive) {
        this.id = id;
        this.name = name;
        this.isActive = isActive;
    }

    //get and set
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    //get method for isActive like that
    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean active) {
        isActive = active;
    }

}
