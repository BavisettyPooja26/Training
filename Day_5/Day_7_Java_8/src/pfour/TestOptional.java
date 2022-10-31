package pfour;

import java.util.Optional;

public class TestOptional {
//addresses the problem of null pointer exception
public static void main(String[] args) {
    String user="pooja";
//    if(user==null){
//        // == content checking
//        //.equals() ref checking
//        System.out.println("null is in obj ref");
//    }
//    else{
//        System.out.println(user);
//    }
    Optional optional= Optional.ofNullable(user);
    System.out.println(optional.isEmpty());
    System.out.println(optional.get());//retrieves values
    System.out.println(optional.orElse("no onj")); //gives no error even if its null
}
}
