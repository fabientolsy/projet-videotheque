package vue;
import java.util.List;

import com.sun.media.jfxmedia.logging.Logger;

import architecture.Vue;
import controleur.ControleurVideotheque;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.Label;
import modele.Film;

public class VueVideotheque extends Vue {

	protected ControleurVideotheque controleur;
	protected static VueVideotheque instance = null; 
	public static VueVideotheque getInstance() {if(null==instance)instance = new VueVideotheque();return VueVideotheque.instance;}; 
	
	public VueVideotheque() 
	{
		super("videotheque.fxml"); 
		super.controleur = this.controleur = new ControleurVideotheque();
		Logger.logMsg(Logger.INFO, "new VueVideotheque()");
	}
		
	public void activerControles()
	{
		super.activerControles();
	}
	
	public void afficherFilms(List<Film> films)
	{
		Logger.logMsg(Logger.INFO, "VueVideotheque.afficherFilms()");
		TableView tableau = (TableView)lookup("#liste-films");
		System.out.println("Le tableau est " + tableau);
		TableColumn colonneTitre = (TableColumn) tableau.getColumns().get(0);
		TableColumn colonneMinutes = (TableColumn) tableau.getColumns().get(1);
		TableColumn colonneRealisateur = (TableColumn) tableau.getColumns().get(2);
		colonneTitre.setCellValueFactory(new PropertyValueFactory<>("titre"));
		colonneMinutes.setCellValueFactory(new PropertyValueFactory<>("minutes"));
		colonneRealisateur.setCellValueFactory(new PropertyValueFactory<>("realisateur"));
		
		for(Film film : films)
		{
			tableau.getItems().add(film);
			System.out.println("Film :" + film.getTitre());
		}
	}
		
	public void afficherSyntheseMinutes(int minutesTotales, int minutesMoyenne)
	{
		Logger.logMsg(Logger.INFO, "VueVideotheque.afficherSyntheseMinutes()");
		Label vueMinutesTotales = (Label) lookup("#synthese-minutes-total");
		Label vueMinutesMoyennes = (Label) lookup("#synthese-minutes-moyenne");
		//System.out.println(minutesMoyenne);
		vueMinutesTotales.setText(minutesTotales + " minutes totales");
		vueMinutesMoyennes.setText(minutesMoyenne+ " minutes en moyenne");
	
	}
	
	public void afficherSyntheseCategories(int nombreCategories)
	{
		Label vueNombreCategories = (Label) lookup("#synthese-categories-total");
		
		vueNombreCategories.setText("Dans " + nombreCategories + " categories");
	}

	public void afficherSyntheseFilms(int nombreFilms)
	{
		System.out.println("Afficher nombre de films");
		Label vueNombreFilms = (Label) lookup("#synthese-films-total");
		
		vueNombreFilms.setText(nombreFilms + " films");

	}
}
