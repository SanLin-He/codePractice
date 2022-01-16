import java.util.HashMap;
import java.util.Map;

/*
 * @lc app=leetcode id=387 lang=java
 *
 * [387] First Unique Character in a String
 */

// @lc code=start
class Solution {
    public int firstUniqChar(String s) {
        // return way1(s);
        // return way2(s);
        return way3(s);

    }



    //26 letters much better use int array
    int way3(String s) {
        int[] chars = new int[26];
        for(int i = 0; i < s.length(); i++){
            chars[s.charAt(i) - 'a']++;
        }

        for(int i=0; i <s.length(); i++){
            if(chars[s.charAt(i)-'a'] == 1){
                return i;
            }

        }

        return -1;
    }

    int way1(String s) {
        char[] chars = s.toCharArray();
        Map<Character, Integer> charCount = new HashMap<>();

        for (int i = 0; i < chars.length; i++) {
            char a = chars[i];
            if (charCount.containsKey(a)) {
                charCount.put(a, charCount.get(a) + 1);
            } else {
                charCount.put(a, 1);
            }
        }
        for (int i = 0; i < chars.length; i++) {
            char a = chars[i];
            if (charCount.get(a) == 1)
                return i;
        }
        return -1;

    }

    int way2(String s) {
        Map<Character, Integer> charCount = new HashMap<>();

        for(int i = 0; i < s.length(); i++){
            char a = s.charAt(i);
            if (charCount.containsKey(a)) {
                charCount.put(a, charCount.get(a) + 1);
            } else {
                charCount.put(a, 1);
            }
        }

        for (int i = 0; i < s.length(); i++) {
            char a = s.charAt(i);
            if (charCount.get(a) == 1)
                return i;
        }
        return -1;
    }
}
// @lc code=end
