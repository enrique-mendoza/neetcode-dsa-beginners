package neetcode.courses.dsa.arrays.statics.exercises;

public class RemoveElement {
    // Problem definition: https://leetcode.com/problems/remove-element/description/
    public static int removeElement(int[] nums, int val) {
        int l = 0;

        for (int r = 0; r < nums.length; r++) {
            if (nums[r] != val) {
                nums[l] = nums[r];
                l++;
            }
        }

        return l;
    }

    public static void main(String[] args) {
        int[] nums = {0, 1, 2, 2, 3, 0, 4, 2};
        int val = 2;
        int k = removeElement(nums, val);
        System.out.println(k);
    }
}
