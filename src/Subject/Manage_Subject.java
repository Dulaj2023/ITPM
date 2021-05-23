/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Subject;

import DBConnection.DBConnect;
import Location.Manage_Locations;
import Student.Manage_student;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Rashmika Dulaj
 */
public class Manage_Subject extends javax.swing.JFrame {

    PreparedStatement ps;
    ResultSet rs;
    Connection con = null;
    
    public Manage_Subject() {
        initComponents();
        this.setLocationRelativeTo(null);
        LoadTAble();
        
        offerd_year.setEnabled(false);
        subject_name.setEnabled(false);
        subject_code.setEnabled(false);
        number_of_lection_hourws.setEnabled(false);    
        number_of_tutorial_hours.setEnabled(false);
        number_of_lab_hours.setEnabled(false);
        number_of_evalution_hours.setEnabled(false);
        
         jButton1.setEnabled(true);
        jButton2.setEnabled(false);
    }

    public void LoadTAble(){
        try {
            String quary = "Select * From subject";
            ps = DBConnect.getConnection().prepareStatement(quary);
            rs = ps.executeQuery();
            while(rs.next()){
                String id = rs.getString("id");
                if(rs.getInt("semester") == 1){
                    first_semester.setSelected(true);
                }
                if(rs.getInt("semester") == 2){
                    second_semester.setSelected(true);
                }
                String year = rs.getString("year");
                String semester = rs.getString("semester");
                String subjectName =rs.getString("subjectName");
                String subjectCode = rs.getString("subjectCode");
                int nofLecHours = rs.getInt("nofLecHours");
                int nofTutoHours = rs.getInt("nofTutoHours");
                int nofLabhours = rs.getInt("nofLabhours");
                int nofevaHours = rs.getInt("nofevaHours");

                String tbData[] = {id,subjectCode,subjectName,year,semester};
                DefaultTableModel tblModel = (DefaultTableModel)DetailsTable.getModel();
                
                tblModel.addRow(tbData);
            }
        } catch (SQLException ex) {
            Logger.getLogger(Manage_student.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    void clearAll(){
        offerd_year.setSelectedIndex(0);
        first_semester.setSelected(false);
        second_semester.setSelected(false);
        subject_name.setText("");
        subject_code.setText("");
        number_of_lection_hourws.setValue(0);
        number_of_tutorial_hours.setValue(0);
        number_of_lab_hours.setValue(0);
        number_of_evalution_hours.setValue(0);
        
        offerd_year.setEnabled(false);
        subject_name.setEnabled(false);
        subject_code.setEnabled(false);
        number_of_lection_hourws.setEnabled(false);    
        number_of_tutorial_hours.setEnabled(false);
        number_of_lab_hours.setEnabled(false);
        number_of_evalution_hours.setEnabled(false);
        
        jButton1.setEnabled(true);
        jButton2.setEnabled(false);
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel3 = new javax.swing.JPanel();
        subject_name = new javax.swing.JTextField();
        offerd_year = new javax.swing.JComboBox();
        subject_code = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        Clear = new javax.swing.JButton();
        first_semester = new javax.swing.JRadioButton();
        second_semester = new javax.swing.JRadioButton();
        jLabel10 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        DetailsTable = new javax.swing.JTable();
        jTextField1 = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        sub_id = new javax.swing.JLabel();
        number_of_lection_hourws = new javax.swing.JSpinner();
        number_of_tutorial_hours = new javax.swing.JSpinner();
        number_of_lab_hours = new javax.swing.JSpinner();
        number_of_evalution_hours = new javax.swing.JSpinner();
        jButton4 = new javax.swing.JButton();
        CloseBtn = new javax.swing.JButton();
        DeleteBtn = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        setResizable(false);

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));

        subject_name.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                subject_nameActionPerformed(evt);
            }
        });

        offerd_year.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Year 01", "Year 02", "Year 03", "Year 04" }));

        subject_code.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                subject_codeActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        jLabel2.setText("Number of Tutorial Hours  :");

        jLabel3.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        jLabel3.setText("Number of Lab Hours       :");
        jLabel3.setPreferredSize(new java.awt.Dimension(233, 22));

        jLabel4.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        jLabel4.setText("Number of evalution Hours   :");

        jLabel6.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        jLabel6.setText("Offerd Year     :");

        jLabel7.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        jLabel7.setText("Subject Name :");

        jLabel8.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        jLabel8.setText("Subject Code :");

        jLabel9.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        jLabel9.setText("Number of Lecture Hours   :");

        Clear.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        Clear.setForeground(new java.awt.Color(0, 0, 255));
        Clear.setText("Clear");
        Clear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ClearActionPerformed(evt);
            }
        });

        first_semester.setFont(new java.awt.Font("Arial", 0, 16)); // NOI18N
        first_semester.setText("1st Semester ");
        first_semester.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                first_semesterActionPerformed(evt);
            }
        });

        second_semester.setFont(new java.awt.Font("Arial", 0, 16)); // NOI18N
        second_semester.setText("2nd Semester");

        jLabel10.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        jLabel10.setText("Offerd Semester     :");

        DetailsTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Subject Code", "subject Nmae", "Offered Year", "Offered Sem "
            }
        ));
        DetailsTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                DetailsTableMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(DetailsTable);
        if (DetailsTable.getColumnModel().getColumnCount() > 0) {
            DetailsTable.getColumnModel().getColumn(1).setResizable(false);
        }

        jTextField1.setText("Search");
        jTextField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField1ActionPerformed(evt);
            }
        });

        jButton1.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jButton1.setForeground(new java.awt.Color(0, 0, 255));
        jButton1.setText("Edit");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jButton2.setForeground(new java.awt.Color(0, 0, 255));
        jButton2.setText("Update");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jButton3.setForeground(new java.awt.Color(0, 0, 255));
        jButton3.setText("Refresh");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        sub_id.setForeground(new java.awt.Color(255, 255, 255));

        jButton4.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jButton4.setForeground(new java.awt.Color(0, 0, 255));
        jButton4.setText("Add New");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        CloseBtn.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        CloseBtn.setForeground(new java.awt.Color(0, 0, 255));
        CloseBtn.setText("Close");
        CloseBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CloseBtnActionPerformed(evt);
            }
        });

        DeleteBtn.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        DeleteBtn.setForeground(new java.awt.Color(0, 0, 255));
        DeleteBtn.setText("Delete");
        DeleteBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DeleteBtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(17, 17, 17)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 891, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 306, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 371, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jButton2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jButton3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(DeleteBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(Clear, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(CloseBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(sub_id))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGap(45, 45, 45)
                                .addComponent(jLabel6)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(offerd_year, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGap(47, 47, 47)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel7, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel8, javax.swing.GroupLayout.Alignment.TRAILING))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(subject_code, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(subject_name, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 162, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(first_semester)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(second_semester)))
                        .addGap(43, 43, 43)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel2)
                                    .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 233, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(42, 42, 42)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(number_of_lection_hourws, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(number_of_tutorial_hours, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel4))
                                .addGap(42, 42, 42)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(number_of_evalution_hours, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(number_of_lab_hours, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(sub_id)
                        .addGap(126, 126, 126))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(DeleteBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(Clear, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(CloseBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 465, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 17, Short.MAX_VALUE)))
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(offerd_year, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6)
                    .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(number_of_lection_hourws, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(33, 33, 33)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(first_semester)
                    .addComponent(second_semester)
                    .addComponent(jLabel10)
                    .addComponent(jLabel2)
                    .addComponent(number_of_tutorial_hours, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(subject_name, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(number_of_lab_hours, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(27, 27, 27)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(subject_code, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel4))
                    .addComponent(number_of_evalution_hours, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(29, 29, 29))
        );

        jPanel1.setBackground(new java.awt.Color(0, 0, 204));

        jLabel1.setBackground(new java.awt.Color(255, 255, 255));
        jLabel1.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Manage Subject");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 782, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void subject_nameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_subject_nameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_subject_nameActionPerformed

    private void subject_codeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_subject_codeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_subject_codeActionPerformed

    private void ClearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ClearActionPerformed
        clearAll();
        jButton2.setEnabled(false);
    }//GEN-LAST:event_ClearActionPerformed

    private void first_semesterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_first_semesterActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_first_semesterActionPerformed

    private void jTextField1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField1ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        clearAll();
        DefaultTableModel model = (DefaultTableModel)DetailsTable.getModel();
         while(model.getRowCount() > 0)
        {
            model.removeRow(0);
        }
         LoadTAble();
         jButton2.setEnabled(false);
    }//GEN-LAST:event_jButton3ActionPerformed

    private void DetailsTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_DetailsTableMouseClicked
         jButton1.setEnabled(true);
        jButton2.setEnabled(false);
        try {
            DefaultTableModel model = (DefaultTableModel)DetailsTable.getModel();
            int selectdindex = DetailsTable.getSelectedRow();
            
            sub_id.setText(model.getValueAt(selectdindex, 0).toString());
            String SubID = sub_id.getText();
            
            String quary = "Select * From subject Where id = ?";
            
            ps = DBConnect.getConnection().prepareStatement(quary);
            ps.setString(1, SubID);
            rs = ps.executeQuery();
            while(rs.next()){
                offerd_year.setSelectedItem(rs.getString("year"));
                // radio btn
                subject_name.setText(rs.getString("subjectName"));
                subject_code.setText(rs.getString("subjectCode"));
                number_of_lection_hourws.setValue(rs.getInt("nofLecHours"));
                number_of_tutorial_hours.setValue(rs.getInt("nofTutoHours"));
                number_of_lab_hours.setValue(rs.getInt("nofLabhours"));
                number_of_evalution_hours.setValue(rs.getInt("nofevaHours"));
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(Manage_Subject.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }//GEN-LAST:event_DetailsTableMouseClicked

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        offerd_year.setEnabled(true);
        subject_name.setEnabled(true);
        subject_code.setEnabled(true);
        number_of_lection_hourws.setEnabled(true);    
        number_of_tutorial_hours.setEnabled(true);
        number_of_lab_hours.setEnabled(true);
        number_of_evalution_hours.setEnabled(true);
        offerd_year.requestFocus();
        jButton1.setEnabled(false);
        jButton2.setEnabled(true);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        String OfferdYear = (String)offerd_year.getSelectedItem();
        OfferdYear = offerd_year.getSelectedItem().toString();
        
        String SubID = sub_id.getText();
            
            
        String Sem = "";
        if(first_semester.isSelected()){
            Sem = "1";
        }
        if(second_semester.isSelected()){
            Sem = "2";
        }
        String subjectName = subject_name.getText();
        String subjectCode = subject_code.getText();
        int nofLecHours = (Integer) number_of_lection_hourws.getValue();
        int nofTutorialHours = (Integer) number_of_tutorial_hours.getValue();
        int nofTLabHours = (Integer) number_of_lab_hours.getValue();
        int nofEvHours = (Integer) number_of_evalution_hours.getValue();
        
        String quary = "UPDATE subject SET  year = ? ,semester = ? , subjectName = ? ,subjectCode = ? ,nofLecHours = ?,nofTutoHours = ? ,nofLabhours = ? ,nofevaHours = ?  WHERE id = ?";
        
        try {
            ps = DBConnect.getConnection().prepareStatement(quary);
            
            ps.setString(1, OfferdYear);
            ps.setString(2, Sem);
            ps.setString(3, subjectName);
            ps.setString(4, subjectCode);
            ps.setInt(5, nofLecHours);
            ps.setInt(6, nofTutorialHours);
            ps.setInt(7, nofTLabHours);
            ps.setInt(8, nofEvHours);
            ps.setString(9, SubID);
            
            
            if(ps.executeUpdate() == 1){
                JOptionPane.showMessageDialog(null, "Data Added Successfully!");
                jButton3ActionPerformed(evt);
            }else{
                JOptionPane.showMessageDialog(null, "Error!");
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(Add_Subject.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        new Add_Subject().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jButton4ActionPerformed

    private void CloseBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CloseBtnActionPerformed
        this.dispose();
    }//GEN-LAST:event_CloseBtnActionPerformed

    private void DeleteBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DeleteBtnActionPerformed
        int a=JOptionPane.showConfirmDialog(null,"Are you Sure?");
        if(a==JOptionPane.YES_OPTION){
            try {
                DefaultTableModel model = (DefaultTableModel)DetailsTable.getModel();
                int selectdindex = DetailsTable.getSelectedRow();

                int id =Integer.valueOf(model.getValueAt(selectdindex, 0).toString());

                String quary = "DELETE FROM subject where id = ?";
                ps = DBConnect.getConnection().prepareStatement(quary);
                ps.setInt(1, id);

                if(ps.executeUpdate() == 1){
                    JOptionPane.showMessageDialog(null, "Deleted");
                    while(model.getRowCount() > 0)
                    {
                        model.removeRow(0);
                    }
                    LoadTAble();
                }

            } catch (SQLException ex) {
                Logger.getLogger(Manage_Locations.class.getName()).log(Level.SEVERE, null, ex);
            }
        }else if(a==JOptionPane.NO_OPTION){
            
        }
    }//GEN-LAST:event_DeleteBtnActionPerformed

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
            java.util.logging.Logger.getLogger(Manage_Subject.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Manage_Subject.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Manage_Subject.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Manage_Subject.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Manage_Subject().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Clear;
    private javax.swing.JButton CloseBtn;
    private javax.swing.JButton DeleteBtn;
    private javax.swing.JTable DetailsTable;
    private javax.swing.JRadioButton first_semester;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JSpinner number_of_evalution_hours;
    private javax.swing.JSpinner number_of_lab_hours;
    private javax.swing.JSpinner number_of_lection_hourws;
    private javax.swing.JSpinner number_of_tutorial_hours;
    private javax.swing.JComboBox offerd_year;
    private javax.swing.JRadioButton second_semester;
    private javax.swing.JLabel sub_id;
    private javax.swing.JTextField subject_code;
    private javax.swing.JTextField subject_name;
    // End of variables declaration//GEN-END:variables
}
