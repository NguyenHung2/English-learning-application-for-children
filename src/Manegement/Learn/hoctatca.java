/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Manegement.Learn;

import Manegement.panelData.Hoc;
import com.sun.speech.freetts.Voice;
import com.sun.speech.freetts.VoiceManager;
import java.awt.Color;
import java.awt.Image;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.ImageIcon;
import javax.swing.table.DefaultTableModel;
import user.Connect;

/**
 *
 * @author HP
 */
public class hoctatca extends javax.swing.JFrame {

    private static final String VOICENAME = "kevin16";
    private static int position = 0;

    DefaultTableModel tbn = new DefaultTableModel();
    Connect a = new Connect();
    Connection con = a.getConnection();
    Statement st = null;
    PreparedStatement pst = null;
    ResultSet rs = null;

    String fPath = null;
    byte[] img_DATA;

    private String username;
    int count;

    public hoctatca() {
        initComponents();
        this.setTitle("Học từ vựng");
        this.setLocationRelativeTo(null);
        getConnection();
        loadTest();
        this.setResizable(false);
    }

    public void getConnection() {
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            con = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;databaseName=duan1;user=sa;password=sa2008");
            st = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);
            rs = st.executeQuery("Select * from TuVung");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            System.out.println(e.toString());
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

        Body = new javax.swing.JPanel();
        Header = new javax.swing.JPanel();
        btnReturn = new javax.swing.JLabel();
        lblSound = new javax.swing.JLabel();
        Center = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        btnPrevious = new javax.swing.JLabel();
        btnNext = new javax.swing.JLabel();
        txtTV = new javax.swing.JTextField();
        txtPro = new javax.swing.JTextField();
        txtVN = new javax.swing.JTextField();
        Right = new javax.swing.JPanel();
        lblImg = new javax.swing.JLabel();
        Bottom = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        Body.setBackground(new java.awt.Color(204, 216, 224));
        Body.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        Body.setPreferredSize(new java.awt.Dimension(900, 550));
        Body.setLayout(new java.awt.BorderLayout(20, 20));

