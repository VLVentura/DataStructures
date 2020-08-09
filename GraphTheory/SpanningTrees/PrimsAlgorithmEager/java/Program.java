import Prim.Algorithm;
import Prim.Edge;
import Prim.Graph;
import Prim.Vertex;

public class Program {
	public static void main(String[] args) {
		Graph graph = new Graph();

		Vertex v1 = new Vertex("A");
		Vertex v2 = new Vertex("B");
		Vertex v3 = new Vertex("C");

		graph.addVertex(v1);
		graph.addVertex(v2);
		graph.addVertex(v3);

		graph.addEdge(new Edge(100, v1, v2));
		graph.addEdge(new Edge(1, v1, v3));
		graph.addEdge(new Edge(10, v2, v3));

		Algorithm algo =  new Algorithm(graph);
		algo.spanningTree();
		algo.showMST();
	}
}