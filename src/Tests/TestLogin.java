package Tests;

import Managers.LoginData;
import org.junit.jupiter.api.Test;

import java.sql.SQLException;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class TestLogin {
    @Test
    void shouldReturnFalse(){
        LoginData data = new LoginData();
        try {
            assertFalse(data.getAdmin("ahmed@gmail.com","test"));
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    void shouldReturnTrue(){
        LoginData data = new LoginData();
        try {
            assertTrue(data.getAdmin("ahmed@gmail.com","ahmed123"));
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    void shouldReturnFalse1(){
        LoginData data = new LoginData();
        try {
            assertFalse(data.getAdmin("ahmed@gmail.co","ahmed123"));
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
