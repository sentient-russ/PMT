import java.awt.Color;
import java.awt.Toolkit;
import java.awt.event.WindowEvent;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;

public class ViewProjectRequirements extends javax.swing.JFrame {
    DbAccess dataAccess = new DbAccess();
    int projIdGlobal = 0;
    public ViewProjectRequirements(int projId) {
        initComponents();
        projIdGlobal = projId;
        getContentPane().setBackground(new Color(54, 69, 79));
        
        tableFunctionalReqProject1.scrollBarUpdateProjectTable(jScrollPane2);
        tableNonFunctionalReqProject1.scrollBarUpdateProjectTable(jScrollPane3);        
        DefaultTableModel modelFunctional = (DefaultTableModel)tableFunctionalReqProject1.getModel();
        DefaultTableModel modelNonFunctional = (DefaultTableModel)tableNonFunctionalReqProject1.getModel();
        ArrayList<ModelRequirement> resultsList = dataAccess.GetRequirements(projId);
        for (int i = 0; i <= resultsList.size() -1; i++) {            
            if(resultsList.get(i).reqType.equalsIgnoreCase("Functional")){
                modelFunctional.addRow(new Object[]{resultsList.get(i).reqId, resultsList.get(i).projNumber, resultsList.get(i).reqDescription, resultsList.get(i).reqStatus, resultsList.get(i).reqType});
            } else if (resultsList.get(i).reqType.equalsIgnoreCase("Non-Functional")){
                modelNonFunctional.addRow(new Object[]{resultsList.get(i).reqId, resultsList.get(i).projNumber, resultsList.get(i).reqDescription, resultsList.get(i).reqStatus, resultsList.get(i).reqType});
            }
        }
        
        TextTotalExpended.setText(Integer.toString(dataAccess.calcExpendedTotal(projId)));
        ModelProject currentProject = dataAccess.GetProject(projId);
        TextProjectedHrs.setText(currentProject.projEstimatedHours);
        TextRiskStatus.setText(currentProject.projStatus);
        TextProjId.setText(Integer.toString(projId));        
        ArrayList<ModelRisk> risks = dataAccess.GetRisks(projId);
        for(int i = 0; i <= risks.size() -1; i++){
            if(risks.get(i).riskStatus.equalsIgnoreCase("Un-Resolved")){
                TextRiskStatus.setText("Risks Oustanding");
            }    
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

        tableProject1 = new TableFunctionalReqProject();
        tableProject2 = new TableFunctionalReqProject();
        jLabel4 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        projectNonFuncBtnAdd = new javax.swing.JButton();
        projectNonFuncBtnDelete = new javax.swing.JButton();
        projectNonFuncBtnUpdate = new javax.swing.JButton();
        projectFuncBtnDelete = new javax.swing.JButton();
        projectFuncBtnUpdate = new javax.swing.JButton();
        projectFuncBtnAdd = new javax.swing.JButton();
        projectFuncBtnBack = new javax.swing.JButton();
        projectFuncBtnHome = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        LabelTotalExpended = new javax.swing.JLabel();
        TextTotalExpended = new javax.swing.JLabel();
        LabelTotalExpended1 = new javax.swing.JLabel();
        LabelTotalExpended2 = new javax.swing.JLabel();
        TextRiskStatus = new javax.swing.JLabel();
        LabelTotalExpended3 = new javax.swing.JLabel();
        TextStatus = new javax.swing.JLabel();
        LabelTotalExpended4 = new javax.swing.JLabel();
        TextProjId = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jSeparator3 = new javax.swing.JSeparator();
        jScrollPane3 = new javax.swing.JScrollPane();
        tableNonFunctionalReqProject1 = new TableNonFunctionalReqProject();
        jScrollPane2 = new javax.swing.JScrollPane();
        tableFunctionalReqProject1 = new TableFunctionalReqProject();
        jSeparator5 = new javax.swing.JSeparator();
        TextProjectedHrs = new javax.swing.JLabel();

        jLabel4.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(153, 153, 153));
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("Functional Requirements");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setForeground(new java.awt.Color(102, 102, 102));
        setMaximumSize(new java.awt.Dimension(1000, 1000));
        setMinimumSize(new java.awt.Dimension(1000, 1000));
        setPreferredSize(new java.awt.Dimension(1000, 900));
        setResizable(false);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pmt_logo_smaill.jpg"))); // NOI18N
        jLabel1.setAlignmentY(1.0F);

        projectNonFuncBtnAdd.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        projectNonFuncBtnAdd.setForeground(new java.awt.Color(0, 51, 102));
        projectNonFuncBtnAdd.setText("Add New");
        projectNonFuncBtnAdd.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        projectNonFuncBtnAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                projectNonFuncBtnAddActionPerformed(evt);
            }
        });

        projectNonFuncBtnDelete.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        projectNonFuncBtnDelete.setForeground(new java.awt.Color(204, 0, 0));
        projectNonFuncBtnDelete.setText("Delete");
        projectNonFuncBtnDelete.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        projectNonFuncBtnDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                projectNonFuncBtnDeleteActionPerformed(evt);
            }
        });

        projectNonFuncBtnUpdate.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        projectNonFuncBtnUpdate.setForeground(new java.awt.Color(0, 51, 102));
        projectNonFuncBtnUpdate.setText("Update");
        projectNonFuncBtnUpdate.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        projectNonFuncBtnUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                projectNonFuncBtnUpdateActionPerformed(evt);
            }
        });

        projectFuncBtnDelete.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        projectFuncBtnDelete.setForeground(new java.awt.Color(204, 0, 0));
        projectFuncBtnDelete.setText("Delete");
        projectFuncBtnDelete.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        projectFuncBtnDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                projectFuncBtnDeleteActionPerformed(evt);
            }
        });

        projectFuncBtnUpdate.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        projectFuncBtnUpdate.setForeground(new java.awt.Color(0, 51, 102));
        projectFuncBtnUpdate.setText("Update");
        projectFuncBtnUpdate.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        projectFuncBtnUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                projectFuncBtnUpdateActionPerformed(evt);
            }
        });

        projectFuncBtnAdd.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        projectFuncBtnAdd.setForeground(new java.awt.Color(0, 51, 102));
        projectFuncBtnAdd.setText("Add New");
        projectFuncBtnAdd.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        projectFuncBtnAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                projectFuncBtnAddActionPerformed(evt);
            }
        });

        projectFuncBtnBack.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        projectFuncBtnBack.setForeground(new java.awt.Color(0, 51, 102));
        projectFuncBtnBack.setText("Back");
        projectFuncBtnBack.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        projectFuncBtnBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                projectFuncBtnBackActionPerformed(evt);
            }
        });

        projectFuncBtnHome.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        projectFuncBtnHome.setForeground(new java.awt.Color(0, 51, 102));
        projectFuncBtnHome.setText("Home");
        projectFuncBtnHome.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        projectFuncBtnHome.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                projectFuncBtnHomeActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(153, 153, 153));
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("Functional Requirements");

        LabelTotalExpended.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        LabelTotalExpended.setForeground(new java.awt.Color(204, 204, 204));
        LabelTotalExpended.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        LabelTotalExpended.setText("Expended Hours");
        LabelTotalExpended.setToolTipText("");
        LabelTotalExpended.setName(""); // NOI18N
        LabelTotalExpended.setPreferredSize(new java.awt.Dimension(130, 25));

        TextTotalExpended.setForeground(new java.awt.Color(204, 204, 204));
        TextTotalExpended.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        TextTotalExpended.setText("0");
        TextTotalExpended.setToolTipText("");
        TextTotalExpended.setName(""); // NOI18N
        TextTotalExpended.setPreferredSize(new java.awt.Dimension(130, 25));

        LabelTotalExpended1.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        LabelTotalExpended1.setForeground(new java.awt.Color(204, 204, 204));
        LabelTotalExpended1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        LabelTotalExpended1.setText("Projected Hours");
        LabelTotalExpended1.setToolTipText("");
        LabelTotalExpended1.setName(""); // NOI18N
        LabelTotalExpended1.setPreferredSize(new java.awt.Dimension(130, 25));

        LabelTotalExpended2.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        LabelTotalExpended2.setForeground(new java.awt.Color(204, 204, 204));
        LabelTotalExpended2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        LabelTotalExpended2.setText("Risks Status");
        LabelTotalExpended2.setToolTipText("");
        LabelTotalExpended2.setMinimumSize(new java.awt.Dimension(100, 25));
        LabelTotalExpended2.setName(""); // NOI18N
        LabelTotalExpended2.setPreferredSize(new java.awt.Dimension(100, 25));

        TextRiskStatus.setForeground(new java.awt.Color(204, 204, 204));
        TextRiskStatus.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        TextRiskStatus.setText("Risks Resolved");
        TextRiskStatus.setToolTipText("");
        TextRiskStatus.setMinimumSize(new java.awt.Dimension(100, 25));
        TextRiskStatus.setName(""); // NOI18N
        TextRiskStatus.setPreferredSize(new java.awt.Dimension(100, 25));

        LabelTotalExpended3.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        LabelTotalExpended3.setForeground(new java.awt.Color(204, 204, 204));
        LabelTotalExpended3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        LabelTotalExpended3.setText("Proj. Status");
        LabelTotalExpended3.setToolTipText("");
        LabelTotalExpended3.setMinimumSize(new java.awt.Dimension(100, 25));
        LabelTotalExpended3.setName(""); // NOI18N
        LabelTotalExpended3.setPreferredSize(new java.awt.Dimension(100, 25));

        TextStatus.setForeground(new java.awt.Color(204, 204, 204));
        TextStatus.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        TextStatus.setText("In-Process");
        TextStatus.setToolTipText("");
        TextStatus.setMinimumSize(new java.awt.Dimension(100, 25));
        TextStatus.setName(""); // NOI18N
        TextStatus.setPreferredSize(new java.awt.Dimension(100, 25));

        LabelTotalExpended4.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        LabelTotalExpended4.setForeground(new java.awt.Color(204, 204, 204));
        LabelTotalExpended4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        LabelTotalExpended4.setText("Proj. Id");
        LabelTotalExpended4.setToolTipText("");
        LabelTotalExpended4.setMinimumSize(new java.awt.Dimension(100, 25));
        LabelTotalExpended4.setName(""); // NOI18N
        LabelTotalExpended4.setPreferredSize(new java.awt.Dimension(100, 25));

        TextProjId.setForeground(new java.awt.Color(204, 204, 204));
        TextProjId.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        TextProjId.setText("0");
        TextProjId.setToolTipText("");
        TextProjId.setMinimumSize(new java.awt.Dimension(100, 25));
        TextProjId.setName(""); // NOI18N
        TextProjId.setPreferredSize(new java.awt.Dimension(100, 25));

        jLabel5.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(153, 153, 153));
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setText("Non-Functional Requirements");
        jLabel5.setMaximumSize(new java.awt.Dimension(237, 35));
        jLabel5.setMinimumSize(new java.awt.Dimension(237, 35));
        jLabel5.setName(""); // NOI18N

        jSeparator3.setForeground(new java.awt.Color(204, 204, 204));

        tableNonFunctionalReqProject1.setForeground(new java.awt.Color(51, 51, 51));
        tableNonFunctionalReqProject1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Req. Id", "Proj. Id", "Req. Description", "Req. Status", "Req. Type"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane3.setViewportView(tableNonFunctionalReqProject1);
        if (tableNonFunctionalReqProject1.getColumnModel().getColumnCount() > 0) {
            tableNonFunctionalReqProject1.getColumnModel().getColumn(0).setMinWidth(25);
            tableNonFunctionalReqProject1.getColumnModel().getColumn(0).setPreferredWidth(50);
            tableNonFunctionalReqProject1.getColumnModel().getColumn(1).setMinWidth(25);
            tableNonFunctionalReqProject1.getColumnModel().getColumn(1).setPreferredWidth(50);
            tableNonFunctionalReqProject1.getColumnModel().getColumn(2).setMinWidth(50);
            tableNonFunctionalReqProject1.getColumnModel().getColumn(2).setPreferredWidth(450);
            tableNonFunctionalReqProject1.getColumnModel().getColumn(3).setMinWidth(25);
            tableNonFunctionalReqProject1.getColumnModel().getColumn(3).setPreferredWidth(50);
            tableNonFunctionalReqProject1.getColumnModel().getColumn(4).setMinWidth(25);
            tableNonFunctionalReqProject1.getColumnModel().getColumn(4).setPreferredWidth(50);
        }

        tableFunctionalReqProject1.setForeground(new java.awt.Color(51, 51, 51));
        tableFunctionalReqProject1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Req. Id", "Proj. Id", "Req. Description", "Req. Status", "Req. Type"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane2.setViewportView(tableFunctionalReqProject1);
        if (tableFunctionalReqProject1.getColumnModel().getColumnCount() > 0) {
            tableFunctionalReqProject1.getColumnModel().getColumn(0).setMinWidth(25);
            tableFunctionalReqProject1.getColumnModel().getColumn(0).setPreferredWidth(50);
            tableFunctionalReqProject1.getColumnModel().getColumn(1).setMinWidth(25);
            tableFunctionalReqProject1.getColumnModel().getColumn(1).setPreferredWidth(50);
            tableFunctionalReqProject1.getColumnModel().getColumn(2).setMinWidth(50);
            tableFunctionalReqProject1.getColumnModel().getColumn(2).setPreferredWidth(450);
            tableFunctionalReqProject1.getColumnModel().getColumn(3).setMinWidth(25);
            tableFunctionalReqProject1.getColumnModel().getColumn(3).setPreferredWidth(50);
            tableFunctionalReqProject1.getColumnModel().getColumn(4).setMinWidth(25);
            tableFunctionalReqProject1.getColumnModel().getColumn(4).setPreferredWidth(50);
        }

        jSeparator5.setForeground(new java.awt.Color(204, 204, 204));

        TextProjectedHrs.setForeground(new java.awt.Color(204, 204, 204));
        TextProjectedHrs.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        TextProjectedHrs.setText("0");
        TextProjectedHrs.setToolTipText("");
        TextProjectedHrs.setName(""); // NOI18N
        TextProjectedHrs.setPreferredSize(new java.awt.Dimension(130, 25));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 962, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(projectFuncBtnAdd, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(projectFuncBtnUpdate, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(projectFuncBtnDelete, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 954, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addContainerGap(20, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(projectFuncBtnBack, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel1)
                        .addGap(149, 149, 149)
                        .addComponent(projectFuncBtnHome, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(20, 20, 20))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 962, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 954, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                    .addGap(540, 540, 540)
                                    .addComponent(projectNonFuncBtnAdd, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(projectNonFuncBtnUpdate, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(projectNonFuncBtnDelete, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(0, 0, Short.MAX_VALUE))))
            .addGroup(layout.createSequentialGroup()
                .addGap(202, 202, 202)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(TextProjId, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(LabelTotalExpended4, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(TextStatus, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(LabelTotalExpended3, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(TextRiskStatus, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(LabelTotalExpended2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(LabelTotalExpended1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 6, Short.MAX_VALUE))
                            .addComponent(TextProjectedHrs, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(TextTotalExpended, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(LabelTotalExpended, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jSeparator3)
                    .addComponent(jSeparator5, javax.swing.GroupLayout.PREFERRED_SIZE, 596, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(projectFuncBtnBack, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(projectFuncBtnHome, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, 8, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(4, 4, 4)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(LabelTotalExpended, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(TextTotalExpended, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(TextProjectedHrs, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(LabelTotalExpended1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(LabelTotalExpended2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(TextRiskStatus, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(LabelTotalExpended3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(TextStatus, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                            .addComponent(LabelTotalExpended4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(TextProjId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator5, javax.swing.GroupLayout.PREFERRED_SIZE, 8, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(28, 28, 28)
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 245, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(projectFuncBtnUpdate, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(projectFuncBtnAdd, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(projectFuncBtnDelete, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(11, 11, 11)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(projectNonFuncBtnUpdate, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(projectNonFuncBtnAdd, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(projectNonFuncBtnDelete, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20))
        );

        getAccessibleContext().setAccessibleDescription("");

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void projectNonFuncBtnAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_projectNonFuncBtnAddActionPerformed
        System.out.println("Add Non-Functional");
    }//GEN-LAST:event_projectNonFuncBtnAddActionPerformed

    private void projectNonFuncBtnDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_projectNonFuncBtnDeleteActionPerformed
        System.out.println("Delete Non-Functional");
    }//GEN-LAST:event_projectNonFuncBtnDeleteActionPerformed

    private void projectNonFuncBtnUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_projectNonFuncBtnUpdateActionPerformed
        System.out.println("Update Non-Functional");
    }//GEN-LAST:event_projectNonFuncBtnUpdateActionPerformed

    private void projectFuncBtnDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_projectFuncBtnDeleteActionPerformed
        System.out.println("Delete Functional");
    }//GEN-LAST:event_projectFuncBtnDeleteActionPerformed

    private void projectFuncBtnUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_projectFuncBtnUpdateActionPerformed
        System.out.println("Update Functional");
    }//GEN-LAST:event_projectFuncBtnUpdateActionPerformed

    private void projectFuncBtnAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_projectFuncBtnAddActionPerformed
        System.out.println("Add Functional");
    }//GEN-LAST:event_projectFuncBtnAddActionPerformed

    private void projectFuncBtnBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_projectFuncBtnBackActionPerformed
                ViewProjectDetails vh = new ViewProjectDetails(projIdGlobal);
                vh.setVisible(true);
                this.dispose();
    }//GEN-LAST:event_projectFuncBtnBackActionPerformed

    private void projectFuncBtnHomeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_projectFuncBtnHomeActionPerformed
                ViewHome vh = new ViewHome();
                vh.setVisible(true);
                this.dispose();
                
    }//GEN-LAST:event_projectFuncBtnHomeActionPerformed
    public void close(){
        WindowEvent closeWindow = new WindowEvent(this, WindowEvent.WINDOW_CLOSING);
        Toolkit.getDefaultToolkit().getSystemEventQueue().postEvent(closeWindow);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel LabelTotalExpended;
    private javax.swing.JLabel LabelTotalExpended1;
    private javax.swing.JLabel LabelTotalExpended2;
    private javax.swing.JLabel LabelTotalExpended3;
    private javax.swing.JLabel LabelTotalExpended4;
    private javax.swing.JLabel TextProjId;
    private javax.swing.JLabel TextProjectedHrs;
    private javax.swing.JLabel TextRiskStatus;
    private javax.swing.JLabel TextStatus;
    private javax.swing.JLabel TextTotalExpended;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JSeparator jSeparator5;
    private javax.swing.JButton projectFuncBtnAdd;
    private javax.swing.JButton projectFuncBtnBack;
    private javax.swing.JButton projectFuncBtnDelete;
    private javax.swing.JButton projectFuncBtnHome;
    private javax.swing.JButton projectFuncBtnUpdate;
    private javax.swing.JButton projectNonFuncBtnAdd;
    private javax.swing.JButton projectNonFuncBtnDelete;
    private javax.swing.JButton projectNonFuncBtnUpdate;
    private TableFunctionalReqProject tableFunctionalReqProject1;
    private TableNonFunctionalReqProject tableNonFunctionalReqProject1;
    private TableFunctionalReqProject tableProject1;
    private TableFunctionalReqProject tableProject2;
    // End of variables declaration//GEN-END:variables
}
