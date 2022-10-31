package pthree;

class Callee{
    //lock on shout out until the bracket is closed
    synchronized void ShoutOut(String msg) throws InterruptedException {

//        object synchronization
//                synchronized(callee){
//            callee.shoutout(message);
//                }
//                code block synchronization
//                synchronized(this){
//                    System.out.print("["+msg);
//                    try {
//                        Thread.sleep(500);
//                    }
//                    catch(InterruptedException e){
//                        throw new RuntimeException(e);
//                    }
//                    System.out.print("]");
//
//                }
//                }
        System.out.print("["+msg);
        try {
            Thread.sleep(500);
        }
        catch(InterruptedException e){
            throw new RuntimeException(e);
        }
        System.out.print("]");

    }
}
class Caller extends Thread{
    String message;
    Callee callee;
    Caller(String m, Callee c){
        message=m;
        callee=c;
    }
    public void run(){
        try {
            callee.ShoutOut(message);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
public class TestAppTwo {
    public static void main(String[] args) {
        Callee obj = new Callee();

        Caller o1=new Caller("hi",obj);
        Caller o2=new Caller("to",obj);
        Caller o3=new Caller("java",obj);
        o1.start();
        o2.start();
        o3.start();
    }
}
