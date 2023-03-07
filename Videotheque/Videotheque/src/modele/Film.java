package modele;

public class Film {
	
	protected int id;
	protected String titre;
	protected String realisateur;
	protected int minutes;
	protected String categorie;
	public Film(String titre) {
		super();
		this.titre = titre;
	}
	public Film(String titre, String realisateur, int temps, String categorie) {
		super();
		this.titre = titre;
		this.realisateur = realisateur;
		this.minutes = temps;
		this.categorie = categorie;
	}
	public String getCategorie() {
		return categorie;
	}
	public void setCategorie(String categorie) {
		this.categorie = categorie;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTitre() {
		return titre;
	}
	public void setTitre(String titre) {
		this.titre = titre;
	}
	public String getRealisateur() {
		return realisateur;
	}
	public void setRealisateur(String realisateur) {
		this.realisateur = realisateur;
	}
	public int getMinutes() {
		return minutes;
	}
	public void setMinutes(int minutes) {
		this.minutes = minutes;
	}

	
	
}
