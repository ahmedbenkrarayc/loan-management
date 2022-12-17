package DAO;

import Models.Emprunt;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.data.general.DefaultPieDataset;

import java.sql.SQLException;
import java.util.ArrayList;

public interface IEmprunt {
    boolean addEmprunt(Emprunt emprunt) throws SQLException;
    ArrayList<Emprunt> getEmpruntByStudentId(int id) throws SQLException;
    ArrayList<Emprunt> getEmpruntByMaterial(String name) throws SQLException;
    ArrayList<Emprunt> getEmprunts() throws SQLException;
    ArrayList<Emprunt> getEmprunts(String name) throws SQLException;
    boolean effectBackDate(int id) throws SQLException;

    DefaultCategoryDataset getPlotData(String email) throws SQLException;
    DefaultPieDataset getPieData() throws SQLException;
}
