import java.util.HashSet;
import java.util.Set;

/*
 * @lc app=leetcode id=217 lang=java
 *
 * [217] Contains Duplicate
 */

// @lc code=start
class Solution {
    public boolean containsDuplicate(int[] nums) {
        int n = nums.length;
        if (n == 1)
            return false;
        Set<Integer> set = new HashSet<>();
        for(int i =0 ; i < n;i++){
            if(set.contains(nums[i]))return true;
            set.add(nums[i]);
        }

        return false;
    }
}
// @lc code=end
