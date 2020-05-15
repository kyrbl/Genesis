package Java_HT_2;

import java.util.Scanner;

public class HT_2 {
    static final Scanner in = new Scanner(System.in);

    public static void main(String[] args){
        while (true){

            System.out.println("What do u want to do? \ntask 1[1]; task 2[2]; task 3[3]; task 4[4]; task 5[5]; task 6[6]; task 7[7]; exit[8]");

            int check = in.nextInt();

            switch (check){
                case 1:
                    task_1();
                    break;
                case 2:
                    task_2();
                    break;
                case 3:
                    task_3();
                    break;
                case 4:
                    task_4();
                    break;
                case 5:
                    task_5();
                    break;
                case 6:
                    task_6();
                    break;
                case 7:
                    task_7();
                    break;
                case 8:
                    return;
                default:
                    System.out.println("Err in input! You must enter one of these numbers: 1, 2, 3, 4, 5, 6, 7, 8!");
            }

        }

    }

    static void task_1(){

        System.out.println("Enter a flat number");
        int flat = in.nextInt();

        int house = flat / 100;
        int floor = flat % 100 / 4 + 1;

        if ((house < 5) && (house > 0) && (floor < 10) && (floor > 0)){
            System.out.println("Flat is in house number " + house + "\nFloor number is " + floor);
        } else {
            System.out.println("Flat is not in these houses");
        }
    }

    static void task_2(){
        System.out.println("Enter the amount of rows");
        int rows = in.nextInt();
        System.out.println("Enter the amount of columns");
        int cols = in.nextInt();

        for (int i = 0; i < rows; i++){
            for (int j = 0; j < cols; j++){
                System.out.print( ((j % 2) == 0)?"***":"+++" );
            }
            System.out.print("\n");
        }
    }

    static void task_3(){
        boolean check;
        int num;
        int fact = 1;

        do {
            System.out.println("Enter a number between 4 and 16");
            num = in.nextInt();
            check = (num >= 16) || (num <= 4);
        } while (check);

        for (int i = 0; i < num; i++){
            fact *= num - i;
        }
        System.out.println("Factorial is " + fact);
    }

    static void task_4(){
        int count = 0;
        int[] arr = {0, 5, 2, 4, 7, 1, 3, 19};

        for (int i = 0; i < 8; i++){
            count += (arr[i] % 2 != 0)?1:0;
        }

        System.out.println("Amount of uneven numbers in array is " + count);
    }

    static void task_5(){
        System.out.println("Enter length of the array");
        int len = in.nextInt();

        double[] arr = new double[len];

        System.out.println("Array is");

        for(int i = 0; i < len; i++){
            arr[i] = Math.round(Math.random() * len);
            System.out.print(arr[i] + " ");
        }
        System.out.println("\n");
    }

    static void task_6(){
        double[] arr = new double[15];
        double[] arr_copy = new double[30];

        for(int i = 0; i < 15; i++){
            arr[i] = Math.round(Math.random() * 15);
            System.out.print(arr[i] + " ");
        }

        for(int i = 0; i < 15; i++){
            arr_copy[i] = arr[i];
            arr_copy[i + 15] = 2 * arr[i];
        }

        System.out.println();

        for(int i = 0; i < 30; i++){
            System.out.print(arr_copy[i] + " ");
        }
        System.out.println("\n");
    }

    static void task_7(){
        System.out.println("Enter any string");
        String str = in.nextLine();
        System.out.println(symbolOcc(str, 'b', 0));
    }

    static int symbolOcc(String str, char searched_char, int index){
        if(index >= str.length()){
            return 0;
        }
        int count = str.charAt(index) == searched_char? 1 : 0;
        return count + symbolOcc(str, searched_char, index + 1);
    }
}
