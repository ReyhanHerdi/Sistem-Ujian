/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package DAOInterface;

import Model.SoalBIND;
import Model.ujian;
import java.util.List;

/**
 *
 * @author DAFFA
 */
public interface IDAOSoalBIND {
    //read data
    public List<SoalBIND> getAll();
    //insert data
    public void insert(SoalBIND b);
    //update data
    public void update(SoalBIND b);
    //delete data
    public int count();
    
    public void updateTabelUjian(ujian b);

    /**
     *
     * @param id_soal
     */
    public void delete(int id_soal);
   }
