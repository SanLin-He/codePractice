/*
 * @lc app=leetcode id=278 lang=java
 *
 * [278] First Bad Version
 */

// @lc code=start
/* The isBadVersion API is defined in the parent class VersionControl.
      boolean isBadVersion(int version); */

public class Solution extends VersionControl {
    public int firstBadVersion(int n) {
        

        // return way1(n);
        return way2(n);
    }

    int way2(int n) {
        return bFind(1,n);
    }

    int bFind(int l,int r) {
       
        if(l >= r) return r;
        int mid = l+(r-l)/2;
        if(isBadVersion(mid)) return bFind(l, mid);
        return bFind(mid+1, r);
       
    }

    public int way1(int n) {
        int left = 1, right = n;
        while (left < right) { // 循环直至区间左右端点相同
            int mid = left + (right - left) / 2; // 防止计算时溢出
            if (isBadVersion(mid)) {
                right = mid; // 答案在区间 [left, mid] 中
            } else {
                left = mid + 1; // 答案在区间 [mid+1, right] 中
            }
        }
        // 此时有 left == right，区间缩为一个点，即为答案
        return left;
    }

}
// @lc code=end

