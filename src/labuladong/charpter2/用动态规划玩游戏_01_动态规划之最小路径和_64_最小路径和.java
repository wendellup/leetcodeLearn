package labuladong.charpter2;

import java.util.Arrays;

/**
 * 
 * @author wendellup 
 * 参考 
 * https://labuladong.github.io/algo/3/26/84/
 */
public class 用动态规划玩游戏_01_动态规划之最小路径和_64_最小路径和 {


	class Solution0 {
		int minPathSum(int[][] grid) {
		    int m = grid.length;
		    int n = grid[0].length;
		    // 计算从左上角走到右下角的最小路径和
		    return dp(grid, m - 1, n - 1);
		}
		
		int dp(int[][] grid, int i, int j) {
		    // base case
		    if (i == 0 && j == 0) {
		        return grid[0][0];
		    }
		    // 如果索引出界，返回一个很大的值，
		    // 保证在取 min 的时候不会被取到
		    if (i < 0 || j < 0) {
		        return Integer.MAX_VALUE;
		    }

		    // 左边和上面的最小路径和加上 grid[i][j]
		    // 就是到达 (i, j) 的最小路径和
		    return Math.min(
		            dp(grid, i - 1, j), 
		            dp(grid, i, j - 1)
		        ) + grid[i][j];
		}
	}
	
	class Solution1 {
		int[][] memo;
		
		int minPathSum(int[][] grid) {
		    int m = grid.length;
		    int n = grid[0].length;
		    // 构造备忘录，初始值全部设为 -1
		    memo = new int[m][n];
		    for (int[] row : memo)
		        Arrays.fill(row, -1);
		    
		    return dp(grid, m - 1, n - 1);
		}

		int dp(int[][] grid, int i, int j) {
		    // base case
		    if (i == 0 && j == 0) {
		        return grid[0][0];
		    }
		    if (i < 0 || j < 0) {
		        return Integer.MAX_VALUE;
		    }
		    // 避免重复计算
		    if (memo[i][j] != -1) {
		        return memo[i][j];
		    }
		    // 将计算结果记入备忘录
		    memo[i][j] = Math.min(
		        dp(grid, i - 1, j),
		        dp(grid, i, j - 1)
		    ) + grid[i][j];

		    return memo[i][j];
		}	
	}
	
	class Solution2 {
		int[][] memo;
		
		int minPathSum(int[][] grid) {
		    int m = grid.length;
		    int n = grid[0].length;
		    // 构造备忘录，初始值全部设为 -1
		    memo = new int[m][n];
		    for (int[] row : memo)
		        Arrays.fill(row, -1);
		    
		    return dp(grid, m - 1, n - 1);
		}

		int dp(int[][] grid, int i, int j) {
		    // base case
		    if (i == 0 && j == 0) {
		        return grid[0][0];
		    }
		    if (i < 0 || j < 0) {
		        return Integer.MAX_VALUE;
		    }
		    // 避免重复计算
		    if (memo[i][j] != -1) {
		        return memo[i][j];
		    }
		    // 将计算结果记入备忘录
		    memo[i][j] = Math.min(
		        dp(grid, i - 1, j),
		        dp(grid, i, j - 1)
		    ) + grid[i][j];

		    return memo[i][j];
		}	
	}
}

