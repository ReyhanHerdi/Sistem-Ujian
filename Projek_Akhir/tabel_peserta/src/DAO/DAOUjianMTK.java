/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import DAOInterface.IDAOUjianMTK;
import Model.SoalMTK;
import com.mysql.jdbc.PreparedStatement;
import helper.KoneksiDB;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import Model.Peserta;

/**
 *
 * @author reyha
 */
public class DAOUjianMTK implements IDAOUjianMTK {
    public DAOUjianMTK()
    {
        con = KoneksiDB.getConnection();
    }
    
    public List<SoalMTK> getAll() {
        List<SoalMTK>lstSMTK = null;
        try
        {
            lstSMTK = new ArrayList<SoalMTK>();
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(strRead);
            while(rs.next())
            {
                SoalMTK smtk = new SoalMTK();
//                smtk.setId_soal(rs.getInt("id_soal"));
                smtk.setPertanyaan(rs.getString("pertanyaan"));
                smtk.setJawaban(rs.getString("jawaban"));
                lstSMTK.add(smtk);
            } 
            
        }
        catch(SQLException e) 
        {
            System.out.println("error"+e);
        }
        return lstSMTK;
    }
    
    public void update(Peserta b) {
        PreparedStatement statement = null;
        try {
            statement = (PreparedStatement) con.prepareStatement(strUpdate);
            
            statement.setInt(1, b.getSkor_mtk());
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
    String strRead = "select * from soal_matematika where id_soal=1;";
    String strUpdate = "update peserta set skor_mtk=? where id_peserta=?";
}
