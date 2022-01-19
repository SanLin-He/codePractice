import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/*
 * @lc app=leetcode id=20 lang=java
 *
 * [20] Valid Parentheses
 */

// @lc code=start
class Solution {

    // 有一种string。replace 来解思路很不错但是效率不高
    // 利用ascii 码 比较
    public boolean isValid(String s) {

        // return way1(s);
        return way2(s);
    }

    boolean way1(String s) {
        Stack<Character> stack = new Stack<>();
        stack.push(s.charAt(0));
        for (int i = 1; i < s.length(); i++) {
            if (stack.isEmpty()) {
                stack.push(s.charAt(i));
            } else {
                if (s.charAt(i) - stack.peek() == 1 || s.charAt(i) - stack.peek() == 2) {
                    stack.pop();
                } else {
                    stack.push(s.charAt(i));
                }
            }

        }
        return stack.isEmpty();
    }

    boolean way2(String s) {
        int n = s.length();
        if (n % 2 != 0)
            return false;
        Map<Character, Character> pairs = new HashMap<>() {
            {
                put(')', '(');
                put(']', '[');
                put('}', '{');
            }
        };

        Stack<Character> stack = new Stack<>();
        
        for (int i = 0; i < n; i++) {
            char ch = s.charAt(i);
            if (pairs.containsKey(ch)) {
                if (stack.isEmpty()|| pairs.get(ch) != stack.peek()) {
                    return false;
                }else {
                    stack.pop();
                }
            }else {
                stack.push(ch);
            }

        }

        return stack.isEmpty();

    }
}
// @lc code=end
