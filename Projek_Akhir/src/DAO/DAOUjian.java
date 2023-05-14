/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import Interface.IDAOUjian;
//import com.mysql.jdbc.Statement;
import java.sql.Statement;
import java.sql.ResultSet;
import helper.KoneksiDB;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
//import model.tbl_ujian;
import model.ujian;

/**
 *
 * @author reyha
 */
public class DAOUjian implements IDAOUjian{

    public DAOUjian(){
        con = KoneksiDB.getConnection();
    }
    
    /**
     *
     * @return
     */
    @Override
    public List<ujian> getAll() {
        List<ujian> tblUjian = null;
        try {
            tblUjian = new ArrayList<>();
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(strRead);
            
            while (rs.next()) {
                ujian ujn = new ujian(); 
                ujn.setId_ujian(rs.getInt("id_ujian"));
                ujn.setNama_matpel(rs.getString("nama_matpel"));
                ujn.setJumlah_soal(rs.getInt("jumlah_Soal"));
                tblUjian.add(ujn);
            }
        } catch (SQLException e) {
            System.out.println("tidak tampil:"+e);
        }
        return tblUjian;

    }
    
    Connection con;
    String strRead = "select * from ujian;";
    
}
