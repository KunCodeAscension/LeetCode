import java.util.ArrayList;
import java.util.List;

public class demo {
    private static List<List<Integer>> res = new ArrayList<List<Integer>>();

    private static List<Integer> path = new ArrayList<>();

    private static int [][] nums = new int [][]{{1,2,3},{7,8,9}};

    public static void main(String[] args) {
        f(0);
        System.out.println(res);
    }

    public static void f(int i){
        if (path.size() == 2){
            res.add(new ArrayList<>(path));
            return;
        }
        for(int j = i;j < nums[0].length;j++){
            path.add(j);
            f(j + 1);
            path.remove(path.size() - 1);
        }
    }
}
