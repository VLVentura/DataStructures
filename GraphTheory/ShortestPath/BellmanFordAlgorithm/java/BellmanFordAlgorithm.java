package ShortestPath;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class BellmanFordAlgorithm {

	private List<Edge> edgeList;
	private List<Vertex> vertexList;

	public BellmanFordAlgorithm(List<Edge> edgeList, List<Vertex> vertexList){
		this.edgeList = edgeList;
		this.vertexList = vertexList;
	}

	public void bellmanFord(Vertex sourceVertex){
		sourceVertex.setDistance(0);

		// V-1 iterations -> Relax all the edges
		for(int i = 0; i < vertexList.size() - 1; ++i){
			for(Edge edge: edgeList){
				Vertex u = edge.getStartVertex();
				Vertex v = edge.getTargetVertex();

				if(u.getDistance() == Double.MAX_VALUE){
					continue;
				}

				double newDistance = u.getDistance() + edge.getWeight();

				if(newDistance < v.getDistance()){
					v.setDistance(newDistance);
					v.setPreviousVertex(u);
				}
			}
		}

		// V-th iteration - Detect if there's a cycle
		for(Edge edge: edgeList){
			if(edge.getStartVertex().getDistance() != Double.MAX_VALUE){
				if(hasCycle(edge)){
					System.out.println("There has been a negative cycle detected");
					return;
				}
			}
		}
	}

	private boolean hasCycle(Edge edge){
		return edge.getStartVertex().getDistance() + edge.getWeight() < edge.getTargetVertex().getDistance();
	}

	public List<Vertex> shortestPathTo(Vertex targetVertex){
		List<Vertex> shortestPathToTarget = new ArrayList<>();

		if(targetVertex.getDistance() == Double.MAX_VALUE){
			System.out.println("There is no path from the source to the target");
		}
		else {
			for(Vertex vertex = targetVertex; vertex != null; vertex = vertex.getPreviousVertex()){
				shortestPathToTarget.add(vertex);
			}
		}

		Collections.reverse(shortestPathToTarget);
		return shortestPathToTarget;
	}
}
