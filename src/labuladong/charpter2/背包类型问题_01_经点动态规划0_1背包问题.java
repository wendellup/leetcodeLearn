package labuladong.charpter2;

/**
 * 
 * @author wendellup 
 * 参考 
 * https://labuladong.gitee.io/algo/3/27/76/
 */
public class 背包类型问题_01_经点动态规划0_1背包问题 {
	int knapsack(int W, int N, int[] wt, int[] val) {
	    // base case 已初始化
		int[][] dp =new int[N+1][W+1];
	    for (int i = 1; i <= N; i++) {
	        for (int w = 1; w <= W; w++) {
	            if (w - wt[i-1] < 0) {
	                // 这种情况下只能选择不装入背包
	                dp[i][w] = dp[i - 1][w];
	            } else {
	                // 装入或者不装入背包，择优
	                dp[i][w] = Math.max(dp[i - 1][w - wt[i-1]] + val[i-1], 
	                               dp[i - 1][w]);
	            }
	        }
	    }
	    
	    return dp[N][W];
	}
}

