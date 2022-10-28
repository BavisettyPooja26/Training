package ptwo;

class InsufficientFund extends Exception{
    void myownPrintStack(){
        System.out.println("Insufficient fund");
    }
}
public class TestApp {
    public static void main(String[] args) throws InsufficientFund{
        try{
            throw new InsufficientFund();
        }
        catch(InsufficientFund ex){

        }
    }
}
