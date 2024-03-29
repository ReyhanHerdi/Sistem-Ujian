/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import Model.SoalMTK;
import helper.KoneksiDB;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import com.mysql.jdbc.PreparedStatement;
import DAOInterface.IDAOSoalMTK;
/**
 *
 * @author DAFFA
 */
public class DAOSoalMTK implements IDAOSoalMTK{

    public DAOSoalMTK()
    {
        con = KoneksiDB.getConnection();
    }
    
    /**
     *
     * @param b
     */
    @Override
    public void insert(SoalMTK b) {
        PreparedStatement statement = null;
        try {
            statement = (PreparedStatement) con.prepareStatement(strInsert);
            
            statement.setInt(1, b.getId_soal());
            statement.setString(2, b.getPertanyaan());
            statement.setString(3, b.getJawaban());
            statement.execute();
        } catch (SQLException e) {
            System.out.println("tidak tampil:"+e);
        }
        finally {
            try {
                statement.close();
            } catch (SQLException ex) {
                System.out.println("tidak berhasil:"+ex);
            }
        }
    }
    
    /**
     *
     * @param b
     */
    @Override
    public void update(SoalMTK b) {
        PreparedStatement statement = null;
        try {
            statement = (PreparedStatement) con.prepareStatement(strUpdate);
            
            statement.setString(1, b.getPertanyaan());
            statement.setString(2, b.getJawaban());
            statement.setInt(3, b.getId_soal());
            statement.execute();
        } catch (SQLException e) {
            System.out.println("gagal update:"+e);
        }
        finally {
            try {
                statement.close();
            } catch (SQLException ex) {
                System.out.println("gagal update:"+ex);
            }
        }
    }
    
    @Override
    public void delete(int id_soal) {
        PreparedStatement statement = null;
        try {
            statement = (PreparedStatement) con.prepareStatement(strDelete);
            
            statement.setInt(1, id_soal);
            statement.execute();
        } catch (SQLException e) {
            System.out.println("gagal update:"+e);
        }
        finally {
            try {
                statement.close();
            } catch (SQLException ex) {
                System.out.println("gagal update:"+ex);
            }
        }
    }
   
    /**
     *
     * @return
     */
    @Override
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
                smtk.setId_soal(rs.getInt("id_soal"));
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
         
    Connection con;
    //SQL Query
    String strRead = "select * from soal_matematika;";
    String strInsert = "insert into soal_matematika(id_soal, pertanyaan, jawaban) VALUES (?,?,?);";
    String strUpdate = "update soal_matematika set pertanyaan=?, jawaban=? where id_soal=?";
    String strDelete = "delete from soal_matematika where id_soal=?";
            
}
