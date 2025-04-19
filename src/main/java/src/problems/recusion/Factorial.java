package src.problems.recusion;

public class Factorial {
    public static void main(String[] args) {
        System.out.println(factorial(3));
    }

    // time complexity - O(n)
    // space complexity - O(n)
    public static int factorial(int n) {
        if (n == 0)
            return 1;
        else
            return n * factorial(n-1);

    }
}
