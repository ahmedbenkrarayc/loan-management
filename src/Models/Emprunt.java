package Models;

import java.util.Calendar;
import java.util.Date;

/**
 * Emprunt model
 * @author ahmed benkrara
 */
public class Emprunt {
    //emprunt id
    private int id;
    //emprunt start date
    private Date date_l;
    //emprunt back date
    private Date date_back;
    //emprunt duration
    private int duration;
    //material linked to emprunt
    private Material material;
    //student who loaned
    private Student student;

    /**
     * constructor
     * @param id
     * @param date_l
     * @param date_back
     * @param duration
     * @param material
     * @param student
     */
    public Emprunt(int id, Date date_l, Date date_back, int duration, Material material, Student student) {
        setId(id);
        setDate_l(date_l);
        setDate_back(date_back);
        setDuration(duration);
        setMaterial(material);
        setStudent(student);
    }

    /**
     * second constructor without id
     * @param date_l
     * @param date_back
     * @param duration
     * @param material
     * @param student
     */
    public Emprunt(Date date_l, Date date_back, int duration, Material material, Student student) {
        setDate_l(date_l);
        setDate_back(date_back);
        setDuration(duration);
        setMaterial(material);
        setStudent(student);
    }

    /**
     * id getter
     * @return
     */
    public int getId() {
        return id;
    }

    /**
     * id setter
     * @param id
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * date_l getter (date of loan)
     * @return
     */
    public Date getDate_l() {
        return date_l;
    }

    /**
     * date_l setter (date of loan)
     * @param date_l
     */
    public void setDate_l(Date date_l) {
        this.date_l = date_l;
    }

    /**
     * date_back getter
     * @return
     */
    public Date getDate_back() {
        return date_back;
    }

    /**
     * date_back setter
     * @param date_back
     */
    public void setDate_back(Date date_back) {
        this.date_back = date_back;
    }

    /**
     * duration getter
     * @return
     */
    public int getDuration() {
        return duration;
    }

    /**
     * duration setter
     * @param duration
     */
    public void setDuration(int duration) {
        this.duration = duration;
    }

    /**
     * material getter
     * @return
     */
    public Material getMaterial() {
        return material;
    }

    /**
     * material setter
     * @param material
     */
    public void setMaterial(Material material) {
        this.material = material;
    }

    /**
     * student getter
     * @return
     */
    public Student getStudent() {
        return student;
    }

    /**
     * student setter
     * @param student
     */
    public void setStudent(Student student) {
        this.student = student;
    }

    /**
     * a method that calculate the difference between two dates in day
     * @param date1
     * @param date2
     * @return
     */
    public static long delay(Date date1, Date date2){
        long res = date1.getTime() - date2.getTime();
        long difference_In_Days
                = (res
                / (1000 * 60 * 60 * 24))
                % 365;
        return difference_In_Days;
    }
}
