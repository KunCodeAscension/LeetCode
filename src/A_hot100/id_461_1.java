package A_hot100;

public class id_461_1 {
    public int hammingDistance(int x, int y) {
        int num = x ^ y;
        int count = 0;
        while (num != 0) {
            int i = num & 1;
            if (i == 1) count++;
            num >>>= 1;
        }
        return count;
    }
}
