package DAO;

import java.time.format.DateTimeFormatter;  
import java.time.LocalDateTime;    

import java.sql.PreparedStatement;
import java.sql.SQLException;

import conexao.Conexao;
import entity.Rent;

public class RentDAO {
    public void insertRent(Rent Rent){
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");  
        LocalDateTime now = LocalDateTime.now(); 

        String sql = "INSERT rent (student_id, book_id, initial_date, final_date, created, modified) VALUES (?, ?, ?, ?, ?, ?)";
        
        PreparedStatement ps = null;
    
        try{
            ps = Conexao.getConexao().prepareStatement(sql);

            ps.setInt(1, Rent.getIdStudent());
            ps.setInt(2, Rent.getIdBook());
            ps.setDate(3, Rent.getInitalDate());
            ps.setDate(4, Rent.getFinalDate());
            ps.setTimestamp(5,java.sql.Timestamp.valueOf(dtf.format(now)));
            ps.setTimestamp(6, java.sql.Timestamp.valueOf(dtf.format(now)));

        }catch(SQLException e){
            e.printStackTrace();
        }

    }
}
