package A_hot100;

import java.util.ArrayList;
import java.util.List;

public class id_22_1 {
    public List<String> generateParenthesis(int n) {
        List<String> ans = new ArrayList<String>();
//        f(ans,0,0,"",n);
        f(0,0,n,ans,new char[2 * n]);
        return ans;
    }

//    public void f(List<String> list, int left, int right, String parenthesis,int n) {
//        if (left == n && right == n) {
//            list.add(parenthesis);
//        }
//        if (left < n) f(list, left + 1, right, parenthesis + "(", n);
//        if (right < left) f(list, left, right + 1, parenthesis + ")", n);
//    }

    public void f(int i,int left,int n,List<String> ans,char[] path){
        if(i == n * 2){
            ans.add(String.valueOf(path));
        }
        if(left < n){
            path[i] =  '(';
            f(i+1,left + 1,n,ans,path);
        }
        if(i - left < left){
            path[i] =  ')';
            f(i+1,left,n,ans,path);
        }
    }
}
