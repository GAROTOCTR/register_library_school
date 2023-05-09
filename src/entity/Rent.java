package entity;

import java.security.Timestamp;
import java.sql.Date;

public class Rent {
    private int id;
    private int student_id;
    private int book_id;
    private Date initial_date;
    private Date final_date;
    private Timestamp created;
    private Timestamp modified;

    public int getId(){
        return this.id;
    }

    public int getIdStudent(){
        return this.student_id;
    }

    public int getIdBook(){
        return this.book_id;
    }

    public Date getInitalDate(){
        return this.initial_date;
    }

    public Date getFinalDate(){
        return this.final_date;
    }

    public Timestamp getDateCreated(){
        return this.created;
    }

    public Timestamp getDateModified(){
        return this.modified;
    }
    
    public void setIdStudent(int id_student){
        this.student_id = id_student;
    }

    public void setIdBook(int id_book){
        this.book_id = id_book;
    }

    public void setInitalDate(Date inital_date){
        this.initial_date = inital_date;
    }

    public void setFinalDate(Date final_date){
        this.final_date = final_date;
    }
}
