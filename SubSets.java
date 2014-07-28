import java.util.ArrayList;

public class SubSets{

    public static void printSet(ArrayList<Integer> set){
        System.out.print("{ ");
        for (Integer i : set){
            System.out.print(i + ", ");
        }
        System.out.println("}");
    }

    public static ArrayList<Integer> copySet(ArrayList<Integer> set){
        ArrayList<Integer> newset = new ArrayList<Integer>();
        for (Integer i : set){
            newset.add(i);
        }
        return newset;
    }

    public static void showSubsets(ArrayList<Integer> set, 
                            ArrayList<Integer> subset){
         if (set.isEmpty()){
            printSet(subset);
            return;
         }

        ArrayList<Integer> newset = copySet(set); // keep copy
        ArrayList<Integer> newSubset1 = copySet(subset);
        ArrayList<Integer> newSubset2 = copySet(subset);
        int num = newset.remove(0); // if no copy, recursion cause set empty;
        newSubset2.add(num);
        showSubsets(newset, newSubset1); 
        showSubsets(newset, newSubset2);
    }

    public static void main(String[] args){
        ArrayList<Integer> set = new ArrayList<Integer>();
        ArrayList<Integer> subset = new ArrayList<Integer>();
        set.add(1);
        set.add(2);
        SubSets.showSubsets(set, subset);
    }
}
