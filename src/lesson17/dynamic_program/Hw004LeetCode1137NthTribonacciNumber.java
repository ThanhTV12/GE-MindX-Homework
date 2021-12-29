package lesson17.dynamic_program;

public class Hw004LeetCode1137NthTribonacciNumber {
    class Solution {
        public int tribonacci(int n) {
            if(n == 0) {
                return 0;
            }
            if(n == 1) {
                return 1;
            }
            int a = 0;
            int b = 1;
            int c = 1;
            int res = c;
            for(int i = 3; i < n + 1; i++) {
                res = a + b + c;
                a = b;
                b = c;
                c = res;
            }
            return res;
        }
    }
}
