package Pages;

import javax.swing.*;
import java.awt.*;

/**
 * a class to add a button to JTable that inherits DefaultCellEditor
 * @author ahmed benkrara
 */
public class ButtonEditorTable extends DefaultCellEditor {

    //declaring a JButton named btn
    private final JButton btn;

    /**
     * constructor
     * @param checkBox
     * @param btn
     */
    public ButtonEditorTable(JCheckBox checkBox,JButton btn)
    {
        super(checkBox);
        this.btn=btn;
    }

    /**
     * i use it to change button style and return it
     * @param table           the <code>JTable</code> that is asking the
     *                          editor to edit; can be <code>null</code>
     * @param value           the value of the cell to be edited; it is
     *                          up to the specific editor to interpret
     *                          and draw the value.  For example, if value is
     *                          the string "true", it could be rendered as a
     *                          string or it could be rendered as a check
     *                          box that is checked.  <code>null</code>
     *                          is a valid value
     * @param isSelected      true if the cell is to be rendered with
     *                          highlighting
     * @param row             the row of the cell being edited
     * @param column          the column of the cell being edited
     * @return
     */
    @Override
    public Component getTableCellEditorComponent(JTable table, Object value,
                                                 boolean isSelected, int row, int column) {
        if (isSelected) {
            btn.setForeground(table.getSelectionForeground());
            btn.setBackground(table.getSelectionBackground());
        }
        else
        {
            btn.setForeground(table.getForeground());
            btn.setBackground(table.getBackground());
        }
        return btn;
    }

}
