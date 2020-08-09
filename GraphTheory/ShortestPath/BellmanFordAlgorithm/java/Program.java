import ShortestPath.BellmanFordAlgorithm;
import ShortestPath.Edge;
import ShortestPath.Vertex;

import java.util.ArrayList;
import java.util.List;

public class Program {
	public static void main(String[] args) {
		List<Vertex> vertexList = new ArrayList<>();
		List<Edge> edgeList = new ArrayList<>();

		vertexList.add(new Vertex("A"));
		vertexList.add(new Vertex("B"));
		vertexList.add(new Vertex("C"));

		edgeList.add(new Edge(1, vertexList.get(0), vertexList.get(1)));
		edgeList.add(new Edge(-1, vertexList.get(1), vertexList.get(2)));
		edgeList.add(new Edge(1, vertexList.get(2), vertexList.get(0)));

		BellmanFordAlgorithm algo = new BellmanFordAlgorithm(edgeList, vertexList);

		algo.bellmanFord(vertexList.get(0));
		System.out.println(algo.shortestPathTo(vertexList.get(2)));
	}
}