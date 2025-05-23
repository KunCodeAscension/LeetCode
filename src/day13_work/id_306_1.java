package day13_work;

import java.util.ArrayList;
import java.util.List;

public class id_306_1 {
    char[] s;
    List<Integer> path = new ArrayList<>();

    public boolean isAdditiveNumber(String num) {
        this.s = num.toCharArray();
        return f(0,0);
    }

    public boolean f(int start, int end) {
        if(path.size() >= 3){
            int endIndex = path.size() - 1;
            if (path.get(endIndex) != path.get(endIndex - 1) + path.get(endIndex - 2)) {
                return false;
            }
        }
        if(end == s.length){
            return path.size() >= 3;
        }
        // 不选
        if(end < s.length - 1){
            if(f(start, end+1)){
                return true;
            }
        }
        // 选
        if(end != start && s[start] == '0'){
            return false;
        }
        int sum = sum(start, end);
        path.add(sum);
        if(f(end+1, end+1)){
            return true;
        }
        path.remove(path.size() - 1);
        return false;
    }

    public int sum(int start, int end) {
        StringBuilder num = new StringBuilder();
        for(int i = start;i <= end;i++){
            num.append(s[i]);
        }
        return Integer.parseInt(num.toString());
    }

}
