package labb4;

import java.util.Scanner;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author DELL
 */
public class smathphonelist {
    private smathphone[] list = null;
    private int cout=0;
    private int i;
    public smathphonelist(int size)
    {
        if(size<10) size =10;
        list = new smathphone[size];
    }
    int Find (String acode)
    {
        for (i =0;i<cout;i++)
            if(acode.equals(list[i].getCode())) return i;
            return -1;
    }
    public void add()
    {
        if(cout==list.length) System.out.println("List if Full");
        else 
        {
            String newCode,newName;
            int newprice;
            Scanner sc = new Scanner(System.in);
            int pos;
            do
            {
                System.out.println("Enter the laptop code: ");
                newCode = sc.nextLine().toUpperCase();
                pos = Find(newCode);
                if(pos>=0)
                    System.out.println("\tThis code existed ");
            }
            while(pos>=0);
                    {
                        System.out.println("Enter the laptop name: ");
                        newName = sc.nextLine().toUpperCase();
                        System.out.println("Enter the laptop price: ");
                        newprice = Integer.parseInt(sc.nextLine());
                        list[cout++] = new smathphone(newCode,newName,newprice);
                        System.out.println("New laptop have been added ");
                    }
        }
}
        public void remove()
        {
            if(cout==0)
            {
                System.out.println("Empty list");
                return;
            }
            String removeCode;
            Scanner sc= new Scanner(System.in);
            System.out.println("Enter the code of removed laptop: ");
            removeCode = sc.nextLine().toUpperCase();
            int pos = Find (removeCode);
            if(pos<0)
                System.out.println("This laptop dose not exist.");
            else
            {
                for(i=pos;i<cout-1;i++) list[i]=list[i+1];
                cout--;
                System.out.println("The laptop " + removeCode +"was removed" );
        }
    }
        public void update()
        {
            if(cout==0)
            {
                System.out.println("Empty list.");
                return;
            }
            String code;
            Scanner sc = new Scanner(System.in);
            System.out.println("Enter the code of updated laptop: ");
            code = sc.nextLine().toUpperCase();
            int pos=Find(code);
            if(pos<0)
                System.out.println("This laptop does not exist");
            else {
                String newName;
                int newPrice;
                System.out.println("Enter the laptop name: ");
                newName = sc.nextLine().toUpperCase();
                System.out.println("Enter the laptop price:");
                newPrice = Integer.parseInt(sc.nextLine());
                list[pos].setName(newName);
                list[pos].setPrice(newPrice);
                System.out.println("The laptop"+code+" was updated");
        }
    }
            public void print()
            {
                if(cout==0)
                {
                    System.out.println("Empty list.");
                    return;
            }
                System.out.println("LIST OF Device: ");
                for(i=0;i<cout;i++)
                    System.out.println(list[i].toString());
    }
            void sort()
            {
                if(cout==0)
                    return;
                for(i=0;i<cout-1;i++)
                    for(int j=cout-1;j>i;j--)
                        if(list[j].getPrice()>list[j-1].getPrice())
                        {
                            smathphone p = list[j];
                            list[j]= list[j-1];
                            list[j-1]=p;
                        }
            }
}