import java.util.Arrays;

/*
 * @lc app=leetcode id=215 lang=java
 *
 * [215] Kth Largest Element in an Array
 */

// @lc code=start
class Solution {
    // public int findKthLargest(int[] nums, int k) {
    // Arrays.sort(nums);
    // return nums[nums.length - k];
    // }
    // public int findKthLargest(int[] nums, int k) {

    // int len = nums.length;
    // int left = 0;
    // int right = len - 1;

    // // 转换一下，第 k 大元素的下标是 len - k(排序后的)
    // int tIndex = len - k;

    // //动态排序
    // while (true) {
    // int index = partition(nums, left, right);
    // if (index == tIndex) {
    // return nums[index];
    // } else if (index < tIndex) {//找到的小了，在大的区域去找
    // left = index + 1;
    // } else {
    // right = index - 1;
    // }
    // }
    // }

    public int findKthLargest(int[] nums, int k) {
        int n = nums.length;
        int l = 0;
        int r = n - 1;
        int targetIndex = n - k;
        while (true) {
            int index = partition(nums, l, r);// nums的顺序已经被改变了
            if (index == targetIndex)
                return nums[index];
            if (index < targetIndex) {
                l = index + 1;
            } else {
                r = index - 1;
            }

        }

    }

    public int partition(int[] nums, int left, int right) {
        int pivot = nums[left];
        int leastSmallIndex = left;
        for (int i = left; i <=right; i++) {
            if (nums[i] < pivot) {
                swap(nums, leastSmallIndex + 1, i);
                leastSmallIndex++;
            }
        }
        swap(nums, left, leastSmallIndex);

        return leastSmallIndex;
    }

    /**
     * 对数组 nums 的子区间 [left..right] 执行 partition 操作，返回 nums[left] 排序以后应该在的位置
     * 在遍历过程中保持循环不变量的定义：
     * nums[left + 1..j] < nums[left]
     * nums(j..i) >= nums[left]
     *
     * @param nums
     * @param left
     * @param right
     * @return
     */
    // public int partition(int[] nums, int left, int right) {
    // int pivot = nums[left];
    // int j = left;
    // for (int i = left;i <= right;i++) {
    // if (nums[i] < pivot) {
    // swap(nums, j+1, i);
    // j++;
    // }

    // }
    // // 在之前遍历的过程中，满足 nums[left + 1..j] < pivot，并且 nums(j..i) >= pivot
    // swap(nums, j, left);
    // // 交换以后 nums[left..j - 1] < pivot, nums[j] = pivot, nums[j + 1..right] >=
    // pivot
    // return j;
    // }

    private void swap(int[] nums, int index1, int index2) {
        int temp = nums[index1];
        nums[index1] = nums[index2];
        nums[index2] = temp;
    }
}
// @lc code=end
