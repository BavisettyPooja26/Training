package pthree;
//wait and notify method from object class - enables alternate execution
class Tortoise extends Thread{
    int oddNum=1;
    Object obj;
    Tortoise(Object obj){
        this.obj=obj;
    }
    public void run(){
        for(int start=0; start <=10; start++){
            synchronized (obj){
                System.out.println("tortoise prints "+oddNum);
                oddNum+=2;
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                try {
                    //releases the lock and
                    obj.notify();
                    obj.wait();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }
}
class Rabbit extends Thread{
    int evenNum=2;
    Object obj;
    Rabbit(Object obj){
        this.obj=obj;
    }
    public void run(){
        for(int start=0; start <=10; start++){
            synchronized (obj){

                System.out.println("rabbit prints "+evenNum);
                evenNum+=2;
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                obj.notify();
                try {
                    obj.wait();

                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }
}
public class InterThreadCommunication
{
    public static void main(String[] args) {
        Object obj = new Object();
        Tortoise tobj=new Tortoise(obj);
        Rabbit robj = new Rabbit(obj);
        tobj.start();
        robj.start();
    }

}
