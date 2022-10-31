package pthree;

class Example <X extends String,Y extends Integer>{
    X var1;
    Y var2;

    Y setinfo(X info1, Y info2){
        var1=info1;
        var2=info2;
        System.out.println(var1+" "+var2);
        return var2;
    }
}
public class TestGenericClass {
    public static void main(String[] args) {
        Example e = new Example();
        //e.setinfo(22,"Pooja");
        Example<String,Integer> obj = new Example();
        System.out.println(obj.setinfo("r",2));
    }
}
