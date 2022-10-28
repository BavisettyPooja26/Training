package ptwo;

class Outer{
    static class Inner{
        static void display(){
            System.out.println("static inner class method invoked");
        }
    }
}
public class TestApp {
    public static void main(String[] args) {
        Outer.Inner.display();

    }
}
