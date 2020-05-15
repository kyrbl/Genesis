package secondLesson;

import java.util.Arrays;

public class Method {
    public static void main(String[] args){

        //justShow();

        //withParams("World!");

        //nextParam(true, "lol ", 3);

        int res = getLen("Hello");
        System.out.println(res);

        int[] arr = {1, 2, 3, 4, 5, 6, 7};
        System.out.println(Arrays.toString(arr));
        sum(arr);
    }

    static void sum(int[] arr){
        for (int i = 0; i < arr.length; ){
            arr[i] = arr[i] + 1;
        }
    }

    public static void justShow(){
        System.out.println("Hello!");
    }

    static void withParams(String str){
        System.out.println(str);
    }

    static void nextParam(boolean flag, String str, int count){
        if(flag){
            for (int i = 0; i < count; i++){
                System.out.print(str);
            }
        }
    }

    static int getLen(String str){
        int value = str.length();
        return value;
    }
}
