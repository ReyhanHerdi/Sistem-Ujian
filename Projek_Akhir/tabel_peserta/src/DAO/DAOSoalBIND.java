/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import Model.SoalBIND;
import helper.KoneksiDB;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import com.mysql.jdbc.PreparedStatement;
import DAOInterface.IDAOSoalBIND;
import Model.ujian;
import javax.swing.JOptionPane;
/**
 *
 * @author DAFFA
 */
public class DAOSoalBIND implements IDAOSoalBIND{

    public DAOSoalBIND()
    {
        con = KoneksiDB.getConnection();
    }
    
    /**
     *
     * @param b
     */
    @Override
    public void insert(SoalBIND b) {
        PreparedStatement statement = null;
        try {
            statement = (PreparedStatement) con.prepareStatement(strInsert);
            statement.setInt(1, b.getId_soal());
            statement.setString(2, b.getPertanyaan());
            statement.setString(3, b.getJawaban());
            statement.execute();
            
            JOptionPane.showMessageDialog(null, "input berhasil");
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
    public void update(SoalBIND b) {
        PreparedStatement statement = null;
        try {
            statement = (PreparedStatement) con.prepareStatement(strUpdate);
            
            statement.setString(1, b.getPertanyaan());
            statement.setString(2, b.getJawaban());
            statement.setInt(3, b.getId_soal());
            statement.execute();
            
            JOptionPane.showMessageDialog(null, "update berhasil");
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
            int confirm = JOptionPane.showConfirmDialog(null, "hapus data?");
            
            if (confirm == 0) {
                statement = (PreparedStatement) con.prepareStatement(strDelete);
            
                statement.setInt(1, id_soal);
                statement.execute();

                JOptionPane.showMessageDialog(null, "delete berhasil");
            }
        } catch (SQLException e) {
            System.out.println("gagal delete:"+e);
        }
        finally {
            try {
                statement.close();
            } catch (SQLException ex) {
                System.out.println("gagal delete:"+ex);
            }
        }
    }
   
    /**
     *
     * @return
     */
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
                SoalBIND smtk = new SoalBIND();
                smtk.setId_soal(rs.getInt("id_soal"));
                smtk.setPertanyaan(rs.getString("pertanyaan"));
                smtk.setJawaban(rs.getString("jawaban"));
                lstSBIND.add(smtk);
            } 
            
        }
        catch(SQLException e) 
        {
            System.out.println("error"+e);
        }
        return lstSBIND;
    }
    public int count() {
        PreparedStatement statement = null;
        try {
//            statement = (PreparedStatement) con.prepareStatement(strCount);
//            statement.execute();
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(strCount);
            rs.next();
            int count =rs.getInt(1);

            return count;
        } catch (Exception e) {
            System.out.println("gak count"+e);
            
            return 0;
        }  
    }
    
    @Override
    public void updateTabelUjian(ujian b){
        PreparedStatement statement = null;
        try {
            statement = (PreparedStatement) con.prepareStatement(strUpdateTabelUjian);
            
            //statement.setInt(1, b.getId_ujian());
            statement.setInt(1, b.getJumlah_soal());
            statement.execute();
        } catch (SQLException e) {
            System.out.println("update gagal:"+e);
        }
        finally {
            try {
                statement.close();
            } catch (SQLException ex) {
                System.out.println("update gagal:"+ex);
            }
        }
    }
         
    Connection con;
    //SQL Query
    String strRead = "select * from soal_bind;";
    String strInsert = "insert into soal_bind(id_soal, pertanyaan, jawaban) VALUES (?,?,?);";
    String strUpdate = "update soal_bind set pertanyaan=?, jawaban=? where id_soal=?";
    String strDelete = "delete from soal_bind where id_soal=?";
    String strCount = "select count(*) from soal_bind;";
    String strUpdateTabelUjian = "update ujian set jumlah_soal=? where id_ujian=2" ;
            
}
