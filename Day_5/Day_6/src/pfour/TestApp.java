package pfour;
//step1: find what to make thread then find its cloass and inherit Thread class
 class Employee implements Runnable{
    String ename;

    public Employee(String ename) {
        this.ename = ename;
    }
    //step2: there is predefined run method so use that for the task u want
    public void run(){
        for(int start=0; start<=10; start++){
            System.out.println(ename+" prints "+start);
            try {
                Thread.sleep(1000);//used for pausing one thread while the other thread works
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
public class TestApp {
    public static void main(String[] args) {

        Employee empone = new Employee(("pooja"));
        Employee emptwo = new Employee(("dhananjay"));
        //step3: start the threads
        Thread t1 = new Thread(empone);
        Thread t2 = new Thread(emptwo);
//        emptwo.start();
//        empone.start();
        t1.start();
        t2.start();

        try {
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
