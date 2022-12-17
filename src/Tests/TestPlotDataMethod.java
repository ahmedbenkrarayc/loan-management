package Tests;

import Managers.EmpruntData;
import org.junit.jupiter.api.Test;

import java.sql.SQLException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class TestPlotDataMethod {
    @Test
    void shouldBeNull(){
        var data = new EmpruntData();
        try {
            assertEquals(null,data.getPlotData(null));
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    void shouldntBeNull(){
        var data = new EmpruntData();
        try {
            assertNotNull(data.getPlotData("ahmed@gmail.com"));
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
