class P015 {
	public static void main(String[] args) {
		System.out.println(combinations(40, 20));
	}


	static long combinations(int n, int k) {
		//nCk
		long res = 1;
		for (int i = 1; i <= k; ++i) {
			res = res * (n + 1 - i) / i;
		}
		return res;
	} 
}