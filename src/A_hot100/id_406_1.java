package A_hot100;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class id_406_1 {
    /**
     * 体育上课时老师对学生按照规则进行了排序但是学生们还是忘了
     * [7,0],[4,4],[7,1],[5,0],[6,1],[5,2]
     * 先按照身高进行排序，身高一样的，比自己高的越多，越往后面站，像这样：
     * [7,0],[7,1],[6,1],[5,0],[5,2],[4,4]
     * 然后开始排序
     * [[7,0]]
     * [7,1] 看自己和第一个身高一样，并且前面还有一个人大于等于自己的身高，所以站在第二位
     * [[7,0],[7,1]]
     * [6,1] 看自己比前两个身高都小，但是前面有一个人的身高大于等于自己，所以站在第二位
     * [[7,0],[6,1],[7,1]]
     * [5,0] 看自己比前面所有人的身高都小，但是前面没有一个人身高大于自己，所以站在第一位
     * [5,0],[7,0],[6,1],[7,1]]
     * ......
     * list.add(person[1], person);
     */
    public int[][] reconstructQueue(int[][] people) {
        Arrays.sort(people, new Comparator<int[]>() {
            public int compare(int[] o1, int[] o2) {
                if (o1[0] == o2[0]) return o1[1] - o2[1];
                return o2[0] - o1[0];
            }
        });
        List<int[]> list = new ArrayList<>();
        for (int[] person : people) {
            list.add(person[1], person);
        }
        return list.toArray(new int[people.length][]);
    }
}
