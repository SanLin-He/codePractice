import java.util.ArrayList;
import java.util.List;

/*
 * @lc app=leetcode id=412 lang=java
 *
 * [412] Fizz Buzz
 */

// @lc code=start
class Solution {
    public List<String> fizzBuzz(int n) {
        // return way1(n);
        return way2(n);
    }

    public List<String> way1(int n) {
        List<String> ans = new ArrayList<>();
        String fizz = "Fizz";
        String buzz = "Buzz";
        int mod3 = 0;
        int mod5 = 0;
        for (int i = 1; i <= n; i++) {
            mod3 = i % 3;
            mod5 = i % 5;
            if (mod3 == 0 && mod5 == 0) {
                ans.add(fizz+buzz);
            }else if(mod3 == 0) {
                ans.add(fizz);
            }else if(mod5 == 0) {
                ans.add(buzz);
            }else {
                ans.add(i+"");
            }
        }

        return ans;
    }

    public List<String> way2(int n) {
        List<String> ans = new ArrayList<>();
        String fizz = "Fizz";
        String buzz = "Buzz";
        int i3 = 0;
        int i5 = 0;
        String temp = null;
        for (int i = 1; i <= n; i++) {
                temp = i+"";
                if(i - i3 == 3) {
                   temp = fizz;
                    i3 = i;
                }
                if(i - i5 == 5) {
                    temp = buzz;
                    i5 = i;
                    
                }
                if(i3 == i5&& i3 == i){
                    temp = fizz+buzz;
                }
                ans.add(temp);
            
        }

        return ans;
    }
}
// @lc code=end
