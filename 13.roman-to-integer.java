import java.util.HashMap;
import java.util.Map;

/*
 * @lc app=leetcode id=13 lang=java
 *
 * [13] Roman to Integer
 */

// @lc code=start
class Solution {

  //  把hashmap 转化成switch会快很多
  public int romanToInt(String s) {

    // return way1(s);
    return way2(s);

  }

  int way1(String s) {
    Map<Character, Integer> map = new HashMap<>();
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
    int count = 0;
    for (int i = 0; i < s.length() - 1; i++) {
      left = map.get(s.charAt(i));
      right = map.get(s.charAt(i + 1));
      if (left < right) {
        ans += right - left;
        i++;
        count += 2;
      } else {
        ans += left;
        count += 1;
      }

    }
    if (count <= s.length() - 1) {
      ans += map.get(s.charAt(s.length() - 1));
    }

    return ans;
  }

  int way2(String s) {
    int ans = 0;
    int pre = getValue(s.charAt(0));
    int num = 0;
    for(int i = 1; i < s.length(); i++){
      num = getValue(s.charAt(i));
      if(pre < num){
        ans -= pre;
      }else {
        ans += pre;
      }
      pre = num;
    }
    ans += pre;


    return ans;
  }

  int getValue(char c) {
    switch (c) {
      case 'I':
        return 1;
      case 'V':
        return 5;
      case 'X':
        return 10;
      case 'L':
        return 50;
      case 'C':
        return 100;
      case 'D':
        return 500;
      case 'M':
        return 1000;
      default:
        return 0;

    }
  }

}
// @lc code=end
