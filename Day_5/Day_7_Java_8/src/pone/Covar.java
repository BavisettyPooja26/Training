package pone;

// covarient return type: when in method overriding we can change the return type of the method
//it has to be class type while u change it from its parent type
class Employee{
    Employee Show(){
        System.out.println("Show method of Employee");

        return new Employee();
    }
}
class ITEmployee extends Employee{
    ITEmployee Show(){
        System.out.println("show inheruted from eployee parent but got changed");
        return new ITEmployee();
    }
}
public class Covar {
    public static void main(String[] args) {
        Employee empone = new Employee();
        empone.Show();
        ITEmployee itemp = new ITEmployee();
        itemp.Show();
    }
}