
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;


public class Chatserver  {
    public static void main(String[] args) throws IOException {
            ServerSocket serverSocket= new ServerSocket(9999); // tạo 1 server với cổng là 9999
            
            
            Socket socket= serverSocket.accept(); // đợi client kết nối với server
            
            DataInputStream dataInputStream = new DataInputStream(socket.getInputStream());                           // đọc dữ liệu từ client lên
            DataOutputStream dataOutputStream = new DataOutputStream(socket.getOutputStream());
            
            Scanner scanner = new Scanner(System.in);
            
            while (true) {            
                // đọc dữ liệu từ client truyền lên
            String str= dataInputStream.readUTF();
            if(str.equals("q")){
                break;
            }
            
                System.out.println("Client say:"+ str);
                
                
                //truyền dữ liệu từ server về
                String str2= scanner.nextLine();
                dataOutputStream.writeUTF(str2);//truyền dữ liệu về client
                dataOutputStream.flush(); //đẩy dữ liệu
        }
            
            dataInputStream.close();
            dataOutputStream.close();
            socket.close();
            serverSocket.close();
    
    }
}
