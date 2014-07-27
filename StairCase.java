public class StairCase{
    public static int ways1(int stair){
        if (stair<0){
            return 0;
        }
        if (stair==0){ // base case: ==0
            return 1;
        }

        return ways1(stair-1) + ways1(stair-2) + ways1(stair-3) ;
    }

    // dp solution
    public static int ways2(int stair, int[] num){
        if (stair<0){
            return 0;
        }
        if (stair==0){
            return 1;
        }
        if(num[stair]!=0){
            return num[stair];
        }else{
           num[stair] = ways2(stair-1, num) + ways2(stair-2, num)
                        + ways2(stair-3, num);
           return num[stair];
        }
    }

    public static void main(String[] args){
        int stair = Integer.valueOf(args[0]);
        //System.out.println( stair + " stairs has " + 
        //                    StairCase.ways1(stair) + " ways");

        System.out.println( stair + " stairs has " +
                            StairCase.ways2(stair, new int[stair+1])
                            + " ways");
        //System.out.println(stair);
    }
}
