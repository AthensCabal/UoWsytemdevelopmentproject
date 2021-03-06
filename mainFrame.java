
import java.awt.Dimension;
import java.awt.Toolkit;
import java.text.Normalizer.Form;
import javax.swing.JFrame;


public class mainFrame extends JFrame {

    /**
     * Creates new form GUI_Main
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
            java.util.logging.Logger.getLogger(mainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(mainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(mainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(mainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new mainFrame().setVisible(true);
            }
        }
    );
    }
    public mainFrame() {
        initComponents();
        setResizable(false);
        setLocationRelativeTo(this);
        setTitle("CCCU Scholarship Management System");

    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        mainFrame = new javax.swing.JFrame();
        cccu_logoLabel = new javax.swing.JLabel();
        cccu_bgLabel = new javax.swing.JLabel();
        studentLabel = new javax.swing.JLabel();
        student_eidLabel = new javax.swing.JLabel();
        student_passwordLabel = new javax.swing.JLabel();
        student_loginButton = new javax.swing.JButton();
        teacherLabel = new javax.swing.JLabel();
        teacher_eidLabel = new javax.swing.JLabel();
        teacher_passwordLabel = new javax.swing.JLabel();
        teacher_loginButton = new javax.swing.JButton();
        bgPanel = new javax.swing.JPanel();
        student_eidTextField = new javax.swing.JTextField();
        teacher_eidTextField = new javax.swing.JTextField();
        jPasswordField1 = new javax.swing.JPasswordField();
        jPasswordField2 = new javax.swing.JPasswordField();
        jButtonReset1 = new javax.swing.JButton();
        jButtonReset2 = new javax.swing.JButton();

        mainFrame.setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        mainFrame.setTitle("CCCU Scholarship Management System");
        mainFrame.setAlwaysOnTop(true);
        mainFrame.setBounds(new java.awt.Rectangle(0, 0, 770, 500));
        mainFrame.setLocation(new java.awt.Point(0, 0));
        mainFrame.setMinimumSize(new java.awt.Dimension(770, 500));
        mainFrame.setName("MainFrame"); // NOI18N
        mainFrame.setResizable(false);
        mainFrame.setSize(new java.awt.Dimension(770, 500));

        javax.swing.GroupLayout mainFrameLayout = new javax.swing.GroupLayout(mainFrame.getContentPane());
        mainFrame.getContentPane().setLayout(mainFrameLayout);
        mainFrameLayout.setHorizontalGroup(
            mainFrameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        mainFrameLayout.setVerticalGroup(
            mainFrameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBounds(new java.awt.Rectangle(0, 0, 770, 500));
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        setMinimumSize(new java.awt.Dimension(770, 500));
        setPreferredSize(new java.awt.Dimension(847, 640));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        cccu_logoLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/CCCU_logo.PNG"))); // NOI18N
        cccu_logoLabel.setToolTipText("");
        getContentPane().add(cccu_logoLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 30, -1, 140));

        cccu_bgLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/CCCU_background.JPG"))); // NOI18N
        cccu_bgLabel.setText("EID");
        cccu_bgLabel.setOpaque(true);
        cccu_bgLabel.setPreferredSize(new java.awt.Dimension(850, 640));
        cccu_bgLabel.setVerifyInputWhenFocusTarget(false);
        getContentPane().add(cccu_bgLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 840, 190));

        studentLabel.setBackground(new java.awt.Color(102, 255, 153));
        studentLabel.setText("Students, please login here:");
        getContentPane().add(studentLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 220, 170, 30));

        student_eidLabel.setText("EID");
        getContentPane().add(student_eidLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 250, 80, 20));

        student_passwordLabel.setText("Password");
        getContentPane().add(student_passwordLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 280, 80, 20));

        student_loginButton.setText("Login");
        student_loginButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                student_loginButtonActionPerformed(evt);
            }
        });
        getContentPane().add(student_loginButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 320, -1, -1));

        teacherLabel.setText("Teachers, please login here:");
        getContentPane().add(teacherLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 220, 170, 30));

        teacher_eidLabel.setText("EID");
        getContentPane().add(teacher_eidLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 250, 70, 20));

        teacher_passwordLabel.setText("Password");
        getContentPane().add(teacher_passwordLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 280, 70, 20));

        teacher_loginButton.setText("Login");
        teacher_loginButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                teacher_loginButtonActionPerformed(evt);
            }
        });
        getContentPane().add(teacher_loginButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 320, -1, -1));

        bgPanel.setBackground(new java.awt.Color(255, 255, 255));

        student_eidTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                student_eidTextFieldActionPerformed(evt);
            }
        });

        teacher_eidTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                teacher_eidTextFieldActionPerformed(evt);
            }
        });

        jButtonReset1.setText("Reset");
        jButtonReset1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonReset1ActionPerformed(evt);
            }
        });

        jButtonReset2.setText("Reset");
        jButtonReset2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonReset2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout bgPanelLayout = new javax.swing.GroupLayout(bgPanel);
        bgPanel.setLayout(bgPanelLayout);
        bgPanelLayout.setHorizontalGroup(
            bgPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(bgPanelLayout.createSequentialGroup()
                .addGap(137, 137, 137)
                .addGroup(bgPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jButtonReset1)
                    .addGroup(bgPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jPasswordField1, javax.swing.GroupLayout.DEFAULT_SIZE, 180, Short.MAX_VALUE)
                        .addComponent(student_eidTextField)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 266, Short.MAX_VALUE)
                .addGroup(bgPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, bgPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(teacher_eidTextField)
                        .addComponent(jPasswordField2, javax.swing.GroupLayout.DEFAULT_SIZE, 180, Short.MAX_VALUE))
                    .addComponent(jButtonReset2, javax.swing.GroupLayout.Alignment.TRAILING))
                .addGap(97, 97, 97))
        );
        bgPanelLayout.setVerticalGroup(
            bgPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(bgPanelLayout.createSequentialGroup()
                .addGap(248, 248, 248)
                .addGroup(bgPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(student_eidTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(teacher_eidTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(bgPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jPasswordField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPasswordField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(bgPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonReset1)
                    .addComponent(jButtonReset2))
                .addContainerGap(260, Short.MAX_VALUE))
        );

        getContentPane().add(bgPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, 600));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void student_eidTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_student_eidTextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_student_eidTextFieldActionPerformed

    private void teacher_eidTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_teacher_eidTextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_teacher_eidTextFieldActionPerformed

    private void student_loginButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_student_loginButtonActionPerformed
        dispose();
        studentFrame fr = new studentFrame();
        fr.setResizable(false);
        fr.setSize(835,600);
        fr.setLocationRelativeTo(this);
        fr.setTitle("CCCU Scholarship Management System");
        fr.setVisible(true);
        
    }//GEN-LAST:event_student_loginButtonActionPerformed

    private void teacher_loginButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_teacher_loginButtonActionPerformed
        dispose();
        staffFrame fr = new staffFrame();
        fr.setResizable(false);
        fr.setSize(835,600);
        fr.setLocationRelativeTo(this);
        fr.setTitle("CCCU Scholarship Management System");
        fr.setVisible(true);
        
    }//GEN-LAST:event_teacher_loginButtonActionPerformed

    private void jButtonReset1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonReset1ActionPerformed
        student_eidTextField.setText(null);
        jPasswordField1.setText(null);
    }//GEN-LAST:event_jButtonReset1ActionPerformed

    private void jButtonReset2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonReset2ActionPerformed
        teacher_eidTextField.setText(null);
        jPasswordField2.setText(null);
    }//GEN-LAST:event_jButtonReset2ActionPerformed

    /**
     * @param args the command line arguments
     */


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel bgPanel;
    private javax.swing.JLabel cccu_bgLabel;
    private javax.swing.JLabel cccu_logoLabel;
    private javax.swing.JButton jButtonReset1;
    private javax.swing.JButton jButtonReset2;
    private javax.swing.JPasswordField jPasswordField1;
    private javax.swing.JPasswordField jPasswordField2;
    private javax.swing.JFrame mainFrame;
    private javax.swing.JLabel studentLabel;
    private javax.swing.JLabel student_eidLabel;
    private javax.swing.JTextField student_eidTextField;
    private javax.swing.JButton student_loginButton;
    private javax.swing.JLabel student_passwordLabel;
    private javax.swing.JLabel teacherLabel;
    private javax.swing.JLabel teacher_eidLabel;
    private javax.swing.JTextField teacher_eidTextField;
    private javax.swing.JButton teacher_loginButton;
    private javax.swing.JLabel teacher_passwordLabel;
    // End of variables declaration//GEN-END:variables
}
