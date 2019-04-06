import java.util.*;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class P013 {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		List<Long> lines = getData(in);
		System.out.println(getSum(lines));
	}

	static long getSum(List<Long> nums) {
		return nums.stream().mapToLong(i -> i.longValue()).sum();
	}

	static List<Long> getData(Scanner in) {
		List<Long> list = new ArrayList<>();
		String fileName = "data.txt";
		try (Stream<String> stream = Files.lines(Paths.get(fileName))) {
			list = stream
					.map(str -> str.substring(0, 12))
					.map(Long::valueOf)
					.collect(Collectors.toList());

		} catch (IOException e) {
			e.printStackTrace();
		}
		return list;
	}
}