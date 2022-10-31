package pthree;
//placeholder
class Sample<P>{
//    char ShowInfo(char info){
////        return info;
////    }
    // you can take any letter you want but put one def in class

    // place holder are replaced with corresponding wrapper class by jvm at the time of function call---- type erasing
    //placeholder will be replaced by the implicit boxings data type
    P ShowInfo(P info){
        return info;
    }
}
public class TestGenericFunction {
    public static void main(String[] args) {
        Sample s= new Sample();
        // a is the object ref, implicit boxing

        System.out.println(s.ShowInfo('A'));

    }
}
