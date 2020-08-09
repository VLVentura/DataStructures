package Prim;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class Algorithm {

	private List<Vertex> unvisitedVertexes;
	private List<Edge> spanningTree;
	private PriorityQueue<Edge> edgeHeap;
	private double fullCost;

	public Algorithm(List<Vertex> unvisitedVertexes){
		this.spanningTree = new ArrayList<>();
		this.unvisitedVertexes = unvisitedVertexes;
		this.edgeHeap = new PriorityQueue<>();
	}

	public void primsAlgorithm(Vertex vertex){
		this.unvisitedVertexes.remove(vertex);

		while(!unvisitedVertexes.isEmpty()){
			for(Edge edge: vertex.getAdjacenciesList()){
				if(this.unvisitedVertexes.contains(edge.getTargetVertex())){
					this.edgeHeap.add(edge);
				}
			}

			Edge minEdge = this.edgeHeap.remove();

			this.spanningTree.add(minEdge);
			this.fullCost += minEdge.getWeight();

			vertex = minEdge.getTargetVertex();
			this.unvisitedVertexes.remove(vertex);
		}
	}

	public void showMST(){
		System.out.println("Minimum Spanning Tree cost: " + this.fullCost);

		for(Edge edge: spanningTree){
			System.out.print(edge.getStartVertex() + " " + edge.getTargetVertex() + " -- ");
		}
	}
}
