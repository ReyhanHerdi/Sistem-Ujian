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
        
        stmUjian.getSoalMTK1().setText(soal.get(0).toString());
        stmUjian.getSoalMTK2().setText(soal.get(1).toString());
    }
    
    public void TampilJawaban()
    {
        ArrayList<Object> jawaban = stmUjian.KirimJawaban();
        
        stmUjian.getJawabanMTK1().setText(jawaban.get(0).toString());
        stmUjian.getJawabanMTK2().setText(jawaban.get(1).toString());
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
        
        System.out.print(skor);
        
        try {
            Peserta b = new Peserta();
            b.setSkor_mtk(skor);
            b.setId_peserta(Integer.valueOf(stmUjian.getTxtIdPeserta().getText()));
        
            iUjianMTK.update(b);
        
            JOptionPane.showMessageDialog(null, "Ujian Selesai");
            stmUjian.Tabel1();
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
