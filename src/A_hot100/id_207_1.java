package A_hot100;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 本题是先构成一个有向图，然后寻找这个有向图是否有拓扑排序
 * 本题采用三染色法 把每一个节点标记为三种状态 0：未被访问 1：正在被访问 2：访问完了
 * 如果在递归调用的过程中发现访问的节点正在被访问，说明存在环（即不存在拓扑排序）
 */
public class id_207_1 {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        List<Integer>[] g = new ArrayList[numCourses];
        Arrays.setAll(g, i -> new ArrayList<Integer>());
        int[] color = new int[numCourses];
        for (int[] prerequisite : prerequisites) {
            g[prerequisite[1]].add(prerequisite[0]);
        }

        for (int i = 0; i < numCourses; i++) {
            if(color[i] == 0 && dfs(i, g, color)){
                return false;
            }
        }
        return true;  // 没有环
    }

    public boolean dfs(int x,List<Integer>[] g,int[] color) {
        color[x] = 1;
        for (Integer y : g[x]) {
            if(color[y] == 1 || (color[y] == 0 && dfs(y, g, color))){
                return true; // 有环
            }
        }
        color[x] = 2;
        return false;  // 无
    }
}
