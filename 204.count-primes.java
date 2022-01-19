import java.util.Arrays;

/*
 * @lc app=leetcode id=204 lang=java
 *
 * [204] Count Primes
 */

// @lc code=start
class Solution {
    public int countPrimes(int n) {

        return way1(n);
    }

    // 埃塞法
    int way1(int n) {
        if (n == 1 || n == 0)
            return 0;
        int[] primes = new int[n];
        Arrays.fill(primes, 1);
        int count = 0;
        for (int i = 2; i < n; i++) {
            if (primes[i] == 1) {
                count++;
                if ((long) i * i < n)
                    for (int j = i * i; j < n; j += i) {
                        primes[j] = 0;
                    }
            }
        }

        return count;
    }
}
// @lc code=end
