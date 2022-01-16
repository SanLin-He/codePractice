import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/*
 * @lc app=leetcode id=242 lang=java
 *
 * [242] Valid Anagram
 */

// @lc code=start
class Solution {
    public boolean isAnagram(String s, String t) {

        // return way2(s,t);
        return way3(s,t);


        
    }

    //sort
    boolean way3 (String s, String t) {
        if(s.length() != t.length()) return false;
        char[] sStr = s.toCharArray();
        char[] tStr = t.toCharArray();
        Arrays.sort(sStr);
        Arrays.sort(tStr);
        return Arrays.equals(sStr, tStr);
    }

    //only work lowcase；
    boolean way2 (String s, String t) {
        if(s.length() != t.length()) return false;
        int[] charFrequence = new int[26];
        for(int i = 0; i< s.length(); i++){
            charFrequence[s.charAt(i)-'a']++;
        }
        for(int i=0;i<t.length();i++) {
            charFrequence[t.charAt(i)-'a']--;
            if(charFrequence[t.charAt(i)-'a'] < 0)return false;
        }

        // for(int i =0; i<26;i++){
        //     if(charFrequence[i] != 0)return false;
        // }
    
        return true;
    }

    //only work if t and s 自身亦或不为0； XXXXXXXXXXX
    boolean way1 (String s, String t) {
        if(s.length() != t.length()) return false;
        Set<Character> sSet = new HashSet<>();
        Set<Character> tSet = new HashSet<>();
        for (int i = 0; i < s.length(); i++){
            sSet.add(s.charAt(i));
            tSet.add(t.charAt(i));
        }
        if(sSet.size() != tSet.size()) return false;

        int ans = 0;
        Iterator<Character> sIterator = sSet.iterator();
        Iterator<Character> tIterator = tSet.iterator();

        for(int i = 0; i < sSet.size(); i++) {
            ans ^= sIterator.next()^tIterator.next();
        }

        if (ans == 0) return true;
        return false;
    }
}
// @lc code=end

