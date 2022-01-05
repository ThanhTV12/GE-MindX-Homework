package lesson19;

import java.util.HashMap;
import java.util.Map;

public class LeetCode146LRUCache {

    public static void main(String[] args) {
        LRUCache lruCache = new LRUCache(2);
        lruCache.put(1, 1);
        lruCache.put(2, 2);
        int i = lruCache.get(2);
        int i2 = lruCache.get(3);
        lruCache.put(3, 3);
        int i3 = lruCache.get(3);
        int ix = lruCache.get(1);
    }

    static class LRUCache {
        Map<Integer, DLL> cache;
        int capacity;
        DLL start;
        DLL end;
        public LRUCache(int capacity) {
            cache = new HashMap(capacity);
            this.capacity = capacity;
        }

        public int get(int key) {
            if(cache.containsKey(key)) {
                DLL node = cache.get(key);
                putValueToEnd(node);
                return node.data;
            }
            return -1;
        }

        public void put(int key, int value) {
            DLL nodeValue = new DLL();
            nodeValue.data = value;
            if(start == null) {
                start = nodeValue;
            }
            if(end == null) {
                end = nodeValue;
                cache.put(key, end);
                return;
            }
            if(cache.containsKey(key)) {
                DLL temp = cache.get(key);
                putValueToEnd(temp);
            }  else {
                cache.put(key, nodeValue);
                addNewNode(nodeValue);
            }
        }

        private void putValueToEnd(DLL node) {
            if(start == node && node.next != null) {
                start = node.next;
            }
            if(node.prev != null) {
                node.prev.next = node.next;
            }
            if(node.next != null) {
                node.next.prev = node.prev;
            }
            end.next = node;
            node.prev = end;
            end = node;
        }

        private void addNewNode(DLL node) {
            end.next = node;
            node.prev = end;
            end = node;
            if(cache.size() > capacity) {
                cache.remove(start.data);
                start = start.next;
                start.prev = null;
            }
        }
    }

    static class DLL {
        public Integer data;
        public DLL next;
        public DLL prev;
    }

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */
}
