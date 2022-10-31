package pfive;
// hosts one and only one abstract methods but can have multiple default and static method
@FunctionalInterface
interface MyFunctionalInterface{
    void method1();
   // void method2();

    default void method3(){
        System.out.println("default m3 of myFunvtionalInterface");
    }
    default void method4(){
        System.out.println("default m4 of myFunvtionalInterface");
    }
    static void method5(){
        System.out.println("static 1 of myFunvtionalInterface");
    }
    static void method6(){
        System.out.println("static 2 of myFunvtionalInterface");
    }
}
class  Child implements MyFunctionalInterface{

    @Override
    public void method1() {
        System.out.println("m1 from child");
    }
    @Override
    public void method3() {
        System.out.println("m3 from child");
        MyFunctionalInterface.super.method3();
    }
}
public class TestFunctionalInterface {
    public static void main(String[] args) {
        Child child = new Child();
        child.method1();
        child.method3();child.method4();
        MyFunctionalInterface.method5();
        MyFunctionalInterface.method6();
//anonymous class syntax:
        MyFunctionalInterface cone = new MyFunctionalInterface() {
            @Override
            public void method1() {
                System.out.println("abstract method of FI defined using anpnymous class");
            }
        };
        cone.method1();
        //System.out.println("using anonymous method syntax: (lambda expression)");
        // only for abstract method of functional interface
        MyFunctionalInterface c2 =(//parameter(no data type reqd)
                )-> {
                System.out.println("abstract method of FI defined using anpnymous class");
            };
        c2.method1();
        };
    }

