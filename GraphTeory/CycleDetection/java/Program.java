import CycleDetection.CycleDetection;
import CycleDetection.Vertex;

import java.util.ArrayList;
import java.util.List;

public class Program {
	public static void main(String[] args) {
		CycleDetection algo = new CycleDetection();
		List<Vertex> graph = new ArrayList<Vertex>();

		graph.add(new Vertex("1"));
		graph.add(new Vertex("2"));
		graph.add(new Vertex("3"));
		graph.add(new Vertex("4"));
		graph.add(new Vertex("5"));
		graph.add(new Vertex("6"));

		graph.get(0).addNeighbour(graph.get(1));
		graph.get(1).addNeighbour(graph.get(2));
		graph.get(2).addNeighbour(graph.get(0));
		graph.get(3).addNeighbour(graph.get(0));
		graph.get(3).addNeighbour(graph.get(4));
		graph.get(4).addNeighbour(graph.get(5));
		graph.get(5).addNeighbour(graph.get(3));

		algo.detectCycle(graph);
	}
}