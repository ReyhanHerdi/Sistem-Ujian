/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package DAOInterface;

import Model.SoalMTK;
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

    /**
     *
     * @param id_soal
     */
    public void delete(int id_soal);
   }
