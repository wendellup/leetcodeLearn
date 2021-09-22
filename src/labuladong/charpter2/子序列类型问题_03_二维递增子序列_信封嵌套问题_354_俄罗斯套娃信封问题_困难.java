package labuladong.charpter2;

import java.util.Arrays;
import java.util.Comparator;

/**
 * 
 * @author wendellup 
 * 参考 
 * https://labuladong.gitee.io/algo/3/25/67/
 */
public class 子序列类型问题_03_二维递增子序列_信封嵌套问题_354_俄罗斯套娃信封问题_困难 {
	
	class Solution0{
		// envelopes = [[w, h], [w, h]...]
				public int maxEnvelopes(int[][] envelopes) {
				    int n = envelopes.length;
				    // 按宽度升序排列，如果宽度一样，则按高度降序排列
				    Arrays.sort(envelopes, new Comparator<int[]>() 
				    {
				        public int compare(int[] a, int[] b) {
				            return a[0] == b[0] ? 
				                b[1] - a[1] : a[0] - b[0];
				        }
				    });
				    // 对高度数组寻找 LIS
				    int[] height = new int[n];
				    for (int i = 0; i < n; i++)
				        height[i] = envelopes[i][1];

				    return lengthOfLIS(height);
				}
				
				/* 返回 nums 中 LIS 的长度 */
				public int lengthOfLIS(int[] nums) {
				    int piles = 0, n = nums.length;
				    int[] top = new int[n];
				    for (int i = 0; i < n; i++) {
				// 要处理的扑克牌
				int poker = nums[i];
				int left = 0, right = piles;
				// 二分查找插入位置
				while (left < right) {
				            int mid = (left + right) / 2;
				            if (top[mid] >= poker)
				                right = mid;
				            else
				                left = mid + 1;
				        }
				        if (left == piles) piles++;
				        // 把这张牌放到牌堆顶
				        top[left] = poker;
				    }
				    // 牌堆数就是 LIS 长度
				    return piles;
				}
	}
	
}



