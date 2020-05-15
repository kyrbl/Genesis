package lesso1;

import java.util.Scanner;

public class ScannerTest {
    public static void main(String[] args){

        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter your project name");

        String s = scanner.nextLine();

        System.out.println("Your project name is:"+s+"!");
    }
}

