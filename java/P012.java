import java.util.*;

public class P012 {
	public static void main(String[] args) {
		int max = 1;
		for (int i = 1; i < 15000; ++i) {
			int triValue = i * (i + 1) / 2;
			max = Math.max(countDivisors(triValue), max);
			if (max > 500) {
				System.out.println(triValue);
				break;
			}
		}
		System.out.println(max);
	}

	private static int countDivisors(int n) {
		int res = 0;
		for (int i = 1; i < Math.ceil(Math.sqrt(n) + 1); ++i) {
			if (0 != (n % i)) {
				continue;
			}
			if (i * i == n) {
				return res + 1;
			} else {
				res += 2;
			}
		}
		return res;
	}
}