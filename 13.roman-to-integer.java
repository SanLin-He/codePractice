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
        int lNum = 0;
        int rNum = 0;
        int i =0;
      for( ;i < s.length()-1; i++){
        lNum = map.get(s.charAt(i));
        rNum = map.get(s.charAt(i+1));
          if( lNum < rNum){
            ans += rNum - lNum;
            i++;
          }else {
              ans += lNum;
          }
      }
      if(i == s.length() -1){
          ans+= map.get(s.charAt(i));
      }



        return ans;
    }
}
// @lc code=end

