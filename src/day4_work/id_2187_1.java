package day4_work;

public class id_2187_1 {
    public long minimumTime(int[] time, int totalTrips) {
        long left = 1,right = 1;
        for (int i : time) {
            right = Math.max(right, (long) i * totalTrips);
        }
        while (left <= right) {
            long mid = left + (right - left) / 2;
            if(checkBos(time, totalTrips, mid)) {
                right = mid - 1;
            }else {
                left = mid + 1;
            }
        }
        return left;
    }

    public boolean checkBos(int[] time, int totalTrips,long mid) {
        long count = 0;
        for (int i : time) {
            count += mid / i;
            if(count >= totalTrips) return true;
        }
        return false;
    }
}
