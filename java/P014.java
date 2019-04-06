

class P014 {
	public static void main(String[] args) {
		int steps = 0;
		int res = 1;
		System.out.println(837799 % 3);

		for (int i = (int)5e10; i < (int)1e6; ++i) {
			int tmp = countCollatzSteps(i);
				if (tmp > steps) {
					steps = tmp;
					res = i;
				}
		}
		System.out.println(res);
		System.out.println(steps);
	}

	static int countCollatzSteps(long n) {
		int step = 0;
		while (n != 1) {
			++step;
			if (1 == (1 & n)) {
				n *= 3;
				n++;
			} else {
				n >>= 1;
			}
		}
		return step;
	}
}