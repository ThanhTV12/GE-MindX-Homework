package lesson17.dynamic_program;

public class Hw007LeetCode583DeleteOperationsForTwoStrings {
    // DP find the longest common string (the character is not required continuously)
// the minimum steps = word1.lengh + word2.length - 2 * longest

// Step 1: Identify state => longest[i][j] => the longest common string at i-th of word1 and at i-th of word2
// Step 2: Find relationship between longest[i][j] and the their subproblems
// if(word1[i] == word2[j]) {
//      longest[i][j] = longest[i - 1][j - 1] + 1
//} else {
//      longest[i][j] = Max(longest[i][j - 1], longest[i - 1][j])
//}


    class Solution {
        public int minDistance(String word1, String word2) {
            int[][] longest = new int[word1.length()][word2.length()];
            //Buttom - up
            for(int i = 0; i < word1.length(); i++) {
                for(int j = 0; j < word2.length(); j++) {
                    char cI = word1.charAt(i);
                    char cJ = word2.charAt(j);
                    if(cI == cJ) {
                        if(i * j == 0) {
                            longest[i][j] = 1;
                        } else {
                            longest[i][j] = longest[i - 1][j - 1] + 1;
                        }
                    } else {
                        if(i + j == 0) {
                            longest[i][j] = 0;
                        } else if(i == 0) {
                            longest[i][j] = longest[i][j - 1];
                        } else if(j == 0) {
                            longest[i][j] = longest[i - 1][j];
                        } else {
                            longest[i][j] = Math.max(longest[i - 1][j], longest[i][j - 1]);
                        }
                    }
                }
            }
            return word1.length() + word2.length() - 2 * longest[word1.length() - 1][word2.length() - 1];
        }
    }
}
