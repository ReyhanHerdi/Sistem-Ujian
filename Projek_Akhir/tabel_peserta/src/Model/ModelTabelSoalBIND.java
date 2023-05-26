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
public class ModelTabelSoalBIND extends AbstractTableModel {

    public ModelTabelSoalBIND(List<SoalBIND> lstSBIND) {
        this.lstSBIND = lstSBIND;
    }

    @Override
    public int getRowCount() {
        return this.lstSBIND.size();
    }

    @Override
    public int getColumnCount() {
        return 3;
    }

    @Override
    public String getColumnName(int column){
        switch (column){
            case 0:
                return "Id_Soal";
            case 1:
                return "Pertanyaan";
            case 2:
                return "Jawaban";
            default:
                return null;
        }
    }                       
    
    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        switch (columnIndex)
        {       
            case 0:
                return lstSBIND.get(rowIndex).getId_soal();
            case 1:
                return lstSBIND.get(rowIndex).getPertanyaan();
            case 2:
                return lstSBIND.get(rowIndex).getJawaban();
            default:
                return null;
        }
    }

    List<SoalBIND> lstSBIND;
}
