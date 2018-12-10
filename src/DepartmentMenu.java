/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author neefez
 */
public class DepartmentMenu extends StartFrame {

    /**
     * Creates new form DepartmentMenu
     */
    public DepartmentMenu() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        ManagePeople = new javax.swing.JButton();
        ManageCourse = new javax.swing.JButton();
        RegisterCourse = new javax.swing.JButton();
        ReturnToUpper = new javax.swing.JButton();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        Quit = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        ManagePeople.setText("Manage People");
        ManagePeople.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ManagePeopleActionPerformed(evt);
            }
        });

        ManageCourse.setText("Manage Course");
        ManageCourse.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ManageCourseActionPerformed(evt);
            }
        });

        RegisterCourse.setText("Register a Course for a Person");
        RegisterCourse.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RegisterCourseActionPerformed(evt);
            }
        });

        ReturnToUpper.setText("Return to Previous Menu");
        ReturnToUpper.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ReturnToUpperActionPerformed(evt);
            }
        });

        jMenu1.setText("File");

        Quit.setText("Quit");
        Quit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                QuitActionPerformed(evt);
            }
        });
        jMenu1.add(Quit);

        jMenuBar1.add(jMenu1);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(131, 131, 131)
                        .addComponent(ReturnToUpper))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(146, 146, 146)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(ManageCourse)
                            .addComponent(ManagePeople)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(110, 110, 110)
                        .addComponent(RegisterCourse)))
                .addContainerGap(109, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(57, Short.MAX_VALUE)
                .addComponent(ManagePeople)
                .addGap(18, 18, 18)
                .addComponent(ManageCourse)
                .addGap(18, 18, 18)
                .addComponent(RegisterCourse)
                .addGap(41, 41, 41)
                .addComponent(ReturnToUpper)
                .addGap(53, 53, 53))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void ManagePeopleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ManagePeopleActionPerformed
        // TODO add your handling code here:
       new PeopleMenu().setVisible(true);
       this.setVisible(false);
    }//GEN-LAST:event_ManagePeopleActionPerformed

    private void ReturnToUpperActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ReturnToUpperActionPerformed
        // TODO add your handling code here:
       new MainFrame().setVisible(true);
       this.setVisible(false);
    }//GEN-LAST:event_ReturnToUpperActionPerformed

    private void QuitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_QuitActionPerformed
        // TODO add your handling code here:
       System.exit(0);
    }//GEN-LAST:event_QuitActionPerformed

    private void ManageCourseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ManageCourseActionPerformed
        // TODO add your handling code here:
       new CourseMenu().setVisible(true);
       this.setVisible(false);
    }//GEN-LAST:event_ManageCourseActionPerformed

    private void RegisterCourseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RegisterCourseActionPerformed
        // TODO add your handling code here:
       Department dep = (Department)depList.getFromIndex(StartFrame.index); 
       if(dep.peopleList.isEmpty())    
       {
          new ListNoPeople().setVisible(true);
          this.setVisible(false);
       }    
       else if(dep.courseList.isEmpty())
       {
          new ListNoCourses().setVisible(true);
          this.setVisible(false);
       }    
       else
       {    
          new RegisterCourse().setVisible(true);
          this.setVisible(false);
       }    
    }//GEN-LAST:event_RegisterCourseActionPerformed

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
            java.util.logging.Logger.getLogger(DepartmentMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(DepartmentMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(DepartmentMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(DepartmentMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new DepartmentMenu().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton ManageCourse;
    private javax.swing.JButton ManagePeople;
    private javax.swing.JMenuItem Quit;
    private javax.swing.JButton RegisterCourse;
    private javax.swing.JButton ReturnToUpper;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenuBar jMenuBar1;
    // End of variables declaration//GEN-END:variables
}