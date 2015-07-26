package metier;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Incident {
	
	public static final SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
	
	private int id;
	private String description;
	private Date date;
	private int urgence;
	private String categorie;
	
	//getters ans setters
	public int getId() { return id; }
	public void setId(int id) { this.id = id; }
	public String getDescription() {return description;}
	public void setDescription(String description) { this.description = description; }
	public Date getDate() { return date; }
	public void setDate(Date date) { this.date = date; }
	public int getUrgence() { return urgence; }
	public void setUrgence(int urgence) { this.urgence = urgence; }
	public String getCategorie() {return categorie; }
	public void setCategorie(String categorie) { this.categorie = categorie; }
	
	//les constructeurs
	public Incident() { this(0, "", null, 0, "");}
	public Incident(int id, String description, Date date, int urgence,	String categorie) {
		this.id = id;
		this.description = description;
		this.date = date;
		this.urgence = urgence;
		this.categorie = categorie;
	}
	
	//overrride de la méthode to string, permet le println(Incident);
	@Override
	public String toString() {
		return "Incident [description=" + description + ", date=" + format.format(date)	+ ", urgence=" + urgence + ", categorie=" + categorie + "]";
	}
	
	
	

}
