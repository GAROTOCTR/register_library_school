package DAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import conexao.Conexao;
import entity.Student;

public class StudentDAO {
    public void insertStudent(Student Student){

        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");  
        LocalDateTime now = LocalDateTime.now(); 
        
        String sql = "INSERT INTO student (registration, name, created, modified) VALUES (?, ?, ?, ?)";

        PreparedStatement ps = null;

        try{
            ps = Conexao.getConexao().prepareStatement(sql);

            ps.setInt(1, Student.getRegistration());
            ps.setString(2, Student.getName());
            ps.setTimestamp(3, java.sql.Timestamp.valueOf(dtf.format(now)));
            ps.setTimestamp(4, java.sql.Timestamp.valueOf(dtf.format(now)));

            ps.execute();
            ps.close();

        }catch(SQLException e){
            e.printStackTrace();
        }
    }

    public void getAllStudents(){

        String sql = "SELECT * FROM student";

        try{
            ResultSet rsStudents = Conexao.getConexao().createStatement().executeQuery(sql);
            
            while(rsStudents.next()){
                System.out.println("Registration: " + rsStudents.getString("registration"));
                System.out.println("Name: " + rsStudents.getString("name"));
                System.out.println("Created: " + rsStudents.getTimestamp("created"));
                System.out.println("Modified" + rsStudents.getTimestamp("modified"));

                System.out.println("================================================");
            }

            if(Conexao.getConexao() != null){
                Conexao.getConexao().close();
            }
            
        }catch(SQLException e){
            e.printStackTrace();
        }
    }

    public void updateStudent(int registration, String name){
        String sql = "UPDATE student SET registration = " + registration + ", name = " + name + " WHERE registration = " + registration;
        
        try{
            Conexao.getConexao().createStatement().executeQuery(sql);

            if(Conexao.getConexao() != null){
                Conexao.getConexao().close();
            }
        }catch(SQLException e){
             e.printStackTrace();
        }
    }

    public void getOnlyStudent(int registration){
        String sql = "SELECT * FROM student WHERE registration =" + registration;

        try{
            ResultSet rsStudent = Conexao.getConexao().createStatement().executeQuery(sql);

            if(rsStudent.next()){
                System.out.println("Registration: " + rsStudent.getString("registration"));
                System.out.println("Name: " + rsStudent.getString("name"));
                System.out.println("Created: " + rsStudent.getTimestamp("created"));
                System.out.println("Modified" + rsStudent.getTimestamp("modified"));
    
                System.out.println("================================================");
            
            }else{
                System.out.println("NENHUM ESTUDANTE ENCONTRADO!");
            }

            if(Conexao.getConexao() != null){
                Conexao.getConexao().close();
            }
        }catch(SQLException e){
            e.printStackTrace();
        }
    }
}
