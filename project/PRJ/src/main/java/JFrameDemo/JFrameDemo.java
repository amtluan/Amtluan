
package JFrameDemo;

import java.awt.FlowLayout;
import javax.swing.JButton;
import javax.swing.JFrame;


public class JFrameDemo extends JFrame{
   // private JFrame frame;
    JButton button;

    public JFrameDemo() {
        creatAndShow();
        
    }

    private void creatAndShow() {
        button= new JButton();
   //   frame = new JFrame(" TAO DANH M H CHU NHIN.., THICH NHIN HOG");
      setSize(600,500);
      setVisible(true);
      this.setLocationRelativeTo(null);
      this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      
      this.add(button);
      this.setLayout(new FlowLayout());
   
    }
  
    public static void main(String[] args) {
        new JFrameDemo();
    }
    
    
}
