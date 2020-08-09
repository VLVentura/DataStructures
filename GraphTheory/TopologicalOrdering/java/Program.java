import TopologicalOrder.TopologicalOrdering;
import TopologicalOrder.Vertex;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Program {
	public static void main(String[] args) {
		TopologicalOrdering algo = new TopologicalOrdering();
		List<Vertex> graph = new ArrayList<>();

		graph.add(new Vertex("A"));
		graph.add(new Vertex("B"));
		graph.add(new Vertex("C"));
		graph.add(new Vertex("D"));
		graph.add(new Vertex("E"));

		graph.get(0).addNeighbour(graph.get(2));
		graph.get(0).addNeighbour(graph.get(3));
		graph.get(1).addNeighbour(graph.get(3));
		graph.get(2).addNeighbour(graph.get(1));
		graph.get(2).addNeighbour(graph.get(4));
		graph.get(4).addNeighbour(graph.get(3));

		for(int i = 0; i < graph.size(); ++i){
			if(!graph.get(i).isVisited()){
				algo.dfs(graph.get(i));
			}
		}

		Stack<Vertex> stack = algo.getStack();

		while(!stack.isEmpty()){
			System.out.print(stack.pop() + " ");
		}
	}
}