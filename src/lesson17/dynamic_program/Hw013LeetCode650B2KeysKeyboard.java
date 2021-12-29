package lesson17.dynamic_program;

public class Hw013LeetCode650B2KeysKeyboard {
    class Solution {
        int[] steps;
        public int minSteps(int n) {
            if(n == 1) {
                return 0;
            }
            steps = new int[n + 1];
            return recur(n);
        }

        public int recur(int n) {
            if(steps[n] != 0) {
                return steps[n];
            }
            int devideBy = n - 1;
            int step = n;
            while(devideBy > 1) {
                if(n % devideBy == 0) {
                    step = Math.min(step, recur(devideBy) + (n / devideBy));
                }
                devideBy--;
            }
            return step;
        }
    }
}
