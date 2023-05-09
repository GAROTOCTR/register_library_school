package entity;

import java.security.Timestamp;

public class Student {
    private int registration;
    private String name;
    private Timestamp created;
    private Timestamp modified;

    public int getRegistration(){
        return this.registration;
    }

    public String getName(){
        return this.name;
    }

    public Timestamp getDateCreated(){
        return this.created; 
    }

    public Timestamp getDateModified(){
        return this.modified;
    }

    public void setRegistration(int registration){
        this.registration = registration;
    }

    public void setName(String name){
        this.name = name;
    }
}
