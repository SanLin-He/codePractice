import java.util.HashMap;
import java.util.Map;

/*
 * @lc app=leetcode id=13 lang=java
 *
 * [13] Roman to Integer
 */

// @lc code=start
class Solution {
    public int romanToInt(String s) {
        Map<Character, Integer> map= new  HashMap<>();
        map.put('I', 1);
        map.put('V', 5);
        map.put('X', 10);
        map.put('L', 50);
        map.put('C', 100);
        map.put('D', 500);
        map.put('M', 1000);

        int ans = 0;
        int left = 0;
        int right = 0;
      for(int i =0; i < s.length()-1; i++){
        left = map.get(s.charAt(i));
        right = map.get(s.charAt(i+1));
          if( left < right){
            ans = right - left;
            i++;
          }else {
              ans = left+right;
              i++;
          }

      }



        return ans;
    }
}
// @lc code=end

