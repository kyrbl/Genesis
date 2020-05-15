package secondLesson;

public class Exceptions {
    public static void main(String[] args){
        try {
            show();
        } catch (Exception err){
            err.printStackTrace();
        }
        
        System.out.println("Next Iteration");
    }

    static void show(){
        System.out.println(4 / 0);
    }
}
