package quiz_bkp.leetcode.easy;

public class MaximumSubArray {

    static int maximumSubArray(int[] array) {
        int maxSub = array[0];
        int sum = 0;

        for (int val : array) {
            if (sum < 0) {
                sum = 0;
            }
            sum += val;
            maxSub = Math.max(maxSub, sum);
        }

        return maxSub;
    }

    public static void main(String[] args) {

        int[] array = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
        System.out.println(maximumSubArray(array));

    }
}
