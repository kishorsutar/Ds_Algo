class GCDP {
	public static void main(String[] args) {
		System.out.println(gcd(78, 66));
	}

	static int gcd(int a, int b) {
		// find gcd of a and b

		// according to euclides algorithm
		// gcd(a,b) = gcd(b, a%b);

		if(b == 0) {
			return a;
		}

		return gcd(b, a % b);

		
	}
}