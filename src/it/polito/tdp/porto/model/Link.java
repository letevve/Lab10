package it.polito.tdp.porto.model;

import org.jgrapht.graph.DefaultEdge;

public class Link extends DefaultEdge {
	
	private Author a1;
	private Author a2;
	
	public Link() { }

	public Link(Author a1, Author a2) {
		super();
		this.a1 = a1;
		this.a2 = a2;
	}

	/**
	 * @return the a1
	 */
	public Author getA1() {
		return a1;
	}

	/**
	 * @param a1 the a1 to set
	 */
	public void setA1(Author a1) {
		this.a1 = a1;
	}

	/**
	 * @return the a2
	 */
	public Author getA2() {
		return a2;
	}

	/**
	 * @param a2 the a2 to set
	 */
	public void setA2(Author a2) {
		this.a2 = a2;
	}
	
	

}
