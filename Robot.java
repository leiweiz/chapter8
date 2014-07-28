import CtCILibrary.AssortedMethods;

public class Robot{

    // right solution, refer solution just gets one path
    public static int ways(Pos dest){
       if (dest.x<0 || dest.y<0){
            return 0;
       }
       
       if (dest.x==0 && dest.y==0){
            return 1;
       }
       
       return ways(new Pos(dest.x-1, dest.y)) 
            + ways(new Pos(dest.x, dest.y-1));

    }



    public static void main(String[] args){
        Pos dest = new Pos(Integer.valueOf(args[0]),
                            Integer.valueOf(args[1]));
        System.out.println("ways: " + Robot.ways(dest));
    }
}

class Pos{
    public int x;
    public int y;
    public Pos(int _x, int _y){
        x = _x;
        y = _y;
    }
}
