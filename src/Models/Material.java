package Models;

/**
 * material model
 * @author ahmed benkrara
 */
public class Material {
    //material id
    private int id;
    //material title
    private String titre;
    //material cover
    private String cover;
    //material status 0 means not available and 1 means available
    private int status;

    /**
     * material constructor
     * @param id
     * @param titre
     * @param cover
     * @param status
     */
    public Material(int id, String titre, String cover, int status){
        setId(id);
        setTitre(titre);
        setCover(cover);
        setStatus(status);
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
     * titre getter
     * @return
     */
    public String getTitre() {
        return titre;
    }

    /**
     * titre setter
     * @param titre
     */
    public void setTitre(String titre) {
        this.titre = titre;
    }

    /**
     * cover getter
     * @return
     */
    public String getCover() {
        return cover;
    }

    /**
     * cover setter
     * @param cover
     */
    public void setCover(String cover) {
        this.cover = cover;
    }

    /**
     * status getter
     * @return
     */
    public int getStatus() {
        return status;
    }

    /**
     * status setter
     * @param status
     */
    public void setStatus(int status) {
        this.status = status;
    }
}
