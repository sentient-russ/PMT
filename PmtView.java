import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableCellRenderer;
import java.awt.*;
public class PmtView extends JTable {
    public PmtView(){
        getTableHeader().setDefaultRenderer(new TableDarkHeader());
        getTableHeader().setPreferredSize(new Dimension(0,25));
        setDefaultRenderer(Object.class, new TableDarkCell());
        setRowHeight(20);
    }
    public void fixTable(JScrollPane scroll){
        scroll.setVerticalScrollBar(new ScrollBarCustom());
        JPanel panel = new JPanel();
        panel.setBackground(new Color(54,69,79));
        scroll.setCorner(JScrollPane.UPPER_RIGHT_CORNER, panel);
        scroll.getViewport().setBackground(new Color(222,225,226));
        scroll.setBorder(BorderFactory.createLineBorder(new Color(54,69,79)));
    }
    private class TableDarkHeader extends DefaultTableCellRenderer{
        @Override
        public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
            Component comp = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
            comp.setBackground(new Color(54,69,79));
            comp.setForeground(new Color(231,235,238));
            return comp;
        }
    }
    private class TableDarkCell extends DefaultTableCellRenderer{
        @Override
        public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
            Component comp = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
            if(isCellSelected(row, column)){
                if(row%2==0){
                    comp.setBackground(new Color(158,165,170));
                }else{
                    comp.setBackground(new Color(158,165,170));
                }
            }else{
                if(row%2==0){
                    comp.setBackground(new Color(238,240,240));
                }else{
                    comp.setBackground(new Color(222,225,226));
                }
            }
            setBorder(new EmptyBorder(0,5,0,5));
            return comp;
        }
    }
}
