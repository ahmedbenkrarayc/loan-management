package Managers;

import DAO.IMaterial;
import Models.Material;
import Models.Student;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;

public class MaterialData implements IMaterial {
    private Database db;
    public MaterialData(){
        db = new Database();
    }

    @Override
    public ArrayList<Material> getMaterials() throws SQLException {
        var result = db.getStatement().executeQuery("select * from material");
        var materials = new ArrayList<Material>();
        while(result.next()){
            materials.add(new Material(result.getInt(1),result.getString(2),result.getString(3),result.getInt(4)));
        }
        return materials;
    }

    @Override
    public ArrayList<Material> getMaterial(String titre) throws SQLException {
        var result = db.getConnection().prepareStatement("select * from material where titre like ?");
        result.setString(1,"%"+titre+"%");
        var rs = result.executeQuery();
        var materials = new ArrayList<Material>();
        while(rs.next()){
            materials.add(new Material(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getInt(4)));
        }
        return materials;
    }

    @Override
    public Boolean changeStatus(int id, int status) throws SQLException {
        var prs = db.getConnection().prepareStatement("update material set status = ? where id = ?");
        prs.setInt(1, status);
        prs.setInt(2, id);

        int row = prs.executeUpdate();
        if (row == 0){
            return false;
        }
        return true;
    }

    @Override
    public Boolean isAvailable(String titre) throws SQLException {
        var result = db.getConnection().prepareStatement("select * from material where titre like ?");
        result.setString(1,titre);
        var rs = result.executeQuery();
        if(rs.next()){
            if(rs.getInt(4) == 0){
                return false;
            }
            return true;
        }
        return false;
    }

    @Override
    public Material getMaterialById(int id) throws SQLException {
        PreparedStatement result = null;
        try {
            result = db.getConnection().prepareStatement("select * from material where id = ?");

            result.setInt(1,id);
            var rs = result.executeQuery();
            if(rs.next()){
                return new Material(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getInt(4));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return null;
    }
}
