/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import DAO.DAOUjian;
import Interface.IDAOUjian;
import view.tampil_data;
import java.util.List;
import javax.swing.JOptionPane;
import model.tbl_ujian;
import model.ujian;

/**
 *
 * @author reyha
 */
public class UjianController {
    
    public UjianController(tampil_data tampilData){
        this.tampilData = tampilData;
        iUjian = new DAOUjian();
        //iUjian.getAll();
    }
    
    public void isiTabel(){
        tblUjian = iUjian.getAll();
        tbl_ujian tblUjn = new tbl_ujian(tblUjian);
        tampilData.getTabelData().setModel(tblUjn);
    }
    
    public void insert(){
        ujian b = new ujian();
        b.setId_ujian(Integer.parseInt(tampilData.gettxtID().getText()));
        b.setNama_matpel(tampilData.gettxtMatpel().getText());
        b.setJumlah_soal(Integer.parseInt(tampilData.gettxtJumlahsoal().getText()));
        iUjian.insert(b);
        JOptionPane.showConfirmDialog(null, "input berhasil");
        
        
    }
    
    tampil_data tampilData;
    IDAOUjian iUjian;
    List<ujian> tblUjian;
}
