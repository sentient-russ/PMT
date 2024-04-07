import javax.swing.*;
import java.awt.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.DefaultTableCellRenderer;
import java.util.ArrayList;


public class PmtView extends JFrame{

    static JFrame majorFrame = new JFrame("PMT");
    static String selectedCompanyName;
    static String selectedOwner;
    static String selectedManager;
    static String selectedDescription;
    static String selectedEstimatedHours;
    static String selectedStatus;

    public static void main(String[] args) {
        majorFrame.setVisible(true);
        majorFrame.setSize(1200,800);
        startPage();
    }

    public static void startPage(){
        JPanel panel = new JPanel();
        panel.setLayout(null);
        panel.setBounds(0,0,1200, 800);
        panel.setBackground(Color.WHITE);

        JButton add = new JButton("Add");
        add.setBounds(950,730,50, 25);
        add.setFont(new Font("Times New Roman", Font.PLAIN, 15));
        add.setBackground(Color.decode("#3B9EBF"));
        add.setOpaque(true);
        add.setBorder(BorderFactory.createEmptyBorder());
        add.setForeground(Color.WHITE);
        add.setBorderPainted(false);
        add.setFocusPainted(false);
        add.addActionListener(e -> {
          //add button functionality goes here
            addNewPage();
            panel.setVisible(false);
        });
        panel.add(add);

        JButton delete = new JButton("Delete");
        delete.setBounds(1070,730,50, 25);
        delete.setFont(new Font("Times New Roman", Font.PLAIN, 15));
        delete.setBackground(Color.RED);
        delete.setOpaque(true);
        delete.setBorder(BorderFactory.createEmptyBorder());
        delete.setForeground(Color.WHITE);
        delete.setBorderPainted(false);
        delete.setFocusPainted(false);
        delete.addActionListener(e -> {
            //delete button functionality goes here
        });
        panel.add(delete);

        JButton exit = new JButton("X");
        exit.setBounds(1100,10,50, 25);
        exit.setFont(new Font("Times New Roman", Font.PLAIN, 15));
        exit.setBackground(Color.decode("#3B9EBF"));
        exit.setOpaque(true);
        exit.setBorder(BorderFactory.createEmptyBorder());
        exit.setForeground(Color.WHITE);
        exit.setBorderPainted(false);
        exit.setFocusPainted(false);
        exit.addActionListener(e -> {
            //exit button functionality goes here
            majorFrame.dispose();
        });
        panel.add(exit);

        ImageIcon icon = new ImageIcon("/Users/ekeneezeobi/Documents/GitHub/PMT/icon.png");

        JLabel logo = new JLabel(icon);
        logo.setBounds(570,20,50, 50);
        logo.setBackground(Color.WHITE);
        logo.setOpaque(true);
        logo.setBorder(BorderFactory.createEmptyBorder());
        panel.add(logo);


        JLabel tag = new JLabel("Projects");
        tag.setBounds(550,100,100, 25);
        tag.setFont(new Font("Times New Roman", Font.BOLD, 25));
        tag.setBackground(Color.WHITE);
        tag.setOpaque(true);
        tag.setBorder(BorderFactory.createEmptyBorder());
        panel.add(tag);



        String[] columnNames = {"ID", "Company Name", "Owner", "Manager", "Description", "Estimated Hours", "Status"};
        DefaultTableModel model = new DefaultTableModel(columnNames, 0);
        JTable projects = new JTable(model);
        projects.setBounds(50, 200, 1100, 500); // Adjust size as needed
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

        JButton update = new JButton("Update");
        update.setBounds(1010,730,50, 25);
        update.setFont(new Font("Times New Roman", Font.PLAIN, 15));
        update.setBackground(Color.decode("#3B9EBF"));
        update.setOpaque(true);
        update.setBorder(BorderFactory.createEmptyBorder());
        update.setForeground(Color.WHITE);
        update.setBorderPainted(false);
        update.setFocusPainted(false);
        update.addActionListener(e -> {
            //update button functionality goes here
            int selectedRow = projects.getSelectedRow();
            if (selectedRow >= 0) {
                DefaultTableModel model1 = (DefaultTableModel) projects.getModel();
                selectedCompanyName = model1.getValueAt(selectedRow, 1).toString();
                selectedOwner = model1.getValueAt(selectedRow, 2).toString();
                selectedManager = model1.getValueAt(selectedRow, 3).toString();
                selectedDescription = model1.getValueAt(selectedRow, 4).toString();
                selectedEstimatedHours = model1.getValueAt(selectedRow, 5).toString();
                selectedStatus = model1.getValueAt(selectedRow, 6).toString();

                // Now open updatePage populated with this data
                updatePage();
                panel.setVisible(false);
            } else {
                JOptionPane.showMessageDialog(majorFrame, "Please select a row to update.");
            }
        });
        panel.add(update);

        // Fetch projects from database
        ArrayList<ProjectModel> projectList = DbAccess.GetProjects();
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
        js.setBounds(50, 200, 1100, 500); // Adjust size as needed
        panel.add(js);


        majorFrame.add(panel);
    }

