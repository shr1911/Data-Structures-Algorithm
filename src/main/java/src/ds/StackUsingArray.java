package src.ds;

//Problem - stack overflow because array can become full. So either use dynamic array or linked list based implementation
public class StackUsingArray {

    public static final int MAX_SIZE = 101;
    int[] A = new int[MAX_SIZE];
    int top = -1;

    public static void main(String[] args) {
        StackUsingArray stack = new StackUsingArray();
        stack.push(2);stack.print();
        stack.push(5); stack.print();
        stack.push(10); stack.print();
        stack.pop();stack.print();
        stack.push(12); stack.print();
        System.out.println(stack.top());
        System.out.println(stack.isEmpty());
        stack.pop();stack.print();
        stack.pop();stack.print();
        stack.pop();stack.print();
        System.out.println(stack.isEmpty());

    }

    private void print() {
        for (int i = 0; i <= top; i++) {
            System.out.print(A[i] + " ");
        }
        System.out.println();
    }

    private boolean isEmpty() {
        if(top == -1){
            return true;
        }
        return false;
    }

    private int top() {
        return A[top];
    }

    private void pop() {
        if (top == -1) {
            System.out.println("Error: No element to pop");
            return;
        }
        top--;
    }



    public void push(int data) {
        if (top == MAX_SIZE - 1){
            System.out.println("Error: Stack Overflow");
            return;
        }
        A[++top] = data;
    }
}
