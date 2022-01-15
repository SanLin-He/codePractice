import java.util.Arrays;

/*
 * @lc app=leetcode id=189 lang=java
 *
 * [189] Rotate Array
 */

// @lc code=start
class Solution {
    public void rotate(int[] nums, int k) {
        // way1(nums, k);
        // way2(nums, k);
        way3(nums, k);
    }

    // xxx move one by one bf time limit exceeded
    void way1(int[] nums, int k) {
        int temp = 0;
        for (int step = 0; step < k; step++) {
            temp = nums[nums.length - 1];
            for (int i = nums.length - 1; i > 0; i--) {
                nums[i] = nums[i - 1];
            }
            nums[0] = temp;
        }
    }

    void way2(int[] nums, int k) {
        int length = nums.length;
        int[] copy = Arrays.copyOf(nums, length);
        for (int i = 0; i < length; i++) {
            nums[(i + k) % length] = copy[i];
        }

    }

    void way3(int[] nums, int k) {
        k %= nums.length;
        if(k <=0) return;
        reverse(nums, 0, nums.length - 1);
        reverse(nums, 0, k - 1);
        reverse(nums, k, nums.length - 1);
    }

    void reverse(int[] nums, int l, int r) {
        if (l >= r)
            return;

        while (r > l) {
            nums[l] = nums[l] ^ nums[r];
            nums[r] = nums[l] ^ nums[r];
            nums[l] = nums[l] ^ nums[r];
            l++;
            r--;
        }
    }
}
// @lc code=end
