public class Queen{
    private static int count = 0;
    private static int SIZE = 8;
    public static int[][] chess = new int[SIZE][SIZE];

    public static void genQueen(){
        hgenQueen(0);
    }
    
    public static void hgenQueen(int num){
        if (num==SIZE-1){
            for (int i=0; i<SIZE; i++){
                if (isValid(num, i)){
                    chess[num][i] = 8;
                    showChess();
                }
            }
            return;
        }

        for (int i=0; i<SIZE; i++){
            if(isValid(num, i)){
                chess[num][i] = 8;
                hgenQueen(num+1);
                chess[num][i] = 0;
            }
        }
    }
    
    public static boolean isValid(int row, int col){
        // same col
        for (int i=0; i<SIZE; i++){
            if(i!=row && chess[i][col]==8){
                return false;
            }
        }

        // same row
        for (int i=0; i<SIZE; i++){
            if (i!=col && chess[row][i]==8){
                return false;
            }
        }

        // left top
        int offset = 1;
        while ( (row-offset)>=0 && (col-offset)>=0 ){
            if ( chess[row-offset][col-offset]==8 ){
                return false;
            }
            offset++;
        }
        
        // right down
        offset = 1;
        while ( (row+offset)<SIZE && (col+offset)<SIZE ){
            if ( chess[row+offset][col+offset]==8 ){
                return false;
            }
            offset++;
        }

        // left down
        offset = 1;
        while ( (row-offset)>=0 && (col+offset)<SIZE ){
            if ( chess[row-offset][col+offset]==8 ){
                return false;
            }
            offset++;
        }

        // right up
        while ( (row+offset)<SIZE && (col-offset)>=0 ){
            if ( chess[row+offset][col-offset]==8 ){
                return false;
            }
            offset++;
        }
        
        // then valid
        return true;
    }

    public static void showChess(){
        System.out.println("*-------chess:"+ count + "---------");
        count++;
        for (int x=0; x<SIZE; x++){
            for (int y=0; y<SIZE; y++){
                System.out.print(chess[x][y] + "  ");
            }
            System.out.println();
        }
        System.out.println("*-------chess---------");
    }
   
    public static void main(String[] args){
        showChess(); 
        genQueen();
        //showChess();
    }
}
