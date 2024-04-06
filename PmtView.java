import javax.swing.*;
import java.awt.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.DefaultTableCellRenderer;
import java.util.ArrayList;


public class PmtView extends JFrame{

    static JFrame majorFrame = new JFrame("PMT");

    public static void main(String[] args) {
        majorFrame.setVisible(true);
        majorFrame.setSize(800,800);
        startPage();
    }

    public static void startPage(){
        JPanel panel = new JPanel();
        panel.setLayout(null);
        panel.setBounds(0,0,800, 800);
        panel.setBackground(Color.WHITE);

        JButton add = new JButton("Add");
        add.setBounds(550,730,50, 25);
        add.setFont(new Font("Times New Roman", Font.PLAIN, 15));
        add.setBackground(Color.decode("#3B9EBF"));
        add.setOpaque(true);
        add.setBorder(BorderFactory.createEmptyBorder());
        add.setForeground(Color.WHITE);
        add.setBorderPainted(false);
        add.setFocusPainted(false);
        panel.add(add);

        JButton update = new JButton("Update");
        update.setBounds(610,730,50, 25);
        update.setFont(new Font("Times New Roman", Font.PLAIN, 15));
        update.setBackground(Color.decode("#3B9EBF"));
        update.setOpaque(true);
        update.setBorder(BorderFactory.createEmptyBorder());
        update.setForeground(Color.WHITE);
        update.setBorderPainted(false);
        update.setFocusPainted(false);
        panel.add(update);

        JButton delete = new JButton("Delete");
        delete.setBounds(670,730,50, 25);
        delete.setFont(new Font("Times New Roman", Font.PLAIN, 15));
        delete.setBackground(Color.RED);
        delete.setOpaque(true);
        delete.setBorder(BorderFactory.createEmptyBorder());
        delete.setForeground(Color.WHITE);
        delete.setBorderPainted(false);
        delete.setFocusPainted(false);
        panel.add(delete);

        JButton exit = new JButton("X");
        exit.setBounds(700,10,50, 25);
        exit.setFont(new Font("Times New Roman", Font.PLAIN, 15));
        exit.setBackground(Color.decode("#3B9EBF"));
        exit.setOpaque(true);
        exit.setBorder(BorderFactory.createEmptyBorder());
        exit.setForeground(Color.WHITE);
        exit.setBorderPainted(false);
        exit.setFocusPainted(false);
        panel.add(exit);

        JLabel logo = new JLabel("P.M.T Logo");
        logo.setBounds(350,40,100, 25);
        logo.setBackground(Color.WHITE);
        logo.setOpaque(true);
        logo.setBorder(BorderFactory.createEmptyBorder());
        panel.add(logo);


        JLabel tag = new JLabel("Projects");
        tag.setBounds(350,70,100, 25);
        tag.setFont(new Font("Times New Roman", Font.BOLD, 25));
        tag.setBackground(Color.WHITE);
        tag.setOpaque(true);
        tag.setBorder(BorderFactory.createEmptyBorder());
        panel.add(tag);



        String[] columnNames = {"ID", "Company Name", "Owner", "Manager", "Description", "Estimated Hours", "Status"};
        DefaultTableModel model = new DefaultTableModel(columnNames, 0);
        JTable projects = new JTable(model);
        projects.setBounds(50, 200, 700, 500); // Adjust size as needed
        projects.setRowHeight(30);

        projects.setDefaultRenderer(Object.class, new DefaultTableCellRenderer(){
            @Override
            public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
                Component c = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
                if (!isSelected) {
                    c.setBackground(row % 2 == 0 ? Color.WHITE : new Color(238, 238, 238)); // Light gray for every other row
                } else {
                    c.setBackground(getBackground());
                }
                return c;
            }
        });

        // Fetch projects from database
        DbAccess dbAccess = new DbAccess();
        ArrayList<ProjectModel> projectList = dbAccess.GetProjects();
        for (ProjectModel project : projectList) {
            model.addRow(new Object[]{
                    project.getProjId(),
                    project.getCompanyName(),
                    project.getProjOwner(),
                    project.getProjManager(),
                    project.getProjDescription(),
                    project.getProjEstimatedHours(),
                    project.getProjStatus()
            });
        }

        JScrollPane js = new JScrollPane(projects);
        js.setBounds(50, 200, 700, 500); // Adjust size as needed
        panel.add(js);


        majorFrame.add(panel);
    }



}