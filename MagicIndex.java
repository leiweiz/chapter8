public class MagicIndex{
    public static void isMagic(int[] arr,
                        int start, int end){
        if(start>end){
            return;
        }
        int mid = (start+end)/2;
        if (arr[mid]==mid){
            System.out.print(mid + " ");
        }
        if (arr[mid]>mid){
            isMagic(arr, start, mid-1);
        }else if(arr[mid]<mid){
            isMagic(arr, mid+1, end);
        }else{
            isMagic(arr, start, mid-1);
            isMagic(arr, mid+1, end);
        }
    }

    public static void main(String[] args){
        int[] arr = new int[10];
        for (int i=0; i<10; i++){
            arr[i] = i;
        }
        MagicIndex.isMagic(arr,0, 9);
        System.out.println();
    }
}
