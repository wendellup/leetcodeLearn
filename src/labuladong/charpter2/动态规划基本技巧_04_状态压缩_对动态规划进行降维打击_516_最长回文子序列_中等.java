package labuladong.charpter2;

/**
 * 
 * @author wendellup 参考https://labuladong.gitee.io/algo/3/24/63/
 */
public class 动态规划基本技巧_04_状态压缩_对动态规划进行降维打击_516_最长回文子序列_中等 {
		
	int longestPalindromeSubseq(String s) {
	    int n = s.length();
	    // dp 数组全部初始化为 0
	    int[] dp = new int[n];

	    // base case
	    for (int i = 0; i < n; i++)
	        dp[i] = 1;
	    // 反着遍历保证正确的状态转移
	    for (int i = n - 2; i >= 0; i--) {
	    	int pre = 0;
	        for (int j = i + 1; j < n; j++) {
	        	int temp = dp[j];
	            // 状态转移方程
	            if (s.charAt(i) == s.charAt(j))
	               	dp[j] = pre+2;
	            else
	            	dp[j] = Math.max(dp[j], dp[j - 1]);
	            pre = temp;
	        }
	    }
	    // 整个 s 的最长回文子串长度
	    return dp[n - 1];
	}
}
