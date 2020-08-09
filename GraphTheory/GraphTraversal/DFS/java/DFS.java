package DFS;

import java.util.List;
import java.util.Stack;

public class DFS {

	public void dfs(List<Vertex> vertexList){
		for(Vertex v: vertexList){
			if(!v.isVisited()){
				v.setVisited(true);
				// dfsIterative(v);
				dfsRecursive(v);
			}
		}
	}ls
	

	public void dfsRecursive(Vertex root){
		System.out.print(root.getName() + " ");

		for(Vertex v: root.getNeighbourList()){
			if(!v.isVisited()){
				v.setVisited(true);
				dfsRecursive(v);
			}
		}
	}

	public void dfsIterative(Vertex root){
		Stack<Vertex> stack = new Stack<Vertex>();
		stack.add(root);
		root.setVisited(true);

		while(!stack.isEmpty()){
			Vertex actualVertex = stack.pop();
			System.out.print(actualVertex.getName() + " ");

			for(Vertex v: actualVertex.getNeighbourList()){
				if(!v.isVisited()){
					v.setVisited(true);
					stack.push(v);
				}
			}
		}
	}
}
