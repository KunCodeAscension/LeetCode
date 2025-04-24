package day4_work;

import javax.swing.*;

// https://leetcode.cn/problems/koko-eating-bananas/submissions/624811512/

public class id_875_1 {
    public int minEatingSpeed(int[] piles, int h) {
        int left = 1, right = 0;
        for (int pile : piles) {
            right = Math.max(right, pile);
        }
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if(checkeat(piles, h, mid)) {
                right = mid - 1;
            }else {
                left = mid + 1;
            }
        }
        return left;
    }

    public boolean checkeat(int[] piles, int h, int k) {
        int count = piles.length;
        for (int pile : piles) {
            count += (pile - 1) / k;
            if(count > h) return false;
        }
        return true;
    }
}
