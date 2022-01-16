/*
 * @lc app=leetcode id=125 lang=java
 *
 * [125] Valid Palindrome
 */

// @lc code=start
class Solution {
    public boolean isPalindrome(String s) {
         return way1(s);
        // return way2(s);
        
    }

    boolean way2(String s) {
        if (s.isBlank() ||s.length() == 0)return true;
        StringBuilder b = new StringBuilder();
        for(int i =0; i < s.length(); i++){
            if(Character.isLetterOrDigit(s.charAt(i))){
                b.append(Character.toLowerCase(s.charAt(i)) );
            }
        }
        if(b.length() == 0)return true;
        StringBuilder rb = new StringBuilder(b).reverse();
        return b.toString().equals(rb.toString()); 
    }

    boolean way1(String s) {
        if (s.isBlank() ||s.length() == 0)return true;
        StringBuilder b = new StringBuilder();
        for(int i =0; i < s.length(); i++){
            if(Character.isLetterOrDigit(s.charAt(i))){
                b.append(Character.toLowerCase(s.charAt(i)) );
            }
        }
        if(b.length() == 0)return true;
        int l=0;
        int  r =b.length() -1;
        while(r > l) {
            if(b.charAt(l) != b.charAt(r)){
                return false;
            }
            l++;
            r--;
        }
        return true;
    }

    boolean isPalindromeHelper(String s,int l,int r) {
        while(r > l) {
            if(s.charAt(l) != s.charAt(r)){
                return false;
            }
            l++;
            r--;
        }
        return true;
    }
}
// @lc code=end

