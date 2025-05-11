import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class groupLargest {
    public static int countLargestGroup(int n) {
        HashMap<Integer, ArrayList<Integer>> map = new HashMap<>();

        for (int i = 1; i <= n; i++) {
            int sum = digitSum(i);
            map.putIfAbsent(sum, new ArrayList<>());
            map.get(sum).add(i);
        }

        int maxSize = 0;
        for (ArrayList<Integer> group : map.values()) {
            maxSize = Math.max(maxSize, group.size());
        }

        int count = 0;
        for (ArrayList<Integer> group : map.values()) {
            if (group.size() == maxSize) {
                count++;
            }
        }

        return count;
    }

    private static int digitSum(int num) {
        int sum = 0;
        while (num != 0) {
            sum += num % 10;
            num /= 10;
        }
        return sum;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the value of n: ");
        int n = sc.nextInt();

        int count = countLargestGroup(n);
        System.out.println(count);
    }
}
