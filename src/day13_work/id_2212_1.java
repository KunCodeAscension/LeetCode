package day13_work;

import java.util.Arrays;

public class id_2212_1 {
    private int[] bobArrows = new int[12];

    int[] ans;

    private int MaxNUM = 0;

    public int[] maximumBobPoints(int numArrows, int[] aliceArrows) {
        f(0,numArrows,0,aliceArrows);
        return ans;
    }

    public void f(int i,int numArrows,int num,int[] aliceArrows){
        if(i == 11 && numArrows != 0){
            bobArrows[11] += numArrows;
            if(bobArrows[11] > aliceArrows[11]){
                num += 11;
            }
            MaxNUM = Math.max(MaxNUM, num);
            if(num == MaxNUM){
                ans = Arrays.copyOf(bobArrows, bobArrows.length);
            }
            // 回溯
            bobArrows[11] -= numArrows;
            return;
        }
        if(numArrows==0){
            MaxNUM = Math.max(MaxNUM, num);
            if(num == MaxNUM){
                ans = Arrays.copyOf(bobArrows, bobArrows.length);
            }
            return;
        }
        // 不选
        f(i+1,numArrows,bobArrows[i] > aliceArrows[i] ? num + i : num,aliceArrows);
        // 选
        int count = 0;
        while (bobArrows[i] <= aliceArrows[i] && count < numArrows) {
            bobArrows[i] += 1;
            count++;
        }
        f(i+1,numArrows-count,bobArrows[i] > aliceArrows[i] ? num + i : num,aliceArrows);
        // 回溯
        bobArrows[i] -= count;
    }
}
