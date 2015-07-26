package metier;

import java.sql.*;
import java.util.ArrayList;
import java.util.Scanner;

//Data Access Object
//en relation avec la BdD
public class IncidentDAO {
	public static final String SELECT_ALL_SQL = "select * from `incidents`";
	public static final String INSERT_SQL = "insert into `incidents` (`description`, `date`, `urgence`, `categorie`) VALUES(?,?,?,?)";
	public static final String UPDATE_SQL = "update `incidents` set `description`= ?, `date`=?, `urgence`=?, `categorie`= ? WHERE `id`=?";
	public static final String DELETE_SQL = "delete from `incidents`  WHERE `id`=?";	
	
	private PreparedStatement selectAllStatement;
	private PreparedStatement insertStatement;
	private PreparedStatement updateStatement;
	private PreparedStatement deleteStatement;
	
	private Connection base;
	
	public IncidentDAO () {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			base =	DriverManager.getConnection("jdbc:mysql://localhost:3306/bddincidents", "root", "");
			System.out.println("connecté à la base de données");
			selectAllStatement = base.prepareStatement(SELECT_ALL_SQL);
			insertStatement = base.prepareStatement(INSERT_SQL);
			updateStatement = base.prepareStatement(UPDATE_SQL);
			deleteStatement = base.prepareStatement(DELETE_SQL);
			
		} catch (ClassNotFoundException e) {e.printStackTrace();}
		catch (SQLException e) {e.printStackTrace();}
	}
	
	//methode findAll renvoit tt les incidents
	public ArrayList<Incident> findAll() {
		
		ArrayList<Incident> incidents = new ArrayList<Incident>();
		
		try {
			ResultSet rs = selectAllStatement.executeQuery();
			while (rs.next()) {
				incidents.add(new Incident(rs.getInt("id"),
						rs.getString("description"),
						new java.util.Date(rs.getDate("date").getTime()), // conversion sql.Date -> util.Date
						rs.getInt("urgence"),
						rs.getString("categorie")));
			}
			rs.close();
		} catch (SQLException e) {e.printStackTrace();}
		
		return incidents;
	}
	
	//methode delete efface un incident
	public void delete(Incident i) {
		try {
			deleteStatement.clearParameters();
			deleteStatement.setInt(1, i.getId());
			deleteStatement.executeUpdate();
		} catch (SQLException e) {	e.printStackTrace();}
	}

	//methode save pour inserrtion ou un update enregistre en base un incident
	public void save(Incident i) {
		if (i.getId() == 0) {
			// insertion
			try {
				insertStatement.clearParameters();
				insertStatement.setString(1, i.getDescription());
				insertStatement.setDate(2, new java.sql.Date(i.getDate().getTime()));
				insertStatement.setInt(3, i.getUrgence());
				insertStatement.setString(4, i.getCategorie());
				insertStatement.executeUpdate();
			} catch (SQLException e) {	e.printStackTrace();}
		}
		else
		{
			// update
			try {
				updateStatement.clearParameters();
				updateStatement.setString(1, i.getDescription());
				updateStatement.setDate(2, new java.sql.Date(i.getDate().getTime()));
				updateStatement.setInt(3, i.getUrgence());
				updateStatement.setString(4, i.getCategorie());
				updateStatement.setInt(5, i.getId());
				updateStatement.executeUpdate();
			} catch (SQLException e) {e.printStackTrace();}
		}
	}

}
