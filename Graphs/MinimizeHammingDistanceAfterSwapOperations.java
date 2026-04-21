// LeetCode 1722 - Minimize Hamming Distance After Swap Operations
// Time Complexity: O(n * alpha(n)) | Space Complexity: O(n)
import java.util.HashMap;
import java.util.Map;

public class MinimizeHammingDistanceAfterSwapOperations {
    public int minimumHammingDistance(int[] source, int[] target, int[][] allowedSwaps) {
        int n = source.length;
        UnionFind uf = new UnionFind(n);

        for (int[] swap : allowedSwaps) {
            uf.union(swap[0], swap[1]);
        }

        Map<Integer, Map<Integer, Integer>> componentCounts = new HashMap<>();
        for (int i = 0; i < n; i++) {
            int root = uf.find(i);
            componentCounts
                .computeIfAbsent(root, key -> new HashMap<>())
                .merge(source[i], 1, Integer::sum);
        }

        int distance = 0;
        for (int i = 0; i < n; i++) {
            int root = uf.find(i);
            Map<Integer, Integer> counts = componentCounts.get(root);
            int available = counts.getOrDefault(target[i], 0);

            if (available > 0) {
                counts.put(target[i], available - 1);
            } else {
                distance++;
            }
        }

        return distance;
    }

    private static class UnionFind {
        private final int[] parent;
        private final int[] rank;

        UnionFind(int size) {
            parent = new int[size];
            rank = new int[size];
            for (int i = 0; i < size; i++) {
                parent[i] = i;
            }
        }

        int find(int value) {
            if (parent[value] != value) {
                parent[value] = find(parent[value]);
            }
            return parent[value];
        }

        void union(int a, int b) {
            int rootA = find(a);
            int rootB = find(b);
            if (rootA == rootB) {
                return;
            }

            if (rank[rootA] < rank[rootB]) {
                parent[rootA] = rootB;
            } else if (rank[rootA] > rank[rootB]) {
                parent[rootB] = rootA;
            } else {
                parent[rootB] = rootA;
                rank[rootA]++;
            }
        }
    }
}
