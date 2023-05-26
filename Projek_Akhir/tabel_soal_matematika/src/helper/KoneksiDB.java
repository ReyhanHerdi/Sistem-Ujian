/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package helper;

//import com.mysql.jdbc.MySQLConnection;
import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;
import java.sql.Connection;

/**
 *
 * @author dappa
 */
public class KoneksiDB {
    static Connection con;
    
    public static Connection getConnection(){
        if (con == null) {
            MysqlDataSource data = new MysqlDataSource();
            data.setDatabaseName("db_sistemujian");
            data.setUser("root");
            data.setPassword("");
            
            try {
                con = data.getConnection();
                System.out.println("Koneksi berhasil");
            } catch (Exception e) {
                System.out.println("tidak konek");  
            }
        }
        return con;
    }
}