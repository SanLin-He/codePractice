/*
 * @lc app=leetcode id=191 lang=java
 *
 * [191] Number of 1 Bits
 */

// @lc code=start
public class Solution {
    // you need to treat n as an unsigned value
    public int hammingWeight(int n) {

        //return way1(n);
         return way2(n);
        
    }

    //1 的其他位上都为0；
    int way1(int n){
        int ans = 0;
        for(int i = 0; i <= 31; i++){
            if((n&(1<<i)) != 0){
                ans++;
            }
        }

        return ans; 
    }
    //2 n&(n-1) 去掉最后一个为1的
    int way2(int n) {
        int ans = 0;
        while(n!=0){
            n = n&(n-1);
            ans++;
        }
        return ans;
    }
    
}
// @lc code=end

