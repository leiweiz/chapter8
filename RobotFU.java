import java.util.Hashtable;
import java.util.ArrayList;

public class RobotFU{
    public static int SIZE = 7;
    public static int[][] map = new int[SIZE][SIZE];

    public static boolean isFree(int x, int y){
        if (map[x][y]!=0){
            return true;
        }else{
            return false;
        }
    }

    public static void genMap(){
        for (int x=0; x<SIZE; x++){
            for (int y=0; y<SIZE; y++){
                map[x][y] = (int) (Math.random()*100%2);
                System.out.print(map[x][y] + " ");
            }
            System.out.println();
        }
    }

    public static boolean getPath(int x, int y, ArrayList<Pos> path, Hashtable<Pos, Boolean> cache){
        if ( x<0 || y<0 || !isFree(x,y)){
            return false;
        }
        
        Pos point = new Pos(x,y);
        if (cache.containsKey(point)){
            return cache.get(point);
        }

        boolean isValidPath = (x==0 && y==0);
        boolean succeed = false;
        if (isValidPath || getPath(x-1,y, path, cache) || getPath(x, y-1, path, cache) ){
            path.add(point);
            succeed = true;
        }

        cache.put(point, succeed);
        return succeed;
    }
    
    public static void printPath(ArrayList<Pos> path){
        StringBuffer sb = new StringBuffer();
        for (Pos p : path){
            sb.append("("+p.x + "," + p.y + ")");
        }
        if (sb.length()!=0){
            System.out.println(sb.toString());
        }else{
            System.out.println("empty path");
        }
    }

    public static void main(String[] args){
        ArrayList<Pos> path = new ArrayList<Pos>();
        Hashtable<Pos, Boolean> cache = new Hashtable<Pos, Boolean>();
        RobotFU.genMap();
        RobotFU.getPath(5, 5, path, cache);
        RobotFU.printPath(path);
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
