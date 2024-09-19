package neetcode.courses.dsa.arrays.dynamics.exercises;

public class ConcatenationOfArray {

    // Problem definition: https://leetcode.com/problems/concatenation-of-array/
    public static int[] getConcatenation(int[] nums) {
        int n = nums.length;
        int[] ans = new int[2 * n];

        for (int i = 0; i < nums.length; i++) {
            ans[i] = nums[i];
            ans[n] = nums[i];
            n++;
        }

        return ans;
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 1};
        int[] ans = getConcatenation(nums);

        for (int i = 0; i < ans.length; i++) {
            System.out.print(ans[i]);
        }
    }
}
