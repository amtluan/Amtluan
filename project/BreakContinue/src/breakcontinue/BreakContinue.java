/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package breakcontinue;

/**
 *
 * @author Hứa Minh Luân
 */
public class BreakContinue {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here   
        int sum = 0, n = 100;

        String msg = "Hello world";
//                
//        for(int i=0; i<n ; i++){
//            sum +=i;
//            System.out.println("i:  "+ i);
//        
//            if(i == 10){
//                break;
//            }  
//        }
//          System.out.println("sum: "+ sum);

//for(int i=0; i< msg.length(); i++)
//{
//   
//    if(msg.charAt(i) <= 'o'){
//        continue; 
//                                        }
//     System.out.println(msg.charAt(i));
//}
//    
//       
        System.out.println("các số chẵn: ");
        for (int i = 0; i < n; i++) {
            // nếu chia ra số lẻ thì vào thư viện  continue(bỏ qua) và in kết quả chẵn.
            if (i % 2 != 0) {
                continue;
            }else{
                  System.out.println("Các số lẻ: "+ i);
            }

            System.out.println(i);
        }
      
        
    }

}
