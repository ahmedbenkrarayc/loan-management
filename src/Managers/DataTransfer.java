package Managers;

import Models.Material;
import Models.Student;
import Views.MainFrame;
import Views.StudentFrame;

/**
 * class contains static attributes for transferring data
 */
public class DataTransfer {
    /**
     * static attribute to transfer material data
     */
    public static Material material;
    /**
     * static attribute to transfer student data
     */
    public static Student student;
    /**
     * object to make changes on MainFrame from other Frames
     */
    public static MainFrame main = new MainFrame();
    /**
     * object to make changes on StudentFrame from other Frames
     */
    public static StudentFrame studentframe = new StudentFrame();

    /**
     * static attribute for transferring student data from HistoryPanel to HistoryFrame
     */
    public static int student_id = 0;

}
