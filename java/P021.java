import java.util.*;
import java.util.stream.*;

class P021 {
	public static void main(String[] args) {
		int res = 0;
		int limit = 10000;
		List<Integer> sumArray = getDivisorsSumArray(limit);
		System.out.println(getAmicableSum(sumArray));
	}

	static int getAmicableSum(List<Integer> arr) {
		int res = IntStream.
				range(0, arr.size()).
				map(idx ->
					isAmicalNumber(idx, arr) ?
				 	idx : 0).
					sum();
		return res;
	}

	static private boolean isAmicalNumber(
		int idx, 
		List<Integer> divisorsSumArray
		) {
		int pair = divisorsSumArray.get(idx);
		return pair < divisorsSumArray.size() && pair != idx && divisorsSumArray.get(pair) == idx;

	}

	static private List<Integer> getDivisorsSumArray(int limit) {
		return IntStream.range(0, limit).map(num -> sumOfProperDivisors(num)).boxed().collect(Collectors.toList());
	}

	static private int sumOfProperDivisors(int n) {
		int res = n > 1 ? 1 : 0;
		for (int i = 2; i < Math.sqrt(n); ++i) {
			if (0 == (n % i)) {
				res += (i + n / i);
			}
			if (n == i * i) {
				res -= i;
			}
		}
		return res;
	}
}