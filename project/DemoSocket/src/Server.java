
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import javax.swing.JOptionPane;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Hứa Minh Luân
 */
public class Server extends javax.swing.JFrame {

    /**
     * Creates new form Server
     */
    ServerSocket sv;
    Socket fake; //chap nhan 1 client ket noi
    DataInputStream in;
    DataOutputStream out;
    Thread t;
    public Server() {
        initComponents();
        btnDownloadServer.setVisible(false);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnstart = new javax.swing.JButton();
        btnStop = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtServer = new javax.swing.JTextArea();
        txtMsgServer = new javax.swing.JTextField();
        btnSendServer = new javax.swing.JButton();
        btnDownloadServer = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        txtServer2 = new javax.swing.JTextArea();
        txtMsgServer2 = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        btnstart.setText("Start");
        btnstart.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnstartActionPerformed(evt);
            }
        });

        btnStop.setText("Stop");

        txtServer.setColumns(20);
        txtServer.setRows(5);
        jScrollPane1.setViewportView(txtServer);

        txtMsgServer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtMsgServerActionPerformed(evt);
            }
        });

        btnSendServer.setText("Send");
        btnSendServer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSendServerActionPerformed(evt);
            }
        });

        btnDownloadServer.setText("Download");
        btnDownloadServer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDownloadServerActionPerformed(evt);
            }
        });

        txtServer2.setColumns(20);
        txtServer2.setRows(5);
        jScrollPane2.setViewportView(txtServer2);

        txtMsgServer2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtMsgServer2ActionPerformed(evt);
            }
        });

        jLabel1.setText("Server");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnstart)
                .addGap(40, 40, 40)
                .addComponent(btnStop)
                .addGap(23, 23, 23))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(txtMsgServer2, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtMsgServer, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 721, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 353, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jScrollPane2)))
                .addGap(52, 52, 52)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnDownloadServer)
                    .addComponent(btnSendServer))
                .addGap(0, 57, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnStop)
                            .addComponent(btnstart)))
                    .addComponent(jLabel1))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(74, 74, 74)
                        .addComponent(btnDownloadServer))
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 343, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 343, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(36, 36, 36)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtMsgServer, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnSendServer))
                .addGap(18, 18, 18)
                .addComponent(txtMsgServer2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(82, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnstartActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnstartActionPerformed
        try {
            sv = new ServerSocket(7777);
            JOptionPane.showMessageDialog(null, "Server Start.");
            fake = sv.accept();// neu co ket noi thi tao ban sao// don nan ket noi client
            if (fake != null) {
                in = new DataInputStream(fake.getInputStream());//tao buffer to control no.
                out = new DataOutputStream(fake.getOutputStream());
                 t= new Thread(new Runnable() {
                    @Override
                    public void run() {
                        while (true) {                            
                            btnDownloadServerActionPerformed(null);
                            try {
                                Thread.sleep(1000);
                            } catch (Exception e) {
                            }
                        }
                    }
                });
                t.start();
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Server cannot start. ");
        }
    }//GEN-LAST:event_btnstartActionPerformed

    private void btnDownloadServerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDownloadServerActionPerformed
        try {
            if (in != null) {
                byte[] kq = new byte[in.available()];
                in.read(kq);
                String s1 = new String(kq);
                if(!s1.isEmpty()){
                    txtServer.setText(txtServer.getText()+"\nClient1: "+s1);
                
                }
                
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Cannot Download");
        }
        
        
        
        //màng hình server 2
         try {
            if (in != null) {
                byte[] kq = new byte[in.available()];
                in.read(kq);
                String s2 = new String(kq);
                if(!s2.isEmpty()){
                    txtServer2.setText(txtServer2.getText()+"\nClient2: "+s2);
                
                }
                
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Cannot Download");
        }
    }//GEN-LAST:event_btnDownloadServerActionPerformed

    private void btnSendServerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSendServerActionPerformed
        try {
            String  s1= txtMsgServer.getText().trim();
            if (s1!=null && !s1.isEmpty()) {
                byte[] tmp= s1.getBytes();
                if (out!=null) {
                    out.write(tmp);
                    out.flush();
                }
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "cannot Send");
        }
        
        
        
        
         try {
            String  s2= txtMsgServer2.getText().trim();
            if (s2!=null && !s2.isEmpty()) {
                byte[] sa= s2.getBytes();
                if (out!=null) {
                    out.write(sa);
                    out.flush();
                }
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "cannot Send");
        }
    }//GEN-LAST:event_btnSendServerActionPerformed

    private void txtMsgServer2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtMsgServer2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtMsgServer2ActionPerformed

    private void txtMsgServerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtMsgServerActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtMsgServerActionPerformed

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
            java.util.logging.Logger.getLogger(Server.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Server.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Server.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Server.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Server().setVisible(true);
               
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnDownloadServer;
    private javax.swing.JButton btnSendServer;
    private javax.swing.JButton btnStop;
    private javax.swing.JButton btnstart;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextField txtMsgServer;
    private javax.swing.JTextField txtMsgServer2;
    private javax.swing.JTextArea txtServer;
    private javax.swing.JTextArea txtServer2;
    // End of variables declaration//GEN-END:variables
}