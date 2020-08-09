package Prim;

import java.util.List;
import java.util.PriorityQueue;

public class Algorithm {

	private List<Vertex> vertexList;
	private PriorityQueue<Vertex> heap;

	public Algorithm(Graph graph){
		this.vertexList = graph.getVertexList();
		this.heap = new PriorityQueue<>();
	}

	public void spanningTree(){
		for(Vertex vertex: vertexList){
			if(!vertex.isVisited()){
				makePrims(vertex);
			}
		}
	}

	private void makePrims(Vertex vertex) {
		vertex.setDistance(0);
		heap.add(vertex);

		while(!heap.isEmpty()){
			Vertex v = heap.remove();
			scanVertexes(v);
		}
	}

	private void scanVertexes(Vertex vertex) {
		vertex.setVisited(true);

		for(Edge edge: vertex.getAdjacenciesList()){
			Vertex v = edge.getTargetVertex();

			if(v.isVisited()){
				continue;
			}

			if(edge.getWeight() < v.getDistance()){
				v.setDistance(edge.getWeight());
				v.setMinEdge(edge);

				if(this.heap.contains(v)){
					this.heap.remove(v);
				}

				this.heap.add(v);
			}
		}
	}

	public void showMST(){
		for(Vertex vertex: vertexList){
			if(vertex.getMinEdge() != null){
				Edge e = vertex.getMinEdge();
				System.out.println("Edge: " + e.getStartVertex() + " " + e.getTargetVertex());
			}
		}
	}

}
