package com.loncoto.webapps.exo2JPA.beans;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.*;
@Entity
public class Post {
	
		private int id;
		private String titre;
		private String corps;
		
		private Set<Tag> tags;
		
		//cascade=CascadeType.PERSIST permet de dire que si on persist un post avec un tag pas persisté il va persisté la tag automatiquement
		@ManyToMany(mappedBy="posts", cascade=CascadeType.PERSIST)
		public Set<Tag> getTags() { 
			if(tags == null) tags = new HashSet<Tag>();		
			return tags;
		}	
		
		public void setTags(Set<Tag> tags) { this.tags = tags; }
		
		@Id @GeneratedValue(strategy=GenerationType.AUTO)
		public int getId() {return id;	}
		public void setId(int id) { this.id = id; }
		public String getTitre() {	return titre; }
		public void setTitre(String titre) { this.titre = titre; }
		public String getCorps() { return corps; }
		public void setCorps(String corps) { this.corps = corps; }
		
		public Post(){this(0, "", "");}
		public Post(int id, String titre, String corps) {
			this.id = id;
			this.titre = titre;
			this.corps = corps;
		}
		
		

}
