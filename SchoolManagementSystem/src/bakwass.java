import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;

public class bakwass {
    public static void main(String[] args) {
        int [] integers = {1,2,3,4,5,6};
        ArrayList<Integer> sortinglist = new ArrayList<Integer>();
        for(int element:integers){
            System.out.println(element);
            sortinglist.add(element);
        }
        System.out.println(sortinglist);
        ArrayList<Integer> sortedlist = new ArrayList<Integer>();
//        System.out.println(sortinglist.get(0));
//        System.out.println(sortinglist.get(1));
//        System.out.println(sortinglist.get(2 ));
        for (int i= sortinglist.size()-1;i>=0;i--){
//            System.out.println(sortinglist.get(0));
//            System.out.println(sortinglist.get(1));
//            System.out.println(sortinglist.get(2 ));
            System.out.println(i);
            sortedlist.add(sortinglist.get(i));
//            sortedlist.set(i-sortinglist.size(),sortinglist.get(i));
        }
        System.out.println(sortedlist);
;
//        for (int i=sortinglist.length;i==0;i--){
//            System.out.println(sortinglist.length);
//            sortedlist[(sortinglist.length)-i] = sortinglist[i-1];
//            }

        }

    }

