import java.util.ArrayList;
import java.util.Set;
import java.util.HashSet;

public class NPair{
    
    // my solution
    public static Set<String> hshowPair(int num){
        if (num==0){
            return null;
        }else if(num==1){
            Set<String> al = new HashSet<String>();
            al.add("()");
            return al;
        }else{
            Set<String> res = new HashSet<String>();
            Set<String> tmp = hshowPair(num-1);
            for( String str: tmp ){
                res.add("()" + str);
                res.add("(" + str + ")");
                res.add(str + "()");
            }
            return res;
        }
    }

    // refer sol1
    public static Set<String> generateParens1(int remaining){
        Set<String> set = new HashSet<String>();
        if (remaining == 0){
            set.add("");
        }else{
            Set<String> prev = generateParens1(remaining-1);
            for (String str : prev){
                for (int i=0; i<str.length(); i++){
                    if (str.charAt(i)=='('){
                        String s = insertInside(str, i);
                        set.add(s);
                    }
                }
                set.add("()"+str);
            }
        }

        return set;
    }

    public static String insertInside(String str, int leftIndex){
        String left = str.substring(0, leftIndex+1);
        String right = str.substring(leftIndex+1, str.length());
        return left + "()" + right;
    }

    // refer sol2
    public static void addParen(ArrayList<String> list, int leftRem, int rightRem, char[] str, int count){
        if (leftRem<0 || rightRem<leftRem) return;

        if (leftRem==0 && rightRem==0){
            String s = String.copyValueOf(str);
            list.add(s);
        }else{
            if (leftRem>0){
                str[count] = '(';
                addParen(list, leftRem-1, rightRem, str, count+1);
            }

            if (rightRem>leftRem){
                str[count] = ')';
                addParen(list, leftRem, rightRem-1, str, count+1);
            }
        }
    }

    public static ArrayList<String> generateParens2(int count){
        char[] str = new char[count*2];
        ArrayList<String> list = new ArrayList<String>();
        addParen(list, count, count, str, 0);
        return list;
    }

    public static void main(String[] args){
        int num = 5;
        //Set<String> al = hshowPair(num);
        //Set<String> al = generateParens1(num);
        //int count = 0;
        //for ( String str : al ){
        //    count++;
        //    System.out.println(count + " " + str);
        //}

        ArrayList<String> list = generateParens2(num);
        for (String str : list){
            count++;
            System.out.println(count + " " + str);
        }
    }
}
