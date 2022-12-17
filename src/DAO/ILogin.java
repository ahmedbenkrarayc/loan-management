package DAO;

import Models.Admin;

import java.sql.SQLException;
import java.util.ArrayList;

/**
 * Interface for definning Login methods
 * @author ahmed benkrara
 */
public interface ILogin {
    /**
     * @param email
     * @param password
     * @return Boolean
     * @throws SQLException
     */
    Boolean getAdmin(String email, String password) throws SQLException;
}
