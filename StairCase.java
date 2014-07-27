public class StairCase{
    public static int ways(int stair){
        if (stair<0){
            return 0;
        }
        if (stair==0){ // base case: ==0
            return 1;
        }

        return ways(stair-1) + ways(stair-2) + ways(stair-3) ;
    }

    public static void main(String[] args){
        int stair = Integer.valueOf(args[0]);
        System.out.println( stair + " stairs has " + 
                            StairCase.ways(stair) + " ways");
        //System.out.println(stair);
    }
}
