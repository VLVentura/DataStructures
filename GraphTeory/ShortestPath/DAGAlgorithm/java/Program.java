import ShortestPath.AcyclicShortestPath;
import ShortestPath.Edge;
import ShortestPath.Vertex;

import java.util.ArrayList;
import java.util.List;

public class Program {
	public static void main(String[] args) {
		Vertex v1 = new Vertex("A");
		Vertex v2 = new Vertex("B");
		Vertex v3 = new Vertex("C");

		List<Vertex> vertexList = new ArrayList<>();
		vertexList.add(v1);
		vertexList.add(v2);
		vertexList.add(v3);

		v1.addNeighbour(new Edge(1, v1, v2));
		v1.addNeighbour(new Edge(10, v1, v3));
		v2.addNeighbour(new Edge(1, v2, v3));

		AcyclicShortestPath acyclicShortestPath = new AcyclicShortestPath();
		acyclicShortestPath.shortestPath(vertexList, v1, v3);
		acyclicShortestPath.showShortestPathTo(v3);
	}
}