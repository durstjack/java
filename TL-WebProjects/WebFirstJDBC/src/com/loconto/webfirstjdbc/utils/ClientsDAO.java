package com.loconto.webfirstjdbc.utils;
import java.sql.*;

import java.util.ArrayList;
import java.util.List;

import com.loconto.webfirstjdbc.beans.*;


//classe de DataAccessObjet Clients, 
//les objets serviront à faire le lien entre la WebApp et la Base de données
public class ClientsDAO {
	
	private Connection base;
	
	//requete preparées et attributs de ClientsDAO
	public static final String FIND_ALL_SQL = "SELECT * FROM `clients`";
	private PreparedStatement findAllStatement ;
	
	public static final String FIND_ONE_CLIENT = "SELECT * FROM `clients` WHERE `id` = ?";
	private PreparedStatement findByIDStatement ;
	
	public static final String UPDATE_ONE_CLIENT = "UPDATE `clients` SET `nom` = ?, `email` = ?, `solde` = ? WHERE `id` = ?";
	private PreparedStatement updateByIDStatement ;
	
	public static final String INSERT_ONE_CLIENT = "INSERT INTO `clients` (`nom`,`email`,`solde`) VALUES(?,?,?)";
	private PreparedStatement insertStatement ;
	
	public static final String DELETE_ONE_CLIENT = "DELETE FROM `clients` WHERE `id` = ? ";
	private PreparedStatement deleteStatement ;

	//constructeur
	public ClientsDAO(Connection base) {
		this.base = base;
		try {
			//dans le try de ce constructeur, on prepare et on affecte dans des variables nos requetes
			findAllStatement = base.prepareStatement(FIND_ALL_SQL);
			findByIDStatement = base.prepareStatement(FIND_ONE_CLIENT);
			updateByIDStatement = base.prepareStatement(UPDATE_ONE_CLIENT);
			insertStatement = base.prepareStatement(INSERT_ONE_CLIENT);
			deleteStatement = base.prepareStatement(DELETE_ONE_CLIENT);
			
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
	
	//methode qui renvoi un client
	//selectionne un client grace a son id
	public Clients findClient(int id){
		Clients c = null;
		try {
			findByIDStatement.clearParameters();
			findByIDStatement.setInt(1, id);
			
			ResultSet rs = findByIDStatement.executeQuery();
			
			if(rs.next()){
				c = new Clients(rs.getInt("id"),
						  rs.getString("nom"),
						  rs.getString("email"),
						  rs.getDouble("solde"));	
			}

			
		} catch (SQLException e) { e.printStackTrace();	}
		return c;
		
	}
	//methode qui modifie ou insert un client
	//selectionne un client grace a son id	
	public int  save(Clients c){
		//cas d'un update
		if (c.getId() >0){
			try {
				updateByIDStatement.clearParameters();
				updateByIDStatement.setString(1, c.getNom());
				updateByIDStatement.setString(2, c.getEmail());
				updateByIDStatement.setDouble(3, c.getSolde());
				updateByIDStatement.setDouble(4, c.getId());
				
				return updateByIDStatement.executeUpdate();//renvoi le nombre de lignes affectées
				
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
		}
		//cas d'un insert
		else{
			
			try {
				insertStatement.clearParameters();
				insertStatement.setString(1, c.getNom());
				insertStatement.setString(2, c.getEmail());
				insertStatement.setDouble(3, c.getSolde());

				
				return insertStatement.executeUpdate();//renvoi le nombre de lignes affectées
				
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
		}
		return 0;
	}
	
	//methode qui modifie ou insert un client
	//selectionne un client grace a son id	
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
