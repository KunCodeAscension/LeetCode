package day1;

public class id_167_1 {
    public int[] twoSum(int[] numbers, int target) {
        int right = numbers.length - 1;
        int left = 0;
        while (left < right) {
            if (numbers[left] + numbers[right] == target) {
                break;
            }
            else if (numbers[left] + numbers[right] < target) {
                left++;
            }
            else {
                right--;
            }
        }
        return new int[]{left + 1, right + 1};
    }
}
