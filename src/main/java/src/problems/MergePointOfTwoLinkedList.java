package src.problems;

public class MergePointOfTwoLinkedList {
    public static void main(String[] args) {
        DataNode commonList = new DataNode(7, new DataNode(1, null));

        //Length = 4
        DataNode head1 = new DataNode(2, new DataNode(6, commonList));

        //Length = 5
        DataNode head2 = new DataNode(9, new DataNode(3, new DataNode(5, commonList)));



    }

    // Time complexity - O(m+n)
    // Space complexity = O(1)
    public static DataNode findMergePointOptimized(DataNode head1, DataNode head2) {
        int m = findLength(head1);
        int n = findLength(head2);

        int d = n - m;
        if (m > n) {
            DataNode temp = head1;
            head1 = head2;
            head2 = temp;
            d = m - n;
        }

        // walk through d nodes of longer list, i.e. B
        for (int i=0; i<d; i++) {
            head2 = head2.next;
        }

        while (head1 != null && head2 != null) {
            if (head1 == head2)
                return head1;
            head1 = head1.next;
            head2 = head2.next;
        }

        return null;
    }
;
    // Time complexity - O(m*n)
    // Apraoch 2 - store element of 1 list in arraylist, and then iterate over them.
    // Time complexity - O(m + n)
    public static DataNode findMergePointBruteForce(DataNode head1, DataNode head2) {
        int m = findLength(head1);
        int n = findLength(head2);

        DataNode head2Temp = head2;

        for (int i=0; i<m; i++) {
            for (int j=0; j<n; j++) {
                if (head1 == head2) return head1;
                head2 = head2.next;
            }
            head1 = head1.next;
        }

        return null;
    }

    private static int findLength(DataNode head1) {
        int len = 0;
        DataNode temp = head1;

        while (temp != null) {
            len++;
            temp = temp.next;
        }
        return len;
    }


}

class DataNode {
    int data;
    DataNode next;

    public DataNode(int data, DataNode next) {
        this.data = data;
        this.next = next;
    }

    public int getData() {
        return data;
    }

    public void setData(int data) {
        this.data = data;
    }
}
