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

	//requete preparées et attributs de ClientsDAO
	public static final String FIND_ALL_SQL = "SELECT * FROM `articles`";
	private PreparedStatement findAllStatement ;
	
	public static final String FIND_ALL_ORDERED_PRIX_SQL = "SELECT * FROM `articles` ORDER BY prix";
	private PreparedStatement findAllOrderedByPrixStatement ;
	
	public static final String FIND_ALL_ORDERED_POIDS_SQL = "SELECT * FROM `articles` ORDER BY poids";
	private PreparedStatement findAllOrderedByPoidsStatement ;
	
//	public static final String FIND_ONE_CLIENT = "SELECT * FROM `clients` WHERE `id` = ?";
//	private PreparedStatement findByIDStatement ;
//	
//	public static final String UPDATE_ONE_CLIENT = "UPDATE `clients` SET `nom` = ?, `email` = ?, `solde` = ? WHERE `id` = ?";
//	private PreparedStatement updateByIDStatement ;
//	
//	public static final String INSERT_ONE_CLIENT = "INSERT INTO `clients` (`nom`,`email`,`solde`) VALUES(?,?,?)";
//	private PreparedStatement insertStatement ;
//	
//	public static final String DELETE_ONE_CLIENT = "DELETE FROM `clients` WHERE `id` = ? ";
//	private PreparedStatement deleteStatement ;
	
	
	

	public ArticleDAO(Connection base) {
		super();
		this.base = base;
		
		try {
			
			
			findAllStatement = base.prepareStatement(FIND_ALL_SQL);
			findAllOrderedByPoidsStatement = base.prepareStatement(FIND_ALL_ORDERED_POIDS_SQL);
			findAllOrderedByPrixStatement = base.prepareStatement(FIND_ALL_ORDERED_PRIX_SQL);			
			
			
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
	
	
	
	//methode save
	
	
	
	
	
	//methode delete
	
	
}
