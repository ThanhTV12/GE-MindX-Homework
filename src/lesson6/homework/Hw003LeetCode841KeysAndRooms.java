package lesson6.homework;

import general.AdjListGraph;

import java.util.ArrayList;
import java.util.List;

public class Hw003LeetCode841KeysAndRooms {
    class Solution {
        public boolean canVisitAllRooms(List<List<Integer>> rooms) {
            List<List<Integer>> adjListOfRooms = tranformToAdjList(rooms);
            AdjListGraph roomsGraph = new AdjListGraph(adjListOfRooms);
            int numberGroupOfConntedRooms = roomsGraph.countTheNumberOfComponents();
            if (numberGroupOfConntedRooms < 2) {
                return true;
            }
            return false;
        }

        private List<List<Integer>> tranformToAdjList(List<List<Integer>> rooms) {
            List<List<Integer>> adjList = new ArrayList();
            for (int i = 0; i < rooms.size(); i++) {
                List<Integer> adj = new ArrayList();
                for (int key : rooms.get(i)) {
                    if (!adj.contains(key)) {
                        adj.add(key);
                    }
                }
                adjList.add(adj);
            }
            return adjList;
        }
    }
}
