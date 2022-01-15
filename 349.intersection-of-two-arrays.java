import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/*
 * @lc app=leetcode id=349 lang=java
 *
 * [349] Intersection of Two Arrays
 */

// @lc code=start
class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> hashSet = new HashSet<>();
        Set<Integer> hashSet2 = new HashSet<>();
        List<Integer> ans = new ArrayList<>();
        for(int i = 0; i < nums1.length; i ++){
            hashSet.add(nums1[i]);
        }
        for (int num : nums2) {
            hashSet2.add(num);
            
        }
        for (int num : hashSet2) {
            if(hashSet.contains(num)){
                ans.add(num);
            }
            
        }
        int[] arr =  new int[ans.size()];
        for (int i = 0; i < ans.size();i++ ) {
            arr[i] = ans.get(i);
            
        }
        return arr;
        
    }
}
// @lc code=end

