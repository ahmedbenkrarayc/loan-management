package DAO;

import Models.Admin;

import java.sql.SQLException;
import java.util.ArrayList;

public interface ILogin {
    Boolean getAdmin(String email, String password) throws SQLException;
}
