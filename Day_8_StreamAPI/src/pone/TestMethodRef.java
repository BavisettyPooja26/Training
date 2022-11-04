package pone;

class Employee{
    static void task(){
        System.out.println("task");
    }
    void anytask(){
        System.out.println("any task");
    }
}
@FunctionalInterface
interface MySample{
    void doTask();
}
@FunctionalInterface
interface Factory{
    Employee getEmployee();
}

public class TestMethodRef {
    public static void main(String[] args) {
        //refering to the method; using body of task() in doTask()
       /* 1. Static Method ref
                Syntax: Classname :: methodName
        */
        MySample sample=Employee ::task;
        sample.doTask();
         /* 2. Instance Method ref
                Syntax: obj :: methodName
        */
        Employee obj = new Employee();
        MySample samp1= obj::anytask;
        samp1.doTask();


        Factory fact = new Factory() {
            @Override
            public Employee getEmployee() {
                return new Employee();
            }
        };
        Employee obj1 = fact.getEmployee();
        obj1.anytask();
        // or myFactory.getEmployee().anytask();
         /* 3. Constructor Method ref
                Syntax: ClassName :: new
        */
        Factory factory = Employee::new;
        factory.getEmployee().anytask();
    }

}
