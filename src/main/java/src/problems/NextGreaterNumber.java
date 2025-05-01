package src.problems;

public class NextGreaterNumber {
    public static void main(String[] args) {
        System.out.println(nextGreaterElement(121));
    }

    public static int nextGreaterElement(int n) {
        char[] strN = ("" + n).toCharArray();

        int i = strN.length - 2;

        while (i >= 0 && strN[i + 1] <= strN[i]) {
            i--;
        }

        if (i < 0) return -1;

        int j = strN.length - 1;
        while (j >= 0 && strN[j] <= strN[i]) {
            j--;
        }

        swap(strN, i, j);
        reverse(strN, i + 1);

        try {
            return Integer.parseInt(strN.toString());
        } catch (Exception e) {
            return -1;
        }
    }

    private static void reverse(char[] strN, int start) {
        int i = start;
        int j = strN.length - 1;

        while (i < j) {
            swap(strN, i, j);
            i++;
            j--;
        }
    }

    private static void swap(char[] strN, int i, int j) {
        char temp = strN[i];
        strN[i] = strN[j];
        strN[j] = temp;
    }
}
