import java.util.ArrayList;

public class Permu{
    public static ArrayList<String> permu(String str){
        ArrayList<String> allperm = new ArrayList<String>();
        hpermu(str, "", allperm);
        return allperm;
    }

    public static void hpermu(String remain, String contain, ArrayList<String> allperm){
        if(remain.length()==0){
            allperm.add(contain);
            //System.out.println(contain);
            return;
        }else{
            for(int i=0; i<remain.length(); i++){
                String newrem = remain.substring(0,i)+
                        remain.substring(i+1,remain.length());
                String newcon = contain+remain.charAt(i);
                hpermu(newrem, newcon, allperm);
            }
        }
        
    }

    public static void main(String[] args){
        String str = "abc";
        ArrayList<String> allperm = Permu.permu(str);
        for (String s : allperm){
            System.out.println(s);
        }
    }

}
