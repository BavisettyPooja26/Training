package pone;

class Parent{
    Parent(){
        System.out.println("parent class zero parameter constructor");
    }
    void Show(){
        System.out.println("Parent class method");
    }
}
class Sample extends Parent{
    Sample(){
        System.out.println("constructor with no parameters");
    }
    Sample(int a){
        this();
        System.out.println("constructor with one parameter");
    }
    Sample(int a,int b){
        this(5);
        System.out.println("constructor with two parameters");
    }
}
public class TestApp {
    public static void main(String[] args){
        Sample obj = new Sample(1,2);

    }
}
