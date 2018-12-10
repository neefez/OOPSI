
import java.util.InputMismatchException;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author neefez
 */
public class RegisterCourse extends StartFrame {

    /**
     * Creates new form RegisterCourse
     */
    public RegisterCourse() {
        initComponents();
    }

    public static String idCourse;
    public static String tempID;
    public static int id;
    public static int ind = Bag.NOT_FOUND;
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        personID = new javax.swing.JTextField();
        courseID = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("Student or Professor ID:");

        jLabel2.setText("Course ID:");

        jButton1.setText("Enter");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jMenu1.setText("File");

        jMenuItem1.setText("Quit");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem1);

        jMenuBar1.add(jMenu1);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(49, 49, 49)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel2)
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton1)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(personID)
                        .addComponent(courseID, javax.swing.GroupLayout.DEFAULT_SIZE, 107, Short.MAX_VALUE)))
                .addContainerGap(122, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(78, 78, 78)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(personID, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(courseID, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jButton1)
                .addContainerGap(93, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        // TODO add your handling code here:
       System.exit(0);
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
       idCourse = courseID.getText();
       Department dep = (Department)StartFrame.depList.getFromIndex(
                                                       StartFrame.index);
       
       boolean valid = false;
       id = 0;
       String tempId = "0";
           
       try
       { 
          tempID = personID.getText();
          valid = isIdFive(tempID);
          valid = isIdValid(tempID);
       }
       catch(InputMismatchException e)
       {
          new ValidRegister().setVisible(true);
          this.setVisible(false);
          valid = false;
       }         
   
       if(valid)
       {    
          if(dep.peopleList.getItem(Integer.parseInt(tempID)) != null
             && dep.peopleList.getItem(Integer.parseInt(tempID)) 
             instanceof Student)
          {
             Student std = (Student)dep.peopleList.getItem(
                                               Integer.parseInt(tempID));
             ind = dep.peopleList.find(std);
          }    
          else if(dep.peopleList.getItem(Integer.parseInt(tempID)) != null
                  && dep.peopleList.getItem(Integer.parseInt(tempID)) 
                  instanceof Professor)
          {
             Professor prof = (Professor)dep.peopleList.getItem(
                                               Integer.parseInt(tempID));
             ind = dep.peopleList.find(prof);
          }    
       }     
       
       if(dep.courseList.getFromName(idCourse) == null && valid)
       {
          new CourseNotFound().setVisible(true);
          this.setVisible(false);
       } 
       else
       {    
          if(!valid)
             id = ValidRegister.getID();
          else
             id = Integer.parseInt(tempID);
     
          if(ind == Bag.NOT_FOUND && valid)
          {
             new ValidRegister().setVisible(true);
             this.setVisible(false);
             valid = false;
          }            
        
          if(ind != Bag.NOT_FOUND)
          {    
             if(dep.peopleList.getFromIndex(ind) instanceof Student)
             {    
                Student s = (Student)dep.peopleList.getItem(id);
                s.register((Course)dep.courseList.getFromName(idCourse));
                valid = true;
             }
             else if(dep.peopleList.getFromIndex(ind) instanceof Professor)
             {
                Professor p = (Professor)dep.peopleList.getItem(id);
                p.register((Course)dep.courseList.getFromName(idCourse));
                valid = true;
             }    
           
             if(valid)
             {    
                new RegistrationSuccess().setVisible(true);
                this.setVisible(false);   
             }   
          }
       }
    }//GEN-LAST:event_jButton1ActionPerformed

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
            java.util.logging.Logger.getLogger(RegisterCourse.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(RegisterCourse.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(RegisterCourse.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(RegisterCourse.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new RegisterCourse().setVisible(true);
            }
        });
    }
    
    public static String getCourseID()
    {
       return idCourse;
    }        
    
    public static int getIndex()
    {
       return ind;
    }        
    
    /**
    * Checks to see if the id inputted is a number.
    * If the id is not a number, throws an exception.
    * @param tempId is the inputted id
    * @return true if tempId is a number, else throws an exception
    * @throws InputMismatchException for cases when tempId is not a number
    */
   public boolean isIdValid(String tempId) throws InputMismatchException
   {
      try
      {
         int i = Integer.parseInt(tempId);    
      }
      catch(Exception e)
      {    
         throw (new InputMismatchException("wrong character."));
      }
      
      return true;
   }
   
   /**
    * Checks to see if the inputted id is of length five.
    * Throws an exception if the id is too long or too short.
    * @param tempId is the inputted id
    * @return true if tempId is length five, else throws and exception
    * @throws InputMismatchException when length is not five
    */
   public boolean isIdFive(String tempId) 
                  throws InputMismatchException
   {
      int id = tempId.length();
      if (id != 5)
         throw (new InputMismatchException("the length of id has to be 5."));
       
      return true;
   }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField courseID;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JTextField personID;
    // End of variables declaration//GEN-END:variables
}
