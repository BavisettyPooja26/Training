 class AddressBook {
    String name = "Pooja";
    long phone_number = 123456789;
    Address tempAddress;
    Address permAddress;

    class Address {
        String name= "Pooja";
        String street_address;
        String city;
        String state;
    }

}
public class TestApp{
    public static void main(String[] args){
         AddressBook a = new AddressBook();
         AddressBook.Address b = a.new Address();
         // for temporary address
            b.street_address="abc street 123";
            b.city = "Kolkata";
            b.state="West bengal";
            a.tempAddress=b;
            System.out.println("\nAddress details of "+a.name+"(Ph no: "+a.phone_number+"):\n\nTemporary address:" +
                    "\nStreet address: "+a.tempAddress.street_address+
                    "\nCity: "+a.tempAddress.city+"\n" +
                    "State: "+a.tempAddress.state);
        AddressBook.Address b2 = a.new Address();
        // for permanent address
        b2.street_address="def street 456";
        b2.city = "Mumbai";
        b2.state="Maharashtra";
        a.permAddress=b2;
        System.out.println("\nPermanent address:" +
                "\nStreet address: "+a.permAddress.street_address+
                "\nCity: "+a.permAddress.city+"\n" +
                "State: "+a.permAddress.state);
    }
}
