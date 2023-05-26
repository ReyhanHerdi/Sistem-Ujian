/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import DAO.DAOUjian;
import DAOInterface.IDAOUjian;
import view.SistemUjian;
import java.util.List;
import Model.tbl_ujian;
import Model.ujian;
/**
 *
 * @author reyha
 */
public class UjianController {
    
    public UjianController(SistemUjian stmUjian){
        this.stmUjian = stmUjian;
        iUjian = new DAOUjian();
        iUjian.getAll();
    }
    
    public void isiTabel(){
        tblUjian = iUjian.getAll();
        tbl_ujian tblUjn = new tbl_ujian(tblUjian);
        stmUjian.getTabelDataUjian().setModel(tblUjn);
    }
    
    public void insert(){
        ujian b = new ujian();
        b.setId_ujian(Integer.valueOf(stmUjian.getTxtID1().getText()));
        b.setNama_matpel(stmUjian.getTxtMatpel1().getText());
        b.setJumlah_soal(Integer.valueOf(stmUjian.getTxtJumlahSoal1().getText()));
        iUjian.insert(b);
        //JOptionPane.showConfirmDialog(null, "input berhasil");
    }
    
    public void reset(){
        if (!stmUjian.getTxtID1().isEnabled()) {
            stmUjian.getTxtID1().setEnabled(true);
        }
        stmUjian.getTxtID1().setText("");
        stmUjian.getTxtMatpel1().setText("");
        stmUjian.getTxtJumlahSoal1().setText("");
    }
    
    public void isiField(int row){
        stmUjian.getTxtID1().setEnabled(false);
        stmUjian.getTxtID1().setText(tblUjian.get(row).getId_ujian().toString());
        stmUjian.getTxtMatpel1().setText(tblUjian.get(row).getNama_matpel());
        stmUjian.getTxtJumlahSoal1().setText(tblUjian.get(row).getJumlah_soal().toString());
    }
    
    public void update(){
        ujian b = new ujian();
        b.setNama_matpel(stmUjian.getTxtMatpel1().getText());
        b.setJumlah_soal(Integer.valueOf(stmUjian.getTxtJumlahSoal1().getText()));
        b.setId_ujian(Integer.valueOf(stmUjian.getTxtID1().getText()));
        iUjian.update(b);
        //JOptionPane.showConfirmDialog(null, "update berhasil");
    }
    
    public void delete(){
        ujian b = new ujian();
        //b.setId_ujian();
        iUjian.delete(Integer.parseInt(stmUjian.getTxtID1().getText()));
        //JOptionPane.showConfirmDialog(null, "hapus data berhasil");
    }
    
    SistemUjian stmUjian;
    IDAOUjian iUjian;
    List<ujian> tblUjian;
}
