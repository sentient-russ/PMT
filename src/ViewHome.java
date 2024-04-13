import java.awt.Color;
import java.awt.Toolkit;
import java.awt.event.WindowEvent;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;

public class ViewHome extends javax.swing.JFrame {
    DbAccess dataAccess = new DbAccess();
    /**
     * Creates new form ViewHome
     */
    public ViewHome() {
        initComponents();
        getContentPane().setBackground(new Color(54, 69, 79));
        homeTbl1.scrollBarUpdateHomeTable(jScrollPane1);
        DefaultTableModel model = (DefaultTableModel)homeTbl1.getModel();
        ArrayList<ModelProject> resultsList = dataAccess.GetProjects();
        
        for (int i = 0; i <= resultsList.size() -1; i++) {
            String hoursExpended = Integer.toString(dataAccess.calcExpendedTotal(resultsList.get(i).projId));
            model.addRow(new Object[]{resultsList.get(i).projId, resultsList.get(i).companyName, resultsList.get(i).projDescription, resultsList.get(i).projStatus, resultsList.get(i).projEstimatedHours, hoursExpended});
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pmtApplication1 = new TableHome();
        jScrollPane1 = new javax.swing.JScrollPane();
        homeTbl1 = new TableHome();
        logo1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        homeBtnAdd = new javax.swing.JButton();
        homeBtnDelete = new javax.swing.JButton();
        homeBtnUpdate = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Project Management Tool (P.M.T.)");
        setFocusCycleRoot(false);
        setMinimumSize(new java.awt.Dimension(1000, 1000));
        setPreferredSize(new java.awt.Dimension(1000, 1000));

        homeTbl1.setForeground(new java.awt.Color(51, 51, 51));
        homeTbl1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Proj. Id", "Company Name", "Proj. Description", "Status", "Projected Hours", "Expended Hours"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(homeTbl1);
        if (homeTbl1.getColumnModel().getColumnCount() > 0) {
            homeTbl1.getColumnModel().getColumn(0).setMinWidth(25);
            homeTbl1.getColumnModel().getColumn(0).setPreferredWidth(50);
            homeTbl1.getColumnModel().getColumn(1).setMinWidth(50);
            homeTbl1.getColumnModel().getColumn(1).setPreferredWidth(100);
            homeTbl1.getColumnModel().getColumn(2).setMinWidth(100);
            homeTbl1.getColumnModel().getColumn(2).setPreferredWidth(300);
            homeTbl1.getColumnModel().getColumn(3).setMinWidth(25);
            homeTbl1.getColumnModel().getColumn(3).setPreferredWidth(75);
            homeTbl1.getColumnModel().getColumn(4).setMinWidth(25);
            homeTbl1.getColumnModel().getColumn(4).setPreferredWidth(75);
            homeTbl1.getColumnModel().getColumn(5).setMinWidth(25);
            homeTbl1.getColumnModel().getColumn(5).setPreferredWidth(75);
        }

        logo1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pmt_logo_smaill.jpg"))); // NOI18N
        logo1.setAlignmentY(1.0F);
        logo1.setAutoscrolls(true);

        homeBtnAdd.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        homeBtnAdd.setForeground(new java.awt.Color(0, 51, 102));
        homeBtnAdd.setText("Add New");
        homeBtnAdd.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        homeBtnAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                homeBtnAddActionPerformed(evt);
            }
        });

        homeBtnDelete.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        homeBtnDelete.setForeground(new java.awt.Color(204, 0, 0));
        homeBtnDelete.setText("Delete");
        homeBtnDelete.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        homeBtnDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                homeBtnDeleteActionPerformed(evt);
            }
        });

        homeBtnUpdate.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        homeBtnUpdate.setForeground(new java.awt.Color(0, 51, 102));
        homeBtnUpdate.setText("View/Update");
        homeBtnUpdate.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        homeBtnUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                homeBtnUpdateActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(204, 204, 204));
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("All Projects");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel2)
                .addGap(6, 6, 6))
            .addGroup(layout.createSequentialGroup()
                .addGap(308, 308, 308)
                .addComponent(logo1)
                .addContainerGap(308, Short.MAX_VALUE))
            .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(homeBtnAdd, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(homeBtnUpdate, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(homeBtnDelete, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 934, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(logo1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel2)
                .addGap(50, 50, 50)
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 531, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(homeBtnUpdate, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(homeBtnAdd, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(homeBtnDelete, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(36, 36, 36))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void homeBtnAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_homeBtnAddActionPerformed
        java.awt.EventQueue.invokeLater(() -> {
            new ViewProjectNew().setVisible(true);
            this.setVisible(false);
            this.dispose();
        });
    }//GEN-LAST:event_homeBtnAddActionPerformed

    private void homeBtnDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_homeBtnDeleteActionPerformed
        DefaultTableModel tblModel = (DefaultTableModel) homeTbl1.getModel();
        //if single a row is selected then delete it. Multiple delete not allowed.
        if(homeTbl1.getSelectedRowCount() == 1){
            int rowIndex = homeTbl1.getSelectedRow();
            int projId = (int)tblModel.getValueAt(rowIndex, 0);
            tblModel.removeRow(rowIndex);
            dataAccess.DeleteProject(projId);
        }
    }//GEN-LAST:event_homeBtnDeleteActionPerformed

    private void homeBtnUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_homeBtnUpdateActionPerformed
            
        DefaultTableModel tblModel = (DefaultTableModel) homeTbl1.getModel();
        //if single a row is selected then delete it. Multiple delete not allowed.
        if(homeTbl1.getSelectedRowCount() == 1){
            int rowIndex = homeTbl1.getSelectedRow();
            int projId = (int)tblModel.getValueAt(rowIndex, 0);
                java.awt.EventQueue.invokeLater(() -> {
                    new ViewProjectDetails(projId).setVisible(true);
                    this.setVisible(false);
                    this.dispose();
            });
        }
    }//GEN-LAST:event_homeBtnUpdateActionPerformed
    public void close(){
        WindowEvent closeWindow = new WindowEvent(this, WindowEvent.WINDOW_CLOSING);
        Toolkit.getDefaultToolkit().getSystemEventQueue().postEvent(closeWindow);
    }
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(ViewHome.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ViewHome.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ViewHome.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ViewHome.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            new ViewHome().setVisible(true);
            
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton homeBtnAdd;
    private javax.swing.JButton homeBtnDelete;
    private javax.swing.JButton homeBtnUpdate;
    private TableHome homeTbl1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel logo1;
    private TableHome pmtApplication1;
    // End of variables declaration//GEN-END:variables
}