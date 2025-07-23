package A_hot100;

import java.util.*;

/**
 * 先构成一个带权的无向图，在深度优先遍历图
 */
public class id_399_1 {
    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        Map<String,Map<String,Double>> map = new HashMap<>();
        for (int i = 0; i < equations.size(); i++) {
            String a = equations.get(i).get(0);
            String b = equations.get(i).get(1);
            Double value = values[i];
            if (!map.containsKey(a)) {
                map.put(a, new HashMap<>());
            }
            if (!map.containsKey(b)) {
                map.put(b, new HashMap<>());
            }
            map.get(a).put(b, value);
            map.get(b).put(a, 1 / value);
            map.get(a).put(a, 1.0);
            map.get(b).put(b, 1.0);
        }
        // dfs
        int m = queries.size();
        double[] res = new double[m];
        Arrays.fill(res, -1.0);
        Set<String> visited;
        for (int i = 0; i < queries.size(); i++) {
            String qx = queries.get(i).get(0);
            String qy = queries.get(i).get(1);
            if (!map.containsKey(qx) || !map.containsKey(qy)) continue;
            visited = new HashSet<>();
            visited.add(qx);
            res[i] = dfs(qx,qy,1.0,map,visited);
        }
        return res;
    }

    public double dfs(String node,String qy,double mul,Map<String,Map<String,Double>> map,Set<String> visited) {
        if (node.equals(qy)) return mul;
        double res = -1;
        visited.add(node);
        for (Map.Entry<String, Double> entry : map.get(node).entrySet()) {
            String key = entry.getKey();
            Double value = entry.getValue();
            if (!visited.contains(key)) {
                res = dfs(key,qy,mul * value ,map,visited);
            };
            if(res != -1) break;
        }
        return res;
    }
}
