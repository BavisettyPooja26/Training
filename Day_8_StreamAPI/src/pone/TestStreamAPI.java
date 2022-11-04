package pone;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import java.util.stream.Collectors;
import java.util.stream.Stream;

// api in java is a packaqge; collection of classes
class Emp{
    private String name;
    private double salary;
    private int yoj;
    private List<String> projects;
    public Emp(){
        super();
    }

    public Emp(String name, double salary, int yoj, List<String> projects) {
        this.name = name;
        this.salary = salary;
        this.yoj = yoj;
        this.projects = projects;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public int getYoj() {
        return yoj;
    }

    public void setYoj(int yoj) {
        this.yoj = yoj;
    }

    public List<String> getProjects() {
        return projects;
    }

    @Override
    public String toString() {
        return "Emp{" +
                "name='" + name + '\'' +
                ", salary=" + salary +
                ", yoj=" + yoj +
                ", projects=" + projects +
                '}';
    }

    public void setProjects(List<String> projects) {
        this.projects = projects;
    }
}
public class TestStreamAPI {
    static List<String> projects;
    static List<Emp> emplist;

    //static before main gets more priority
    static {
        List<String> proj1 = new ArrayList<>();
        proj1.add("payment module");
        List<String> proj2 = new ArrayList<>();
        proj2.add("payment module");
        proj2.add("cart module");
        List<String> proj3 = new ArrayList<>();
        proj3.add("payment module");
        proj3.add("cart module");
        proj3.add("wishlist module");

        Emp emp1 = new Emp("a", 1, 2022, proj1);
        Emp emp2 = new Emp("b", 2, 2022, proj2);
        Emp emp3 = new Emp("c", 3, 2022, proj3);
        emplist = new ArrayList<Emp>();
        emplist.add(emp1);
        emplist.add(emp2);
        emplist.add(emp3);

    }

    public static void main(String[] args) {
//        System.out.println("Retreiving details:");
//        for(Emp obj: emplist){
//            System.out.println(obj);
//        }
//    } ---> traditional way to do
// using stream api support
        emplist.stream()
                .forEach(System.out::println);

        //providing 20%hike in each salary

        emplist.stream()
                .map(obj->obj.getSalary()*1.20)
                .forEach(System.out::println);//applies one function on per object
// checking can be done here >60k


        emplist.stream()
                .filter(obj->obj.getSalary() > 1)
                .map(obj->obj.getSalary()*1.20)
                .forEach(System.out::println);
        //1d array
        String plist= emplist.stream().map(obj->obj.getProjects())
                            .flatMap(string->string.stream())
                            .collect(Collectors.joining(","));

    }
}
//stream API is library of classes and interfaces for performing operations on
//        collections of objects maintained by collection framework; for this we need to convert the collection of object into stream o f
//        objects and there after we can use stream api to support desired operation
//
//        Stream Api support provides two diff kind of methods:
//        1.Intermediate Operation; output of one method becomes the input for second
//        method in the chain of method invocation or in method pipeline
//        e.g: ma(), filter(), flatmap()
//
//        2. Terminal Operation; finally terminates the whole stream api operations with certain desired output; last one to call
//        eg: foreach(), collect(Collector,toList or toSet

//        List<Integer> list1=List.of(1,2,3,3,4,4,5);
//        List<Integer> elist=new ArrayList<>();
//        for(Integer num: list1){
//            //working without stream api
//            if(num%2==0){
//                elist.add(num);
//            }
//        }
//        System.out.println(elist);
// working with stream api
//step1: convert the list(collection of objs) to stream of objects
//        Stream<Integer> stream = list1.stream();
//        stream.filter(num->num%2==0)
//                .collect(Collectors.toSet())
//                        .forEach(num-> System.out.println(num));
//
//.forEach(num-> System.out::println);

//or,        stream.filter(num->num%2==0)
//                .forEach(num -> System.out.println(num+"\t"));
//       or, stream.forEach(new Consumer<Integer>() {
//            @Override
//            public void accept(Integer num) {
//                if(num%2==0){
//                    elist.add(num);
//                }
//            }
//        });
        //System.out.println(elist);

//        List<Integer> list2=new ArrayList<>();
//        list2.add(55);
//        list2.add(66);
