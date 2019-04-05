class P006 {
	public static void main(String[] args) {
		int tmp = sumOfRange(100);
		System.out.println(tmp * tmp - sumOfSquares(100));
	}

	public static int sumOfSquares(int n) {
		return n * (n + 1) * (2 * n + 1) / 6;
	}

	public static int sumOfRange(int n) {
		return n * (n + 1) / 2;
	}
}