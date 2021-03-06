package sort;

import java.util.Arrays;
import java.util.Random;

public class IntSorterTest {

    public static final int SELECTION = 1, INSERTION = 2, BUBLE = 3;
    public static final int QUICK1 = 4, QUICK2 = 5, HEAP = 6;
    public static final int MERGE = 7, RADIX = 8;
    public static int n = 10000;

    public static void genArray(int a[], int n) {
        Random ran = new Random(System.currentTimeMillis());
        for (int i = 0; i < n; i++) {
            a[i] = ran.nextInt(1000);
        }

    }

    public static void print(int a[], int n) {
        for (int i = 0; i < n; i++) {
            System.out.format("%3d, ", a[i]);
            if ((i > 0 && (i + 1) % 30 == 0)) {
                System.out.println();
            }
        }
        System.out.println();
    }

    public static boolean checkAsc(int a[], int n) {
        for (int i = 1; i < n; i++) {
            if (a[i] < a[i - 1]) {
                return false;
            }
        }

        return true;
    }

    public static long measure(int a[], int n, int method) {
        long t1 = System.currentTimeMillis();
        long t2;
        switch (method) {
            case SELECTION:
                IntSorter.selectionSort(a, n);
                break;
            case INSERTION:
                IntSorter.selectionSort(a, n);
                break;
            case BUBLE:
                IntSorter.selectionSort(a, n);
                break;
            case QUICK1:
                IntSorter.selectionSort(a, n);
                break;
            case QUICK2:
                IntSorter.selectionSort(a, n);
                break;
            case HEAP:
                IntSorter.selectionSort(a, n);
                break;
            case RADIX:
                IntSorter.selectionSort(a, n);
                break;

        }
        t2 = System.currentTimeMillis();
        return t2 - t1;
    }

    public static void main(String[] args) {
        int ar[] = new int[n];
        genArray(ar, n);
        System.out.println("Original array: ");
        System.out.println("Waiting for sorting " + n + " element.\n");
        long t;
        int a[] = Arrays.copyOf(ar, n);
        t = measure(a, n, SELECTION);
        System.out.println("Selection sort, time cost: " + t + "milisec.");
        System.out.println("Ascending order? " + checkAsc(a, n) + "\n");
        a = Arrays.copyOf(ar, n);
        t = measure(a, n, INSERTION);
        System.out.println("Selection sort, time cost: " + t + "milisec.");
        System.out.println("Ascending order? " + checkAsc(a, n) + "\n");
        a = Arrays.copyOf(ar, n);
        t = measure(a, n, BUBLE);
        System.out.println("Bubble sort, time cost: " + t + "milisec.");
        System.out.println("Ascending order? " + checkAsc(a, n) + "\n");
        a = Arrays.copyOf(ar, n);
        t = measure(a, n, QUICK1);
        System.out.println("Quicksort1,   time cost: " + t + "milisec.");
        System.out.println("Ascending order? " + checkAsc(a, n) + "\n");
        a = Arrays.copyOf(ar, n);
        t = measure(a, n, QUICK2);
        System.out.println("Quicksort2,   time cost: " + t + "milisec.");
        System.out.println("Ascending order? " + checkAsc(a, n) + "\n");
        a = Arrays.copyOf(ar, n);
        t = measure(a, n, HEAP);
        System.out.println("Heap sort,  time cost: " + t + "milisec.");
        System.out.println("Ascending order? " + checkAsc(a, n) + "\n");
        a = Arrays.copyOf(ar, n);
        t = measure(a, n, MERGE);
        System.out.println("Merge  sort, time cost: " + t + "milisec.");
        System.out.println("Ascending order? " + checkAsc(a, n) + "\n");
        a = Arrays.copyOf(ar, n);
        t = measure(a, n, RADIX);
        System.out.println("Redix sort, time cost: " + t + "milisec.");
        System.out.println("Ascending order? " + checkAsc(a, n) + "\n");

    }

}
