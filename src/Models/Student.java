package Models;

/**
 * student model
 * @author ahmed benkrara
 */
public class Student {
    //student id
    private int id;
    //student nom
    private String nom;
    //student prenom
    private String prenom;
    //student email
    private String email;

    /**
     * student constructor
     * @param id
     * @param nom
     * @param prenom
     * @param email
     */
    public Student(int id, String nom, String prenom, String email){
        setId(id);
        setNom(nom);
        setPrenom(prenom);
        setEmail(email);
    }

    /**
     * student constructor without id
     * @param nom
     * @param prenom
     * @param email
     */
    public Student(String nom, String prenom, String email){
        setNom(nom);
        setPrenom(prenom);
        setEmail(email);
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
     * nom getter
     * @return
     */
    public String getNom() {
        return nom;
    }

    /**
     * nom setter
     * @param nom
     */
    public void setNom(String nom) {
        this.nom = nom;
    }

    /**
     * prenom getter
     * @return
     */
    public String getPrenom() {
        return prenom;
    }

    /**
     * prenom setter
     * @param prenom
     */
    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    /**
     * email getter
     * @return
     */
    public String getEmail() {
        return email;
    }

    /**
     * email setter
     * @param email
     */
    public void setEmail(String email) {
        this.email = email;
    }
}
