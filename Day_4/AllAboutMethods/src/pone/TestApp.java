package pone;
class Customer{
    int custid;
    String custname;
    String custaddr;

    void ShowCustomerInfo(){
        System.out.println(custid+" "+custname+" "+custaddr);
    }
}
class Order{
    int orderid;
    String ordername;
    int orderprice;
    //Customer cobj;

    void ShowOrderInfo(){
        System.out.println(orderid+" "+ordername+" "+orderprice);
    }
    double orderDiscount(double discount){
        orderprice=orderprice-discount;
        return orderprice;
        //System.out.println("After discount: "+orderprice);
    }
    void placeOrder(Customer obj){
        System.out.println(obj.custname+ "placed an order of "+ordername);

    }

}
public class TestApp {
    public static void main(String[] args) {
        System.out.println("Hello v1.0 !");

        Customer custone = new Customer();
        custone.custid=1;
        custone.custname="pooja";
        custone.custaddr="kol";

        Customer custtwo = new Customer();
        custtwo.custid=2;
        custtwo.custname="dhananjay";
        custtwo.custaddr="mumbai";

        custone.ShowCustomerInfo();
        custtwo.ShowCustomerInfo();

        Order one = new Order();
        one.orderid=1;
        one.ordername="margareta";
        one.orderprice=500;

       double dprice=one.orderDiscount(200);
        System.out.println("After discount: "+dprice);

        one.placeOrder(custtwo);

        Order two = new Order();
        two.orderid=2;
        two.ordername="cake";
        two.orderprice=200;

        one.ShowOrderInfo();
        two.ShowOrderInfo();

    }
}