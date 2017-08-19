package nav.amazon;

import java.util.*;

public class TopologicalSort {

    private int numVertices, counter, index;
    private LinkedList<Character> adj[];
    private List<Character> visited;
    private Stack<Character> result;

    private TreeMap<Character, Integer> vertexMap;

    public TopologicalSort(int numVertices) {
        this.numVertices = numVertices;
        adj = new LinkedList[numVertices];
        visited = new ArrayList<>();
        result = new Stack<>();
        vertexMap = new TreeMap<>();
        counter = 0;
        index = 0;
        for(int i = 0; i < numVertices; i++)
            adj[i] = new LinkedList<>();
    }

    public static void main(String[] args) {

        TopologicalSort g = new TopologicalSort(8);
        g.addEdge('a', 'c');
        g.addEdge('b', 'c');
        g.addEdge('c', 'e');
        g.addEdge('b', 'd');
        g.addEdge('e', 'h');
        g.addEdge('e', 'f');
        g.addEdge('d', 'f');
        g.addEdge('f', 'g');

        System.out.println("Following is Topological Sort (starting from vertex a)");
        g.topSort('a');
    }

    public void addEdge(char src, char dest) {
        if(vertexMap.get(src) == null)
            vertexMap.put(src, counter++);
        if(vertexMap.get(dest) == null)
            vertexMap.put(dest, counter++);
        adj[vertexMap.get(src)].add(dest);
    }

    public char getUnvisitedNode() {
        for(Character c : vertexMap.keySet()) {
            if(!result.contains(c)) {
                return c;
            }
        }
        return 'a';
    }

    public void topSort(char ch) {
        while(result.size() < numVertices) {
            topSortUtil(ch);
            ch = getUnvisitedNode();
        }
        while(!result.empty()) {
            System.out.print(result.pop() + " ");
        }
    }

    public void topSortUtil(char ch) {
        char currentChar;
        Iterator<Character> itr;
        //System.out.println("sort " + ch);
        visited.add(ch);
        itr = adj[vertexMap.get(ch)].iterator();
        while(itr.hasNext()) {
            currentChar = itr.next();
            //System.out.println("Child " + currentChar);
            if(!visited.contains(currentChar)) {
                topSortUtil(currentChar);
                //System.out.println("Sorted " + currentChar);
            }
        }
        result.add(ch);
    }
}
