package ptwo;

class Customer{
    static int cid;
    static String cname;

    static void ShowDetails(){
        System.out.println(cid+" "+cname)
    }
}

class Admin{
    static int aid;
    static String aname;

    static void ShowDetails(){
        System.out.println(aid+" "+aname)
    }
}

public class TestApp{
    public static void main(String[] args){
        Admin.aid = 1;
        Admin.aname = 1;
        Admin.ShowDetails();

    }
}