package pthree;

class TennisClub{
    static int countMember=0;

    static void TrackMemCount(){
        countMember+=1;
        System.out.println("Total members joined: "+countMember);
    }
    void DisplayBranches(String[] branch){
        for(String i : branch){
            System.out.println(i+" ");
        }
    }
}
public class TestApp {
    static{
        System.out.println("Pre processing before main");
    }

    public static void main(String[] args){
        TennisClub memone =new TennisClub();
        memone.TrackMemCount();

        TennisClub memtwo =new TennisClub();
        memtwo.TrackMemCount();

        TennisClub memthree =new TennisClub();
        memthree.TrackMemCount();

        String branch[]=new String[3];
        branch[0]="Noida";
        branch[1]="Kolkata";
        branch[2]="Mumbai";
        memthree.DisplayBranches(branch);
//        for(int index=0; index<3;index++){
//            System.out.println(branch[index]);
//        }



        //TennisClub memfour =new TennisClub();



    }
}
