/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package DAOInterface;

import Model.SoalMTK;
import java.util.List;
import Model.Peserta;

/**
 *
 * @author reyha
 */
public interface IDAOUjianMTK {
    public List<SoalMTK> getAll();
    public void update(Peserta b);
}
