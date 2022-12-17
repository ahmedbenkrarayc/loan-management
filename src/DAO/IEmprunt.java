package DAO;

import Models.Emprunt;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.data.general.DefaultPieDataset;

import java.sql.SQLException;
import java.util.ArrayList;

/**
 * Interface for deciding the methods that will need in Emprunt
 * @author ahmed benkrara
 */
public interface IEmprunt {
    /**
     * @param emprunt
     * @return
     * @throws SQLException
     */
    boolean addEmprunt(Emprunt emprunt) throws SQLException;

    /**
     * @param id
     * @return
     * @throws SQLException
     */
    ArrayList<Emprunt> getEmpruntByStudentId(int id) throws SQLException;

    /**
     * @param name
     * @return
     * @throws SQLException
     */
    ArrayList<Emprunt> getEmpruntByMaterial(String name) throws SQLException;

    /**
     * @return
     * @throws SQLException
     */
    ArrayList<Emprunt> getEmprunts() throws SQLException;

    /**
     * @param name
     * @return ArrayList<Emprunt>
     * @throws SQLException
     */
    ArrayList<Emprunt> getEmprunts(String name) throws SQLException;

    /**
     * @param id
     * @return boolean
     * @throws SQLException
     */
    boolean effectBackDate(int id) throws SQLException;

    /**
     * @param email
     * @return DefaultCategoryDataset
     * @throws SQLException
     */
    DefaultCategoryDataset getPlotData(String email) throws SQLException;

    /**
     * @return DefaultPieDataset
     * @throws SQLException
     */
    DefaultPieDataset getPieData() throws SQLException;
}
