/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package DAOInterface;

import Model.SoalMTK;
import Model.ujian;
import java.util.List;

/**
 *
 * @author DAFFA
 */
public interface IDAOSoalMTK {
    //read data
    public List<SoalMTK> getAll();
    //insert data
    public void insert(SoalMTK b);
    //update data
    public void update(SoalMTK b);
    //delete data
    public void delete(int id_soal);
    public int count();
    public void updateTabelUjian(ujian b);
   }
