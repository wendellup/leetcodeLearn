package labuladong.charpter2;

/**
 * 
 * @author wendellup 参考https://labuladong.gitee.io/algo/3/24/60/
 */
public class _509_斐波那契数_简单_动态规划接替核心框架 {
	int fib(int n) {
		if (n < 1)
			return 0;
		if (n == 2 || n == 1)
			return 1;
		int prev = 1, curr = 1;
		for (int i = 3; i <= n; i++) {
			int sum = prev + curr;
			prev = curr;
			curr = sum;
		}
		return curr;
	}
	
	public int fib2(int n) {
	    if (n == 0) return 0;
	    int[] dp = new int[n + 1];
	    // base case
	    dp[0] = 0; dp[1] = 1;
	    // 状态转移
	    for (int i = 2; i <= n; i++) {
	        dp[i] = dp[i - 1] + dp[i - 2];
	    }

	    return dp[n];
	}
}
