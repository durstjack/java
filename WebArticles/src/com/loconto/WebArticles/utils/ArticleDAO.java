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

	//requete preparées et attributs de ClientsDAO
	public static final String FIND_ALL_SQL = "SELECT * FROM `articles`";
	private PreparedStatement findAllStatement ;
	
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
			
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	//methode findAll
	public List<Article> findAll(){
		ArrayList<Article> datas = new ArrayList<Article>();
		ResultSet rs = null;
		
		//je nettoie les parametres  précdents
		try {
			findAllStatement.clearParameters();
			//j'execute la requete et l affecte dans un resultset			
			rs = findAllStatement.executeQuery();
			
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
