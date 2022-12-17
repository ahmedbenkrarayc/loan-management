package DAO;

import Models.Material;
import Models.Student;

import java.sql.SQLException;
import java.util.ArrayList;

public interface IMaterial {
    ArrayList<Material> getMaterials() throws SQLException;
    ArrayList<Material> getMaterial(String titre) throws SQLException;
    Boolean changeStatus(int id,int status) throws SQLException;
    Boolean isAvailable(String titre) throws SQLException;
    Material getMaterialById(int id) throws SQLException;
}
