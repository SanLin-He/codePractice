import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
 * @lc app=leetcode id=17 lang=java
 *
 * [17] Letter Combinations of a Phone Number
 */

// @lc code=start
class Solution {
    public List<String> letterCombinations(String digits) {

        // return way1(digits);
        return way2(digits);
    }

    List<String> way2(String digits) {
        List<String> ans = new ArrayList<>();
        if (digits.length() == 0) {
            return ans;
        }
        Map<Character, String> phoneMap = new HashMap<Character, String>() {
            {
                put('2', "abc");
                put('3', "def");
                put('4', "ghi");
                put('5', "jkl");
                put('6', "mno");
                put('7', "pqrs");
                put('8', "tuv");
                put('9', "wxyz");
            }
        };

        
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < digits.length();i++){

            backtrack2(phoneMap.get(digits.charAt(i)), sb, ans,digits.length());
        }
        return ans;
    }

    void backtrack2(String digitLetters, StringBuilder sb, List<String> ans, int n) {
        if (sb.length() >= n) {
            ans.add(sb.toString());
            return;
        }
        for (int i = 0; i < digitLetters.length(); i++) {
            sb.append(digitLetters.charAt(i));
            backtrack2(digitLetters, sb, ans,n);
            sb.deleteCharAt(sb.length()-1);
        }
    }


    List<String> way1(String digits) {
        List<String> ans = new ArrayList<>();
        if (digits.length() == 0) {
            return ans;
        }
        Map<Character, String> phoneMap = new HashMap<Character, String>() {
            {
                put('2', "abc");
                put('3', "def");
                put('4', "ghi");
                put('5', "jkl");
                put('6', "mno");
                put('7', "pqrs");
                put('8', "tuv");
                put('9', "wxyz");
            }
        };

        
        StringBuilder sb = new StringBuilder();
        backtrack1(digits, phoneMap, sb, 0, ans);
        return ans;
    }

    void backtrack1(String digits, Map<Character, String> phoneMap, StringBuilder sb, int index, List<String> ans) {
        if (sb.length() >= digits.length()) {
            ans.add(sb.toString());
            return;
        }
        String digitLetters = phoneMap.get(digits.charAt(index));
        for (int i = 0; i < digitLetters.length(); i++) {
            sb.append(digitLetters.charAt(i));
            backtrack1(digits, phoneMap, sb, index + 1, ans);
            sb.deleteCharAt(index);
        }
    }

}
// @lc code=end
