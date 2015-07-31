package com.loncoto.webapps.exo3JPA.beans;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.*;
@Entity
public class Cours {
	
		private int id;
		private Date dateDebut;
		private Date dateFin;
		private String libelle;
		
		private Set<Etudiant> etudiants;
		@ManyToMany
		public Set<Etudiant> getEtudiants() {
			if( etudiants == null ) etudiants = new HashSet<Etudiant>();
			return etudiants;
		}
		public void setEtudiants(Set<Etudiant> etudiants) { this.etudiants = etudiants; }
		
		
		private Matiere matiere;		
		@ManyToOne
		public Matiere getMatiere() { return matiere; }
		public void setMatiere(Matiere matiere) { this.matiere = matiere; }
		
		
		private Formateur formateur;
		@ManyToOne
		public Formateur getFormateur() { return formateur; 	}
		public void setFormateur(Formateur formateur) { this.formateur = formateur;	}
		
		@Id @GeneratedValue
		public int getId() { return id; }
		public void setId(int id) {	this.id = id; }
		public Date getDateDebut() { return dateDebut; }
		public void setDateDebut(Date dateDebut) { this.dateDebut = dateDebut; }
		public Date getDateFin() { return dateFin; }
		public void setDateFin(Date dateFin) { this.dateFin = dateFin; }
		public String getLibelle() { return libelle;}
		public void setLibelle(String libelle) { this.libelle = libelle; }
		
		public Cours(){ this(0, null, null, "");}
		public Cours(int id, Date dateDebut, Date dateFin, String libelle) {
			super();
			this.id = id;
			this.dateDebut = dateDebut;
			this.dateFin = dateFin;
			this.libelle = libelle;
		}
		
		

}
