package src.problems.recusion;

public class PowXN {
    public static void main(String[] args) {
        System.out.println(powRecursion(2, 4));
    }

    // Time complexity - In better case - O(log(n)), Worst Case - O(n)
    // space complexity - In better case - O(log(n)), Worst Case - O(n)
    private static int powRecursionBetter(int x, int n) {
        if (n == 0) return 1;

        else if (n % 2 == 0) {
            int y = powRecursionBetter(x, n/2);
            return y * y;
        } else {
            return x * powRecursionBetter(x, n-1);

        }
    }

    // Time complexity - O(n)
    // space complexity - O(n)
    private static int powRecursion(int x, int n) {
        if (n == 0) return 1;

        return x * powRecursion(x, n-1);
    }
}
