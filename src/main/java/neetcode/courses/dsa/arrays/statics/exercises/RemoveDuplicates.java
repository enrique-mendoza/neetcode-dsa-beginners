package neetcode.courses.dsa.arrays.statics.exercises;

public class RemoveDuplicates {

    // Problem definition: https://leetcode.com/problems/remove-duplicates-from-sorted-array/description/
    public static int removeDuplicates(int[] nums) {
        int l = 1;

        for (int r = 1; r < nums.length; r++) {
            if (nums[r] != nums[r - 1]) {
                nums[l] = nums[r];
                l++;
            }
        }

        return l;
    }

    public static void main(String[] args) {
        int[] nums = {0, 0, 1, 1, 1, 2, 2, 3, 3, 4};
        int k = removeDuplicates(nums);
        System.out.println(k);
    }
}
