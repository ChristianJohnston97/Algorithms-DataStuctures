public class Fibonacci
{

	public static void main(String[] args)
	{
		int value = 3;
		int[] memoisation = new int[value+1];
		int result = fibonacci(3, memoisation);
		System.out.println(result);
	}

// Recursive fibonacci with memoisation
	public static int fibonacci(int n, int[] memoisation)
	{
		if(n == 0) return 0;
		if(n == 1) return 1;

		if(memoisation[n] == 0)
		{
			memoisation[n] = fibonacci(n-1, memoisation) + fibonacci(n-2, memoisation);
		}
		return memoisation[n];
	}

// Iterative fibonacci 
	public static int fibonacci2(int n)
	{
		if(n == 0) return 0;
		if(n == 1) return 1;

		int fib = 1;
		int prevFib = 1;

		for(int i=2; i<n; i++)
		{
			int temp = fib;
			temp += prevFib;
			prevFib = temp;
		}
		return fib;
	}

}
