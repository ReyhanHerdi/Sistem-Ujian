/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

//import java.awt.List;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author reyha
 */
public class tbl_ujian extends AbstractTableModel{
    
    public tbl_ujian(List<ujian> tblUjian) {
        this.tblUjian = tblUjian;
    }
    @Override
    public int getRowCount() {
        return this.tblUjian.size();
    }

    @Override
    public int getColumnCount() {
        return 3;
    }
    
    //@Override

    /**
     *
     * @param column
     * @return
     */
    @Override
    public String getColumnName(int column){
        return switch (column) {
            case 0 -> "ID Ujian";
            case 1 -> "Mata Pelajaran";
            case 2 -> "Jumlah Soal";
            default -> null;
        };
    }
    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        return switch (columnIndex) {
            case 0 -> tblUjian.get(rowIndex).getId_ujian();
            case 1 -> tblUjian.get(rowIndex).getNama_matpel();
            case 2 -> tblUjian.get(rowIndex).getJumlah_soal();
            default -> null;
        };
    }
    
    List<ujian> tblUjian;
}
