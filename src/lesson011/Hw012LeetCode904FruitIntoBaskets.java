package lesson011;

import java.util.HashMap;
import java.util.Map;

public class Hw012LeetCode904FruitIntoBaskets {
    class Solution {
        public int totalFruit(int[] fruits) {
            int left = 0;
            int right = 0;
            int res = 0;
            Map<Integer, Integer> tracker = new HashMap();
            while(right < fruits.length) {
                if(tracker.size() < 2 || tracker.containsKey(fruits[right])) {
                    tracker.put(fruits[right], right);
                    int length = right - left + 1;
                    if(res < length) {
                        res = length;
                    }
                    right++;
                } else {
                    while(true) {
                        if(tracker.get(fruits[left]) == left) {
                            tracker.remove(fruits[left]);
                            left++;
                            break;
                        }
                        left++;
                    }
                    tracker.put(fruits[right], right);
                }
            }
            return res;
        }
    }
}
