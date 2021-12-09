package Lesson15.Trie;

import java.util.*;

public class Hw008LeetCode1233RemoveSubFoldersFromTheFilesystem {
    public static void main(String[] args) {
        Solution solution = new Solution();
        String[] folders = new String[] {"/a","/a/b","/c/d","/c/d/e","/c/f"};
        List<String> strings = solution.removeSubfolders(folders);
    }

    static class Solution {

        private TrieNode root = new TrieNode();
        public List<String> removeSubfolders(String[] folder) {
            insert(folder);
            return getParentsByDFS(root);
        }

        private void insert(String[] folder) {
            for(String f : folder) {
                String[] names = f.split("/");
                TrieNode cur = root;
                for(String name : names) {
                    if(cur.isFolder) {
                        break;
                    }
                    if("".equals(name)) {
                        continue;
                    }
                    if(!cur.children.containsKey(name)) {
                        TrieNode child = new TrieNode();
                        cur.children.put(name, child);
                        cur = child;
                    } else {
                        cur = cur.children.get(name);
                    }
                }
                cur.isFolder = true;
            }
        }


        //private List<String> res = new ArrayList();
        private List<String> getParentsByDFS(TrieNode cur) {
            if(cur == null) {
                return Collections.EMPTY_LIST;
            }
            if(cur.isFolder) {
                return Collections.EMPTY_LIST;
            }
            List<String> res = new ArrayList();
            for(String name : cur.children.keySet()) {
                System.out.println(name);
                List<String> resRecurs =  getParentsByDFS(cur.children.get(name));
                if(resRecurs.isEmpty()) {
                    res.add("/" + name);
                    continue;
                }
                for(String resRecur : resRecurs) {
                    res.add("/" + name + resRecur);
                }
            }
            return res;
        }

    }


    static class TrieNode {
        public Map<String, TrieNode> children = new HashMap();
        public boolean isFolder = false;
    }
}
