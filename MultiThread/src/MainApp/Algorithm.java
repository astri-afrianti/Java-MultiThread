package MainApp;

public class Algorithm {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(Fibonacci(5));
	}
	
	static int Fibonacci(int n) {
		if(n <= 1) {
			return n;
		} else {
			return Fibonacci(n - 1) + Fibonacci(n - 2);
		}
	}

}
