package A_hot100;

/**
 * 插旗法，把一块连续的岛屿上都插满旗
 * 1 1 0 0 0
 * 1 1 0 0 0
 * 0 0 1 0 0
 * 0 0 0 1 1
 * 遍历到第一个的时候通过递归，把第一块岛全部插满旗
 * 2 2 0 0 0
 * 2 2 0 0 0
 * 0 0 1 0 0
 * 0 0 0 1 1
 */
public class id_200_1 {
    public int numIslands(char[][] grid) {
        int count = 0;
        int m = grid.length;
        int n = grid[0].length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == '1') {
                    dfs(grid,i, j);
                    count++;
                }
            }
        }
        return count;
    }

    public void dfs(char[][] grid,int i,int j) {
        if(grid[i][j] != '1') return;
        grid[i][j] = '2';
        if(!(i+1 >= grid.length))  dfs(grid,i+1,j);
        if(!(j+1 >= grid[0].length))  dfs(grid,i,j+1);
        if(!(j - 1 < 0)) dfs(grid,i,j-1);
        if(!(i - 1 < 0)) dfs(grid,i-1,j);
    }
}
