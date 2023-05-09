package DAO;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import conexao.Conexao;
import entity.Book;

public class BookDAO {
    public void insertBook(Book Book){
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");  
        LocalDateTime now = LocalDateTime.now(); 

        String sql = "INSERT INTO book (code, name, author, created, modified) VALUES (?, ?, ?, ?, ?)";

        PreparedStatement ps = null;

        try{
            ps = Conexao.getConexao().prepareStatement(sql);

            ps.setInt(1, Book.getCode());
            ps.setString(2, Book.getName());
            ps.setString(3, Book.getAuthor());
            ps.setTimestamp(4, java.sql.Timestamp.valueOf(dtf.format(now)));
            ps.setTimestamp(5, java.sql.Timestamp.valueOf(dtf.format(now)));

            ps.execute();
            ps.close();

        }catch(SQLException e){
            e.printStackTrace();
        }
    }
}
