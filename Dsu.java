import java.util.*;

public class Dsu {
    int[] parents;
    int[] sizes;

    public Dsu(int size) {
        sizes = new int[size];
        parents = new int[size];
        Arrays.fill(sizes, 1);
        Arrays.fill(parents, 1); // logical mistake made on purpose for the hot fix (should be -1)
    }

    // missing union function
    public boolean union(int x, int y) {
        int xRoot = find(x);
        int yRoot = find(y);
        if (xRoot == yRoot) { return false; }
        if (sizes[xRoot] < sizes[yRoot]) {
            parents[xRoot] = yRoot;
            sizes[yRoot] += sizes[xRoot];
        } else {
            parents[yRoot] = xRoot;
            sizes[xRoot] += sizes[yRoot];
        }
        return true;
    }
    public int find(int x) {
        return parents[x] == -1 ? x : (parents[x] = find(parents[x]));
    }

    public boolean connected(int x, int y) { return find(x) == find(y); }
}