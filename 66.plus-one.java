/*
 * @lc app=leetcode id=66 lang=java
 *
 * [66] Plus One
 */

// @lc code=start
class Solution {
    public int[] plusOne(int[] digits) {
        int n = digits.length;
        int[]ans = new int[n+1];
        ans[n] = 1;
        int head = 0;
        int sum = 0;
        for(int tail = n; tail>0; tail--){
            sum = ans[tail] + digits[tail-1] + head;
            ans[tail] = sum%10;
            head = sum/10;
        }
        if(ans[0] == 0) {
            for(int i  =0; i <n;i++){
                digits[i] = ans[i+1];
            }
            return digits;
        }
        return ans;

    }
}
// @lc code=end

