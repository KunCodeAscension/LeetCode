package day15_work;

public class id_357_1 {


    public int countNumbersWithUniqueDigits(int n) {
        if(n==0) return 1;
        int ans = 9,count = 9;
        for(int i=2;i<=n;i++) {
            count*=(11-i);
            ans+=count;
        }
        return ans + 1;
    }

}
