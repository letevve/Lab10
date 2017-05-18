package it.polito.tdp.porto.db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;

import it.polito.tdp.porto.model.Author;
import it.polito.tdp.porto.model.Coauthor;
import it.polito.tdp.porto.model.Paper;

public class PortoDAO {
	
	

	public List<Author> getCoautori(int authorid){
		final String sql = "SELECT * FROM author WHERE id IN (select authorid FROM creator WHERE eprintid IN  (SELECT eprintid FROM paper WHERE eprintid IN (SELECT eprintid FROM creator WHERE authorid = ?)	) AND authorid!= ? )";

		List<Coauthor> coautori = new ArrayList<Coauthor>();
		List<Author> autori = new ArrayList<Author>();
		
		try {
			Connection conn = DBConnect.getConnection();
			PreparedStatement st = conn.prepareStatement(sql);
			st.setInt(1, authorid);
			st.setInt(2, authorid);

			ResultSet rs = st.executeQuery();

			while (rs.next()) {

				Author autore = new Author(rs.getInt("id"), rs.getString("lastname"), rs.getString("firstname"));
				if(!autori.contains(autore)){
					autori.add(autore);
				}
			}

			return autori;

		} catch (SQLException e) {
			// e.printStackTrace();
			throw new RuntimeException("Errore Db");
		}
	}
	
	/*
	trovo i coautori di un autore: 
		SELECT authorid FROM creator WHERE eprintid IN 
		(SELECT eprintid FROM paper WHERE eprintid IN 
			(SELECT eprintid FROM creator WHERE authorid = 85)
		) AND authorid!= 85
	*/

	public List<Paper> getPubblicazioni(int authorId) {
		final String sql = "SELECT * FROM paper WHERE eprintid IN (SELECT eprintid FROM creator WHERE authorid = ?";
		List<Paper> pubblicazioni = new ArrayList<Paper>();
		
		try {
			Connection conn = DBConnect.getConnection();
			PreparedStatement st = conn.prepareStatement(sql);
			st.setInt(1, authorId);

			ResultSet rs = st.executeQuery();

			while (rs.next()) {

				Paper pubblicazione = new Paper(rs.getInt("eprintid"), rs.getString("title"), rs.getString("issn"),
						rs.getString("publication"), rs.getString("type"), rs.getString("types"));
				
				pubblicazioni.add(pubblicazione);
				
			}

			return pubblicazioni;

		} catch (SQLException e) {
			// e.printStackTrace();
			throw new RuntimeException("Errore Db");
		}
	}

	/*
	 * Dato l'id ottengo l'autore.
	 */
	public Author getAutore(int id) {

		final String sql = "SELECT * FROM author where id=?";

		try {
			Connection conn = DBConnect.getConnection();
			PreparedStatement st = conn.prepareStatement(sql);
			st.setInt(1, id);

			ResultSet rs = st.executeQuery();

			if (rs.next()) {

				Author autore = new Author(rs.getInt("id"), rs.getString("lastname"), rs.getString("firstname"));
				return autore;
			}

			return null;

		} catch (SQLException e) {
			// e.printStackTrace();
			throw new RuntimeException("Errore Db");
		}
	}

	/*
	 * Dato l'id ottengo l'articolo.
	 */
	public Paper getArticolo(int eprintid) {

		final String sql = "SELECT * FROM paper where eprintid=?";

		try {
			Connection conn = DBConnect.getConnection();
			PreparedStatement st = conn.prepareStatement(sql);
			st.setInt(1, eprintid);

			ResultSet rs = st.executeQuery();

			if (rs.next()) {
				Paper paper = new Paper(rs.getInt("eprintid"), rs.getString("title"), rs.getString("issn"),
									rs.getString("publication"), rs.getString("type"), rs.getString("types"));
				return paper;
			}

			return null;

		} catch (SQLException e) {
			 e.printStackTrace();
			throw new RuntimeException("Errore Db");
		}
	}

	public List<Author> getAllAutori() {
		// TODO Auto-generated method stub
		final String sql = "SELECT * FROM author ";
		List<Author> autori = new LinkedList<Author>();
		
		try {
			Connection conn = DBConnect.getConnection();
			PreparedStatement st = conn.prepareStatement(sql);

			ResultSet rs = st.executeQuery();

			while (rs.next()) {
				Author autore = new Author(rs.getInt("id"), rs.getString("lastname"), rs.getString("firstname"));
				if(!autori.contains(autore)){
					autori.add(autore);
				}
				else{}
			}

			return autori;

		} catch (SQLException e) {
			 e.printStackTrace();
			throw new RuntimeException("Errore Db");
		}
	}
}