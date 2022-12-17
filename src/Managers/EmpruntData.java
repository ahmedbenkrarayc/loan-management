package Managers;

import DAO.IEmprunt;
import Models.Emprunt;
import Models.Material;
import Models.Student;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.data.general.DefaultPieDataset;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;

public class EmpruntData implements IEmprunt {
    private Database db;
    public EmpruntData(){
        db = new Database();
    }

    @Override
    public boolean addEmprunt(Emprunt emprunt) throws SQLException {
        var prs = db.getConnection().prepareStatement("insert into emprunt(material_id,student_id,date_l,date_back,duration) values (?,?,?,?,?)");
        prs.setInt(1, emprunt.getMaterial().getId());
        prs.setInt(2, emprunt.getStudent().getId());
        prs.setDate(3, new Date(Calendar.getInstance().getTimeInMillis()));
        prs.setDate(4, null);
        prs.setInt(5, emprunt.getDuration());

        int row = prs.executeUpdate();
        if (row == 0){
            return false;
        }
        return true;
    }

    @Override
    public ArrayList<Emprunt> getEmpruntByStudentId(int id) throws SQLException {
        PreparedStatement result = null;
        try {
            result = db.getConnection().prepareStatement("select * from emprunt where student_id = ?");

            result.setInt(1,id);
            var rs = result.executeQuery();
            ArrayList<Emprunt> loans = new ArrayList<>();
            int i = 0;
            while(rs.next()){
                i = 1;
                StudentData data = new StudentData();
                MaterialData mdata = new MaterialData();
                loans.add(new Emprunt(rs.getDate(4),rs.getDate(5),rs.getInt(6),mdata.getMaterialById(rs.getInt(2)),data.getStudentById(id)));
            }
            if(i == 1){
                return loans;
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return null;
    }

    @Override
    public ArrayList<Emprunt> getEmpruntByMaterial(String name) throws SQLException {
        PreparedStatement result = null;
        try {
            result = db.getConnection().prepareStatement("select e.* from emprunt e, material m where e.material_id = m.id and m.titre like ? and date_back is null");

            result.setString(1,"%"+name+"%");
            var rs = result.executeQuery();
            ArrayList<Emprunt> loans = new ArrayList<>();
            int i = 0;
            while(rs.next()){
                i = 1;
                StudentData data = new StudentData();
                MaterialData mdata = new MaterialData();
                loans.add(new Emprunt(rs.getInt(1),rs.getDate(4),rs.getDate(5),rs.getInt(6),mdata.getMaterialById(rs.getInt(2)),data.getStudentById(rs.getInt(3))));
            }
            if(i == 1){
                return loans;
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return null;
    }

    @Override
    public ArrayList<Emprunt> getEmprunts() throws SQLException {
        PreparedStatement result = null;
        try {
            result = db.getConnection().prepareStatement("select e.* from emprunt e, material m where e.material_id = m.id and date_back is null");
            var rs = result.executeQuery();
            ArrayList<Emprunt> loans = new ArrayList<>();
            int i = 0;
            while(rs.next()){
                i = 1;
                StudentData data = new StudentData();
                MaterialData mdata = new MaterialData();
                loans.add(new Emprunt(rs.getInt(1),rs.getDate(4),rs.getDate(5),rs.getInt(6),mdata.getMaterialById(rs.getInt(2)),data.getStudentById(rs.getInt(3))));
            }
            if(i == 1){
                return loans;
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return null;
    }

    @Override
    public ArrayList<Emprunt> getEmprunts(String name) throws SQLException {
        PreparedStatement result = null;
        try {
            result = db.getConnection().prepareStatement("select e.* from emprunt e, material m, student s where e.material_id = m.id and e.student_id = s.id and date_back is null and (s.email like ? or m.titre like ?)");
            result.setString(1,"%"+name+"%");
            result.setString(2,"%"+name+"%");
            var rs = result.executeQuery();
            ArrayList<Emprunt> loans = new ArrayList<>();
            int i = 0;
            while(rs.next()){
                i = 1;
                StudentData data = new StudentData();
                MaterialData mdata = new MaterialData();
                loans.add(new Emprunt(rs.getInt(1),rs.getDate(4),rs.getDate(5),rs.getInt(6),mdata.getMaterialById(rs.getInt(2)),data.getStudentById(rs.getInt(3))));
            }
            if(i == 1){
                return loans;
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return null;
    }

    @Override
    public boolean effectBackDate(int id) throws SQLException {
        var prs = db.getConnection().prepareStatement("update emprunt set date_back = ? where id = ?");
        prs.setDate(1, new Date(Calendar.getInstance().getTimeInMillis()));
        prs.setInt(2, id);

        int row = prs.executeUpdate();
        if (row == 0){
            return false;
        }
        return true;
    }

    @Override
    public DefaultCategoryDataset getPlotData(String email) throws SQLException {
        PreparedStatement result = null;
        try {
            result = db.getConnection().prepareStatement("select COUNT(e.id) as count, titre from emprunt e, material m, student s where e.material_id = m.id and s.id = e.student_id and s.email like ? group by titre;");
            result.setString(1,email);
            var rs = result.executeQuery();
            DefaultCategoryDataset data = new DefaultCategoryDataset();
            int i = 0;
            while(rs.next()){
                i = 1;
                data.setValue(Integer.parseInt(rs.getString(1)),"Number of loans of each material",rs.getString(2));
            }
            if(i == 1){
                return data;
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return null;
    }

    @Override
    public DefaultPieDataset getPieData() throws SQLException {
        PreparedStatement result = null;
        try {
            result = db.getConnection().prepareStatement("select * from statistic order by count desc LIMIT 5;");
            var rs = result.executeQuery();
            DefaultPieDataset data = new DefaultPieDataset();
            int i = 0;
            while(rs.next()){
                i = 1;
                data.setValue(rs.getString(2),Integer.parseInt(rs.getString(1)));
            }
            if(i == 1){
                return data;
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return null;
    }

}
