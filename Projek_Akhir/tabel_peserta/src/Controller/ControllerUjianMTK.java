/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import DAO.DAOUjianMTK;
import DAOInterface.IDAOPeserta;
import DAOInterface.IDAOUjianMTK;
import Model.Peserta;
import Model.SoalMTK;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import view.SistemUjian;

/**
 *
 * @author reyha
 */
public class ControllerUjianMTK {

    /**
     *
     * @param stmUjian
     */
    public ControllerUjianMTK(SistemUjian stmUjian)
    {
        this.stmUjian = stmUjian;
        iUjianMTK = new DAOUjianMTK();
        iUjianMTK.getAll();
    }
    
    public void TampilSoal()
    {
        ArrayList<Object> soal = stmUjian.KirimPertanyaan();
        
        try {
            stmUjian.getSoalMTK1().setText(soal.get(0).toString());
            stmUjian.getSoalMTK2().setText(soal.get(1).toString());
            stmUjian.getSoalMTK3().setText(soal.get(2).toString());
            stmUjian.getSoalMTK4().setText(soal.get(3).toString());
            stmUjian.getSoalMTK5().setText(soal.get(4).toString());
        } catch (Exception e) {
            System.out.println("Soal tidak mencukupi");
        }
        
    }
    
    public void TampilJawaban()
    {
        ArrayList<Object> jawaban = stmUjian.KirimJawaban();
        try {
            stmUjian.getJawabanMTK1().setText(jawaban.get(0).toString());
            stmUjian.getJawabanMTK2().setText(jawaban.get(1).toString());
            stmUjian.getJawabanMTK3().setText(jawaban.get(2).toString());
            stmUjian.getJawabanMTK4().setText(jawaban.get(3).toString());
            stmUjian.getJawabanMTK5().setText(jawaban.get(4).toString());
        } catch (Exception e) {
            System.out.println("Jawaban tidak mencukupi");
        }
        
    }
    
    public void nilai()
    {
        int skor = 0;
        if (stmUjian.getJawabanMTK1().isSelected()) {
            skor++;
        } 
        if (stmUjian.getJawabanMTK2().isSelected()) {
            skor++;  
        }
        if (stmUjian.getJawabanMTK3().isSelected()) {
            skor++;  
        }
        if (stmUjian.getJawabanMTK4().isSelected()) {
            skor++;  
        }
        if (stmUjian.getJawabanMTK5().isSelected()) {
            skor++;  
        }
        
        int totalSkor = skor * 20;
        
        System.out.print(skor);
        
        try {
            Peserta b = new Peserta();
            b.setSkor_mtk(totalSkor);
            b.setId_peserta(Integer.valueOf(stmUjian.getTxtIdPeserta().getText()));
        
            iUjianMTK.update(b);
        
            JOptionPane.showMessageDialog(null, "Ujian Selesai");
            stmUjian.Tabel1();
            
            reset();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "ID peserta belum diisi");
            stmUjian.Tabel7();
            System.out.println("error bang");
        }
    }
    
    public void reset()
    {
        stmUjian.getTxtIdPeserta().setText("");
        stmUjian.ClearJawabanMTK();
    }
    
    SistemUjian stmUjian;
    IDAOUjianMTK iUjianMTK;
    List<SoalMTK> lstSMTK;
    IDAOPeserta iPeserta;
    List<Peserta> lstPst;
}
