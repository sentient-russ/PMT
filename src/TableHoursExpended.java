import java.awt.*;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableCellRenderer;
/**
 *
 * @author russe
 */
public class TableHoursExpended extends JTable {
    public TableHoursExpended(){
        getTableHeader().setDefaultRenderer(new TableHoursExpendedHeader());
        getTableHeader().setPreferredSize(new Dimension(0,25));
        setDefaultRenderer(Object.class, new TableHoursExpendedCell());
        setRowHeight(25);
    }
    private class TableHoursExpendedHeader extends DefaultTableCellRenderer{
        @Override
        public Component getTableCellRendererComponent(JTable jTable, Object o, boolean bin, boolean bln1, int i, int i1 ){
            Component com = super.getTableCellRendererComponent(jTable, o, bin, bln1, i, i1);
            com.setBackground(new Color(54, 69, 79));
            com.setForeground(new Color(231, 235, 238));
            com.setFont(com.getFont().deriveFont(Font.BOLD, 12));
            return com;
        }  
    }
    private class TableHoursExpendedCell extends DefaultTableCellRenderer{
        @Override
        public Component getTableCellRendererComponent(JTable jTable, Object o, boolean bin, boolean bln1, int row, int column ){
            Component com  = super.getTableCellRendererComponent(jTable, o, bin, bln1, row, column);
            if (isCellSelected(row, column)) {
                if (row % 2 == 0) {
                    com.setBackground(new Color(158, 165, 170));
                } else {
                    com.setBackground(new Color(158, 165, 170));
                }
            } else {
                if (row % 2 == 0) {
                    com.setBackground(new Color(238, 240, 240));
                } else {
                    com.setBackground(new Color(222, 225, 226));
                }
            }
            setBorder(new EmptyBorder(0, 5, 0, 5));
            return com;
        }  
    }
    public void scrollBarUpdateTeamMembersTable(JScrollPane scroll) {
        scroll.setVerticalScrollBar(new ScrollBarSettings());
        JPanel panel = new JPanel();
        panel.setBackground(new Color(54, 69, 79));
        scroll.setCorner(JScrollPane.UPPER_RIGHT_CORNER, panel);
        scroll.getViewport().setBackground(new Color(222, 225, 226));
        scroll.setBorder(BorderFactory.createLineBorder(new Color(54, 69, 79)));
    }
    public void scrollBarUpdateTeamMembersCombo(JScrollPane scroll) {
        scroll.setVerticalScrollBar(new ScrollBarSettings());
        JPanel panel = new JPanel();
        panel.setBackground(new Color(54, 69, 79));
        scroll.setCorner(JScrollPane.UPPER_RIGHT_CORNER, panel);
        scroll.getViewport().setBackground(new Color(222, 225, 226));
        scroll.setBorder(BorderFactory.createLineBorder(new Color(54, 69, 79)));
    }
}
