import ShortestPath.DijkstraAlgorithm;
import ShortestPath.Edge;
import ShortestPath.Vertex;

public class Program {
	public static void main(String[] args) {
		DijkstraAlgorithm algo = new DijkstraAlgorithm();

		Vertex v1 = new Vertex("A");
		Vertex v2 = new Vertex("B");
		Vertex v3 = new Vertex("C");
		Vertex v4 = new Vertex("D");
		Vertex v5 = new Vertex("E");
		Vertex v6 = new Vertex("F");
		Vertex v7 = new Vertex("G");
		Vertex v8 = new Vertex("H");

		v1.addNeighbour(new Edge(5, v1, v2));
		v1.addNeighbour(new Edge(9, v1, v5));
		v1.addNeighbour(new Edge(8, v1, v8));
		v2.addNeighbour(new Edge(4, v2, v8));
		v2.addNeighbour(new Edge(12, v2, v3));
		v2.addNeighbour(new Edge(15, v2, v4));
		v3.addNeighbour(new Edge(3, v3, v4));
		v4.addNeighbour(new Edge(9, v4, v7));
		v5.addNeighbour(new Edge(5, v5, v8));
		v5.addNeighbour(new Edge(4, v5, v6));
		v5.addNeighbour(new Edge(20, v5, v7));
		v6.addNeighbour(new Edge(1, v6, v3));
		v6.addNeighbour(new Edge(13, v6, v7));
		v8.addNeighbour(new Edge(7, v8, v3));
		v8.addNeighbour(new Edge(6, v8, v6));

		algo.computePaths(v1);
		System.out.println(algo.getShortestPathTo(v7));
	}
}