/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import DAO.DAOPeserta;
import Model.Peserta;
import view.FormPeserta;
import Model.ModelTabelPeserta;
import java.util.List;
import DAOInterface.IDAOPeserta;
//import java.util.Date;
import javax.swing.JOptionPane;



/**
 *
 * @author DAFFA
 */
public class ControllerPeserta {
    
    public ControllerPeserta(FormPeserta frmPeserta) {
        this.frmPeserta = frmPeserta;
        iPeserta = new DAOPeserta();
        iPeserta.getAll();
    }
    
    public void isiTable()
    {
        lstPst = iPeserta.getAll();
        ModelTabelPeserta tabelPst = new ModelTabelPeserta(lstPst);
        frmPeserta.getTabelData().setModel(tabelPst);
    }
    
    public void insert()
    {
        Peserta b = new Peserta();
        b.setId_peserta(Integer.valueOf(frmPeserta.getTxtID_Peserta().getText()));
        b.setEmail(frmPeserta.getTxtEmail().getText());
        b.setNama_peserta(frmPeserta.getTxtNama_Peserta().getText());
        //b.setTgl_lahir(Date(frmPeserta.getDateTgl_Lahir().getText()));
        b.setNo_telp(frmPeserta.getTxtNo_Telp().getText());
        b.setKelas(frmPeserta.getTxtKelas().getText());
        b.setJenis_kelamin(frmPeserta.getTxtJkl().getSelectedItem().toString());
        b.setPassword(frmPeserta.getTxtPassword().getText());

        iPeserta.insert(b);
        JOptionPane.showMessageDialog(null, "input berhasil");

    }
    
    public void reset()
    {
        if (!frmPeserta.getTxtID_Peserta().isEnabled())
            frmPeserta.getTxtID_Peserta().setEnabled(true);
        frmPeserta.getTxtID_Peserta().setText("");
        frmPeserta.getTxtEmail().setText("");
        frmPeserta.getTxtNama_Peserta().setText("");
        //frmPeserta.getDateTgl_Lahir().setText("");
        frmPeserta.getTxtNo_Telp().setText("");
        frmPeserta.getTxtKelas().setText("");
        frmPeserta.getTxtJkl().setSelectedItem("L");
        frmPeserta.getTxtPassword().setText("");

    }
    
    public void isiField(int row)
    {
        frmPeserta.getTxtID_Peserta().setEnabled(false);
        frmPeserta.getTxtID_Peserta().setText(lstPst.get(row).getId_peserta().toString());
        frmPeserta.getTxtEmail().setText(lstPst.get(row).getEmail());
        frmPeserta.getTxtNama_Peserta().setText(lstPst.get(row).getNama_peserta());
        //frmPeserta.getDateTgl_Lahir().setText(lstPst.get(row).getTgl_lahir());
        frmPeserta.getTxtNo_Telp().setText(lstPst.get(row).getNo_telp());
        frmPeserta.getTxtKelas().setText(lstPst.get(row).getKelas());
        frmPeserta.getTxtJkl().setSelectedItem(lstPst.get(row).getJenis_kelamin());
        frmPeserta.getTxtPassword().setText(lstPst.get(row).getPassword());

    }
    
    public void update()
    {
        Peserta b = new Peserta();
        b.setEmail(frmPeserta.getTxtEmail().getText());
        b.setNama_peserta(frmPeserta.getTxtNama_Peserta().getText());
        //b.setTgl_lahir(Date(frmPeserta.getDateTgl_Lahir().getText()));
        b.setNo_telp(frmPeserta.getTxtNo_Telp().getText());
        b.setKelas(frmPeserta.getTxtKelas().getText());
        b.setJenis_kelamin(frmPeserta.getTxtJkl().getSelectedItem().toString());
        b.setPassword(frmPeserta.getTxtPassword().getText());
        b.setId_peserta(Integer.valueOf(frmPeserta.getTxtID_Peserta().getText()));

        iPeserta.update(b);
        JOptionPane.showMessageDialog(null, "update berhasil");
    }
    
    public void delete()
    {
        Peserta b =  new Peserta();
        iPeserta.delete(Integer.parseInt(frmPeserta.getTxtID_Peserta().getText()));
        JOptionPane.showMessageDialog(null, "delete berhasil");

    }
    
    FormPeserta frmPeserta;
    IDAOPeserta iPeserta;
    List<Peserta> lstPst;

}
