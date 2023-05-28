/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import DAO.DAOPeserta;
import Model.Peserta;
import view.SistemUjian;
import Model.ModelTabelPeserta;
import java.util.List;
import DAOInterface.IDAOPeserta;
import javax.swing.JOptionPane;



/**
 *
 * @author DAFFA
 */
public class ControllerPeserta {
    
    public ControllerPeserta(SistemUjian stmUjian) {
        this.stmUjian = stmUjian;
        iPeserta = new DAOPeserta();
        iPeserta.getAll();
    }
    
    public void isiTable()
    {
        lstPst = iPeserta.getAll();
        ModelTabelPeserta tabelPst = new ModelTabelPeserta(lstPst);
        stmUjian.getTabelData().setModel(tabelPst);
    }
    
    public void insert()
    {
        Peserta b = new Peserta();
        b.setId_peserta(Integer.valueOf(stmUjian.getTxtID_Peserta().getText()));
        b.setEmail(stmUjian.getTxtEmail().getText());
        b.setNama_peserta(stmUjian.getTxtNama_Peserta().getText());
        b.setTgl_lahir(stmUjian.getTxtTgl_Lahir().getText());
        b.setNo_telp(stmUjian.getTxtNo_Telp().getText());
        b.setKelas(stmUjian.getTxtKelas().getText());
        b.setJenis_kelamin(stmUjian.getTxtJkl().getSelectedItem().toString());
        b.setPassword(stmUjian.getTxtPassword().getText());

        iPeserta.insert(b);
//        JOptionPane.showMessageDialog(null, "input berhasil");
    }
    
    public void reset()
    {
     if (!stmUjian.getTxtID_Peserta().isEnabled())
          stmUjian.getTxtID_Peserta().setEnabled(true);
        stmUjian.getTxtID_Peserta().setText("");
        stmUjian.getTxtEmail().setText("");
        stmUjian.getTxtNama_Peserta().setText("");
        stmUjian.getTxtTgl_Lahir().setText("");
        stmUjian.getTxtNo_Telp().setText("");
        stmUjian.getTxtKelas().setText("");
        stmUjian.getTxtJkl().setSelectedItem("L");
        stmUjian.getTxtPassword().setText("");

    }
    
    public void isiField(int row)
    {
        stmUjian.getTxtID_Peserta().setEnabled(false);
        stmUjian.getTxtID_Peserta().setText(lstPst.get(row).getId_peserta().toString());
        stmUjian.getTxtEmail().setText(lstPst.get(row).getEmail());
        stmUjian.getTxtNama_Peserta().setText(lstPst.get(row).getNama_peserta());
        stmUjian.getTxtTgl_Lahir().setText(lstPst.get(row).getTgl_lahir());
        stmUjian.getTxtNo_Telp().setText(lstPst.get(row).getNo_telp());
        stmUjian.getTxtKelas().setText(lstPst.get(row).getKelas());
        stmUjian.getTxtJkl().setSelectedItem(lstPst.get(row).getJenis_kelamin());
        stmUjian.getTxtPassword().setText(lstPst.get(row).getPassword());

    }
    
    public void update()
    {
        Peserta b = new Peserta();
        b.setEmail(stmUjian.getTxtEmail().getText());
        b.setNama_peserta(stmUjian.getTxtNama_Peserta().getText());
        b.setTgl_lahir(stmUjian.getTxtTgl_Lahir().getText());
        b.setNo_telp(stmUjian.getTxtNo_Telp().getText());
        b.setKelas(stmUjian.getTxtKelas().getText());
        b.setJenis_kelamin(stmUjian.getTxtJkl().getSelectedItem().toString());
        b.setPassword(stmUjian.getTxtPassword().getText());
        b.setId_peserta(Integer.valueOf(stmUjian.getTxtID_Peserta().getText()));

        iPeserta.update(b);
//        JOptionPane.showMessageDialog(null, "update berhasil");
    }
    
    public void delete()
    {
        iPeserta.delete(Integer.parseInt(stmUjian.getTxtID_Peserta().getText()));
//        JOptionPane.showMessageDialog(null, "delete berhasil");
    }
    
    SistemUjian stmUjian;
    IDAOPeserta iPeserta;
    List<Peserta> lstPst;

}
