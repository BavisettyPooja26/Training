package pone;

public class TestApp {
    public static void main(String[] args) {
        System.out.println("Enter values from cmd");
        try{
            System.out.println(args[0]);
        }
        catch(ArrayIndexOutOfBoundsException e){
            System.out.println("pass from cmd");
            e.printStackTrace();
        }
        System.out.println("code continues");
    }
}
