   
package controleur;

import java.util.ArrayList;
import java.util.List;

import com.sun.media.jfxmedia.logging.Logger;
import architecture.Controleur;
import donnee.FilmDAO;
import modele.Film;
import vue.VueVideotheque;

public class ControleurVideotheque extends Controleur{

	public ControleurVideotheque()
	{
		Logger.logMsg(Logger.INFO, "new ControleurVideotheque()");
	}

	public void initialiser()
	{
		List<Film> films = new ArrayList<Film>();
		
		FilmDAO specialisteFilm = new FilmDAO();

		films.add(new Film("test","test", 50, "test"));
		
		Film filmTest = new Film("test","test", 50, "test");
		films.add(filmTest);
		specialisteFilm.ajouterFilm(filmTest);
		//specialisteFilm.modifierFilm(filmTest);
		//specialisteFilm.effacerFilm(filmTest);
		
		List<Film> films2 = specialisteFilm.listerFilms();

		int nombreFilms = specialisteFilm.nombreFilms;
		int minutesTotale = specialisteFilm.tempsTotal;
		int minutesMoyenne = specialisteFilm.tempsMoyen;
		int nombreCategories = specialisteFilm.nombreCategories;
		
		VueVideotheque.getInstance().afficherSyntheseFilms(nombreFilms);
		VueVideotheque.getInstance().afficherFilms(films2);
		VueVideotheque.getInstance().afficherSyntheseMinutes(minutesTotale, minutesMoyenne);
		VueVideotheque.getInstance().afficherSyntheseCategories(nombreCategories);
	}
}