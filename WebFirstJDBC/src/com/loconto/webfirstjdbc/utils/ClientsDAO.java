package com.loconto.webfirstjdbc.utils;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import com.loconto.webfirstjdbc.beans.*;

//classe de DataAccessObjet Clients, 
//les objets serviront à faire le lien entre la WebApp et la Base de données
public class ClientsDAO {
	
	private Connection base;
	
	//requete preparées
	public static final String FIND_ALL_SQL = "SELECT * FROM `clients`";
	private PreparedStatement findAllStatement ;

	//constructeur
	public ClientsDAO(Connection base) {
		this.base = base;
		try {
			findAllStatement = base.prepareStatement(FIND_ALL_SQL);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	//methode qui renvoi tout les clients
	//methode qui renvoi un type List (liste "modele")
	public List<Clients> findAll(){
		ArrayList<Clients> datas = new ArrayList<Clients>(); //datas contiendra les données
		ResultSet rs = null;
		try 
		{
			
			//je nettoie les parametres  précdents
			findAllStatement.clearParameters();
			//j'execute la requete et l affecte dans un resultset			
			rs = findAllStatement.executeQuery();
			
			while (rs.next()) 
			{
				datas.add(new Clients(rs.getInt("id"),
									  rs.getString("nom"),
									  rs.getString("email")
									  ,rs.getDouble("solde")));				
			}
			
		} catch (SQLException e) { e.printStackTrace(); }
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
	

}
