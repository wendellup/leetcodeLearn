package labuladong.charpter2;

import java.util.Arrays;
import java.util.Comparator;

/**
 * 
 * @author wendellup 
 * 参考 
 * https://labuladong.gitee.io/algo/3/27/79/
 */
public class 贪心类型问题_01_贪心算法之区间调度问题_435_无重叠区间_中等_452_用最少数量的箭引爆气球_中等 {


	class Solution435 {
		public int eraseOverlapIntervals(int[][] intervals) {
			int n = intervals.length;
		    return n - intervalSchedule(intervals);
	    }
		
		public int intervalSchedule(int[][] intvs) {
		    if (intvs.length == 0) return 0;
		    // 按 end 升序排序
		    Arrays.sort(intvs, new Comparator<int[]>() {
		        public int compare(int[] a, int[] b) {
		            return a[1] - b[1];
		        }
		    });
		    // 至少有一个区间不相交
		    int count = 1;
		    // 排序后，第一个区间就是 x
		    int x_end = intvs[0][1];
		    for (int[] interval : intvs) {
		        int start = interval[0];
		        if (start >= x_end) {
		            // 找到下一个选择的区间了
		            count++;
		            x_end = interval[1];
		        }
		    }
		    return count;
		}
	}
	
	class Solution452 {
		int findMinArrowShots(int[][] intvs) {
			if (intvs.length == 0)
				return 0;
			// 按 end 升序排序
			Arrays.sort(intvs, new Comparator<int[]>() {
				public int compare(int[] a, int[] b) {
					return Integer.compare(a[1], b[1]);
				}
			});
			// 至少有一个区间不相交
			int count = 1;
			// 排序后，第一个区间就是 x
			int x_end = intvs[0][1];

			for (int[] interval : intvs) {
				int start = interval[0];
				// 把 >= 改成 > 就行了
				if (start > x_end) {
					count++;
					x_end = interval[1];
				}
			}
			return count;
		}
	}
}

