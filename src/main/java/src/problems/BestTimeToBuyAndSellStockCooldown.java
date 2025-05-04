package src.problems;

public class BestTimeToBuyAndSellStockCooldown {
    public static void main(String[] args) {

    }

    // Time Complexity: O(N) where N is the length of the input price list.
    //
    //We have one loop over the input list, and the operation within one iteration takes constant time.
    //Space Complexity: O(1), constant memory is used regardless the size of the input.
    public static int maxProfit(int[] prices) {
        int sold = Integer.MIN_VALUE;
        int held = Integer.MIN_VALUE;
        int reset = 0;

        for (int price: prices) {
            int preSold = sold;

            sold = held + price;
            held = Math.max(reset - price, held);
            reset = Math.max(reset, preSold);
        }

        return Math.max(sold, reset);
    }
}
