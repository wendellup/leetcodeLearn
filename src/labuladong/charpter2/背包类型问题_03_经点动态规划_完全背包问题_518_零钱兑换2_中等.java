package labuladong.charpter2;

/**
 * 
 * @author wendellup 
 * 参考 
 * https://labuladong.gitee.io/algo/3/26/77/
 */
public class 背包类型问题_03_经点动态规划_完全背包问题_518_零钱兑换2_中等 {


	class Solution0 {
		int change(int amount, int[] coins) {
		    int n = coins.length;
		    int[][] dp = new int[n + 1][amount + 1];
		    // base case
		    for (int i = 0; i <= n; i++) 
		        dp[i][0] = 1;

		    for (int i = 1; i <= n; i++) {
		        for (int j = 1; j <= amount; j++)
		            if (j - coins[i-1] >= 0)
		                dp[i][j] = dp[i - 1][j] 
		                         + dp[i][j - coins[i-1]];
		            else 
		                dp[i][j] = dp[i - 1][j];
		    }
		    return dp[n][amount];
		}
	}
}

