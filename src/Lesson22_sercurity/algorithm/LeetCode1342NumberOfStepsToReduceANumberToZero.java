package Lesson22_sercurity.algorithm;

public class LeetCode1342NumberOfStepsToReduceANumberToZero {
    class Solution {
        public int numberOfSteps(int num) {
            int count = 0;
            while(num > 0) {
                int mod = num % 2;
                if(mod == 0) {
                    num = num / 2;
                } else {
                    num -= 1;
                }
                count++;
            }
            return count;
        }
    }
}
