package labuladong.charpter2;

import java.util.HashMap;

/**
 * 
 * @author wendellup 参考https://labuladong.gitee.io/algo/3/24/64/
 */
public class 动态规划基本技巧_05_动态规划和回溯算法到底谁是谁爹_494_目标和_中等 {

	class Solution0 {
		int result = 0;

		/* 主函数 */
		int findTargetSumWays(int[] nums, int target) {
			if (nums.length == 0)
				return 0;
			backtrack(nums, 0, target);
			return result;
		}

		/* 回溯算法模板 */
		void backtrack(int[] nums, int i, int rest) {
			// base case
			if (i == nums.length) {
				if (rest == 0) {
					// 说明恰好凑出 target
					result++;
				}
				return;
			}
			// 给 nums[i] 选择 - 号
			rest += nums[i];
			// 穷举 nums[i + 1]
			backtrack(nums, i + 1, rest);
			// 撤销选择
			rest -= nums[i];

			// 给 nums[i] 选择 + 号
			rest -= nums[i];
			// 穷举 nums[i + 1]
			backtrack(nums, i + 1, rest);
			// 撤销选择
			rest += nums[i];
		}
	}

	class Solution1 {

		int findTargetSumWays(int[] nums, int target) {
			if (nums.length == 0)
				return 0;
			return dp(nums, 0, target);
		}

		// 备忘录
		HashMap<String, Integer> memo = new HashMap<>();

		int dp(int[] nums, int i, int rest) {
			// base case
			if (i == nums.length) {
				if (rest == 0)
					return 1;
				return 0;
			}
			// 把它俩转成字符串才能作为哈希表的键
			String key = i + "," + rest;
			// 避免重复计算
			if (memo.containsKey(key)) {
				return memo.get(key);
			}
			// 还是穷举
			int result = dp(nums, i + 1, rest - nums[i]) + dp(nums, i + 1, rest + nums[i]);
			// 记入备忘录
			memo.put(key, result);
			return result;
		}
	}

	class Solution2 {

		int findTargetSumWays(int[] nums, int target) {
			int sum = 0;
			for (int n : nums)
				sum += n;
			// 这两种情况，不可能存在合法的子集划分
			if (sum < target || (sum + target) % 2 == 1) {
				return 0;
			}
			return subsets(nums, (sum + target) / 2);
		}

		/* 计算 nums 中有几个子集的和为 sum */
		int subsets(int[] nums, int sum) {
            if(sum<0){
                return 0;
            }
			int n = nums.length;
			int[][] dp = new int[n + 1][sum + 1];
			// base case
			for (int i = 0; i <= n; i++) {
				dp[i][0] = 1;
			}

			for (int i = 1; i <= n; i++) {
				for (int j = 0; j <= sum; j++) {
					if (j >= nums[i - 1]) {
						// 两种选择的结果之和
						dp[i][j] = dp[i - 1][j] + dp[i - 1][j - nums[i - 1]];
					} else {
						// 背包的空间不足，只能选择不装物品 i
						dp[i][j] = dp[i - 1][j];
					}
				}
			}
			return dp[n][sum];
		}

	}

}
