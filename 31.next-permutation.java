/*
 * @lc app=leetcode id=31 lang=java
 *
 * [31] Next Permutation
 */

// @lc code=start
class Solution {
    public void nextPermutation(int[] nums) {
        way2(nums);

    }
    public void way1(int[] nums) {
        int i = nums.length - 2;
        while (i >= 0 && nums[i] >= nums[i + 1]) {
        i--;
        }


        if (i >= 0) {
        int j = nums.length - 1;
        while (j >= 0 && nums[i] >= nums[j]) {
        j--;
        }
        swap(nums, i, j);
        }

    

        reverse(nums, i + 1);

    }
    public void way2(int[] nums) {
        for (int i = nums.length-1; i > 0; i--) {
            if (nums[i] > nums[i-1]) { // 发现了一个山峰
                for (int j = nums.length-1; j >= i; j--) {
                    if (nums[j] > nums[i-1]) { // 必定会发现一个比nums[i-1]大的数字
                        swap(nums, i-1, j);
                        reverse(nums, i, nums.length-1);
                    }
                }
                return ; 
            }
        }
        // 没有找到山峰，说明nums数组为递减序列，需要翻转整个nums数组
        reverse(nums, 0, nums.length-1);
    }

    public void reverse(int[] nums, int left, int right) {
        while (left < nums.length && left < right) {
            swap(nums, left, right);
            left++;
            right--;
        }
    }


    public void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public void reverse(int[] nums, int start) {
        int left = start, right = nums.length - 1;
        while (left < right) {
            swap(nums, left, right);
            left++;
            right--;
        }
    }

}
// @lc code=end
