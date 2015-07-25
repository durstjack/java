package com.loncoto.basic.StrutsFormulaire.actions;

import com.loncoto.basic.StrutsFormulaire.bean.Article;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
//pour faire du modele driven il faut implementer cette interface
public class ArticleAction extends ActionSupport implements ModelDriven<Article>
{
	
	private Article model;

	@Override
	//struts2 appel, getmodel avant edit
	public Article getModel() {
		if( model == null){
			model = new Article();
		}
		return model;
	}
	public String edit(){
		//model = new Article(8, "chaise longue", 69, 4.60);
		getModel().setId(8);
		getModel().setLibelle("chaise longue");
		getModel().setPrix(69.0);
		getModel().setPoids(4.60);
		return SUCCESS;
	}

}
