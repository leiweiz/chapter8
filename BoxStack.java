import java.util.ArrayList;
import java.util.Hashtable;

class Box{
    int width;
    int height;
    int depth;
    public Box(int _width, int _height, int _depth){
        width = _width;
        height = _height;
        depth = _depth;
    }

    public boolean canBeAbove(Box bottom){
        if (bottom==null){
            return true;
        }

        if (width<bottom.width && height<bottom.height &&
                depth<bottom.depth){
            return true;    
        }
        return false;
    }

    public String toString(){
        return "Box: " + width + " " + height + " " + depth;
    }
}

public class BoxStack{

    public static int getHeight(ArrayList<Box> boxes){
        int height = 0;
        for (Box b : boxes){
            height += b.height;
        }
        return height;
    }

    public static ArrayList<Box> getMaxStack(Box[] boxes, Box bottom){
        ArrayList<Box> maxStack = null;
        int max_height = 0;

        for (int i=0; i<boxes.length; i++){
            if (boxes[i].canBeAbove(bottom)){
                ArrayList<Box> newStack = getMaxStack(boxes, boxes[i]);
                int new_height = getHeight(newStack);
                if (new_height>max_height){
                    maxStack = newStack;
                    max_height = new_height;
                }
            }
        }

        if (maxStack==null){
            maxStack = new ArrayList<Box>();
        }

        if (bottom!=null){
            maxStack.add(0, bottom);
        }

        return maxStack;
    }

    public static ArrayList<Box> getMaxStackDP(Box[] boxes, Box bottom, Hashtable<Box, ArrayList<Box>> cache){
        if (bottom!=null && cache.containsKey(bottom)){
            return cache.get(bottom);
        }
        
        ArrayList<Box> maxStack = null;
        int max_height = 0;
        for (int i=0; i<boxes.length; i++){
            if (boxes[i].canBeAbove(bottom)){
                ArrayList<Box> newStack = getMaxStackDP(boxes, boxes[i], cache);
                int new_height = getHeight(newStack);
                if (new_height>max_height){
                    maxStack = newStack;
                    max_height = new_height;
                }
            }
        }

        if (maxStack==null){
            maxStack = new ArrayList<Box>();
        }

        if (bottom!=null){
            cache.put(bottom, maxStack);
            maxStack.add(0, bottom);
        }

        return (ArrayList<Box>)maxStack.clone();
    } 

    public static void main(String[] args){
        Hashtable<Box, ArrayList<Box>> cache = new Hashtable<Box, ArrayList<Box>>();
        Box[] boxes = {new Box(5, 5, 5), new Box(4, 4, 4), new Box(3, 3, 3)};
        ArrayList<Box> boxStack =  getMaxStackDP(boxes, null, cache);
        for (int i=boxStack.size()-1; i>=0; i--){
            Box b = boxStack.get(i);
            System.out.println(b.toString());
        }
    }
}
