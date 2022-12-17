package Models;

public class Material {
    private int id;
    private String titre;
    private String cover;
    private int status;

    public Material(int id, String titre, String cover, int status){
        setId(id);
        setTitre(titre);
        setCover(cover);
        setStatus(status);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitre() {
        return titre;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    public String getCover() {
        return cover;
    }

    public void setCover(String cover) {
        this.cover = cover;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }
}
