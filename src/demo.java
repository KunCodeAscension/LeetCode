import day19.id_300_1;

public class demo {
    public static void main(String[] args) {
        // 创建 id_300_1 类的对象
        id_300_1 lis = new id_300_1();
        // 定义一个数组
        int[] nums = {1,6,7,2,3,4,5,3};
        // 调用 lengthOfLIS 方法
        int result = lis.lengthOfLIS(nums);
        // 输出结果
        System.out.println("最长递增子序列的长度是: " + result);
    }
}
