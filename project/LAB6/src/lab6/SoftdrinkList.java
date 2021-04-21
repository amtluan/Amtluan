package LAB6;

import java.util.Scanner;

public class SoftdrinkList {
    private Softdrink[] list = null;
    private int count = 0;
    
    public SoftdrinkList (int size)
    {
        if (size<10) size=10;
        list = new Softdrink[size];
    }
    
    int find (String aCode)
    {
        for (int i=0; i<count; i++)
            if (aCode.equals(list[i].getCode())) return i;
        return -1;
    }
    
   public void findmake (String aMake)
    {
        int check=0;
        for (int i=0; i<count; i++)
            if (aMake.equals(list[i].getMake())) 
            { 
                check+=1;
                System.out.println(list[i].toString());
            }
        if (check==0)
            System.out.println("The softdrink does not exist.");
    }
    
    public void printfind()
    {
        if(count==0)
        {
            System.out.println("Empty list.");
            return;
        }
        String printFind;
        Scanner s= new Scanner(System.in);
        System.out.print("Enter the manufacturer of softdrink: ");
        printFind = s.nextLine().toUpperCase();
        System.out.println("The softdrinks:");
        findmake(printFind);
    }
    
    public void add()
    {
        if (count == list.length) System.out.println("List is full");
        else
        {
            String newCode, newMake;
            int newVolume=0, newIntCode=0;
            float newPrice=0;
            boolean cont=true;
            Scanner s= new Scanner(System.in);
            int pos;
            do 
            {
                do
                {
                    try
                    {
                        System.out.print("Enter the softdrink's code: ");
                        newIntCode = Integer.parseInt(s.nextLine());
                        if (newIntCode<1 || newIntCode>999)
                        {
                            System.out.println("Code >=1 and Code <=999");
                            cont = true;
                        } else {
                            cont = false;
                        }
                    }
                    catch(Exception e)
                    {
                        System.out.println("Something went wrong.");
                        cont = true;
                    }
                }while(cont == true);
                newCode = DecimalFormatDemo.setCodeFormat("S000",newIntCode);
                pos=find(newCode);
                if (pos>=0) System.out.println("\tThis code existed!");    
            } while (pos>=0);
            
            System.out.print("Enter the softdrink's make: ");
            newMake = s.nextLine().toUpperCase();
            do
            {
                try
                {
                    System.out.print("Enter the softdrink's volume: ");
                    newVolume = Integer.parseInt(s.nextLine());
                    if (newVolume<=0)
                    {
                        System.out.println("The volume >0.");
                        cont=true;
                    } else
                    {
                        cont=false;
                    }
                }
                catch(Exception e)
                {
                    System.out.println("Something went wrong.");
                    cont = true;
                }
            }while(cont==true);
            
            do
            {
                try
                {
                    System.out.print("Enter the softdrink's price: ");
                    newPrice = Float.parseFloat(s.nextLine());
                    if (newPrice<=0)
                    {
                        System.out.println("The price >0.");
                        cont=true;
                    } else
                    {
                        cont=false;
                    }
                }
                catch(Exception e)
                {
                    System.out.println("Something went wrong.");
                    cont = true;
                }
            }while(cont==true);
            list[count++] = new Softdrink(newCode, newMake, newVolume, newPrice);
            System.out.println("New softdrink have been added.");            
        }
    }
    
    public void remove()
    {
        if(count==0)
        {
            System.out.println("Empty list.");
            return;
        }
        
        String removedCode;
        Scanner s= new Scanner(System.in);
        System.out.println("Enter the code of remove softdrink: ");
        removedCode = s.nextLine().toUpperCase();
        int pos = find(removedCode);
        if (pos<0) System.out.println("This softdrink does not exist.");
        else
        {
            for (int i=pos; i<count-1; i++) list[i] = list [i+1];
            count--;
            System.out.println("The softdrink" + removedCode + "was removed");
        }
    }
    
    public void update()
    {
        if (count==0)
        {
            System.out.println("Empty list.");
            return;
        }
        String code;
        Scanner s= new Scanner(System.in);
        System.out.print("Enter the code of update softdrink: ");
        code = s.nextLine().toUpperCase();
        int pos = find(code);
        if (pos<0) System.out.println("This softdrink does not exits.");
        else
        {
            String newMake;
            int newVolume=0;
            float newPrice=0;
            boolean cont=true;
            
            System.out.print("Enter the softdrink's make: ");
            newMake = s.nextLine().toUpperCase();
            
            do
            {
                try
                {
                    System.out.print("Enter the softdrink's volume: ");
                    newVolume = Integer.parseInt(s.nextLine());
                    if (newVolume<=0)
                    {
                        System.out.println("The volume >0.");
                        cont=true;
                    } else
                    {
                        cont=false;
                    }
                }
                catch(Exception e)
                {
                    System.out.println("Something went wrong.");
                    cont = true;
                }
            }while(cont==true);
            
            do
            {
                try
                {
                    System.out.print("Enter the softdrink's price: ");
                    newPrice = Float.parseFloat(s.nextLine());
                    if (newPrice<=0)
                    {
                        System.out.println("The price >0.");
                        cont=true;
                    } else
                    {
                        cont=false;
                    }
                }
                catch(Exception e)
                {
                    System.out.println("Something went wrong.");
                    cont = true;
                }
            }while(cont==true);
            
            list[pos].setMake(newMake);
            list[pos].setVolume(newVolume);
            list[pos].setPrice(newPrice);
            System.out.println("The softdrink" + code + "was updated");
        }
    }
    
    public void print()
    {
        if (count==0)
        {
            System.out.println("Empty list.");
            return;
        }
        System.out.println("LIST OF SOFTDRINK:");
        for (int i=0; i<count; i++)
            System.out.println(list[i].toString());
    }
    
    void sortprice()
    {
        if(count==0) return;
        for (int i=0; i<count; i++)
        for (int j=count-1; j>i; j--)
            if (list[j].getPrice()<list[j-1].getPrice())
            {
                Softdrink s =list[j];
                list[j]=list[j-1];
                list[j-1]=s;
            } 
    }
    
    void sortmake()
    {
        if(count==0) return;
        for (int i=0; i<count; i++)
        for (int j=count-1; j>i; j--)
            if ((list[j].getMake()).compareTo(list[j-1].getMake())<0 )
            {
                Softdrink s =list[j];
                list[j]=list[j-1];
                list[j-1]=s;
            }

    }
}
