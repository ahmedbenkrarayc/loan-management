package Models;

public class Student {
    private int id;
    private String nom;
    private String prenom;
    private String email;

    public Student(int id, String nom, String prenom, String email){
        setId(id);
        setNom(nom);
        setPrenom(prenom);
        setEmail(email);
    }
    public Student(String nom, String prenom, String email){
        setNom(nom);
        setPrenom(prenom);
        setEmail(email);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
