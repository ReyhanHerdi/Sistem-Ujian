/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import DAO.DAOSoalBIND;
import Model.SoalBIND;
import view.SistemUjian;
import Model.ModelTabelSoalBIND;
import java.util.List;
import javax.swing.JOptionPane;
import DAOInterface.IDAOSoalBIND;



/**
 *
 * @author DAFFA
 */
public class ControllerSoalBIND {
    
    public ControllerSoalBIND(SistemUjian stmUjian) {
        this.stmUjian = stmUjian;
        iSoalBIND = new DAOSoalBIND();
        iSoalBIND.getAll();
    }
    
    public void isiTable()
    {
        lstBIND = iSoalBIND.getAll();
        ModelTabelSoalBIND tabeSBIND = new ModelTabelSoalBIND(lstBIND);
        stmUjian.getTabelBIND().setModel(tabeSBIND);
    }
    
    public void insert()
    {
        SoalBIND b = new SoalBIND();
        b.setId_soal(Integer.valueOf(stmUjian.getTxtID_Soal1().getText()));
        b.setPertanyaan(stmUjian.getTxtPertanyaan1().getText());
        b.setJawaban(stmUjian.getTxtJawaban1().getText());

        iSoalBIND.insert(b);
        JOptionPane.showMessageDialog(null, "input berhasil");

    }
    
    public void reset()
    {
     if (!stmUjian.getTxtID_Soal1().isEnabled())
        stmUjian.getTxtID_Soal1().setEnabled(true);
        stmUjian.getTxtID_Soal1().setText("");
        stmUjian.getTxtPertanyaan1().setText("");
        stmUjian.getTxtJawaban1().setText("");

    }
    
    public void isiField(int row)
    {
        stmUjian.getTxtID_Soal1().setEnabled(false);
        stmUjian.getTxtID_Soal1().setText(lstBIND.get(row).getId_soal().toString());
        stmUjian.getTxtPertanyaan1().setText(lstBIND.get(row).getPertanyaan());
        stmUjian.getTxtJawaban1().setText(lstBIND.get(row).getJawaban());
    }
    
    public void update()
    {
        SoalBIND b = new SoalBIND();
        b.setPertanyaan(stmUjian.getTxtPertanyaan1().getText());
        b.setJawaban(stmUjian.getTxtJawaban1().getText());
        b.setId_soal(Integer.valueOf(stmUjian.getTxtID_Soal1().getText()));

        iSoalBIND.update(b);
        JOptionPane.showMessageDialog(null, "update berhasil");
    }
    
    public void delete()
    {
        iSoalBIND.delete(Integer.parseInt(stmUjian.getTxtID_Soal1().getText()));
        JOptionPane.showMessageDialog(null, "delete berhasil");
    }
    
    SistemUjian stmUjian;
    IDAOSoalBIND iSoalBIND;
    List<SoalBIND> lstBIND;

}
