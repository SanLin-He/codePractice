/*
 * @lc app=leetcode id=34 lang=java
 *
 * [34] Find First and Last Position of Element in Sorted Array
 */

// @lc code=start
class Solution {
    public int[] searchRange(int[] nums, int target) {
        int l = 0;
        int r = nums.length-1;//5
        int m = 0;

        boolean find = false;
        while (l <= r) {
            m = l + ((r-l)>>1);//4
            if (nums[m] == target) {
                find = true;//
                break;
            }
            else if (nums[m] < target) {
                l = m + 1;
            }   
            else if(nums[m] > target){
                r = m - 1;
            }
        }
        if (find) {
            l = m;//3
            r = m;
            while (r < nums.length - 1 && nums[r + 1] == target) {
                r++;//4
            }
            while (l > 0 && nums[l - 1] == target) {
                l--;//3
            }
            return new int[] { l, r };
        } else {
            return new int[] { -1, -1 };
        }
    }
}

// class Solution {
//     public int[] searchRange(int[] nums, int target) {
//         int leftIdx = binarySearch(nums, target, true);
//         int rightIdx = binarySearch(nums, target, false) - 1;
//         if (leftIdx <= rightIdx && rightIdx < nums.length && nums[leftIdx] == target && nums[rightIdx] == target) {
//             return new int[]{leftIdx, rightIdx};
//         } 
//         return new int[]{-1, -1};
//     }

//     public int binarySearch(int[] nums, int target, boolean lower) {
//         int left = 0, right = nums.length - 1, ans = nums.length;
//         while (left <= right) {
//             int mid = (left + right) / 2;
//             if (nums[mid] > target || (lower && nums[mid] >= target)) {
//                 right = mid - 1;
//                 ans = mid;
//             } else {
//                 left = mid + 1;
//             }
//         }
//         return ans;
//     }
// }


// @lc code=end
