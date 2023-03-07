package donnee;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;


import modele.Film;
import vue.VueVideotheque;

public class FilmDAO {
	
	public int tempsTotal = 0;
	public int tempsMoyen = 0;
	public int nombreFilms = 0;
	public int nombreCategories = 0;
		
	public List<Film> listerFilms()
	{
		
		
		System.out.println("FilmDAO.listerFilms()");
		List<Film> films = new ArrayList<Film>();
		
		
		try {
			BaseDeDonnees base = BaseDeDonnees.getInstance();		
			Connection connection = base.getConnection();
			Statement requete = connection.createStatement();
			ResultSet curseur = requete.executeQuery("SELECT * FROM videotheque");
			
			
			// curseur.next(); 
			// avance de 1 position - retourne vrai ou faux pour dire si il reste des données
			// doit etre exécuté une fois pour aller à la première données
			while(curseur.next())
			{
				String titre = curseur.getString("titre");
				String realisateur = curseur.getString("realisateur");
				int temps = curseur.getInt("temps");
				String categorie = curseur.getString("categorie");
				Film film = new Film(titre,realisateur, temps, categorie);
				films.add(film);
				
				nombreCategories++;
				tempsTotal = temps + tempsTotal;
				nombreFilms++;
				
				
				System.out.println("Titre " + titre + ", Realisateur: " + realisateur);
			}
			
			System.out.println(nombreCategories);
			tempsMoyen = tempsTotal / nombreFilms;
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return films;
	}
	
	public void ajouterFilm(Film film) {
		
		Connection connection = BaseDeDonnees.getInstance().getConnection();
		try {
			PreparedStatement requete = connection.prepareStatement("INSERT INTO videotheque (titre,realisateur,temps, categorie) VALUES(?,?,?,?)");
			
			requete.setString(1, film.getTitre());
			requete.setString(2, film.getRealisateur());
			requete.setInt(3, film.getMinutes());
			requete.setString(4, film.getCategorie());
			
			
			requete.execute();
		} 
		
		catch (SQLException e) {
			
			e.printStackTrace();
			
		}

	}
	
	public void modifierFilm(Film film) {
		
		Connection connection = BaseDeDonnees.getInstance().getConnection();
		try {
			
			PreparedStatement requete = connection.prepareStatement("UPDATE videotheque SET titre = ?, realsateur = ?, temps = ?, categorie = ? WHERE id = ?");
			requete.setString(1, film.getTitre());
			requete.setString(2, film.getRealisateur());
			requete.setInt(3, film.getMinutes());
			requete.setString(4, film.getCategorie());
			requete.setInt(5, film.getId());
			
			requete.execute();
			
		} 
		
		catch (SQLException e) {
			
			e.printStackTrace();
			
		}
	}
	
	public void effacerFilm(Film film) {
		
		Connection connection = BaseDeDonnees.getInstance().getConnection();
		try {
			String titre = film.getTitre();
			PreparedStatement requete = connection.prepareStatement("DELETE FROM videotheque * WHERE titre =" + titre);
					
			requete.execute();
			
		} 
		
		catch (SQLException e) {
			
			e.printStackTrace();
			
		}
	}

}