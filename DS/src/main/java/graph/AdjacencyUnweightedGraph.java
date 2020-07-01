package graph;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;

public class AdjacencyUnweightedGraph {

    private int vertCount, edgeCount;
    int[][] mat;

    public AdjacencyUnweightedGraph(int vertexCount) {
        this.vertCount = vertexCount;
        mat = new int[vertCount][vertCount];
    }

    public void accept(Scanner sc) {
        System.out.println("Enter edges -  ");
        edgeCount = sc.nextInt();
        System.out.println("Enter number of " + edgeCount + "src - - dst");
        for (int i = 0; i < edgeCount; i++) {
            int src = sc.nextInt();
            int dest = sc.nextInt();
            mat[src][dest] = 1;
            mat[dest][src] = 1;  // for unweighted graphs the value is 1.
        }
    }

    public void display() {
        for (int i = 0; i < vertCount; i++) {
            System.out.print("V"+i);
            for (int j = 0; j < vertCount; j++) {
                System.out.print("\t" + mat[i][j]);
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Hello graph");
        AdjacencyUnweightedGraph graph = new AdjacencyUnweightedGraph(6);
        graph.accept(scanner);
        graph.display();
//        graph.bfsTrav(0);
//        System.out.println("is graph connected " + graph.dfsIsConnected(0));
//        graph.dfsSpanningTree(0);
        graph.singleSourcePathLength(0);
        scanner.close();
    }


    private void dfsSpanningTree(int start) {
        boolean[] visited = new boolean[vertCount];
        Stack<Integer> stack = new Stack<>();
        System.out.println("DFS Spanning Tree");

        stack.push(start);
        visited[start] = true;

        while(!stack.isEmpty()) {
            int vert = stack.pop();


            for (int j = 0; j < vertCount; j++) {
                if (mat[vert][j] == 1
                        && !visited[j]) {
                    visited[j] = true;
                    stack.push(j);
                    System.out.println(vert + "->" + j);

                }
            }
        }
    }


    private void dfsV(int start) {
        boolean[] visited = new boolean[vertCount];
        Stack<Integer> stack = new Stack<>();

        stack.push(start);
        visited[start] = true;

        while(!stack.isEmpty()) {
            int vert = stack.pop();

            System.out.println(vert);

            for (int j = 0; j < vertCount; j++) {
                if (mat[vert][j] == 1
                && !visited[j]) {
                    visited[j] = true;
                    stack.push(j);
                }
            }
        }
    }

    private boolean dfsIsConnected(int start) {
        boolean[] visited = new boolean[vertCount];
        Stack<Integer> stack = new Stack<>();
        int count = 0;
        stack.push(start);
        visited[start] = true;
        count++;

        while(!stack.isEmpty()) {
            int vert = stack.pop();

            for (int j = 0; j < vertCount; j++) {
                if (mat[vert][j] == 1
                        && !visited[j]) {
                    visited[j] = true;
                    count++;
                    stack.push(j);

                    if(count == vertCount)
                        return true;
                }
            }
        }

        return false;
    }


    private void bfsTrav(int start) {
        boolean[] visited = new boolean[vertCount];
        Queue<Integer> q = new LinkedList<>();
        q.offer(start);
        visited[start] = true;

        while (!q.isEmpty()) {
            int v = q.poll();

            System.out.println(v + " ");

            for (int i = 0; i < vertCount; i++) {
                if (mat[v][i] == 1 && !visited[i]) {
                    q.offer(i);
                    visited[i] = true;
                }
            }
        }
    }


    private void singleSourcePathLength(int start) {
        boolean[] visited = new boolean[vertCount];
        int[] dist = new int[vertCount];
        Queue<Integer> q = new LinkedList<>();
        q.offer(start);
        visited[start] = true;
        dist[start] = 0;

        while (!q.isEmpty()) {
            int v = q.poll();

            for (int i = 0; i < vertCount; i++) {
                if (mat[v][i] == 1 && !visited[i]) {
                    q.offer(i);
                    visited[i] = true;
                    dist[i] = dist[v] + 1; // 1 because unweighted graph
                }
            }
        }

        for (int i = 0; i < vertCount; i++) {
            System.out.println("Distance of " + i + "from " + start + "= " + dist[i]);
        }
    }

}
