package psix;

import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class TestInBuiltFI {
    public static void main(String[] args) {
        Predicate<String> predicate = (s) -> {
                if (s == "mini") {
                    return true;
                } else {
                    return false;
                }
        };
        boolean status=predicate.test("mini");
        System.out.println(status);

        Consumer<String> consumer =(s) -> System.out.println(s);
        consumer.accept("ssss");
        // return type becomes the wrapper class
        Supplier<Integer> supplier= new Supplier<Integer>() {
            @Override
            public Integer get() {
                return 5;
            }
        };

        Function<String,String> func = new Function<String, String>() {
            @Override
            public String apply(String s) {
                return s.toLowerCase();
            }
        };
        System.out.println(func.apply("POOJA"));
    }
}
//Most imp:
//1.Predicate -> utilise it for validation
//2.Consumer -> used for manipulating; no return
//3.Supplier -> returns something; no incoming values
//4.Function F1 apply method for implementing