import java.util.Arrays;
import java.util.Random;

/*
 * @lc app=leetcode id=384 lang=java
 *
 * [384] Shuffle an Array
 */

// @lc code=start
class Solution {

    int[]nums;
    int[]original;
    public Solution(int[] nums) {
        this.nums = nums;
        this.original = Arrays.copyOf(nums, nums.length );
    }
    
    public int[] reset() {
        this.nums= Arrays.copyOf(original, original.length);
        return nums;
    }
    
    Random random = new Random();
    int randIndex = -1;
    public int[] shuffle() {
        for(int i = 0; i <nums.length-1; i++){
            // 洗牌算法（去掉已选的，随机新的）
            randIndex = i + random.nextInt(nums.length - i);
            nums[i]= nums[i] + nums[randIndex];
            nums[randIndex] = nums[i] - nums[randIndex];
            nums[i] = nums[i] - nums[randIndex];
        }

        return nums;

        
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(nums);
 * int[] param_1 = obj.reset();
 * int[] param_2 = obj.shuffle();
 */
// @lc code=end

