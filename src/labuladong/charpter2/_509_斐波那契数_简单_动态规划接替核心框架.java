package labuladong.charpter2;

/**
 * 
 * @author wendellup 参考https://labuladong.gitee.io/algo/3/24/60/
 */
public class _509_斐波那契数_简单 {
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
}
