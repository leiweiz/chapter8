import java.util.ArrayList;

public class SubSets{
    // my solution
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


    //refer solution
    public static ArrayList<ArrayList<Integer>> getSubsets(ArrayList<Integer> set, int index){
        ArrayList<ArrayList<Integer>> allsubsets;
        if (set.size()==index){
            allsubsets = new ArrayList<ArrayList<Integer>>();
            allsubsets.add(new ArrayList<Integer>());
        }else{
            allsubsets = getSubsets(set, index+1);
            int item = set.get(index);
            ArrayList<ArrayList<Integer>> moresubsets = 
                   new ArrayList<ArrayList<Integer>>();
            for (ArrayList<Integer> subset : allsubsets){
                ArrayList<Integer> newsubset = new ArrayList<Integer>();
                newsubset.addAll(subset);
                newsubset.add(item);
                moresubsets.add(newsubset);
            }
            allsubsets.addAll(moresubsets);
        }
        return allsubsets;
    }

    public static void main(String[] args){
        ArrayList<ArrayList<Integer>> allset = new ArrayList<ArrayList<Integer>>();
        ArrayList<Integer> set = new ArrayList<Integer>();
        ArrayList<Integer> subset = new ArrayList<Integer>();
        set.add(1);
        set.add(2);
        set.add(3);
        //SubSets.showSubsets(set, subset);
        allset = SubSets.getSubsets(set, 0);
        for(ArrayList<Integer> sub : allset){
            System.out.print("{ ");
            for (Integer i : sub){
                System.out.print(i + " " );
            }
            System.out.println("}");
        }
    }
}
