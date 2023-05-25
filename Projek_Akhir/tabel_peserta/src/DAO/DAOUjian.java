/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import DAOInterface.IDAOUjian;
import com.mysql.jdbc.PreparedStatement;
//import com.mysql.jdbc.PreparedStatement;
//import com.mysql.jdbc.Statement;
import java.sql.Statement;
import java.sql.ResultSet;
import helper.KoneksiDB;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
//import model.tbl_ujian;
import Model.ujian;

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
     * @param b
     */
    
    @Override
    public void insert(ujian b) {
        PreparedStatement statement = null;
        try {
            statement = (PreparedStatement) con.prepareStatement(strInsert);
            
            statement.setInt(1, b.getId_ujian());
            statement.setString(2, b.getNama_matpel());
            statement.setInt(3, b.getJumlah_soal());
            statement.execute();
            JOptionPane.showInternalMessageDialog(null, "simpan data berhasil");
            
        } catch (SQLException e) {
            System.out.println("tidak tampil:"+e);
            JOptionPane.showInternalMessageDialog(null, "ID sudah terdaftar");
        }
        finally {
            try {
                statement.close();
            } catch (SQLException ex) {
                System.out.println("tidak berhasil:"+ex);
            }
        }
    }
    
    @Override
    public void update(ujian b) {
        PreparedStatement statement = null;
        try {
            statement = (PreparedStatement) con.prepareStatement(strUpdate);
            
            //statement.setInt(1, b.getId_ujian());
            statement.setString(1, b.getNama_matpel());
            statement.setInt(2, b.getJumlah_soal());
            statement.setInt(3, b.getId_ujian());
            statement.execute();
            
            JOptionPane.showInternalMessageDialog(null, "edit data berhasil");
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
    
    @Override
    public void delete(int id_ujian) {
        PreparedStatement statement = null;
        try {
            int confirm = JOptionPane.showConfirmDialog(null, "hapus data?");
            
            if (confirm == 0) {
                System.out.print(confirm);
                statement = (PreparedStatement) con.prepareStatement(strDelete);

                //statement.setInt(1, b.getId_ujian());
                statement.setInt(1, id_ujian);
                statement.execute();

                JOptionPane.showInternalMessageDialog(null, "hapus data berhasil");
            }
        } catch (SQLException e) {
            System.out.println("hapus data gagal:"+e);
        }
        finally {
            try {
                statement.close();
            } catch (SQLException ex) {
                System.out.println("hapus data gagal:"+ex);
            }
        }
    }
    
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
    String strInsert = "insert into ujian(id_ujian, nama_matpel, jumlah_soal) VALUES (?,?,?);";
    String strUpdate = "update ujian set nama_matpel=?, jumlah_soal=? where id_ujian=?;";
    String strDelete = "delete from ujian where id_ujian=?;";
}
