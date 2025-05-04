package src.javaconcepts;

import java.util.Scanner;

public class InputCommadLineDemo {
    public static void main(String[] args) {
        System.out.println("Please enter the number you want to take as input ? ");
        Scanner scannerInput = new Scanner(System.in);
        String str = scannerInput.nextLine();

        System.out.println("The value you gave was: " + str);
    }
}
