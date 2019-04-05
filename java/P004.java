import java.util.stream.*;
import java.util.*;

public class P004 {
	public static void main(String[] args) {

		System.out.println(isPalindromic(304) == false);
		System.out.println(isPalindromic(900009) == true);

		System.out.println(solution());
	}

	public static int solution() {
		int res = 1;
		List<Integer> rangeList = 
			IntStream.range(111, 999).boxed().collect(Collectors.toList());

		for (int i : rangeList) {
			for (int j : rangeList) {
				int prod = i * j;
				if (res < prod && isPalindromic(prod)) {
					res = prod;
				}
			}
		}
		return res;
	}

	public static boolean isPalindromic(int n) {
		StringBuilder sb = new StringBuilder(String.valueOf(n));
		return sb.toString().equals(sb.reverse().toString());
	}
}