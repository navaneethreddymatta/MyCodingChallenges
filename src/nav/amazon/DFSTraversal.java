package nav.amazon;

import java.util.Iterator;
import java.util.LinkedList;

public class DFSTraversal {

    private int numVertices;
    private LinkedList<Integer> adj[];

    public DFSTraversal(int numVertices) {
        this.numVertices = numVertices;
        adj = new LinkedList[numVertices];
        for(int i = 0; i < numVertices; i++)
            adj[i] = new LinkedList<>();
    }

    void addEdge(int src, int dest) {
        adj[src-1].add(dest);
    }

    void DFS(int startVertex) {
        boolean visited[] = new boolean[numVertices];
        DFSUtil(startVertex, visited);
    }

    void DFSUtil(int startVertex, boolean[] visited) {
        visited[startVertex - 1] = true;
        System.out.print(startVertex + " ");
        Iterator<Integer> itr = adj[startVertex-1].iterator();
        while (itr.hasNext()) {
            int n = itr.next();
            if(!visited[n - 1])
                DFSUtil(n, visited);
        }
    }

    public static void main(String[] args) {
        DFSTraversal g = new DFSTraversal(6);
        g.addEdge(1, 2);
        g.addEdge(1, 3);
        g.addEdge(2, 4);
        g.addEdge(2, 5);
        g.addEdge(3, 5);
        g.addEdge(4, 5);
        g.addEdge(4, 6);
        g.addEdge(5, 6);

        System.out.println("Following is Depth First Traversal (starting from vertex 1)");

        g.DFS(1);
    }
}
