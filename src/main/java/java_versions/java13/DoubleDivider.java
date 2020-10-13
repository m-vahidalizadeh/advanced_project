package java_versions.java13;

import java.util.Scanner;

public class DoubleDivider {

    public static void main(String[] args) {
        var scanner = new Scanner(System.in);
        System.out.print("Enter the first number: ");
        double num1 = scanner.nextDouble();
        System.out.print("Enter the second number: ");
        double num2 = scanner.nextDouble();
        System.out.println("The answer is " + (num1 / num2));
    }

}
