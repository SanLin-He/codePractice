/*
 * @lc app=leetcode id=88 lang=java
 *
 * [88] Merge Sorted Array
 */

// @lc code=start
class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int l1 = nums1.length;
        int l2 = nums2.length;

        int[] longNums = l1 >= l2 ? nums1 : nums2;
        int l = longNums.length;
        while(l>0){
            if(m > 0 && n > 0) {
                if(nums1[m-1] >= nums2[n-1]) {
                    longNums[l-1] = nums1[m-1];
                    l--;
                    m--;
                }else {
                    longNums[l-1] = nums2[n-1];
                    l--;
                    n--;
                }
            }
            else if(m>0 && n <= 0) {
                longNums[l-1] = nums1[m-1];
                l--;
                m--;
            }
            else if(m<=0 && n > 0){
                longNums[l-1] = nums2[n-1];
                l--;
                n--;
            }
          
        }
    }
}
// @lc code=end

