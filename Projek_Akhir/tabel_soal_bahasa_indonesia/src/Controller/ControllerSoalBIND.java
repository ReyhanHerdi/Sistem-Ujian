/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import DAO.DAOSoalBIND;
import Model.SoalBIND;
import view.FormSoalBIND;
import Model.ModelTabelSoalBIND;
import java.util.List;
import javax.swing.JOptionPane;
import DAOInterface.IDAOSoalBIND;



/**
 *
 * @author DAFFA
 */
public class ControllerSoalBIND {
    
    public ControllerSoalBIND(FormSoalBIND frmSoalMTK) {
        this.frmSoalMTK = frmSoalMTK;
        iSoalMTK = new DAOSoalBIND();
        iSoalMTK.getAll();
    }
    
    public void isiTable()
    {
        lstSMTK = iSoalMTK.getAll();
        ModelTabelSoalBIND tabelSMTK = new ModelTabelSoalBIND(lstSMTK);
        frmSoalMTK.getTabelData().setModel(tabelSMTK);
    }
    
    public void insert()
    {
        SoalBIND b = new SoalBIND();
        b.setId_soal(Integer.valueOf(frmSoalMTK.getTxtID_Soal().getText()));
        b.setPertanyaan(frmSoalMTK.getTxtPertanyaan().getText());
        b.setJawaban(frmSoalMTK.getTxtJawaban().getText());

        iSoalMTK.insert(b);
        JOptionPane.showMessageDialog(null, "input berhasil");

    }
    
    public void reset()
    {
     if (!frmSoalMTK.getTxtID_Soal().isEnabled())
          frmSoalMTK.getTxtID_Soal().setEnabled(true);
        frmSoalMTK.getTxtID_Soal().setText("");
        frmSoalMTK.getTxtPertanyaan().setText("");
        frmSoalMTK.getTxtJawaban().setText("");

    }
    
    public void isiField(int row)
    {
        frmSoalMTK.getTxtID_Soal().setEnabled(false);
        frmSoalMTK.getTxtID_Soal().setText(lstSMTK.get(row).getId_soal().toString());
        frmSoalMTK.getTxtPertanyaan().setText(lstSMTK.get(row).getPertanyaan());
        frmSoalMTK.getTxtJawaban().setText(lstSMTK.get(row).getJawaban());
    }
    
    public void update()
    {
        SoalBIND b = new SoalBIND();
        b.setPertanyaan(frmSoalMTK.getTxtPertanyaan().getText());
        b.setJawaban(frmSoalMTK.getTxtJawaban().getText());
        b.setId_soal(Integer.valueOf(frmSoalMTK.getTxtID_Soal().getText()));

        iSoalMTK.update(b);
        JOptionPane.showMessageDialog(null, "update berhasil");
    }
    
    public void delete()
    {
        iSoalMTK.delete(Integer.parseInt(frmSoalMTK.getTxtID_Soal().getText()));
        JOptionPane.showMessageDialog(null, "delete berhasil");
    }
    
    FormSoalBIND frmSoalMTK;
    IDAOSoalBIND iSoalMTK;
    List<SoalBIND> lstSMTK;

}
