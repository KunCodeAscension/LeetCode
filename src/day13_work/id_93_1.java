package day13_work;

import java.util.ArrayList;
import java.util.List;

public class id_93_1 {
    private List<String> ans = new ArrayList<>();
    private List<String> path = new ArrayList<>();
    private char[] s;

    public List<String> restoreIpAddresses(String s) {
        this.s = s.toCharArray();
        f(0,0,s);
        return ans;
    }

    public void f(int start,int end,String all){
        if(path.size() == 4 && end == s.length){
            ans.add(String.join(".", path));
            return;
        }
        if(end == s.length){
            return;
        }
        // 不选
        if(end < s.length - 1){
            f(start, end + 1,all);
        }
        // 选
        if(isAdd(start,end)){
            path.add(all.substring(start,end+1));
            f(end+1,end+1,all);
            path.remove(path.size()-1);
        }
    }

    public boolean isAdd(int start,int end){
        if(s[start] == '0' && start != end){
            return false;
        }
        long num = 0;
        for(int i = start; i <= end; i++){
            num = num * 10 + s[i] - '0';
        }
        return num <= 255;
    }

}
