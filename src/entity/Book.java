package entity;

import java.security.Timestamp;

public class Book {
    
    private int code;
    private String name;
    private String author;
    private Timestamp created;
    private Timestamp modified;


    public int getCode(){
        return this.code;
    }

    public String getName(){
        return this.name;
    }

    public String getAuthor(){
        return this.author;
    }

    public Timestamp getDateCreated(){
        return this.created;
    }

    public Timestamp getDateModified(){
        return this.modified;
    }

    public void setName(String name){
        this.name = name;
    }

    public void setAuthor(String author){
        this.author = author;
    }
}
