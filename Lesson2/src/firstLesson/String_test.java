package firstLesson;

public class String_test {
    public static void main(String[] args){
        String s1 = "Hello";
        String s2 = "World";

        System.out.println(s1 + s2);

        int index = s1.indexOf("e");
        System.out.println(index);

        String str = "";
        int a = 20;
        str = str + a;
        System.out.println(str);

        double d = 4.4;
        str = Double.toString(d);


    }
}
