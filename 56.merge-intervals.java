import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/*
 * @lc app=leetcode id=56 lang=java
 *
 * [56] Merge Intervals
 */

// @lc code=start
class Solution {
    public int[][] merge(int[][] intervals) {

        if (intervals.length <= 1)return intervals;
        // Arrays.sort(intervals, new Comparator<int[]>() {
        //     public int compare(int[] interval1, int[] interval2) {
        //         return interval1[0] - interval2[0];
        //     }
        // });
        Arrays.sort(intervals, (v1, v2) -> v1[0] - v2[0]);
        
        List<int[]> ans = new ArrayList<>();
        ans.add(intervals[0]);
        for (int i = 1; i < intervals.length; i++) {
            int[] last = ans.get(ans.size()-1);
            if (intervals[i][0] <= last[1]) {
                last[1] = Math.max(last[1], intervals[i][1]);
            } else {
                ans.add(intervals[i]);
            }
        }
        return ans.toArray(new int[ans.size()][]);
    }
}
// @lc code=end
