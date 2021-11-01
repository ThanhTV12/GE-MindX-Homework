package lesson003.onclass;

import java.util.HashMap;
import java.util.Map;

public class CountingSort extends Common {

    final static int MAX = 100;

    public static void main(String[] args) {
        int[] nums = new int[] {30, 10, 20, 50, 0, 90, 40, 70, 60};
        int[] sorted = countingSort(nums);
    }

    private static int[] countingSort(int[] nums) {
        Map<Integer, Integer> countingMap = new HashMap<>();
        for(int i = 0; i < nums.length; i++) {
            if(countingMap.containsKey(nums[i])) {
                countingMap.put(nums[i], countingMap.get(nums[i]) + 1);
            } else {
                countingMap.put(nums[i], 1);
            }
        }
        int numsIndex = 0;
        for(int k = 0; k < MAX; k++) {
            if(!countingMap.containsKey(k)) {
                continue;
            }
            for(int i = 0; i < countingMap.get(k); i++) {
                nums[numsIndex++] = k;
            }
        }
        return nums;
    }
}
