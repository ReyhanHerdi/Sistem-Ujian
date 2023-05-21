/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package DAOInterface;

import Model.Peserta;
import java.util.List;

/**
 *
 * @author DAFFA
 */
public interface IDAOPeserta {
    //read data
    public List<Peserta> getAll();
    //insert data
    public void insert(Peserta b);
    //update data
    public void update(Peserta b);
    //delete data

    /**
     *
     * @param id_peserta
     */
    public void delete(int id_peserta);
   }
