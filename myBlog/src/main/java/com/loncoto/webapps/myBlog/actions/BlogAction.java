package com.loncoto.webapps.myBlog.actions;

import java.util.Date;
import java.util.List;

import javax.servlet.ServletContext;

import org.apache.struts2.util.ServletContextAware;

import com.loncoto.webapps.myBlog.beans.Post;
import com.loncoto.webapps.myBlog.utils.PostDAO;
import com.opensymphony.xwork2.ActionSupport;

public class BlogAction extends ActionSupport implements ServletContextAware {
	
	private List<Post> posts;	
	public List<Post> getPosts() { return posts; 	}

	private PostDAO postDAO;
	private ServletContext ctx;
	
	private int postID;
	private String postTitre;
	private String postCorps;
	private Date postDate;

	public int getPostID() { return postID; }
	public void setPostID(int postID) { this.postID = postID; }
	public String getPostTitre() { return postTitre; }
	public void setPostTitre(String postTitre) { this.postTitre = postTitre; }
	public String getPostCorps() { return postCorps; }
	public void setPostCorps(String postCorps) { this.postCorps = postCorps; }
	public Date getPostDate() {	return postDate; }
	public void setPostDate(Date postDate) { this.postDate = postDate; }
	
	
	@Override
	public void setServletContext(ServletContext arg0) {
		ctx = arg0;
		postDAO = (PostDAO)ctx.getAttribute("postDAO");

	}
	
	public String liste(){		
		posts = postDAO.findAll();
		return SUCCESS;		
	}
	
	public  String edit(){
		//on recupere clientID grâce a struts2 dans struts xml on a <param name="clientID">{1}</param>
		Post p = postDAO.findByID(postID);
		if( p == null ){
			//en retournant "not found" on redirigera vers liste voir dans struts xml
			return "not found";
		}
		//on va setter la valeur des inputs dans edit.jsp
		setPostID(p.getId());
		setPostTitre(p.getTitre());
		setPostCorps(p.getCorps());
		setPostDate(p.getDate());

		return SUCCESS;
	}
	
	public  String create(){
		Date date = new Date();
		Post p = new Post(0, "titre", "corps", date);
		//on va setter la valeur des inputs dans edit.jsp
		setPostID(p.getId());
		setPostTitre(p.getTitre());
		setPostCorps(p.getCorps());
		setPostDate(p.getDate());

		return SUCCESS;
	}
	
	
	public String save(){
		//on ajoute un controle, en retorunant "input" on renverra vers edit.jsp voir dans struts xml
		//on ajoute un fieldError personnalisé sur le champ "clientNom" de notre formulaire
		//propre mecanisme de verification
		if(getPostTitre().equals("")){
			addActionError("Le titre d'un post ne peut pas être vide!!!");
			return INPUT;			
		}
		Post p = new Post(getPostID(), getPostTitre(), getPostCorps(), getPostDate());
		postDAO.save(p);
		return SUCCESS;
		
	}
	
	public  String delete(){
		//on recupere clientID grâce a struts2 dans struts xml on a <param name="clientID">{1}</param>
		int isSuccess = postDAO.delete(postID);
		return SUCCESS;
	}
	
	
	

}
