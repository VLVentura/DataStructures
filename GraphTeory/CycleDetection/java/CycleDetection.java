package CycleDetection;

import java.util.List;

public class CycleDetection {

	public void detectCycle(List<Vertex> vertexList){
		for(Vertex v: vertexList){
			if(!v.isVisited()){
				dfs(v);
			}
		}
	}

	private void dfs(Vertex vertex){
		System.out.println("DFS on " + vertex);
		vertex.setBeingVisited(true);

		for(Vertex v: vertex.getAdjacenciesList()){
			System.out.println("Visiting the neighbours of " + vertex);

			if(v.isBeingVisited()){
				System.out.println("There's a backward edge: there's a cycle!");
				return;
			}

			if(!v.isVisited()){
				System.out.println("Visiting the vertex " + v + " recursively");
				v.setVisited(true);
				dfs(v);
			}
		}

		System.out.println("Set vertex " + vertex + " setBeingVisited(false) and visited(true)");
		vertex.setBeingVisited(false);
		vertex.setVisited(true);
	}
}
