package conexao;

import java.sql.Connection;
import java.sql.DriverManager;

public class Conexao {
    private static Connection conn;

    public static Connection getConexao() {
        try{
            if(conn == null){
                Class.forName("org.postgresql.Driver");
                conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/library-school", "postgres", "renner1207");
                return conn;
            }else{
                return conn;
            }
        }catch(Exception e){
            e.printStackTrace();
            return null;
        }
    }

}