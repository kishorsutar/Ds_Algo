package graph;

import java.util.Scanner;

public class UnionFind {
	static class Edge {
		private int src, dest, weight;
		public Edge(int src, int dest, int weight) {
			this.src = src;
			this.dest = dest;
			this.weight = weight;
		}
		@Override
		public String toString() {
			return "Edge [src=" + src + ", dest=" + dest + ", weight=" + weight + "]";
		}
	}
	
	private final int INF = 999;
	private int[][] mat;
	private int vertCount, edgeCount;
	private Edge[] edges;
	
	public UnionFind(int vCount) {
		vertCount = vCount;
		mat = new int[vertCount][vertCount];
		for (int i = 0; i < vertCount; i++) {
			for (int j = 0; j < vertCount; j++)
				mat[i][j] = INF;
		}
	}
	
	public void accept(Scanner sc) {
		System.out.println("Enter number of edges: ");
		edgeCount = sc.nextInt();
		edges = new Edge[edgeCount];
		System.out.println("Enter " + edgeCount + " edges -- src dest weight:");
		for (int i = 0; i < edgeCount; i++) {
			int src = sc.nextInt();
			int dest = sc.nextInt();
			int wt = sc.nextInt();
			mat[src][dest] = wt;
			mat[dest][src] = wt; // for undirected graph src -> dest => dest -> src 
			edges[i] = new Edge(src, dest, wt);
		}
	}
	
	public void display() {
		for (int i = 0; i < vertCount; i++) {
			System.out.print("v"+i);
			for (int j = 0; j < vertCount; j++) {
				if(mat[i][j] == INF)
					System.out.print("\t#");
				else
					System.out.print("\t" + mat[i][j]);
			}
			System.out.println();
		}
	}

	public int find(int v, int[] parent) {
		while(parent[v] != -1)
			v = parent[v];
		return v;
	}
	
	public void union(int sr, int dr, int[] parent) {
		parent[sr] = dr;
	}
	
	public boolean containsCycle() {
		int[] parent = new int[vertCount];
		for(int i=0; i<vertCount; i++)
			parent[i] = -1;
		for (Edge e : edges) {
			int sr = find(e.src, parent);
			int dr = find(e.dest, parent);
			if(sr == dr)
				return true;
			union(sr, dr, parent);
		}
		return false;
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		UnionFind g = new UnionFind(9);
		g.accept(sc);
		g.display();
		if(g.containsCycle())
			System.out.println("Graph contains cycle.");
		else
			System.out.println("Graph doesn't contain cycle.");
		sc.close();
	}
}

/*
14
7 6 1
8 2 2
6 5 2
0 1 4
2 5 4
8 6 6
2 3 7
7 8 7
0 7 8
1 2 8
3 4 9
5 4 10
1 7 11
3 5 14
*/
