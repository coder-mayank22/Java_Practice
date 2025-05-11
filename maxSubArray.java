import java.util.Scanner;

public class maxSubArray {
    public static int findMaxSum(int[] nums){
        int maxSum = nums[0], currentSum = nums[0];
        for(int i = 1; i < nums.length; i++) {
            currentSum = Math.max(nums[i], currentSum + nums[i]);
            maxSum = Math.max(maxSum, currentSum);
        }

        return maxSum;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter number of elements in the array : ");
        int size = sc.nextInt();
        int[] nums = new int[size];
        System.out.println("Enter elements: ");
        for (int i = 0; i < size; i++) {
            System.out.print("Element " + (i+1) + ": ");
            nums[i] = sc.nextInt();
        }

        int sumMaxSubArray = findMaxSum(nums);
        System.out.println("Sum of maximum subarray = " + sumMaxSubArray);
    }
}
