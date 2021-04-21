
public class DrawingPlusSign {

    public static void main(String[] args) {
        for (int i = 1; i <= 10; i++) {
            for (int j = 1; j <= 10; j++) {
                if ((i==1||i==10||i==4||i==7)&&(j==4||j==7)
                ||((j==1||j==10)&&(i==4||i==7)))
                {
                    System.out.print(" * ");
                }else if ((j==1||j==10)&& (i==5||i==6)||(i==2||i==3||i==8||i==9)
                        &&(j==4||j==7)) {
                    System.out.print(" | ");
                }else if ((i==1||i==10)&&(j==5||j==6)||(i==4||i==7)&&(j==3||j==2||j==8||j==9)) {
                    System.out.print(" - ");
                }else 
                    System.out.print("   ");
                    
                
            }
            System.out.println();
        }

    }
}
