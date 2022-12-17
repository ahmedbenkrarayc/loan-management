package DAO;

import Models.Material;
import Models.Student;

import java.sql.SQLException;
import java.util.ArrayList;

/**
 * Interface for definning Material methods
 */
public interface IMaterial {
    /**
     * @return ArrayList<Material>
     * @throws SQLException
     */
    ArrayList<Material> getMaterials() throws SQLException;

    /**
     * @param titre
     * @return ArrayList<Material>
     * @throws SQLException
     */
    ArrayList<Material> getMaterial(String titre) throws SQLException;

    /**
     *
     * @param id
     * @param status
     * @return ArrayList<Material>
     * @throws SQLException
     */
    Boolean changeStatus(int id,int status) throws SQLException;

    /**
     *
     * @param titre
     * @return ArrayList<Material>
     * @throws SQLException
     */
    Boolean isAvailable(String titre) throws SQLException;

    /**
     *
     * @param id
     * @return ArrayList<Material>
     * @throws SQLException
     */
    Material getMaterialById(int id) throws SQLException;
}
