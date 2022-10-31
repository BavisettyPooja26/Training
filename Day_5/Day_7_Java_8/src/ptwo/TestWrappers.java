package ptwo;
public class TestWrappers {
    public static void main(String[] args) {
        int num=10;
        //int -> Integer, float -> Float
        System.out.println(num);
        // explicit boxing - wrapping up primitive into its class object repr
        // so that we can use methods of Integer class
        // converting value to ref type
        Integer numobjref = new Integer(num);
        //creating obj reference
        // explicit unboxing - (intValue()-retrieves primitive num from ref) converting ref type to primitive type
        System.out.println(numobjref.intValue());
        //Type casting: from one data type to another
        int numone = Integer.parseInt(args[0]);
        int numtwo = Integer.parseInt(args[1]);
        int result=numone+numtwo;
        System.out.println("sum:" +result);
    }
}
