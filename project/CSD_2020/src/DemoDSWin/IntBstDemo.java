/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DemoDSWin;

import binarytree.Menu;
import java.util.Scanner;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author ACER
 */
public class IntBstDemo {

    static Scanner sc = new Scanner(System.in);

    static int input(String msg) {
        System.out.print("\n" + msg);
        return Integer.parseInt(sc.nextLine());
    }

    static void output(String msg) {
        System.out.println("\n" + msg + "\n");
    }

    public static void main(String[] args) {
        Menu mnu = new Menu();
        mnu.add("Add new key");
        mnu.add("Maximum value");
        mnu.add("Minimum value");
        mnu.add("Average value");
        mnu.add("Tree's height");
        mnu.add("Breadth-firt output");
        mnu.add("Align output");
        mnu.add("Inorder-LNR output");
        mnu.add("Inorder-RNL output");
        mnu.add("postorder output");
        mnu.add("searching a key");
        mnu.add("Removing a key-by merging");
        mnu.add("Removing a key-by coppying");
        IntBstTree tree = new IntBstTree();
        tree.add(32, 11, 57, 6, 18, 40, 80, 2, 8, 16, 22, 35, 50, 70, 90);
        tree.add(1, 5, 10, 15, 17, 34, 37, 45, 85, 3);
        int choice;
        int x;
        do {
            choice = mnu.getUserChoice();
            switch (choice) {
                case 1:
                    x = input("Input a key");
                    if (tree.add(x) == true) {
                        output("Adding" + x + "successfully");
                    } else {
                        output("Adding faliled");
                    }
                    break;
                case 2:
                    output("Max value:" + tree.getMax());
                    break;
                case 3:
                    output("Min value:" + tree.getMin());
                    break;
                case 4:
                    output("Avg.value" + tree.getAverage());
                    break;
                case 5:
                    output("Tree's height:" + tree.getHeight());
                    break;
                case 6:
                    output("Breadth-first/level based output:");
                    tree.printLevelBased();
                    break;
                case 7:
                    output("Tree in aligned format:");
                    tree.printAlign();
                    break;
                case 8:
                    output("Tree in preorder list:");
                    tree.printRNL();
                    break;
                case 9:
                    System.out.println("Inorder-LNR output");
                    tree.printLNR();
                    break;
                case 10:
                    output("Inorder-RNL output");
                    tree.printRNL();
                    break;
                case 11:
                    output("Posterder output");
                    tree.printPostOrder();
                    break;
                case 12:
                    x = input("Input sreached value:");
                    IntBstNode node = tree.sreach(x);
                    if (node == null) {
                        output("not found");
                    } else {
                        output("Found: " + node.key);
                    }
                    break;
                case 13:
                    x = input("Input deleted key: ");
                    if (tree.deleteByMerging(x)) {
                        output("deleting successfully");
                    } else {
                        output("deleting fail!");
                    }
                    break;
                case 14:
                    x = input("Input deleted key: ");
                    if (tree.deleteCoppying(x)) {
                        output("Deleting succesfullly");
                    } else {
                        output("deleting fail!");
                    }
                    break;

            }
        } while (choice > 0 && choice <= mnu.size());
    }
}
