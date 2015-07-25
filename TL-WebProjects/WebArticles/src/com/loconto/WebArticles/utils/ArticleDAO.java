package com.loconto.WebArticles.utils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.loconto.WebArticles.beans.*;


public class ArticleDAO {
	
	private Connection base;
	public static final int ORDER_BY_DEFAULT = 0;
	public static final int ORDER_BY_PRIX = 1;
	public static final int ORDER_BY_POIDS = 2;
	public static final int ORDER_BY_LIBELLE = 3;

	//requete preparées et attributs de ClientsDAO
	public static final String FIND_ALL_SQL = "SELECT * FROM `articles`";
	private PreparedStatement findAllStatement ;
	
	public static final String FIND_ALL_ORDERED_LIBELLE_SQL = "SELECT * FROM `articles` ORDER BY libelle";
	private PreparedStatement findAllOrderedByLibelleStatement ;
	
	public static final String FIND_ALL_ORDERED_PRIX_SQL = "SELECT * FROM `articles` ORDER BY prix";
	private PreparedStatement findAllOrderedByPrixStatement ;
	
	public static final String FIND_ALL_ORDERED_POIDS_SQL = "SELECT * FROM `articles` ORDER BY poids";
	private PreparedStatement findAllOrderedByPoidsStatement ;
	
	public static final String FIND_ONE_ARTICLE_SQL = "SELECT * FROM `articles` WHERE `id` = ?";
	private PreparedStatement findByIDStatement ;
	
	public static final String UPDATE_ONE_ARTICLE = "UPDATE `articles` SET `libelle` = ?, `prix` = ?, `poids` = ? WHERE `id` = ?";
	private PreparedStatement updateByIDStatement ;

	public static final String INSERT_ONE_ARTICLE = "INSERT INTO `articles` (`libelle`,`prix`,`poids`) VALUES(?,?,?)";
	private PreparedStatement insertStatement ;
	
	public static final String DELETE_ONE_ARTICLE = "DELETE FROM `articles` WHERE `id` = ? ";
	private PreparedStatement deleteStatement ;
	
	
	

	public ArticleDAO(Connection base) {
		super();
		this.base = base;
		
		try {			
			findAllStatement = base.prepareStatement(FIND_ALL_SQL);
			findAllOrderedByPoidsStatement = base.prepareStatement(FIND_ALL_ORDERED_POIDS_SQL);
			findAllOrderedByPrixStatement = base.prepareStatement(FIND_ALL_ORDERED_PRIX_SQL);
			findAllOrderedByLibelleStatement = base.prepareStatement(FIND_ALL_ORDERED_LIBELLE_SQL);
			findByIDStatement = base.prepareStatement(FIND_ONE_ARTICLE_SQL);
			updateByIDStatement = base.prepareStatement(UPDATE_ONE_ARTICLE);
			insertStatement = base.prepareStatement(INSERT_ONE_ARTICLE);
			deleteStatement = base.prepareStatement(DELETE_ONE_ARTICLE);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	//methode findAll
	//si on appel sans paramettre on rapelle findall avec la variable ORDER_BY_DEFAULT
	public List<Article> findAll(){ return findAll(ORDER_BY_DEFAULT); }	
	
	public List<Article> findAll(int orderType){
		ArrayList<Article> datas = new ArrayList<Article>();
		ResultSet rs = null;
		
		//je nettoie les parametres  précdents
		try {
			
			//ds cette variable stat contiendra la requete choisie pour execution
			//on choisit aussi la colonne pour les order by
			PreparedStatement stat = findAllStatement;
			
			switch(orderType){
			
			case ORDER_BY_DEFAULT:
				findAllStatement.clearParameters();
				stat = findAllStatement;
				break;
			case ORDER_BY_POIDS:
				findAllOrderedByPoidsStatement.clearParameters();
				stat = findAllOrderedByPoidsStatement;
				break;	
			case ORDER_BY_PRIX:
				findAllOrderedByPrixStatement.clearParameters();
				stat = findAllOrderedByPrixStatement;
				break;
			case ORDER_BY_LIBELLE:
				findAllOrderedByLibelleStatement.clearParameters();
				stat = findAllOrderedByLibelleStatement;
				break;	
			
			}		
			
			stat.clearParameters();
			//j'execute la requete et l affecte dans un resultset			
			rs = stat.executeQuery();
			
			while (rs.next()) 
			{
				datas.add(new Article(rs.getInt("id"),
									  rs.getString("libelle"),
									  rs.getDouble("prix"),
									  rs.getDouble("poids")));				
			}			
			
			
		} catch (SQLException e) { e.printStackTrace();	}
		finally{
			//nous avons fini, nous fermons le resultset
			if(rs != null){
				try {
					rs.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}	

		return datas;
	}

	
	
	//methode findByID
	public Article findByID(int id){
		Article a = null;
		try {
			
			findByIDStatement.clearParameters();
			findByIDStatement.setInt(1, id);
			
			ResultSet rs = findByIDStatement.executeQuery();
			
			if(rs.next()){
				a = new Article(rs.getInt("id"),
						  rs.getString("libelle"),
						  rs.getDouble("prix"),
						  rs.getDouble("poids"));				
			}
			return a;
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
		
	}
	
	
	//methode save
	
	public int save(Article a){
		//cas d'un update
		if (a.getId() >0){
			try {
				updateByIDStatement.clearParameters();
				updateByIDStatement.setString(1, a.getLibelle());
				updateByIDStatement.setDouble(2, a.getPrix());
				updateByIDStatement.setDouble(3, a.getPoids());
				updateByIDStatement.setInt(4, a.getId());
				
				return updateByIDStatement.executeUpdate();//renvoi le nombre de lignes affectées
				
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
		}
		//cas d'un insert
		else{
			
			try {
				insertStatement.clearParameters();
				insertStatement.setString(1, a.getLibelle());
				insertStatement.setDouble(2, a.getPrix());
				insertStatement.setDouble(3, a.getPoids());

				
				return insertStatement.executeUpdate();//renvoi le nombre de lignes affectées
				
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
		}
		return 0;
	}	
	
	
	
	//methode delete
	public int delete(int id){
		
		try {
			deleteStatement.clearParameters();
			deleteStatement.setInt(1,id);
			return deleteStatement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return 0;
	}
	
	
	
}