        Header.setBackground(new java.awt.Color(204, 255, 255));
        Header.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        Header.setPreferredSize(new java.awt.Dimension(800, 60));
        Header.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnReturn.setFont(new java.awt.Font("Dialog", 1, 16)); // NOI18N
        btnReturn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/4295560_reply_answear_query_replies_respond_icon.png"))); // NOI18N
        btnReturn.setText("Quay lại");
        btnReturn.setToolTipText("");
        btnReturn.setIconTextGap(10);
        btnReturn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnReturnMouseClicked(evt);
            }
        });
        Header.add(btnReturn, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, -1, -1));

        lblSound.setFont(new java.awt.Font("Dialog", 1, 16)); // NOI18N
        lblSound.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblSound.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/speaker.png"))); // NOI18N
        lblSound.setText("Nghe lại phát âm");
        lblSound.setHorizontalTextPosition(javax.swing.SwingConstants.LEADING);
        lblSound.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblSoundMouseClicked(evt);
            }
        });
        Header.add(lblSound, new org.netbeans.lib.awtextra.AbsoluteConstraints(720, 10, -1, -1));

        Body.add(Header, java.awt.BorderLayout.PAGE_START);

        Center.setBackground(new java.awt.Color(255, 204, 51));
        Center.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        Center.setPreferredSize(new java.awt.Dimension(400, 400));
        Center.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel3.setFont(new java.awt.Font("Dialog", 1, 16)); // NOI18N
        jLabel3.setText("Từ vựng");
        Center.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 40, 80, 40));

        jLabel4.setFont(new java.awt.Font("Dialog", 1, 16)); // NOI18N
        jLabel4.setText("Phiên âm");
        Center.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 90, 80, 40));

        jLabel5.setFont(new java.awt.Font("Dialog", 1, 16)); // NOI18N
        jLabel5.setText("Nghĩa");
        Center.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 140, 80, 40));

        btnPrevious.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/9554501_arrow_left_navigation_gps_direction_icon.png"))); // NOI18N
        btnPrevious.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        btnPrevious.setOpaque(true);
        btnPrevious.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnPreviousMouseClicked(evt);
            }
        });
        Center.add(btnPrevious, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 250, 50, 50));

        btnNext.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/9554506_arrow_right_next_navigation_pointer_icon.png"))); // NOI18N
        btnNext.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        btnNext.setOpaque(true);
        btnNext.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnNextMouseClicked(evt);
            }
        });
        Center.add(btnNext, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 250, 50, 50));

        txtTV.setFont(new java.awt.Font("Dialog", 0, 20)); // NOI18N
        txtTV.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        Center.add(txtTV, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 40, 250, 40));

        txtPro.setFont(new java.awt.Font("Dialog", 0, 20)); // NOI18N
        txtPro.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        Center.add(txtPro, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 90, 250, 40));

        txtVN.setFont(new java.awt.Font("Dialog", 0, 20)); // NOI18N
        txtVN.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        Center.add(txtVN, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 140, 250, 40));

        Body.add(Center, java.awt.BorderLayout.CENTER);

        Right.setBackground(new java.awt.Color(255, 255, 255));
        Right.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        Right.setPreferredSize(new java.awt.Dimension(500, 440));
        Right.setLayout(new java.awt.BorderLayout());

        lblImg.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Right.add(lblImg, java.awt.BorderLayout.CENTER);

        Body.add(Right, java.awt.BorderLayout.EAST);

        Bottom.setBackground(new java.awt.Color(204, 255, 255));
        Bottom.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        Bottom.setPreferredSize(new java.awt.Dimension(800, 50));

        javax.swing.GroupLayout BottomLayout = new javax.swing.GroupLayout(Bottom);
        Bottom.setLayout(BottomLayout);
        BottomLayout.setHorizontalGroup(
            BottomLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 892, Short.MAX_VALUE)
        );
        BottomLayout.setVerticalGroup(
            BottomLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 46, Short.MAX_VALUE)
        );

        Body.add(Bottom, java.awt.BorderLayout.PAGE_END);

        getContentPane().add(Body, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnReturnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnReturnMouseClicked
        Hoc g = new Hoc(username);
        g.setVisible(true);
        setVisible(false);
    }//GEN-LAST:event_btnReturnMouseClicked

    private void lblSoundMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblSoundMouseClicked
        voiceLBL();
    }//GEN-LAST:event_lblSoundMouseClicked

    private void btnPreviousMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnPreviousMouseClicked
        try {
            if (!rs.isFirst()) {
                rs.previous();
                count += 1;
                txtTV.setText(rs.getString(2).trim());
                txtPro.setText(rs.getString(3).trim());
                txtVN.setText(rs.getString(4).trim());
                byte[] img = rs.getBytes(5);
                ImageIcon imgIcon = new ImageIcon(new ImageIcon(img).getImage().getScaledInstance(lblImg.getWidth(), lblImg.getHeight(), Image.SCALE_SMOOTH));
                lblImg.setIcon(imgIcon);
                img_DATA = img;
            }
        } catch (Exception e) {
        }
        voiceLBL();
    }//GEN-LAST:event_btnPreviousMouseClicked

    private void btnNextMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnNextMouseClicked
        try {
            if (!rs.isLast()) {
                rs.next();
                count += 1;
                //lblMaTV.setText("Câu " + rs.getString(1) + ":");
                txtTV.setText(rs.getString(2).trim());
                txtPro.setText(rs.getString(3).trim());
                txtVN.setText(rs.getString(4).trim());
                byte[] img = rs.getBytes(5);
                ImageIcon imgIcon = new ImageIcon(new ImageIcon(img).getImage().getScaledInstance(lblImg.getWidth(), lblImg.getHeight(), Image.SCALE_SMOOTH));
                lblImg.setIcon(imgIcon);
                img_DATA = img;
                voiceLBL();
            }
        } catch (Exception e) {
        }
    }//GEN-LAST:event_btnNextMouseClicked

    public void loadTest() {
        try {
            rs.first();
            //lblMaTV.setText("Câu " + rs.getString(1) + ":");
            txtTV.setText(rs.getString(2).trim());
            txtPro.setText(rs.getString(3).trim());
            txtVN.setText(rs.getString(4).trim());
            byte[] img = rs.getBytes(5);
            ImageIcon imgIcon = new ImageIcon(new ImageIcon(img).getImage().getScaledInstance(lblImg.getWidth(), lblImg.getHeight(), Image.SCALE_SMOOTH));
            lblImg.setIcon(imgIcon);
            img_DATA = img;
        } catch (Exception e) {
            System.out.println(e.toString());
        }
        voiceLBL();
    }

    public void voiceLBL() {
        Voice voice;
        VoiceManager vm = VoiceManager.getInstance();
        voice = vm.getVoice(VOICENAME);

        voice.allocate();

        try {
            voice.speak(txtTV.getText());
        } catch (Exception e) {
        }
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
            java.util.logging.Logger.getLogger(hoctatca.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(hoctatca.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(hoctatca.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(hoctatca.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new hoctatca().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel Body;
    private javax.swing.JPanel Bottom;
    private javax.swing.JPanel Center;
    private javax.swing.JPanel Header;
    private javax.swing.JPanel Right;
    private javax.swing.JLabel btnNext;
    private javax.swing.JLabel btnPrevious;
    private javax.swing.JLabel btnReturn;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel lblImg;
    private javax.swing.JLabel lblSound;
    private javax.swing.JTextField txtPro;
    private javax.swing.JTextField txtTV;
    private javax.swing.JTextField txtVN;
    // End of variables declaration//GEN-END:variables
}
