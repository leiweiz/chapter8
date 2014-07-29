import java.util.LinkedList;
import java.util.Queue;
import java.util.ArrayList;

public class PaintFill{
    public static int SIZE=7;
    public static int[][] screen = new int[SIZE][SIZE];

    // BFS, not recursion
    public static void fill(Pos point, int color){
      Queue<Pos> q = new LinkedList<Pos>();
      q.add(point);
      while(!q.isEmpty()){
            Pos tmp = q.poll();
            if ( screen[tmp.x][tmp.y]==0 ){
                screen[tmp.x][tmp.y] = color;
                ArrayList<Pos> neigh = getNeigh(tmp);
                for ( Pos p : neigh ){
                    q.add(p);
                }
            }
      }
    }

    //DFS, recursion
    public static void fillR(Pos point, int color){
        if(!isFree(point.x, point.y)){
            return;
        }else{
            screen[point.x][point.y] = color;
            if (isFree(point.x-1, point.y)){
                fillR(new Pos(point.x-1, point.y), color);
            }
            if (isFree(point.x+1, point.y)){
                fillR(new Pos(point.x+1, point.y), color);
            }
            if (isFree(point.x, point.y-1)){
                fillR(new Pos(point.x, point.y-1), color);
            }
            if (isFree(point.x, point.y+1)){
                fillR(new Pos(point.x, point.y+1), color);
            }
        }
    }

   public static ArrayList<Pos> getNeigh(Pos point){
        ArrayList<Pos> arrlist = new ArrayList<Pos>();
        if ( isFree(point.x-1, point.y) ){
            arrlist.add(new Pos(point.x-1, point.y));
        }
        if ( isFree(point.x+1, point.y) ){
            arrlist.add(new Pos(point.x+1, point.y));
        }
        if ( isFree(point.x, point.y-1) ){
            arrlist.add(new Pos(point.x, point.y-1)); 
        }
        if ( isFree(point.x, point.y+1) ){
            arrlist.add(new Pos(point.x, point.y+1));
        }
        return arrlist;
   }

   public static boolean isFree(int x, int y){
        if ( x>=0 && y>=0 && x<SIZE && y<SIZE && screen[x][y]==0 ){
            return true;
        }else{
            return false;
        }
   }

   public static void showMap(){
        System.out.println("*----map begin---");
        for(int x=0; x<SIZE; x++){
           for (int y=0; y<SIZE; y++){
                System.out.print(screen[x][y]);
           }
           System.out.println();
        }
        System.out.println("*----map end---");
   }

   public static void generateMap(){
        for (int x=0; x<SIZE; x++){
            for(int y=0; y<SIZE; y++){
                screen[x][y] = (int) (Math.random()*4);
            }
        } 
   }

   public static void main(String[] args){
        generateMap();
        showMap();
        Pos point = new Pos(0,0);
        int color = 5;
        fill(point, color);
        showMap();
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
