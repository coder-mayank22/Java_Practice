import java.util.*;

public class TwoSum {
    public static List<Integer> twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];
            if (map.containsKey(complement)) {
                return Arrays.asList(map.get(complement), i);
            }
            map.put(nums[i], i);
        }
        throw new IllegalArgumentException("No solution found");
    }

    public static void main(String[] args) {
        int[] nums = {2, 7, 11, 15};
        int target = 9;
        List<Integer> result = twoSum(nums, target);
        for(int i : result){
            System.out.println(i);
        }
    }
}
