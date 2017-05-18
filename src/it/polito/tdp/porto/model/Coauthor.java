package it.polito.tdp.porto.model;

public class Coauthor {
	
	private Author a1;
	private Author a2;
	
	public Coauthor(Author a1, Author a2) {
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

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return String.format("Coauthor [a1=%s, a2=%s]", a1, a2);
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((a1 == null) ? 0 : a1.hashCode());
		result = prime * result + ((a2 == null) ? 0 : a2.hashCode());
		return result;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Coauthor other = (Coauthor) obj;
		if (a1 == null) {
			if (other.a1 != null)
				return false;
		} else if (!a1.equals(other.a1))
			return false;
		if (a2 == null) {
			if (other.a2 != null)
				return false;
		} else if (!a2.equals(other.a2))
			return false;
		return true;
	}
	
	
}
