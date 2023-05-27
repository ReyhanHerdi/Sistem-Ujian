/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import DAOInterface.IDAOUjianBIndo;
import Model.Peserta;
import Model.SoalBIND;
import com.mysql.jdbc.PreparedStatement;
import helper.KoneksiDB;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author reyha
 */
public class DAOUjianBIndo implements IDAOUjianBIndo{
    
    public DAOUjianBIndo()
    {
        con = KoneksiDB.getConnection();
    }
    
    @Override
    public List<SoalBIND> getAll() {
        List<SoalBIND>lstSBIND = null;
        try
        {
            lstSBIND = new ArrayList<SoalBIND>();
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(strRead);
            while(rs.next())
            {
                SoalBIND sbind = new SoalBIND();
//                sbind.setId_soal(rs.getInt("id_soal"));
                sbind.setPertanyaan(rs.getString("pertanyaan"));
                sbind.setJawaban(rs.getString("jawaban"));
                lstSBIND.add(sbind);
            } 
            
        }
        catch(SQLException e) 
        {
            System.out.println("error"+e);
        }
        return lstSBIND;
    }

    @Override
    public void update(Peserta b) {
        PreparedStatement statement = null;
        try {
            statement = (PreparedStatement) con.prepareStatement(strUpdate);
            
            statement.setInt(1, b.getSkor_bind());
            statement.setInt(2, b.getId_peserta());
            statement.execute();
        } catch (SQLException e) {
            System.out.println("gagal oi:"+e);
        }
        finally {
            try {
                statement.close();
            } catch (SQLException ex) {
                System.out.println("gagal update:"+ex);
            }
        }
    }
    
    Connection con;
    String strRead = "select * from soal_bind where id_soal=1;";
    String strUpdate = "update peserta set skor_bind=? where id_peserta=?";
    
}
