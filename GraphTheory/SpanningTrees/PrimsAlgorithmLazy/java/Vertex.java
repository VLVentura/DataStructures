package Prim;

import java.util.ArrayList;
import java.util.List;

public class Vertex {

	private String name;
	private boolean visited;
	private Vertex previousVertex;
	private List<Edge> adjacenciesList;

	public Vertex(String name){
		this.name = name;
		this.adjacenciesList = new ArrayList<>();
	}

	public void addEdge(Edge edge){
		this.adjacenciesList.add(edge);
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public boolean isVisited() {
		return visited;
	}

	public void setVisited(boolean visited) {
		this.visited = visited;
	}

	public Vertex getPreviousVertex() {
		return previousVertex;
	}

	public void setPreviousVertex(Vertex previousVertex) {
		this.previousVertex = previousVertex;
	}

	public List<Edge> getAdjacenciesList() {
		return adjacenciesList;
	}

	public void setAdjacenciesList(List<Edge> adjacenciesList) {
		this.adjacenciesList = adjacenciesList;
	}

	@Override
	public String toString(){
		return this.name;
	}
}