    public static void addNewPage(){
        JPanel panel = new JPanel();
        panel.setLayout(null);
        panel.setBounds(0,0,1200, 800);
        panel.setBackground(Color.WHITE);

        JPanel secondPanel = new JPanel();
        secondPanel.setLayout(null);
        secondPanel.setBounds(90,150,1020, 520);
        secondPanel.setBackground(Color.decode("#D3D3D3"));
        panel.add(secondPanel);

        JButton add = new JButton("Add");
        add.setBounds(870, 480,50, 25);
        add.setFont(new Font("Times New Roman", Font.PLAIN, 15));
        add.setBackground(Color.decode("#3B9EBF"));
        add.setOpaque(true);
        add.setBorder(BorderFactory.createEmptyBorder());
        add.setForeground(Color.WHITE);
        add.setBorderPainted(false);
        add.setFocusPainted(false);
        add.addActionListener(e -> {
            //update button functionality goes here
        });
        secondPanel.add(add);

        JButton delete = new JButton("Cancel");
        delete.setBounds(930, 480,50, 25);
        delete.setFont(new Font("Times New Roman", Font.PLAIN, 15));
        delete.setBackground(Color.RED);
        delete.setOpaque(true);
        delete.setBorder(BorderFactory.createEmptyBorder());
        delete.setForeground(Color.WHITE);
        delete.setBorderPainted(false);
        delete.setFocusPainted(false);
        delete.addActionListener(e -> {
            //delete button functionality goes here
        });
        secondPanel.add(delete);


        JButton exit = new JButton("X");
        exit.setBounds(1100,10,50, 25);
        exit.setFont(new Font("Times New Roman", Font.PLAIN, 15));
        exit.setBackground(Color.decode("#3B9EBF"));
        exit.setOpaque(true);
        exit.setBorder(BorderFactory.createEmptyBorder());
        exit.setForeground(Color.WHITE);
        exit.setBorderPainted(false);
        exit.setFocusPainted(false);
        exit.addActionListener(e -> {
            //exit button functionality goes here
            majorFrame.dispose();
        });
        panel.add(exit);

        ImageIcon icon = new ImageIcon("/Users/ekeneezeobi/Documents/GitHub/PMT/icon.png");

        JLabel logo = new JLabel(icon);
        logo.setBounds(570,20,50, 50);
        logo.setBackground(Color.WHITE);
        logo.setOpaque(true);
        logo.setBorder(BorderFactory.createEmptyBorder());
        panel.add(logo);


        JLabel tag = new JLabel("Projects");
        tag.setBounds(550,100,100, 25);
        tag.setFont(new Font("Times New Roman", Font.BOLD, 25));
        tag.setBackground(Color.WHITE);
        tag.setOpaque(true);
        tag.setBorder(BorderFactory.createEmptyBorder());
        panel.add(tag);



        JButton home = new JButton("Home");
        home.setBounds(1070,70,50, 25);
        home.setFont(new Font("Times New Roman", Font.PLAIN, 15));
        home.setBackground(Color.decode("#3B9EBF"));
        home.setOpaque(true);
        home.setBorder(BorderFactory.createEmptyBorder());
        home.setForeground(Color.WHITE);
        home.setBorderPainted(false);
        home.setFocusPainted(false);
        home.addActionListener(e -> {
            //home button functionality goes here
            panel.setVisible(false);
            startPage();
        });
        panel.add(home);


        JButton back = new JButton("Back");
        back.setBounds(70,70,50, 25);
        back.setFont(new Font("Times New Roman", Font.PLAIN, 15));
        back.setBackground(Color.decode("#3B9EBF"));
        back.setOpaque(true);
        back.setBorder(BorderFactory.createEmptyBorder());
        back.setForeground(Color.WHITE);
        back.setBorderPainted(false);
        back.setFocusPainted(false);
        back.addActionListener(e -> {
            //back button functionality goes here
            panel.setVisible(false);
            startPage();
        });
        panel.add(back);


        JButton TMembers = new JButton("View/Edit Team Members");
        TMembers.setBounds(550,700,170, 25);
        TMembers.setFont(new Font("Times New Roman", Font.PLAIN, 15));
        TMembers.setBackground(Color.decode("#3B9EBF"));
        TMembers.setOpaque(true);
        TMembers.setBorder(BorderFactory.createEmptyBorder());
        TMembers.setForeground(Color.WHITE);
        TMembers.setBorderPainted(false);
        TMembers.setFocusPainted(false);
        TMembers.addActionListener(e -> {
            //View or edit Team members button functionality goes here
            panel.setVisible(false);

        });
        panel.add(TMembers);


        JButton vERequirements = new JButton("View/Edit Requirements");
        vERequirements.setBounds(750,700,170, 25);
        vERequirements.setFont(new Font("Times New Roman", Font.PLAIN, 15));
        vERequirements.setBackground(Color.decode("#3B9EBF"));
        vERequirements.setOpaque(true);
        vERequirements.setBorder(BorderFactory.createEmptyBorder());
        vERequirements.setForeground(Color.WHITE);
        vERequirements.setBorderPainted(false);
        vERequirements.setFocusPainted(false);
        vERequirements.addActionListener(e -> {
            //view or edit requirements button functionality goes here
            panel.setVisible(false);

        });
        panel.add(vERequirements);


        JButton vERisk = new JButton("View/Edit Risk");
        vERisk.setBounds(950,700,170, 25);
        vERisk.setFont(new Font("Times New Roman", Font.PLAIN, 15));
        vERisk.setBackground(Color.decode("#3B9EBF"));
        vERisk.setOpaque(true);
        vERisk.setBorder(BorderFactory.createEmptyBorder());
        vERisk.setForeground(Color.WHITE);
        vERisk.setBorderPainted(false);
        vERisk.setFocusPainted(false);
        vERisk.addActionListener(e -> {
            //view or edit risk button functionality goes here
            panel.setVisible(false);

        });
        panel.add(vERisk);


        JLabel name = new JLabel("Company Name:");
        name.setFont(new Font("Times New Roman", Font.PLAIN, 15));
        name.setForeground(Color.BLACK);
        name.setBounds(10, 30, 300, 25);
        secondPanel.add(name);

        JTextField nameText = new JTextField(20);
        nameText.setFont(new Font("Times New Roman", Font.PLAIN, 15));
        nameText.setBackground(Color.WHITE);
        nameText.setBounds(150, 30, 850, 25);
        secondPanel.add(nameText);

        JLabel owner = new JLabel("Project Owner:");
        owner.setFont(new Font("Times New Roman", Font.PLAIN, 15));
        owner.setForeground(Color.BLACK);
        owner.setBounds(10, 80, 300, 25);
        secondPanel.add(owner);

        JTextField ownerText = new JTextField(20);
        ownerText.setFont(new Font("Times New Roman", Font.PLAIN, 15));
        ownerText.setBackground(Color.WHITE);
        ownerText.setBounds(150, 80, 850, 25);
        secondPanel.add(ownerText);


        JLabel manager = new JLabel("Project Manager:");
        manager.setFont(new Font("Times New Roman", Font.PLAIN, 15));
        manager.setForeground(Color.BLACK);
        manager.setBounds(10, 130, 300, 25);
        secondPanel.add(manager);

        JTextField managerText = new JTextField(20);
        managerText.setFont(new Font("Times New Roman", Font.PLAIN, 15));
        managerText.setBackground(Color.WHITE);
        managerText.setBounds(150, 130, 850, 25);
        secondPanel.add(managerText);

        JLabel members = new JLabel("Team Members:");
        members.setFont(new Font("Times New Roman", Font.PLAIN, 15));
        members.setForeground(Color.BLACK);
        members.setBounds(10, 180, 300, 25);
        secondPanel.add(members);

        JTextField membersText = new JTextField(20);
        membersText.setFont(new Font("Times New Roman", Font.PLAIN, 15));
        membersText.setBackground(Color.WHITE);
        membersText.setBounds(150, 180, 850, 25);
        secondPanel.add(membersText);

        JLabel estimatedHours = new JLabel("Estimated Hours:");
        estimatedHours.setFont(new Font("Times New Roman", Font.PLAIN, 15));
        estimatedHours.setForeground(Color.BLACK);
        estimatedHours.setBounds(10, 230, 300, 25);
        secondPanel.add(estimatedHours);

        JTextField estimatedHoursText = new JTextField(20);
        estimatedHoursText.setFont(new Font("Times New Roman", Font.PLAIN, 15));
        estimatedHoursText.setBackground(Color.WHITE);
        estimatedHoursText.setBounds(150, 230, 850, 25);
        secondPanel.add(estimatedHoursText);

        JLabel status = new JLabel("Status:");
        status.setFont(new Font("Times New Roman", Font.PLAIN, 15));
        status.setForeground(Color.BLACK);
        status.setBounds(10, 280, 280, 25);
        secondPanel.add(status);

        JTextField statusText = new JTextField(20);
        statusText.setFont(new Font("Times New Roman", Font.PLAIN, 15));
        statusText.setBackground(Color.WHITE);
        statusText.setBounds(150, 280, 850, 25);
        secondPanel.add(statusText);

        JLabel description = new JLabel("Project Description:");
        description.setFont(new Font("Times New Roman", Font.PLAIN, 15));
        description.setForeground(Color.BLACK);
        description.setBounds(10, 330, 300, 25);
        secondPanel.add(description);

        JTextArea descriptionText = new JTextArea();
        descriptionText.setFont(new Font("Times New Roman", Font.PLAIN, 15));
        descriptionText.setBackground(Color.WHITE);
        descriptionText.setBounds(150, 330, 850, 100);
        descriptionText.setLineWrap(true); // Makes lines wrap
        descriptionText.setWrapStyleWord(true);
        secondPanel.add(descriptionText);

        JScrollPane scrollPane = new JScrollPane(descriptionText);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        scrollPane.setBounds(150, 330, 850, 100);
        secondPanel.add(scrollPane);

        majorFrame.add(panel);
    }

