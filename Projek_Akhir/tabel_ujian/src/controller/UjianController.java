/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import DAO.DAOUjian;
import Interface.IDAOUjian;
import view.tampil_data;
import java.util.List;
//import javax.swing.JOptionPane;
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
        iUjian.getAll();
    }
    
    public void isiTabel(){
        tblUjian = iUjian.getAll();
        tbl_ujian tblUjn = new tbl_ujian(tblUjian);
        tampilData.getTabelData().setModel(tblUjn);
    }
    
    public void insert(){
        ujian b = new ujian();
        b.setId_ujian(Integer.valueOf(tampilData.gettxtID().getText()));
        b.setNama_matpel(tampilData.gettxtMatpel().getText());
        b.setJumlah_soal(Integer.valueOf(tampilData.gettxtJumlahsoal().getText()));
        iUjian.insert(b);
        //JOptionPane.showConfirmDialog(null, "input berhasil");
    }
    
    public void reset(){
        if (!tampilData.gettxtID().isEnabled()) {
            tampilData.gettxtID().setEnabled(true);
        }
        tampilData.gettxtID().setText("");
        tampilData.gettxtMatpel().setText("");
        tampilData.gettxtJumlahsoal().setText("");
    }
    
    public void isiField(int row){
        tampilData.gettxtID().setEnabled(false);
        tampilData.gettxtID().setText(tblUjian.get(row).getId_ujian().toString());
        tampilData.gettxtMatpel().setText(tblUjian.get(row).getNama_matpel());
        tampilData.gettxtJumlahsoal().setText(tblUjian.get(row).getJumlah_soal().toString());
    }
    
    public void update(){
        ujian b = new ujian();
        b.setNama_matpel(tampilData.gettxtMatpel().getText());
        b.setJumlah_soal(Integer.valueOf(tampilData.gettxtJumlahsoal().getText()));
        b.setId_ujian(Integer.valueOf(tampilData.gettxtID().getText()));
        iUjian.update(b);
        //JOptionPane.showConfirmDialog(null, "update berhasil");
    }
    
    public void delete(){
        //b.setId_ujian();
        iUjian.delete(Integer.parseInt(tampilData.gettxtID().getText()));
        //JOptionPane.showConfirmDialog(null, "hapus data berhasil");
    }
    
    tampil_data tampilData;
    IDAOUjian iUjian;
    List<ujian> tblUjian;
}
