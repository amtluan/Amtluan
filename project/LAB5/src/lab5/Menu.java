package LAB5;
import java.util.Scanner;

public class Menu 
{
    String[] hints;
    int n=0;
    
    public Menu (int size)
    {
        if (size<1) size=10;
        hints =new String[size];
    }
    
    public void add (String aHint)
    {
        if (n<hints.length)
        {
            hints[n++]=aHint;
        }
    }
    
    public int getChoice()
    {
        boolean cont = true;
        int result=0;
        do
        {
            try
            {
                if (n>0)
                {
                    for (int i=0; i<n; i++)
                        System.out.println( (i+1) + "-" + hints[i]);
                    System.out.print("Please select an operation: ");
                    Scanner s=new Scanner(System.in);
                    result=s.nextInt();
                    cont=false;
                }
                if (result<1 || result>5)
                {
                    System.out.println("Operation must be 1-5.");
                    cont = true;
                } else {
                cont = false;
                }
            }
            catch(Exception e)
            {
                System.out.println("Something went wrong.");
            }
        }while(cont == true || result<1 || result >5);
        return result;
    }
}