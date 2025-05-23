package day13_work;

import java.util.ArrayList;
import java.util.List;

public class id_1379_1 {
    private List<String> path = new ArrayList<>(2);

    private int num = 0;

    public int maxLength(List<String> arr) {
        f(0,arr);
        return num;
    }

    public void f(int i,List<String> arr){
        String s = String.join("", path);
        if(isUnique(s)){
            num = Math.max(num,s.length());
        }
        for(int j = i;j < arr.size();j++){
            path.add(arr.get(j));
            f(j+1,arr);
            path.remove(path.size()-1);
        }
    }

    private boolean isUnique(String s) {
        int[] cnt = new int[26];
        for (char c : s.toCharArray()) {
            cnt[c - 'a']++;
            if (cnt[c - 'a'] > 1) return false;
        }
        return true;
    }

}
