
package SocketDemo;
import java.net.Socket;
import java.net.ServerSocket;
import java.io.*;

public class ManagerChatter extends javax.swing.JFrame implements Runnable{
    ServerSocket srvSocket=null;
    BufferedReader br=null;
    Thread t;
   
  
    public ManagerChatter() {
        initComponents();
        this.setSize(800, 600);
        int serverPort=Integer.parseInt(txtServerPort.getText());
        try{
           srvSocket= new ServerSocket(serverPort);
           this.lbMessage.setText("Mng. Server is running at the port");
        }catch(Exception e){
        }
        t= new Thread(this);
         setLocationRelativeTo(null);
        t.start();
    }


    
    @Override
      public void run(){
      while(true){
          try{
            Socket aStaffSocket= srvSocket.accept();
            if(aStaffSocket !=null){
                br= new BufferedReader (new InputStreamReader(
                                                aStaffSocket.getInputStream()));
                String S= br.readLine();
                int pos= S.indexOf(":");
                String staffName = S.substring(pos+1);
                
                ChatPanel p= new ChatPanel(aStaffSocket, "Manager", staffName);
                jTabbedPane1.add(staffName,  p);
                p.updateUI();
            }
            Thread.sleep(1000);
          }catch(Exception e){
              
          }
      }  
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        lbMessage = new javax.swing.JLabel();
        txtServerPort = new javax.swing.JTextField();
        jTabbedPane1 = new javax.swing.JTabbedPane();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Manager Chatter");
        setBackground(new java.awt.Color(0, 255, 255));
        setFont(new java.awt.Font("Agency FB", 1, 10)); // NOI18N
        setForeground(new java.awt.Color(0, 102, 255));

        jPanel1.setLayout(new java.awt.GridLayout(1, 0));

        lbMessage.setFont(new java.awt.Font("Tahoma", 1, 15)); // NOI18N
        lbMessage.setForeground(new java.awt.Color(0, 102, 102));
        lbMessage.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbMessage.setText("                                                                 Manager Port:");
        jPanel1.add(lbMessage);

        txtServerPort.setBackground(new java.awt.Color(240, 240, 240));
        txtServerPort.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        txtServerPort.setForeground(new java.awt.Color(0, 102, 102));
        txtServerPort.setText("5555");
        txtServerPort.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtServerPortActionPerformed(evt);
            }
        });
        jPanel1.add(txtServerPort);

        getContentPane().add(jPanel1, java.awt.BorderLayout.PAGE_START);
        getContentPane().add(jTabbedPane1, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtServerPortActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtServerPortActionPerformed
     
    }//GEN-LAST:event_txtServerPortActionPerformed

  
    
    public static void main(String args[]) {
     
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Windows".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(ManagerChatter.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ManagerChatter.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ManagerChatter.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ManagerChatter.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ManagerChatter().setVisible(true);
            }
        });
    }





    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JLabel lbMessage;
    private javax.swing.JTextField txtServerPort;
    // End of variables declaration//GEN-END:variables
}
