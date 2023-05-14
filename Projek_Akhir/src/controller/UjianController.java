/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import DAO.DAOUjian;
import Interface.IDAOUjian;
import view.tampil_data;
import java.util.List;
import model.tbl_ujian;
import model.ujian;

/**
 *
 * @author reyha
 */
public class UjianController {
    
    public UjianController(tampil_data tampilData){
        this.tampilData = tampilData;
        iUjian = new DAOUjian();
        //iUjian.getAll();
    }
    
    public void isiTabel(){
        tblUjian = iUjian.getAll();
        tbl_ujian tblUjn = new tbl_ujian(tblUjian);
        tampilData.getTabelData().setModel(tblUjn);
    }
    
    tampil_data tampilData;
    IDAOUjian iUjian;
    List<ujian> tblUjian;
}
