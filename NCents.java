import java.util.Hashtable;

public class NCents{
    public static int ways(int cents){
        int[] demons = {25, 10, 5, 1};
        return hways(cents, demons, 0);
    }

    public static int hways(int cents, int[] demons, int index){
        if (index==demons.length-1){
            return 1;
        }
        int val = demons[index];
        int totalways = 0;
        for( int i=0; i*val<=cents; i++ ){
            totalways += hways(cents-i*val, demons, index+1);
        }
        return totalways;

    }

    // dp
    public static int waysdp(int cents){
        int[] demons = {25, 10, 5, 1};
        Hashtable<Integer, Integer> ht = new Hashtable<Integer, Integer>();
        return hwaysdp(cents, demons, 0, ht);
    }

    public static int hwaysdp(int cents, int[] demons, int index, Hashtable<Integer, Integer> ht){
        if (ht.containsKey(cents)){
            return ht.get(cents);
        }
        if (index>=demons.length-1){
            return 1;
        }
        int val = demons[index];
        int totalways = 0;
        for (int i=0; i*val<=cents; i++){
            totalways += hwaysdp(cents-i*val, demons, index+1, ht);
        }
        ht.put(cents, totalways);
        return totalways;
    }

    public static void main(String[] args){
        System.out.println(waysdp(Integer.valueOf(args[0]))); 
    }
}
