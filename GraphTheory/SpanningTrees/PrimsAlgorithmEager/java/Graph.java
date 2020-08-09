package Prim;

import java.util.ArrayList;
import java.util.List;

public class Graph {

	private List<Vertex> vertexList;
	private List<Edge> edgeList;

	public Graph(){
		this.vertexList = new ArrayList<>();
		this.edgeList = new ArrayList<>();
	}

	public void addVertex(Vertex vertex){
		this.vertexList.add(vertex);
	}

	public void addEdge(Edge edge){
		Vertex startVertex = edge.getStartVertex();
		Vertex targetVertex = edge.getTargetVertex();

		this.vertexList.get(vertexList.indexOf(startVertex)).addEdge(new Edge(edge.getWeight(), startVertex, targetVertex));
		this.vertexList.get(vertexList.indexOf(targetVertex)).addEdge(new Edge(edge.getWeight(), targetVertex, startVertex));
	}

	public List<Vertex> getVertexList() {
		return vertexList;
	}

	public void setVertexList(List<Vertex> vertexList) {
		this.vertexList = vertexList;
	}

	public List<Edge> getEdgeList() {
		return edgeList;
	}

	public void setEdgeList(List<Edge> edgeList) {
		this.edgeList = edgeList;
	}
}
