import java.util.*;
import java.util.stream.*;

class P023 {
	public static void main(String[] args) {
		int res = 0;
		int limit = 28123;
		
		System.out.println(getNonAbundantableSum(limit));
	}

	static int getAbundantableSum(int limit, IntStream stream) {
		return 	stream.
				filter(n -> n < limit).
				distinct().
				sum();
	}

	static int getNonAbundantableSum(int limit) {
		return (limit * (limit - 1) / 2) -
				getAbundantableSum(
				limit,
				getAbundantCardesianSumList(
					getAbundantArray(limit)
					)
				);
	}

	static IntStream getAbundantCardesianSumList(
		IntStream stream
		) {
		List<Integer> intermedia = stream.boxed().collect(
			Collectors.toList());
		return intermedia.
			stream().
			mapToInt(Integer::valueOf).
			flatMap(
			a -> intermedia.
			stream().
			mapToInt(b -> a + b)
			);
	}

	static private boolean isAbundantNumber(int num) {
		return num < sumOfProperDivisors(num);
	}

	static private IntStream getAbundantArray(int limit) {
		return IntStream.range(0, limit).filter(num ->isAbundantNumber(num));
	}

	static private int sumOfProperDivisors(int n) {
		int res = n > 1 ? 1 : 0;
		for (int i = 2; i <= Math.sqrt(n); ++i) {
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