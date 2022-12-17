package Models;

import java.util.Calendar;
import java.util.Date;

public class Emprunt {
    private int id;
    private Date date_l;
    private Date date_back;
    private int duration;
    private Material material;
    private Student student;

    public Emprunt(int id, Date date_l, Date date_back, int duration, Material material, Student student) {
        setId(id);
        setDate_l(date_l);
        setDate_back(date_back);
        setDuration(duration);
        setMaterial(material);
        setStudent(student);
    }

    public Emprunt(Date date_l, Date date_back, int duration, Material material, Student student) {
        setDate_l(date_l);
        setDate_back(date_back);
        setDuration(duration);
        setMaterial(material);
        setStudent(student);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getDate_l() {
        return date_l;
    }

    public void setDate_l(Date date_l) {
        this.date_l = date_l;
    }

    public Date getDate_back() {
        return date_back;
    }

    public void setDate_back(Date date_back) {
        this.date_back = date_back;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public Material getMaterial() {
        return material;
    }

    public void setMaterial(Material material) {
        this.material = material;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public static long delay(Date date1, Date date2){
        long res = date1.getTime() - date2.getTime();
        long difference_In_Days
                = (res
                / (1000 * 60 * 60 * 24))
                % 365;
        return difference_In_Days;
    }
}
