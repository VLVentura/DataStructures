package StronglyConnectedComponents;

import java.util.Stack;

public class DFS {

	private Stack<Vertex> stack;

	public DFS(Graph graph){
		this.stack = new Stack<>();

		for(Vertex vertex: graph.getVertexList()){
			if(!vertex.isVisited()){
				dfs(vertex);
			}
		}
	}

	private void dfs(Vertex vertex) {
		vertex.setVisited(true);

		for(Vertex v: vertex.getAdjacenciesList()){
			if(!v.isVisited()){
				dfs(v);
			}
		}

		this.stack.push(vertex);
	}

	public Stack<Vertex> getReversePost(){
		return this.stack;
	}
}
