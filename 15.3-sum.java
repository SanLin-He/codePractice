import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
 * @lc app=leetcode id=15 lang=java
 *
 * [15] 3Sum
 */

// @lc code=start

//[-1,0,1,2,-1,-4]
class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        if (nums == null || nums.length < 3)
            return ans;
        // Map<Integer,Integer> mapNegtive = new HashMap<>();
        // Map<Integer,Integer> mapNegPostive = new HashMap<>();

        Arrays.sort(nums);

        if (nums.length == 3) {
            if (nums[0] == 0 && nums[nums.length - 1] != 0) {
                return ans;
            }
        }

        if (nums[0] == 0 && nums[nums.length - 1] == 0) {
            List<Integer> t = new ArrayList<>();
            t.add(0);
            t.add(0);
            t.add(0);
            ans.add(t);
            return ans;
        }

        if (nums[0] > 0) {
            return ans;
        }

        if (nums[0] == 0 && nums[nums.length - 1] != 0) {
            List<Integer> t = new ArrayList<>();
            t.add(0);
            t.add(0);
            t.add(0);
            ans.add(t);
        }

        int MaxNegtiveIndex = 0;
        int MinPostiveIndex = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] < 0) {
                MaxNegtiveIndex = i;
            }
            if (nums[i] > 0) {
                MinPostiveIndex = i;
                break;
            }
        }

        // [-2,-1,0,1,2,3]

        int l = 0;
        int j = l + 1;
        int h = nums.length - 1;

        while (h >j) {

            if (nums[l] == nums[j]) {
                l++;
                j++;
                continue;
            }
            if (nums[h] == nums[h - 1]) {
                h--;
                continue;
            }
            int sum = nums[l] + nums[j] + nums[h];
            if (sum == 0) {
                List<Integer> t = new ArrayList<>();
                t.add(nums[l]);
                t.add(nums[j]);
                t.add(nums[h]);
                ans.add(t);
                l++;
                j++;
                h--;

            } else if (sum < 0) {
                j++;
                l++;
            } else {
                h--;
            }
        }
        return ans;
    }
}
// @lc code=end
