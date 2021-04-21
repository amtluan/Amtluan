
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;


public class ChatClient {
    public static void main(String[] args) throws IOException {
        Socket socket= new Socket("localhost", 9999);
        
        
        DataInputStream dataInputStream = new DataInputStream(socket.getInputStream());
        DataOutputStream dataOutputStream = new DataOutputStream(socket.getOutputStream());
        
        Scanner scanner = new Scanner(System.in);
        
        while (true) {     // truyền dữ liệu lên server       
            String str = scanner.nextLine();
            dataOutputStream.writeUTF(str);
            
            if (str.equals("q")) {
                break;
            }
                    //Đọc dữ liệu về từ server
                    String str2 = dataInputStream.readUTF();
                    System.out.println("Server say: "+ str2);
            
        }
        
        
    }
    
}
