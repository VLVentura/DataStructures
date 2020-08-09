import Prim.Algorithm;
import Prim.Edge;
import Prim.Vertex;

import java.util.ArrayList;
import java.util.List;

public class Program {
	public static void main(String[] args) {
		List<Vertex> vertexList = new ArrayList<>();

		Vertex v1 = new Vertex("A");
		Vertex v2 = new Vertex("B");
		Vertex v3 = new Vertex("C");

		vertexList.add(v1);
		vertexList.add(v2);
		vertexList.add(v3);

		// Undirected edges: v1->v2 = v2->v1
		v1.addEdge(new Edge(100, v1, v2));
		v1.addEdge(new Edge(10, v1, v3));
		v1.addEdge(new Edge(1, v2, v3));

		v2.addEdge(new Edge(100, v2, v1));
		v3.addEdge(new Edge(10, v3, v1));
		v3.addEdge(new Edge(1, v3, v2));

		Algorithm algorithm = new Algorithm(vertexList);
		algorithm.primsAlgorithm(v3);
		algorithm.showMST();

	}
}