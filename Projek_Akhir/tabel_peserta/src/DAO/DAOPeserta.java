/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import Model.Peserta;
import helper.KoneksiDB;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import DAOInterface.IDAOPeserta;
import com.mysql.jdbc.PreparedStatement;
/**
 *
 * @author DAFFA
 */
public class DAOPeserta implements IDAOPeserta{

    public DAOPeserta()
    {
        con = KoneksiDB.getConnection();
    }
    
    /**
     *
     * @param b
     */
    @Override
    public void insert(Peserta b) {
        PreparedStatement statement = null;
        try {
            statement = (PreparedStatement) con.prepareStatement(strInsert);
            
            statement.setInt(1, b.getId_peserta());
            statement.setString(2, b.getEmail());
            statement.setString(3, b.getNama_peserta());
            statement.setString(4, b.getTgl_lahir());
            statement.setString(5, b.getNo_telp());
            statement.setString(6, b.getKelas());
            statement.setString(7, b.getJenis_kelamin());
            statement.setString(8, b.getPassword());
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
    public void update(Peserta b) {
        PreparedStatement statement = null;
        try {
            statement = (PreparedStatement) con.prepareStatement(strUpdate);
            
            statement.setString(1, b.getEmail());
            statement.setString(2, b.getNama_peserta());
            statement.setString(3, b.getTgl_lahir());
            statement.setString(4, b.getNo_telp());
            statement.setString(5, b.getKelas());
            statement.setString(6, b.getJenis_kelamin());
            statement.setString(7, b.getPassword());
            statement.setInt(8, b.getId_peserta());
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
    public void delete(int id_peserta) {
        PreparedStatement statement = null;
        try {
            statement = (PreparedStatement) con.prepareStatement(strDelete);
            
            statement.setInt(1, id_peserta);
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
    public List<Peserta> getAll() {
        List<Peserta>lstPst = null;
        try
        {
            lstPst = new ArrayList<Peserta>();
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(strRead);
            while(rs.next())
            {
                Peserta pst = new Peserta();
                pst.setId_peserta(rs.getInt("id_peserta"));
                pst.setEmail(rs.getString("email"));
                pst.setNama_peserta(rs.getString("nama_peserta"));
                pst.setTgl_lahir(rs.getString("tgl_lahir"));
                pst.setNo_telp(rs.getString("no_telp"));
                pst.setKelas(rs.getString("kelas"));
                pst.setJenis_kelamin(rs.getString("jenis_kelamin"));
                pst.setPassword(rs.getString("password"));
                pst.setSkor_mtk(rs.getInt("skor_mtk"));
                pst.setSkor_bind(rs.getInt("skor_bind"));
                lstPst.add(pst);
            } 
            
        }
        catch(SQLException e) 
        {
            System.out.println("error"+e);
        }
        return lstPst;
    }
         
    Connection con;
    //SQL Query
    String strRead = "select * from peserta;";
    String strInsert = "insert into peserta(id_peserta, email, nama_peserta, tgl_lahir, no_telp, kelas, jenis_kelamin, password) VALUES (?,?,?,?,?,?,?,?);";
    String strUpdate = "update peserta set email=?, nama_peserta=?, tgl_lahir=?, no_telp=?, kelas=?, jenis_kelamin=?, password=? where id_peserta=?";
    String strDelete = "delete from peserta where id_peserta=?";
            
}
