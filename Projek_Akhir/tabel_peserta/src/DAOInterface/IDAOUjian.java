/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package DAOInterface;

import java.util.List;
import Model.ujian;
/**
 *
 * @author reyha
 */
public interface IDAOUjian {
    public List<ujian> getAll();
    public void insert(ujian b);
    public void update(ujian b);
    public void delete(int id_ujian);
}
