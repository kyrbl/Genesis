import java.util.Scanner;

public class Ht_1 {

    static final Scanner in = new Scanner(System.in);

    public static void main(String[] args){

        while (true){

            System.out.println("What do u want to do? \nmax of 3 numbers[1]; sum of 2 numbers[2]; define if number is even[3]; square of parallelogram[4]; square of triangle[5]; exit[6]");

            int check = in.nextInt();

            switch (check){
                case 1:
                    System.out.println("Enter 3 numbers");
                    System.out.println("Result is: " +  max_of_numb(in.nextInt(), in.nextInt(), in.nextInt()));
                    break;
                case 2:
                    System.out.println("Enter 2 numbers");
                    System.out.println("Result is: " +  sum_of(in.next(), in.next()));
                    break;
                case 3:
                    System.out.println("Enter 1 number");
                    System.out.println("Result is: " +  even(in.nextInt()));
                    break;
                case 4:
                    System.out.println("Enter sides of parallelogram");
                    float a = in.nextFloat();
                    float b = in.nextFloat();
                    System.out.println("Enter angle between sides");
                    float ang = in.nextFloat();
                    System.out.println("Result is: " +  square_of_parallelogram(a, b, ang));
                    break;
                case 5:
                    System.out.println("Enter sides of triangle");
                    System.out.println("Result is: " +  square_of_triangle(in.nextFloat(), in.nextFloat(), in.nextFloat()));
                    break;
                case 6:
                    return;
                default:
                    System.out.println("Err in input! You must enter one of these numbers: 1, 2, 3, 4, 5, 6!");
            }

        }
    }

    static int max_of_numb(int a, int b, int c){
        int temp = (a < b) ? b:a;
        return (temp < c) ? c:temp;
    }

    static String sum_of(String a, String b){
        int temp = Integer.parseInt(a) + Integer.parseInt(b);
        return Integer.toString(temp);
    }

    static boolean even(int a){
        return (a%2 == 0);
    }

    static float square_of_parallelogram(float a, float b, float ang){
        return (float) ((a * b) * Math.sin(ang));
    }

    static float square_of_triangle(float a, float b, float c){
        float p = (a+b+c)/2;
        return (float) Math.sqrt(p*(p-a)*(p-b)*(p-b));
    }
}