    public static void updatePage(){
        JPanel panel = new JPanel();
        panel.setLayout(null);
        panel.setBounds(0,0,1200, 800);
        panel.setBackground(Color.WHITE);

        JPanel secondPanel = new JPanel();
        secondPanel.setLayout(null);
        secondPanel.setBounds(90,150,1020, 520);
        secondPanel.setBackground(Color.decode("#D3D3D3"));
        panel.add(secondPanel);

        JButton update = new JButton("Update");
        update.setBounds(870, 480,50, 25);
        update.setFont(new Font("Times New Roman", Font.PLAIN, 15));
        update.setBackground(Color.decode("#3B9EBF"));
        update.setOpaque(true);
        update.setBorder(BorderFactory.createEmptyBorder());
        update.setForeground(Color.WHITE);
        update.setBorderPainted(false);
        update.setFocusPainted(false);
        update.addActionListener(e -> {
            //update button functionality goes here
        });
        secondPanel.add(update);

        JButton delete = new JButton("Cancel");
        delete.setBounds(930, 480,50, 25);
        delete.setFont(new Font("Times New Roman", Font.PLAIN, 15));
        delete.setBackground(Color.RED);
        delete.setOpaque(true);
        delete.setBorder(BorderFactory.createEmptyBorder());
        delete.setForeground(Color.WHITE);
        delete.setBorderPainted(false);
        delete.setFocusPainted(false);
        delete.addActionListener(e -> {
            //delete button functionality goes here
        });
        secondPanel.add(delete);


        JButton exit = new JButton("X");
        exit.setBounds(1100,10,50, 25);
        exit.setFont(new Font("Times New Roman", Font.PLAIN, 15));
        exit.setBackground(Color.decode("#3B9EBF"));
        exit.setOpaque(true);
        exit.setBorder(BorderFactory.createEmptyBorder());
        exit.setForeground(Color.WHITE);
        exit.setBorderPainted(false);
        exit.setFocusPainted(false);
        exit.addActionListener(e -> {
            //exit button functionality goes here
            majorFrame.dispose();
        });
        panel.add(exit);

        ImageIcon icon = new ImageIcon("/Users/ekeneezeobi/Documents/GitHub/PMT/icon.png");

        JLabel logo = new JLabel(icon);
        logo.setBounds(570,20,50, 50);
        logo.setBackground(Color.WHITE);
        logo.setOpaque(true);
        logo.setBorder(BorderFactory.createEmptyBorder());
        panel.add(logo);


        JLabel tag = new JLabel("Projects");
        tag.setBounds(550,100,100, 25);
        tag.setFont(new Font("Times New Roman", Font.BOLD, 25));
        tag.setBackground(Color.WHITE);
        tag.setOpaque(true);
        tag.setBorder(BorderFactory.createEmptyBorder());
        panel.add(tag);



        JButton home = new JButton("Home");
        home.setBounds(1070,70,50, 25);
        home.setFont(new Font("Times New Roman", Font.PLAIN, 15));
        home.setBackground(Color.decode("#3B9EBF"));
        home.setOpaque(true);
        home.setBorder(BorderFactory.createEmptyBorder());
        home.setForeground(Color.WHITE);
        home.setBorderPainted(false);
        home.setFocusPainted(false);
        home.addActionListener(e -> {
            //home button functionality goes here
            panel.setVisible(false);
            startPage();
        });
        panel.add(home);


        JButton back = new JButton("Back");
        back.setBounds(70,70,50, 25);
        back.setFont(new Font("Times New Roman", Font.PLAIN, 15));
        back.setBackground(Color.decode("#3B9EBF"));
        back.setOpaque(true);
        back.setBorder(BorderFactory.createEmptyBorder());
        back.setForeground(Color.WHITE);
        back.setBorderPainted(false);
        back.setFocusPainted(false);
        back.addActionListener(e -> {
            //back button functionality goes here
            panel.setVisible(false);
            startPage();
        });
        panel.add(back);


        JButton TMembers = new JButton("View/Edit Team Members");
        TMembers.setBounds(550,700,170, 25);
        TMembers.setFont(new Font("Times New Roman", Font.PLAIN, 15));
        TMembers.setBackground(Color.decode("#3B9EBF"));
        TMembers.setOpaque(true);
        TMembers.setBorder(BorderFactory.createEmptyBorder());
        TMembers.setForeground(Color.WHITE);
        TMembers.setBorderPainted(false);
        TMembers.setFocusPainted(false);
        TMembers.addActionListener(e -> {
            //View or edit Team members button functionality goes here
            panel.setVisible(false);

        });
        panel.add(TMembers);


        JButton vERequirements = new JButton("View/Edit Requirements");
        vERequirements.setBounds(750,700,170, 25);
        vERequirements.setFont(new Font("Times New Roman", Font.PLAIN, 15));
        vERequirements.setBackground(Color.decode("#3B9EBF"));
        vERequirements.setOpaque(true);
        vERequirements.setBorder(BorderFactory.createEmptyBorder());
        vERequirements.setForeground(Color.WHITE);
        vERequirements.setBorderPainted(false);
        vERequirements.setFocusPainted(false);
        vERequirements.addActionListener(e -> {
            //view or edit requirements button functionality goes here
            panel.setVisible(false);

        });
        panel.add(vERequirements);


        JButton vERisk = new JButton("View/Edit Risk");
        vERisk.setBounds(950,700,170, 25);
        vERisk.setFont(new Font("Times New Roman", Font.PLAIN, 15));
        vERisk.setBackground(Color.decode("#3B9EBF"));
        vERisk.setOpaque(true);
        vERisk.setBorder(BorderFactory.createEmptyBorder());
        vERisk.setForeground(Color.WHITE);
        vERisk.setBorderPainted(false);
        vERisk.setFocusPainted(false);
        vERisk.addActionListener(e -> {
            //view or edit risk button functionality goes here
            panel.setVisible(false);

        });
        panel.add(vERisk);


        JLabel name = new JLabel("Company Name:");
        name.setFont(new Font("Times New Roman", Font.PLAIN, 15));
        name.setForeground(Color.BLACK);
        name.setBounds(10, 30, 300, 25);
        secondPanel.add(name);

        JTextField nameText = new JTextField(selectedCompanyName);
        nameText.setFont(new Font("Times New Roman", Font.PLAIN, 15));
        nameText.setBackground(Color.WHITE);
        nameText.setBounds(150, 30, 850, 25);
        secondPanel.add(nameText);

        JLabel owner = new JLabel("Project Owner:");
        owner.setFont(new Font("Times New Roman", Font.PLAIN, 15));
        owner.setForeground(Color.BLACK);
        owner.setBounds(10, 80, 300, 25);
        secondPanel.add(owner);

        JTextField ownerText = new JTextField(selectedOwner);
        ownerText.setFont(new Font("Times New Roman", Font.PLAIN, 15));
        ownerText.setBackground(Color.WHITE);
        ownerText.setBounds(150, 80, 850, 25);
        secondPanel.add(ownerText);


        JLabel manager = new JLabel("Project Manager:");
        manager.setFont(new Font("Times New Roman", Font.PLAIN, 15));
        manager.setForeground(Color.BLACK);
        manager.setBounds(10, 130, 300, 25);
        secondPanel.add(manager);

        JTextField managerText = new JTextField(selectedManager);
        managerText.setFont(new Font("Times New Roman", Font.PLAIN, 15));
        managerText.setBackground(Color.WHITE);
        managerText.setBounds(150, 130, 850, 25);
        secondPanel.add(managerText);

        JLabel members = new JLabel("Team Members:");
        members.setFont(new Font("Times New Roman", Font.PLAIN, 15));
        members.setForeground(Color.BLACK);
        members.setBounds(10, 180, 300, 25);
        secondPanel.add(members);

        JTextField membersText = new JTextField(20);
        membersText.setFont(new Font("Times New Roman", Font.PLAIN, 15));
        membersText.setBackground(Color.WHITE);
        membersText.setBounds(150, 180, 850, 25);
        secondPanel.add(membersText);

        JLabel estimatedHours = new JLabel("Estimated Hours:");
        estimatedHours.setFont(new Font("Times New Roman", Font.PLAIN, 15));
        estimatedHours.setForeground(Color.BLACK);
        estimatedHours.setBounds(10, 230, 300, 25);
        secondPanel.add(estimatedHours);

        JTextField estimatedHoursText = new JTextField(selectedEstimatedHours);
        estimatedHoursText.setFont(new Font("Times New Roman", Font.PLAIN, 15));
        estimatedHoursText.setBackground(Color.WHITE);
        estimatedHoursText.setBounds(150, 230, 850, 25);
        secondPanel.add(estimatedHoursText);

        JLabel status = new JLabel("Status:");
        status.setFont(new Font("Times New Roman", Font.PLAIN, 15));
        status.setForeground(Color.BLACK);
        status.setBounds(10, 280, 280, 25);
        secondPanel.add(status);

        JTextField statusText = new JTextField(selectedStatus);
        statusText.setFont(new Font("Times New Roman", Font.PLAIN, 15));
        statusText.setBackground(Color.WHITE);
        statusText.setBounds(150, 280, 850, 25);
        secondPanel.add(statusText);

        JLabel description = new JLabel("Project Description:");
        description.setFont(new Font("Times New Roman", Font.PLAIN, 15));
        description.setForeground(Color.BLACK);
        description.setBounds(10, 330, 300, 25);
        secondPanel.add(description);

        JTextArea descriptionText = new JTextArea(selectedDescription);
        descriptionText.setFont(new Font("Times New Roman", Font.PLAIN, 15));
        descriptionText.setBackground(Color.WHITE);
        descriptionText.setBounds(150, 330, 850, 100);
        descriptionText.setLineWrap(true); // Makes lines wrap
        descriptionText.setWrapStyleWord(true);
        secondPanel.add(descriptionText);

        JScrollPane scrollPane = new JScrollPane(descriptionText);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        scrollPane.setBounds(150, 330, 850, 100);
        secondPanel.add(scrollPane);

        majorFrame.add(panel);
    }

}