import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.ArrayList;

public class PMTApplication extends javax.swing.JFrame {
    static DbAccess dataAccess = new DbAccess();
    private JScrollPane jScrollPanel;
    public PmtView pmtView;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    public PMTApplication() {
        initComponents(); //This calls the method bellow that initializes various window controls like buttons and tables.
        getContentPane().setBackground(new Color(54, 69, 79)); //Sets the background color for the projects view.
        pmtView.scrollBarUpdateProjectViewTable(jScrollPanel); //updates the scrollbar in the initial projects view.
        DefaultTableModel model = (DefaultTableModel) pmtView.getModel();
        ArrayList<ProjectModel> resultsList = dataAccess.GetProjects(); //creates an array list of project models then uses the dataAccess instance to

        for (int i = 0; i <= resultsList.size() -1; i++) {
            model.addRow(new Object[]{resultsList.get(i).projId, resultsList.get(i).companyName, resultsList.get(i).projDescription, resultsList.get(i).projStatus, resultsList.get(i).projEstimatedHours, "Fix me"});
        }
    }
    public static void main(String[] args) {
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {

                new PMTApplication().setVisible(true);

            }
        });
        //Runs example-test cases. Remove for final release.
        //RussTestCases();
    }
    //This method is called from within the PMTApplication constructor above to initialize the form table.
    private void initComponents() {

        jScrollPanel = new javax.swing.JScrollPane();
        pmtView = new PmtView();
        jButton1 = new javax.swing.JButton();//***
        jButton2 = new javax.swing.JButton();//***
        jButton3 = new javax.swing.JButton();//***

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMaximumSize(new java.awt.Dimension(1000, 750));
        setMinimumSize(new java.awt.Dimension(1000, 750));
        setResizable(false);

        pmtView.setModel(new javax.swing.table.DefaultTableModel(
                new Object [][] {

                },
                new String [] {
                        "Proj. Id.", "Company Name", "Proj. Description", "Status", "Projected Hours", "Worked Hours"
                }
        ) {
            boolean[] canEdit = new boolean [] {
                    false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        pmtView.getTableHeader().setReorderingAllowed(false);
        jScrollPanel.setViewportView(pmtView);
        if (pmtView.getColumnModel().getColumnCount() > 0) {
            pmtView.getColumnModel().getColumn(0).setMinWidth(40);
            pmtView.getColumnModel().getColumn(0).setPreferredWidth(40);
            pmtView.getColumnModel().getColumn(1).setMinWidth(100);
            pmtView.getColumnModel().getColumn(1).setPreferredWidth(200);
            pmtView.getColumnModel().getColumn(2).setMinWidth(100);
            pmtView.getColumnModel().getColumn(2).setPreferredWidth(350);
            pmtView.getColumnModel().getColumn(3).setMinWidth(50);
            pmtView.getColumnModel().getColumn(3).setPreferredWidth(75);
            pmtView.getColumnModel().getColumn(4).setMinWidth(50);
            pmtView.getColumnModel().getColumn(4).setPreferredWidth(75);
            pmtView.getColumnModel().getColumn(5).setMinWidth(50);
            pmtView.getColumnModel().getColumn(5).setPreferredWidth(75);
        }
        jButton1.setText("Delete");//***
        jButton1.setToolTipText("");//***
        jButton1.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));//***
        jButton1.addActionListener(new java.awt.event.ActionListener() {//***
            public void actionPerformed(java.awt.event.ActionEvent evt) {//***
                jButton1ActionPerformed(evt);//***
            }//***
        });//***

        jButton2.setText("Add New");//***
        jButton2.setToolTipText("");//***
        jButton2.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));//***
        jButton2.addActionListener(new java.awt.event.ActionListener() {//***
            public void actionPerformed(java.awt.event.ActionEvent evt) {//***
                jButton2ActionPerformed(evt);//***
            }//***
        });//***

        jButton3.setText("Update");//***
        jButton3.setToolTipText("");//***
        jButton3.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));//***
        jButton3.addActionListener(new java.awt.event.ActionListener() {//***
            public void actionPerformed(java.awt.event.ActionEvent evt) {//***
                jButton3ActionPerformed(evt);//***
            }//***
        });//***
        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());//***
        getContentPane().setLayout(layout);//***

        layout.setHorizontalGroup(//***
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()//***
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)//***
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)//***
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)//***
                                .addGap(37, 37, 37))//***
                        .addGroup(layout.createSequentialGroup()//***
                                .addGap(24, 24, 24)//***
                                .addComponent(jScrollPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 954, javax.swing.GroupLayout.PREFERRED_SIZE)//***
                                .addContainerGap(22, Short.MAX_VALUE))//***
        );
        layout.setVerticalGroup(//***
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)//***
                        .addGroup(layout.createSequentialGroup()//***
                                .addGap(256, 256, 256)//***
                                .addComponent(jScrollPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(10, 10, 10)//***
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)//***
                                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)//***
                                        .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)//***
                                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))//***
                                .addContainerGap(21, Short.MAX_VALUE))//***
        );//***

        pack();
        setLocationRelativeTo(null);
    }
    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//***
        System.out.println("Pressed the CLOSE button.");//***
    }//***

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//***
        // TODO add your handling code here://***
    }//***

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//***
        // TODO add your handling code here://***
    }//***
    //Test method to be removed for in final production release
    public static void RussTestCases () {

        //get projects from db
        ArrayList<ProjectModel> resultsList = dataAccess.GetProjects();
        printProjects(resultsList);
        //delete a record from projects table by passing project id as an int
            /*
            //dataAccess.DeleteProject(resultsList.get(3).projId);
            //dataAccess.DeleteProject(3);
            */

        //add new project
            /*
            ProjectModel newProject = new ProjectModel();
            newProject.companyName = "New Company";
            newProject.projOwner = "Owner Name";
            newProject.projManager = "PM Name";
            newProject.projDescription = "Detailed project description that can be in the form of a vission statement.";
            newProject.projEstimatedHours = "50";
            newProject.projStatus = "In-Progress";
            ArrayList<ProjectModel> updatedListWithNewId = dataAccess.InsertProject(newProject);
            */
    }
    //Can be used to println ArrayList of projects.
    //Test method to be removed for in final production release
    public static void printProjects (ArrayList <ProjectModel> projectsIn) {

        for (int i = 0; i < projectsIn.size(); i++) {
            System.out.println("Project Id:" + projectsIn.get(i).projId + ", Company: " + projectsIn.get(i).companyName +
                    ", Owner: " + projectsIn.get(i).projOwner + ", Manager: " + projectsIn.get(i).projManager +
                    ", Description: " + projectsIn.get(i).projDescription + ", Est. Hours: " + projectsIn.get(i).projEstimatedHours +
                    ", Status: " + projectsIn.get(i).projStatus);
        }
    }
}