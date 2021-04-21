/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package text;

/**
 *
 * @author Hứa Minh Luân
 */
public class MyStrMatcher {

    public static int indexOf_BF(String S, String pattern) {
        int n = S.length();
        int m = pattern.length();
        int i, j;
        for (i = 0; i < n - m + 1; i++) {
            j = 0;
            while (j < m) {
                if (S.charAt(i + j) != pattern.charAt(j)) {
                    break;
                }
                j++;
                if (j == m) {
                    return i;
                }
            }
        }
        return -1;
    }

    public static int lastIndexOf_BF(String S, String pattern) {
        int n = S.length();
        int m = pattern.length();
        int i, j;
        for (i = n - m; i >= 0; i--) {
            j = 0;
            while (j < m) {
                if (S.charAt(i + j) != pattern.charAt(j)) {
                    break;
                }
                j++;
                if (j == m) {
                    return i;
                }
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        String s1 = "Jack! go away, and you, please do not go away to night";
        String p1 = "go";
        String p2 = "away";
        int pos1 = indexOf_BF(s1, p1);
        int pos2 = indexOf_BF(s1, p2);
        int pos3 = lastIndexOf_BF(s1, p2);
        System.out.println("S1= " + s1);
        System.out.println("p1= " + p1);
        System.out.println("Index of p1 in S1: " + pos1);
        System.out.println("p2= " + p2);
        System.out.println("Index of p2 in S1: " + pos2);
        System.out.println("Last index of p2 in S1: " + pos3);

    }

}
