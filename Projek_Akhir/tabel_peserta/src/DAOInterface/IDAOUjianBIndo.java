/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package DAOInterface;

import Model.Peserta;
import Model.SoalBIND;
import java.util.List;

/**
 *
 * @author reyha
 */
public interface IDAOUjianBIndo {
    public List<SoalBIND> getAll();
    public void update(Peserta b);
}
