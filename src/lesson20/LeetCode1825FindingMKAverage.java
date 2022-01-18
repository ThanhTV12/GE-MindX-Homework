package lesson20;

import java.util.*;

public class LeetCode1825FindingMKAverage {


//    ["MKAverage","addElement","addElement","addElement","addElement","addElement","addElement","calculateMKAverage"]
//            [[6,1],[3],[1],[12],[5],[3],[4],[]]
    public static void main(String[] args) {
        MKAverage obj = new MKAverage(6, 1);
        obj.addElement(3);        // current elements are [3]
        obj.addElement(1);        // current elements are [3,1]
        int v1 = obj.calculateMKAverage();// return -1, because m = 3 and only 2 elements exist.
        obj.addElement(12);       // current elements are [3,1,10]
        int v2 = obj.calculateMKAverage(); // The last 3 elements are [3,1,10].
        // After removing smallest and largest 1 element the container will be [3].
        // The average of [3] equals 3/1 = 3, return 3
        obj.addElement(5);        // current elements are [3,1,10,5]
        obj.addElement(3);        // current elements are [3,1,10,5,5]
        obj.addElement(4);        // current elements are [3,1,10,5,5,5]
        int v3 = obj.calculateMKAverage(); // The last 3 elements are [5,5,5].
        // After removing smallest and largest 1 element the container will be [5].
        // The average of [5] equals 5/1 = 5, return 5
    }

    static class MKAverage {

        Queue<Integer> queue = new LinkedList();
        TreeMap<Integer, Integer> top = new TreeMap<>();
        TreeMap<Integer, Integer> mid = new TreeMap<>();
        TreeMap<Integer, Integer> bot = new TreeMap<>();
        int lenTop = 0;
        int lenBot = 0;
        int m;
        int k;
        int sum = 0;
        public MKAverage(int m, int k) {
            this.m = m;
            this.k = k;
        }

        public void addElement(int num) {
            queue.add(num);
            if(queue.size() > m) {
                int dropped = queue.remove();
                shirk(dropped);
            }
            balance(num);
        }

        private void balance(int num) {
            add(top, num);
            lenTop++;
            if(lenTop <= k) {
                return;
            }
            int smallestTop = getSmallest(top);
            lenTop--;
            add(bot, smallestTop);
            lenBot++;
            if(lenBot <= k) {
                return;
            }
            int biggestBot = getBiggest(bot);
            lenBot--;
            add(mid, biggestBot);
            sum += biggestBot;
        }

        private void shirk(int num) {
            if(top.containsKey(num)) {
                remove(top, num);
                lenTop--;
                Integer biggestMid = getBiggest(mid);
                sum -= biggestMid;
                if(biggestMid != null) {
                    add(top, biggestMid);
                    lenTop++;
                }
            } else if(bot.containsKey(num)) {
                remove(bot, num);
                lenBot--;
                Integer smallestMid = getSmallest(mid);
                sum -= smallestMid;
                if(smallestMid != null) {
                    add(bot, smallestMid);
                    lenBot++;
                }
            } else {
                remove(mid, num);
                sum -= num;
            }
        }

        private void remove(TreeMap<Integer, Integer> tm, int num) {
            if(!tm.containsKey(num)) {
                return;
            }
            if(tm.get(num) == 1) {
                tm.remove(num);
                return;
            }
            tm.put(num, tm.get(num) - 1);
        }

        private void add(TreeMap<Integer, Integer> tm, int num) {
            if(tm.containsKey(num)) {
                tm.put(num, tm.get(num) + 1);
                return;
            }
            tm.put(num,1);
        }

        private Integer getSmallest(TreeMap<Integer, Integer> tm) {
            Integer num = tm.firstKey();
            if(num == null) {
                return null;
            }
            remove(tm, num);
            return num;
        }

        private Integer getBiggest(TreeMap<Integer, Integer> tm) {
            Integer num = tm.lastKey();
            if(num == null) {
                return null;
            }
            remove(tm, num);
            return num;
        }

        public int calculateMKAverage() {
            if(queue.size() < m) {
                return -1;
            }
            return sum / (m - 2 * k);
        }
    }
}
