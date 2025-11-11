package A_hot100;

import java.util.Scanner;

public class id_79 {
        private char[] arr;
        private int row;
        private int col;
        private boolean[][] used;

        public boolean exist(char[][] board, String word) {
            this.used = new boolean[board.length][board[0].length];
            this.row = board.length;
            this.col = board[0].length;
            this.arr = word.toCharArray();
            for(int i = 0; i < board.length; i++){
                for(int j = 0; j < board[0].length; j++){
                    if(board[i][j] == arr[0] && dfs(board,i,j,0)){
                        return true;
                    }
                }
            }
            return false;
        }

        public boolean dfs(char[][] board, int i, int j,int n){
            if(i >= this.row || j >= this.col || i < 0 || j < 0 || used[i][j]) return false;
            if(n >= this.arr.length || board[i][j] != arr[n]) return false;
            if(n == this.arr.length - 1 && !used[i][j]) return true;
            used[i][j] = true;
            boolean result = dfs(board,i+1,j,n + 1) || dfs(board,i-1,j,n + 1) || dfs(board,i,j+1,n + 1) || dfs(board,i,j-1,n + 1);
            used[i][j] = false;
            return result;
        }
}
