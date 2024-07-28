package leetcode.medium;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class KSumPairs {
    static int maxOperationsV2(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        int count = 0;

        for (int num : nums) {
            int comp = k - num;

            if (map.containsKey(comp) && map.get(comp) > 0) {
                count++;
                map.put(comp, map.get(comp) - 1);
            } else {
                map.put(num, map.getOrDefault(num, 0) + 1);
            }

        }

        return count + 1;

    }

    static int maxOperations(int[] nums, int k) {

        Arrays.sort(nums);

        int l = 0, r = nums.length - 1;
        int count = 0;

        while (l < r) {
            int sum = nums[l] + nums[r];
            if (sum == k) {
                count++;
                l++;
                r--;
            } else if (sum < k) {
                l++;
            } else {
                r--;
            }
        }

        return count;

    }

    public static void main(String[] args) {
        int[] nums = {3, 1, 3, 4, 3};
        int k = 6;
        int result = maxOperationsV2(nums, k);
        System.out.println("result = " + result);
        assert result == 1 : "Something went wrong";
    }
}
