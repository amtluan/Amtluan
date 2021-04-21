package labb4;

public class Labb4{
    public static void main(String[] args)
    {
        Menu menu= new Menu(5);
        menu.add(" Add new laptop" );
        menu.add(" Remove laptop");
        menu.add(" Updated laptop");
        menu.add(" List");
        menu.add(" Quit");
        int choice;
        smathphonelist list = new smathphonelist(50);
           do
           {
               System.out.println("\n LAPTOP1 MANAGER");
               choice = menu.getChoice();
               switch (choice)
               {
                   case 1:list.add();break;
                   case 2:list.remove();break;
                   case 3:list.update();break;
                   case 4:list.sort();
                   list.print();break;
               }
           }
           while (choice>=1 && choice<5);
    }
}