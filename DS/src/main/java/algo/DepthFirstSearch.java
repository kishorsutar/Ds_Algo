package algo;

import java.util.*;

public class DepthFirstSearch {

//        public Map<Integer,  List<Edge>> graph = new HashMap<Integer, List<Edge>>();

    static class Edge {
        int from;
        int to;
        int weight;
        public Edge (int from, int to, int weight) {
            this.from = from;
            this.to = to;
            this.weight = weight;
        }
    }

    static void addDirectedEdge(int vertices, Edge edge, Map<Integer, List<Edge>> graph) {
        List<Edge> list = graph.get(vertices);
        if (list == null) {
            list = new ArrayList<Edge>();
            graph.put(vertices, list);
        }
        list.add(edge);
    }

    public static void main(String[] args) {
        Map<Integer, List<Edge>> graph = new HashMap<Integer, List<Edge>>();
        addDirectedEdge(0, new Edge(0, 1, 4), graph);
        addDirectedEdge(0, new Edge(0, 2, 5), graph);
        addDirectedEdge(1, new Edge(1, 3, -2), graph);
        addDirectedEdge(2, new Edge(2, 4, 4), graph);
        addDirectedEdge(3, new Edge(3, 1, 4), graph);

        System.out.println("Result" + dfs(graph, 5, 0)); // no of nodes and starting node
    }

    /** Gives total number of nodes in the graph using depth first search
     *   this is adjacency list method
     */
    static int dfs(Map<Integer, List<Edge>> graph, int n, int start) {

        int count = 0;
        Stack<Integer> stack = new Stack<Integer>();
        boolean[] visited = new boolean[n];

// start by visiting starting node
        stack.push(start);
        visited[start] = true;

        while (!stack.isEmpty()) {
            int vertice = stack.pop();

            List<Edge> edgeList = graph.get(vertice);
            if (edgeList != null) {
                for (int i = 0; i < edgeList.size(); i++) {
                    Edge edge = edgeList.get(i);
                    if (!visited[edge.to]) {
                        visited[edge.to] = true;
                        stack.push(edge.to);
                    }
                }
            }
            count++;
        }

        return count;
    }


}
