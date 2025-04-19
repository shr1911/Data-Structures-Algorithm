package src.problems.recusion;

public class ModularExponentiation {
    public static void main(String[] args) {
        System.out.println(modularExponentiation(5, 2, 7));
    }

    // problem. power here will not fit into integer
    // Equivalent expressions for = (x^n) % mod
    // Time Complexity - In better case - O(log(n)), Worst Case - O(n)
    // Space Complexity - In better case - O(log(n)), Worst Case - O(n)
    private static int modularExponentiation(int x, int n, int mod) {
        if (n == 0) return 1;

        else if (n % 2 == 0) {
            int y = modularExponentiation(x, n/2, mod);
            return (y * y) % mod;
        } else {
            return ((x % mod) * modularExponentiation(x, n-1, mod)) % mod;
        }
    }
}
