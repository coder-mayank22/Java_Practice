import java.util.*;
public class WaysToDecode {
    public static int calculateWays(int num) {
        String s = String.valueOf(num);
        if (s == null) return 0;
        return decodeHelper(s, 0);
    }

    private static int decodeHelper(String s, int index) {
        if (index == s.length()) return 1;

        // Leading zero is invalid
        if (s.charAt(index) == '0') return 0;

        // Option 1: Take one digit
        int count = decodeHelper(s, index + 1);

        // Option 2: Take two digits (if valid)
        if (index + 1 < s.length()) {
            int twoDigit = Integer.parseInt(s.substring(index, index + 2));
            if (twoDigit >= 10 && twoDigit <= 26) {
                count += decodeHelper(s, index + 2);
            }
        }

        return count;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num;
        System.out.print("Enter the number : ");
        num = sc.nextInt();
        System.out.println("Number of ways to decode the number = " + calculateWays(num));
    }
}
