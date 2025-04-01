package day18;

import java.util.Arrays;

// 72. 编辑距离
// https://leetcode.cn/problems/edit-distance/description/
// 解题思路来自：灵茶山艾府
// https://www.bilibili.com/video/BV1TM4y1o7ug?t=486.0

/**
 *  s = hourse
 *  t = ros
 *  最后一个字母不同 可以删去s 最后一个字母 考虑 s[i-1] t[j]
 *                插入一个字母 表示删除t一个字母 考虑 s[i] t[j-1]
 *                替换该字母 考虑 s[i-1] t[j-1]
 *  两个字母相同 考虑 s[i-1] t[j-1]
 */

public class id_72_1 {
    private char[] s;
    private char[] t;
    private int[][] cache;

    public int minDistance(String word1, String word2) {
        this.s = word1.toCharArray();
        this.t = word2.toCharArray();
        int m = s.length, n = t.length;
        cache = new int[m][n];
        for (int[] row : cache) {
            Arrays.fill(row, -1); // -1 表示还没有计算过
        }
        return dfs(m-1, n-1);
    }

    public int dfs(int i,int j){
        if(i<0) return j + 1;
        if(j<0) return i + 1;
        if(cache[i][j] != -1) return cache[i][j];
        if(s[i] == t[j]) return cache[i][j] = dfs(i-1,j-1);
        return cache[i][j] = Math.min(Math.min(dfs(i-1,j),dfs(i,j-1)),dfs(i-1,j-1)) + 1;
    }
}
