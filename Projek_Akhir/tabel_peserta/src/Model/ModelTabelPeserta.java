/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author DAFFA
 */
public class ModelTabelPeserta extends AbstractTableModel {

    public ModelTabelPeserta(List<Peserta> lstPst) {
        this.lstPst = lstPst;
    }

    @Override
    public int getRowCount() {
        return this.lstPst.size();
    }

    @Override
    public int getColumnCount() {
        return 10;
    }

    @Override
    public String getColumnName(int column){
        switch (column){
            case 0:
                return "Id_peserta";
            case 1:
                return "Email";
            case 2:
                return "Nama_peserta";
            case 3:
                return "Tanggal_lahir";
            case 4:
                return "No_telepon";
            case 5:
                return "Kelas";
            case 6:
                return "Jenis_kelamin";
            case 7:
                return "Password";
            case 8:
                return "Matematika";
            case 9:
                return "Bahasa Indonesia";
            default:
                return null;
        }
    }                       
    
    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        switch (columnIndex)
        {       
            case 0:
                return lstPst.get(rowIndex).getId_peserta();
            case 1:
                return lstPst.get(rowIndex).getEmail();
            case 2:
                return lstPst.get(rowIndex).getNama_peserta();
            case 3:
                return lstPst.get(rowIndex).getTgl_lahir();
            case 4:
                return lstPst.get(rowIndex).getNo_telp();
            case 5:
                return lstPst.get(rowIndex).getKelas();
            case 6:
                return lstPst.get(rowIndex).getJenis_kelamin();
            case 7:
                return lstPst.get(rowIndex).getPassword();
            case 8:
                return lstPst.get(rowIndex).getSkor_mtk();
            case 9:
                return lstPst.get(rowIndex).getSkor_bind();
            default:
                return null;
        }
    }

    List<Peserta> lstPst;
}
