/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import DAO.DAOUjianBIndo;
import DAOInterface.IDAOUjianBIndo;
import Model.Peserta;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import view.SistemUjian;

/**
 *
 * @author reyha
 */
public class ControllerUjianBIndo {
    public ControllerUjianBIndo(SistemUjian stmUjian)
    {
        this.stmUjian = stmUjian;
        iUjianBIndo = new DAOUjianBIndo();
        iUjianBIndo.getAll();
    }
    
    public void TampilSoal()
    {
        ArrayList<Object> soal = stmUjian.KirimPertanyaan1();
        
        try {
            stmUjian.getSoalBIndo1().setText(soal.get(0).toString());
            stmUjian.getSoalBIndo2().setText(soal.get(1).toString());
            stmUjian.getSoalBIndo3().setText(soal.get(2).toString());
            stmUjian.getSoalBIndo4().setText(soal.get(3).toString());
            stmUjian.getSoalBIndo5().setText(soal.get(4).toString());
        } catch (Exception e) {
            System.out.println("Soal tidak mencukupi");
        }
    }
    
    public void TampilJawaban()
    {
        ArrayList<Object> soal = stmUjian.KirimJawaban1();
        
        try {
            stmUjian.getJawabanBIndo1().setText(soal.get(0).toString());
            stmUjian.getJawabanBIndo2().setText(soal.get(1).toString());
            stmUjian.getJawabanBIndo3().setText(soal.get(2).toString());
            stmUjian.getJawabanBIndo4().setText(soal.get(3).toString());
            stmUjian.getJawabanBIndo5().setText(soal.get(4).toString());
        } catch (Exception e) {
            System.out.println("Jawaban tidak mencukupi");
        }
        
    }
    
    public void nilai()
    {
        int skor = 0;
        if (stmUjian.getJawabanBIndo1().isSelected()) {
            skor++;
        } 
        if (stmUjian.getJawabanBIndo2().isSelected()) {
            skor++;  
        }
        if (stmUjian.getJawabanBIndo3().isSelected()) {
            skor++;  
        }
        if (stmUjian.getJawabanBIndo4().isSelected()) {
            skor++;  
        }
        if (stmUjian.getJawabanBIndo5().isSelected()) {
            skor++;  
        }
        
        int totalSkor = skor * 20;
        
        System.out.print(skor);
        
        try {
            Peserta b = new Peserta();
            b.setSkor_bind(totalSkor);
            b.setId_peserta(Integer.valueOf(stmUjian.getTxtIdPeserta2().getText()));
        
            iUjianBIndo.update(b);
        
            JOptionPane.showMessageDialog(null, "Ujian Selesai");
            stmUjian.Tabel1();
            
            reset();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "ID peserta belum diisi");
            stmUjian.Tabel9();
            System.out.println("error bang");
        }
    }
    
    public void reset()
    {
        stmUjian.getTxtIdPeserta2().setText("");
        stmUjian.ClearJawabanBIndo();
    }
    
    SistemUjian stmUjian;
    IDAOUjianBIndo iUjianBIndo;
}
