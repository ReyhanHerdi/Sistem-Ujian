/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import DAO.DAOSoalMTK;
import Model.SoalMTK;
import view.SistemUjian;
import Model.ModelTabelSoalMTK;
import java.util.List;
import javax.swing.JOptionPane;
import DAOInterface.IDAOSoalMTK;
import DAOInterface.IDAOUjian;
import Model.ujian;



/**
 *
 * @author DAFFA
 */
public class ControllerSoalMTK {
    
    public ControllerSoalMTK(SistemUjian stmUjian) {
        this.stmUjian = stmUjian;
        iSoalMTK = new DAOSoalMTK();
        iSoalMTK.getAll();
        iSoalMTK.count();
    }
    
    public void isiTable()
    {
        lstSMTK = iSoalMTK.getAll();
        ModelTabelSoalMTK tabelSMTK = new ModelTabelSoalMTK(lstSMTK);
        stmUjian.getTabelMTK().setModel(tabelSMTK);
        
        //System.out.println(lstSMTK.toString());
    }
    
    public void insert()
    {
        SoalMTK b = new SoalMTK();
        b.setId_soal(Integer.valueOf(stmUjian.getTxtID_Soal().getText()));
        b.setPertanyaan(stmUjian.getTxtPertanyaan().getText());
        b.setJawaban(stmUjian.getTxtJawaban().getText());

        iSoalMTK.insert(b);
//        JOptionPane.showMessageDialog(null, "input berhasil");

    }
    
    public void reset()
    {
     if (!stmUjian.getTxtID_Soal().isEnabled())
          stmUjian.getTxtID_Soal().setEnabled(true);
        stmUjian.getTxtID_Soal().setText("");
        stmUjian.getTxtPertanyaan().setText("");
        stmUjian.getTxtJawaban().setText("");

    }
    
    public void isiField(int row)
    {
        stmUjian.getTxtID_Soal().setEnabled(false);
        stmUjian.getTxtID_Soal().setText(lstSMTK.get(row).getId_soal().toString());
        stmUjian.getTxtPertanyaan().setText(lstSMTK.get(row).getPertanyaan());
        stmUjian.getTxtJawaban().setText(lstSMTK.get(row).getJawaban());
        
    }
    
    public void update()
    {
        SoalMTK b = new SoalMTK();
        b.setPertanyaan(stmUjian.getTxtPertanyaan().getText());
        b.setJawaban(stmUjian.getTxtJawaban().getText());
        b.setId_soal(Integer.valueOf(stmUjian.getTxtID_Soal().getText()));

        iSoalMTK.update(b);
//        JOptionPane.showMessageDialog(null, "update berhasil");
    }
    
    public void delete()
    {
        iSoalMTK.delete(Integer.parseInt(stmUjian.getTxtID_Soal().getText()));
//        JOptionPane.showMessageDialog(null, "delete berhasil");
    }
    
    public void updateTabelUjian(){
        ujian b = new ujian();
        b.setJumlah_soal(iSoalMTK.count());;
        iSoalMTK.updateTabelUjian(b);
    }
    
    SistemUjian stmUjian;
    IDAOSoalMTK iSoalMTK;
    List<SoalMTK> lstSMTK;
    IDAOUjian iUjian;

}
