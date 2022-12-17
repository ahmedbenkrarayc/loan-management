package Models;

/**
 * admin model
 * @author ahmed benkrara
 */
public class Admin {
    // admin id
    private int id;
    //admin email
    private String email;
    //admin password
    private String password;

    /**
     * admin constructor
     * @param id
     * @param email
     * @param password
     */
    public Admin(int id, String email, String password){
        setId(id);
        setEmail(email);
        setPassword(password);
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

    /**
     * password getter
     * @return
     */
    public String getPassword() {
        return password;
    }

    /**
     * password setter
     * @param password
     */
    public void setPassword(String password) {
        this.password = password;
    }
}
