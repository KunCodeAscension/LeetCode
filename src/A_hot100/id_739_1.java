package A_hot100;

import java.util.ArrayDeque;
import java.util.Deque;

public class id_739_1 {
    /**
     * 单调栈-从左到右
     */
    public int[] dailyTemperatures1(int[] temperatures) {
        int n = temperatures.length;
        int[] res = new int[n];
        Deque<Integer> stack = new ArrayDeque<>(n);
        for (int i = 0; i < n; i++) {
            // 如果当前元素比栈顶元素大，那么即可更新栈顶元素的答案
            while (!stack.isEmpty() && temperatures[i] > temperatures[stack.peek()]) {
                Integer pop = stack.pop();
                res[pop] = i - pop;
            }
            stack.push(i);
        }
        return res;
    }

    /**
     * 单调栈-从右到左
     */
    public int[] dailyTemperatures2(int[] temperatures) {
        int n = temperatures.length;
        int[] res = new int[n];
        Deque<Integer> stack = new ArrayDeque<>(n);
        for (int i = n - 1; i >= 0; i--) {
            int t = temperatures[i];
            // 删除到不用的元素，直到找到一个比当前元素大的
            while (!stack.isEmpty() && t >= temperatures[stack.peek()]) {
                stack.pop();
            }
            // 更新当前答案
            if (!stack.isEmpty()) {
                res[i] = stack.peek() - i;
            }
            // 入栈
            stack.push(i);
        }
        return res;
    }

}
