

/*
 * @lc app=leetcode id=7 lang=java
 *
 * [7] Reverse Integer
 */

// @lc code=start

//num limit need to consider;
class Solution {
    public int reverse(int x) {
        return way2(x);

    }

    int way2(int x) {
        int a = Math.abs(x);
        long ans = 0;
        while (a != 0) {
            ans = ans * 10 + a % 10;
            a = a / 10;
        }
        if (x < 0)
            ans *= -1;
        if (ans < Integer.MIN_VALUE || ans > Integer.MAX_VALUE)
            return 0;
        return (int) ans;
    }

    int way1(int x) {
        if (x == 0)
            return 0;
        // int min = -(1<<31);
        // int max = (1<<31)-1;
        if (x < Integer.MIN_VALUE || x > Integer.MAX_VALUE)
            return 0;
        char[] s = Integer.toString(x).toCharArray();
        reverseString(s);
        long ans = Long.valueOf(String.valueOf(s));
        if (ans < Integer.MIN_VALUE || ans > Integer.MAX_VALUE)
            return 0;
        return (int) ans;
    }

    void reverseString(char[] s) {
        int l = s[0] == '-' ? 1 : 0;
        int r = s.length - 1;
        char t = ' ';
        while (r > l) {
            t = s[l];
            s[l] = s[r];
            s[r] = t;
            l++;
            r--;
        }

    }
}
// @lc code=end
