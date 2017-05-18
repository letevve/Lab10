package it.polito.tdp.porto.model;

import java.util.*;

import org.jgrapht.Graphs;
import org.jgrapht.graph.DefaultEdge;
import org.jgrapht.graph.SimpleGraph;

import it.polito.tdp.porto.db.PortoDAO;

public class Model {
	
	private PortoDAO pd = new PortoDAO();
	private SimpleGraph<Author, DefaultEdge> graph;

	public List<Author> getAuthors() {
		List<Author> autori=pd.getAllAutori();
		return autori;
	}

	public String creaGrafo() {
		System.out.println("Creating graph...");
		
		this.graph = new SimpleGraph<Author, DefaultEdge>(DefaultEdge.class);
		Graphs.addAllVertices(graph, this.getAuthors());
		
		
		
		for(Author a : this.getAuthors()){
			List<Author> coautori = new ArrayList<Author>();
			for(Author ca : coautori){
				Link arco = new Link(a, ca);
				if(!graph.containsEdge(arco)){
					graph.addEdge(a, ca);
				}
			}
		}
		
		return graph.toString();	
	}

	public List<Author> getCoautori(int autorid) {
		return pd.getCoautori(autorid);
	}

}
