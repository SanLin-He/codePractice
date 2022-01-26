/*
 * @lc app=leetcode id=41 lang=java
 *
 * [41] First Missing Positive
 */

// @lc code=start
class Solution {
    public int firstMissingPositive(int[] nums) {
        //缺失的数字必在[1,n+1]
        //利用数组下标做和原数的符号做哈希标记
        int n = nums.length;
        boolean findone =false;
        for(int i = 0; i < nums.length; i++){
            if(nums[i] == 1){
                findone = true;
            }

        }
        if(!findone) return 1;
        for(int i = 0; i < nums.length; i++){
            if(nums[i] < 1 || nums[i] > n){
                nums[i] = 1;
            }
        }

        for(int i=0; i <nums.length;i++){
            int index = Math.abs(nums[i])-1;
            if(nums[index] > 0) {
                nums[index] = -nums[index];
            }
        }

        for(int i = 0; i < nums.length; i++){
            if(nums[i] > 0) {

                return i+1;
            }
        }

        return n+1;
    }
}
// @lc code=end

