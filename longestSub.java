// Leetcode problem #3

import java.util.Scanner;
import java.util.HashSet;

public class longestSub{
    static String s;
    static void input(){
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a string: ");
        s = sc.next();
    }

    public static int findLengthSubstring(){
        int lenMax = 0, start = 0, end = 0;
        String longeststr = "";
        HashSet<Character> set = new HashSet<>();

        while (end < s.length()) {
            char currentChar = s.charAt(end);
            if (!set.contains(currentChar)) {
                set.add(currentChar);
                end++;
                if (end - start > lenMax) {
                    lenMax = end - start;
                    longeststr = s.substring(start, end);
                }
            } else {
                // Remove the leftmost character and slide the window
                set.remove(s.charAt(start));
                start++;
            }
        }
        System.out.println("Longest substring: " + longeststr);
        return lenMax;
    }

    public static void main(String[] args) {
        input();
        int maxlen = findLengthSubstring();
        System.out.println("Length = " + maxlen);
    }
}