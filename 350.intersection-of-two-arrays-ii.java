import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
 * @lc app=leetcode id=350 lang=java
 *
 * [350] Intersection of Two Arrays II
 */

// @lc code=start
class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        Map<Integer, Integer> hashMap1 = new HashMap<>();
        Map<Integer, Integer> hashMap2 = new HashMap<>();
        Map<Integer, Integer> hashMap3 = new HashMap<>();
        List<Integer> ans = new ArrayList<>();

        for (int num : nums1) {
            hashMap1.put(num, 1+(hashMap1.get(num) == null ? 0 : hashMap1.get(num)));
        }
        for (int num : nums2) {
            hashMap2.put(num, 1+(hashMap2.get(num) == null ? 0 : hashMap2.get(num)));

        }

        int count = 0;
        for (int num : hashMap2.keySet()) {
            if (hashMap1.containsKey(num)) {
                count = Math.min(hashMap1.get(num), hashMap2.get(num));
                hashMap3.put(num, count);
                for(int i = 0; i < count; i++) {
                    ans.add(num);
                }
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
