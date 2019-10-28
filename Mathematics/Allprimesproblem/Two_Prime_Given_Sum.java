class Solution 
{ 
	static boolean SieveOfEratosthenes(int n, boolean isPrime[]) 
	{ 
		isPrime[0] = isPrime[1] = false; 
		for (int i = 2; i <= n; i++) 
			isPrime[i] = true; 
	
		for (int p = 2; p * p <= n; p++) 
		{ 
			if (isPrime[p] == true) 
			{ 
				for (int i = p * p; i <= n; i += p) 
					isPrime[i] = false; 
			} 
		} 
		return false; 
	} 
	
	static void findPrimePair(int n) 
	{ 
		boolean isPrime[]=new boolean[n + 1]; 
		SieveOfEratosthenes(n, isPrime); 
	
		for (int i = 0; i < n; i++) 
		{ 
			if (isPrime[i] && isPrime[n - i]) 
			{ 
				System.out.print(i + " " + (n - i)); 
				return; 
			} 
		} 
	} 
	
	public static void main (String[] args) 
	{ 
		int n = 74; 
		findPrimePair(n); 
	} 
} 
