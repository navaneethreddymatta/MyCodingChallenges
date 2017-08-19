package nav.amazon;

import java.util.Iterator;
import java.util.LinkedList;

public class BFSTraversal {

    private int numVertices, currentNode, nextNode;
    private LinkedList<Integer> adj[];
    private LinkedList<Integer> queue;
    private boolean[] visited;

    public BFSTraversal(int numVertices) {
        this.numVertices = numVertices;
        adj = new LinkedList[numVertices];
        for(int i = 0; i < numVertices; i++)
            adj[i] = new LinkedList<>();
        visited = new boolean[numVertices];
    }

    public static void main(String[] args) {

        BFSTraversal g = new BFSTraversal(6);
        g.addEdge(1, 2);
        g.addEdge(1, 3);
        g.addEdge(2, 4);
        g.addEdge(2, 5);
        g.addEdge(3, 5);
        g.addEdge(4, 5);
        g.addEdge(4, 6);
        g.addEdge(5, 6);

        System.out.println("Following is Breadth First Traversal (starting from vertex 1)");

        g.BFS(1);
    }

    public void addEdge(int src, int dest) {
        adj[src - 1].add(dest);
    }

    public void BFS(int startVertex) {
        queue = new LinkedList<>();
        queue.add(startVertex);
        visited[startVertex - 1] = true;
        while(!queue.isEmpty()) {
            currentNode = queue.poll();
            System.out.print(currentNode + " ");
            Iterator<Integer> itr = adj[currentNode-1].iterator();
            while(itr.hasNext()) {
                nextNode = itr.next();
                if(!visited[nextNode - 1]) {
                    visited[nextNode - 1] = true;
                    queue.add(nextNode);
                }
            }
        }
    }
}
