package animalShelter;

import java.sql.Connection;
import java.sql.DriverManager;

public class JDBC {
    String url = "jdbc:mysql://localhost:8889/LovelyPawsShelter";
    String username = "root";
    String password = "root";
    String jdbcName = "com.mysql.cj.jdbc.Driver";

    public Connection getCon() throws Exception{
        Class.forName(jdbcName);
        Connection con = DriverManager.getConnection(url,username,password);
        return con;
    }
    public void closeCon(Connection con) throws Exception{
        if(con != null){
            con.close();
        }
    }
//    public static void main(String[] args){
//        JDBC jdbc = new JDBC();
//        try{
//            jdbc.getCon();
//            System.out.println("success!");
//        }catch(Exception e){
//            e.printStackTrace();
//            System.out.println("failed!");
//        }
//    }
}
