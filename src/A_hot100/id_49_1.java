package A_hot100;

import java.util.*;
import java.util.function.BiFunction;
import java.util.function.Function;

public class id_49_1 {
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String,List<String>> map = new HashMap<>();
        for (String s : strs) {
            char[] chars = s.toCharArray();
            Arrays.sort(chars);
            map.computeIfAbsent(Arrays.toString(chars), k -> new ArrayList<>()).add(s);
        }
        List<List<String>> ans = new ArrayList<>();
        for (Map.Entry<String,List<String>> entry : map.entrySet()) {
            List<String> list = entry.getValue();
            ans.add(list);
        }
        return ans;
    }
}
