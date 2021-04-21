/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sort;

import java.util.LinkedList;

/**
 *
 * @author Hứa Minh Luân
 */
public class IntSorter {

    public static void swap(int a[], int i, int j) {
        int t = a[i];
        a[i] = a[j];
        a[j] = t;
    }

    public static int getMinIndex(int a[], int first, int last) {
        int minIndex = first;
        for (int i = first + 1; i <= last; i++) {
            if (a[minIndex] > a[i]) {
                minIndex = i;
            }
        }
        return minIndex;

    }

    public static void selectionSort(int a[], int n) {
        int minIndex;
        for (int i = 0; i < n - 1; i++) {
            minIndex = getMinIndex(a, i, n - 1);
            swap(a, minIndex, i);

        }
    }

    public static void inserttionSort(int a[], int n) {
        int i, j, tmp;

        for (i = 1; i < n; i++) {
            tmp = a[i];
            j = i - 1;
            while (j >= 0 && a[j] > tmp) {
                a[j + 1] = a[j];
                j--;
            }
            a[j + 1] = tmp;
        }
    }

    public static void bubbleSort(int a[], int n) {
        int i, j;
        for (i = 0; i < n - 1; i++) {
            for (j = n - 1; j > i; j--) {
                if (a[j] < a[j - 1]) {
                    swap(a, j, j - 1);
                }

            }

        }
    }

    public static void quickSort1(int a[], int first, int last) {
        int mid = (first + last) / 2;
        swap(a, first, mid);
        int lower = first + 1, upper = last;
        int pivote = a[first];
        while (lower <= upper) {
            while (lower <= upper && pivote > a[lower]) {
                lower++;
            }
            while (lower <= upper && pivote < a[lower]) {
                lower--;
            }
            if (lower < upper) {
                swap(a, lower++, upper);
            } else {
                lower++;
            }

        }
        swap(a, upper, first);
        if (first < upper - 1) {
            quickSort1(a, first, upper - 1);
        }
        if (upper + 1 < last) {
            quickSort1(a, upper + 1, last);
        }

    }

    public static void quickSort1(int a[], int n) {
        quickSort1(a, 0, n - 1);

    }

    public static int median(int a, int b, int c) {
        if ((a > b && a < c) || (a > c && a < b)) {
            return a;
        }
        if ((b > a && b < c) || (b > c && b < a)) {
            return b;
        }
        return c;
    }

    public static void quickSort2(int a[], int first, int last) {
        if (first >= last) {
            return;
        }
        int mid = (first + last) / 2;
        int pivote = median(a[first], a[last], a[mid]);
        int lower = first;
        int upper = last;
        while (lower <= upper) {
            while (lower <= upper && pivote > a[lower]) {
                lower++;
            }
            while (lower <= upper && pivote < a[upper]) {
                upper--;
            }
            if (lower < upper) {
                swap(a, lower++, upper--);
            } else {
                lower++;
            }

        }
        quickSort1(a, first, upper);
        quickSort2(a, upper + 1, last);

    }

    public static void quickSort2(int a[], int n) {
        quickSort2(a, 0, n - 1);
    }
    static int[] temp;

    private static void merge(int[] a, int first, int last) {
        int mid = (first + last) / 2;
        int i = first;
        int j = mid + 1;
        int k = 0;
        while (i <= mid && j <= last) {
            if (a[i] < (a[j])) {
                temp[k++] = a[i++];
            } else {
                temp[k++] = a[j++];
            }
        }
        while (i <= mid) {
            temp[k++] = a[i++];
        }
        while (j <= last) {
            temp[k++] = a[j++];
        }
        for (k = 0, i = first; i <= last; a[i++] = temp[k++]) ;

    }

    private static void mergesort(int[] a, int first, int last) {
        int mid = (first + last) / 2;
        if (first < mid) {
            mergesort(a, first, mid);
        }
        if (mid + 1 < last) {
            mergesort(a, mid + 1, last);
        }

    }

    private static void mergeSort(int[] a, int n) {
        if (n < 2) {
            return;
        }
        temp = new int[n];
        mergesort(a, 0, n - 1);

    }

    public static void moveDown(int[] a, int first, int last) {
        int largest = 2 * first + 1;
        while (largest <= last) {
            if (largest < last && a[largest] < a[largest + 1]) {
                largest++;
            }
            if (a[first] < a[largest]) {
                swap(a, first, largest);
                first = largest;
                largest = 2 * first + 1;
            }
        }
    }

    public static void heapSort(int a[], int n) {
        for (int i = n / 2 - 1; i >= 0; --i) {
            moveDown(a, i, n - 1);
        }
        for (int i = n - 1; i >= 1; --i) {
            swap(a, 0, i);
            moveDown(a, 0, i - 1);
        }
    }

    public static final int RADIX = 10;

    public static int countDigits(int n) {
        int count = 0;
        while (n / 10 != 0) {
            count++;
            n /= 10;
        }
        return count + 1;

    }

    public static int maxAbsolute(int a[], int n) {
        int result = Integer.MIN_VALUE;
        for (int x : a) {
            if (x < 0) {
                x = -x;
            }
            if (result < x) {
                result = x;
            }
        }
        return result;
    }

    public static void radixSort(int a[], int n) {
        int longest = maxAbsolute(a, n);
        int digits = countDigits(longest);
        int d, j, k, factor;
        LinkedList<Integer>[] queues = new LinkedList[RADIX];
        for (d = 0; d < RADIX; d++) {
            queues[d] = new LinkedList<>();
        }
        for (d = 1, factor = 1; d <= digits; factor *= RADIX, d++) {
            for (j = 0; j < n; j++) {
                queues[(a[j] / factor) % RADIX].addLast(a[j]);
            }
            for (j = k = 0; j < RADIX; j++) {
                while (!queues[j].isEmpty()) {
                    a[k++] = queues[j].remove();

                }
            }

        }

    }

}
