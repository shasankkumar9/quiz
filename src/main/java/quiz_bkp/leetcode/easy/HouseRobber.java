package quiz_bkp.leetcode.easy;

public class HouseRobber {
    static int houseRobber(int[] arr) {
        int rob1 = 0, rob2 = 0;
        int temp = 0;
        for (int a : arr) {
            temp = Math.max(rob1 + a, rob2);
            rob1 = rob2;
            rob2 = temp;
        }

        return rob2;
    }

    public static void main(String[] args) {

        int[] arr = {1, 2, 3, 1};
        System.out.println(houseRobber(arr));

    }
}
