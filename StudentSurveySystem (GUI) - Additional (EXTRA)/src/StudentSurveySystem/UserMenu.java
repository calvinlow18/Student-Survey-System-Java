package StudentSurveySystem;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;
import java.awt.GridLayout;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class UserMenu extends javax.swing.JFrame {

    /**
     * Creates new form NewJFrame
     */
    public UserMenu() {
        initComponents();
        Administrator.setHorizontalTextPosition(JButton.CENTER);
        Administrator.setVerticalTextPosition(JButton.BOTTOM);
        student.setHorizontalTextPosition(JButton.CENTER);
        student.setVerticalTextPosition(JButton.BOTTOM);
        FormFunction ff = new FormFunction();
        this.addWindowListener(
            new WindowAdapter() { 
                public void windowClosing(WindowEvent evt) {
                    
                    try {
                        ff.writeSurvey();
                    } catch (Exception ex) {
                        Logger.getLogger(UserMenu.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            } 
        );
        
        admin = new Administrator();
        try {
            if (admin.read() == false){
                System.exit(0);
            } else {
                if (test++ == 0) {
                    try {
                        ff.readSurvey();
                        ff.readQuestion();
                    } catch (Exception ex) {
                        Logger.getLogger(AnalysisForm.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
                
            }
        } catch (Exception ex) {
            Logger.getLogger(UserMenu.class.getName()).log(Level.SEVERE, null, ex);
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

        jLabel1 = new javax.swing.JLabel();
        Administrator = new javax.swing.JButton();
        student = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Student Survey Application");
        setResizable(false);

        jLabel1.setFont(new java.awt.Font("Arial Black", 0, 24)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Student Survey Application");

        Administrator.setIcon(new javax.swing.ImageIcon(getClass().getResource("/myicons/Admin.png"))); // NOI18N
        Administrator.setText("Administrator");
        Administrator.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AdministratorActionPerformed(evt);
            }
        });

        student.setIcon(new javax.swing.ImageIcon(getClass().getResource("/myicons/Student.png"))); // NOI18N
        student.setText("Students");
        student.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                studentActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(Administrator, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(18, 18, 18)
                        .addComponent(student, javax.swing.GroupLayout.PREFERRED_SIZE, 213, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(17, 17, 17))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(student, javax.swing.GroupLayout.DEFAULT_SIZE, 244, Short.MAX_VALUE)
                    .addComponent(Administrator, javax.swing.GroupLayout.DEFAULT_SIZE, 244, Short.MAX_VALUE))
                .addContainerGap())
        );

        setSize(new java.awt.Dimension(488, 395));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void AdministratorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AdministratorActionPerformed
        // TODO add your handling code here:
        int option;
        do {
            JPanel panel = new JPanel();
            JLabel label = new JLabel("Enter a password:");
            JPasswordField pass = new JPasswordField(10);
            panel.setLayout(new GridLayout(2, 2));
            panel.add(label);
            panel.add(pass);
            String[] options = new String[]{"OK", "Cancel"};
            option = JOptionPane.showOptionDialog(null, panel, "Administrator Login", JOptionPane.YES_NO_OPTION, JOptionPane.PLAIN_MESSAGE, null, options, options[1]);
            String x = new String(pass.getPassword());
            String y = admin.getPassword();
            if (option == 0) {
                if (x.contentEquals(y)) {
                    AdministratorMenu am = new AdministratorMenu();
                    am.show();
                    option = 1;
                    this.dispose();
                } else if (pass.getText().isEmpty()) {
                    JOptionPane.showMessageDialog(null, new JLabel("Please enter something"), "Password Error", JOptionPane.ERROR_MESSAGE);
                } else {
                    JOptionPane.showMessageDialog(null, new JLabel("Password you entered is incorrect"), "Wrong Password", JOptionPane.ERROR_MESSAGE);
                }
            }
        } while (option == 0);
        
        
    }//GEN-LAST:event_AdministratorActionPerformed

    private void studentActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_studentActionPerformed
        // TODO add your handling code here:
        Survey sa = new Survey();
        sa.show();
        this.dispose();
    }//GEN-LAST:event_studentActionPerformed
    

    
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
            java.util.logging.Logger.getLogger(UserMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(UserMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(UserMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(UserMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new UserMenu().setVisible(true);
            }
        });
        
        
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Administrator;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JButton student;
    // End of variables declaration//GEN-END:variables
    private Administrator admin;
    private static int test = 0;
    
}