package labuladong.charpter2;

import java.util.Arrays;

public class _931_下降路径最小和_中等_BASE_CASE和备忘录的初始值怎么定 {

}

class Solution {
    public static int[][] dp;
    
//    public static int Min(int a,int b){
//        return a < b ? a : b;
//    }
    
    int min(int a, int b) {
		return Math.min(a, b);
	}
    
    public int minFallingPathSum(int[][] A) {
        int len = A[0].length;
        if(len == 1) return A[0][0];
        dp = new int[len][len];
        for(int i = 0;i < len;i++){
            dp[0][i] = A[0][i];
        }
        for(int i = 1;i < len;i++){
            for(int j = 0;j < len;j++){
                if(j == 0){
                    dp[i][j] = A[i][j] + min(dp[i-1][j],dp[i-1][j+1]);
                }else{
                    if(j == len-1){
                        dp[i][j] = A[i][j] + min(dp[i-1][j],dp[i-1][j-1]);
                    }else{
                        dp[i][j] = A[i][j] + min(min(dp[i-1][j],dp[i-1][j+1]),dp[i-1][j-1]);
                    }
                }
            }
        }
        int ans = 20000;
        for(int i = 0;i < len;i++){
            ans = min(ans,dp[len-1][i]);
        }
        return ans;
    }
}

class Solution2 {
	int[][] memo;
	
	boolean[][] memoFlag;
	public int minFallingPathSum(int[][] matrix) {
		int n = matrix.length;
		int res = Integer.MAX_VALUE;

		// 备忘录里的值初始化为 66666
	    memo = new int[n][n];
	    for (int i = 0; i < n; i++) {
	        Arrays.fill(memo[i], 10001);
	    }
		// 终点可能在最后一行的任意一列
		for (int j = 0; j < n; j++) {
			res = Math.min(res, dp(matrix, n - 1, j, n));
		}

		return res;
	}

	int dp(int[][] matrix, int i, int j, int n) {
		// 非法索引检查
		if (i < 0 || j < 0 || i >= matrix.length || j >= matrix[0].length) {
			// 返回一个特殊值
			return 20000;
		}
		// base case
		if (i == 0) {
//			memo[i][j] = matrix[i][j];
			return matrix[i][j];
		}
		// 3、查找备忘录，防止重复计算
	    if (memo[i][j] != 10001) {
	        return memo[i][j];
	    }
		// 状态转移
	    int ret = 0;
		ret = matrix[i][j] + min(dp(matrix, i - 1, j,n), dp(matrix, i - 1, j - 1,n), dp(matrix, i - 1, j + 1,n));
	    
//                if(j == 0){
//                    ret = matrix[i][j] + min(dp(matrix, i-1, j,n),dp(matrix, i-1, j+1,n));
//                    
//                }else{
//                    if(j == n-1){
//                        ret =  matrix[i][j] + min(dp(matrix, i-1, j,n),dp(matrix, i-1, j-1,n));
//                    }else{
//                        ret = matrix[i][j] + min(dp(matrix, i - 1, j,n), dp(matrix, i - 1, j - 1,n), dp(matrix, i - 1, j + 1,n));
//                    }
//                }
	    
         memo[i][j] = ret;
         return ret;
	}

	int min(int a, int b, int c) {
		return Math.min(a, Math.min(b, c));
	}
	
	 int min(int a, int b) {
			return Math.min(a, b);
		}
}