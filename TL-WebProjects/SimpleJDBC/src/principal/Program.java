package principal;

import java.sql.*;

public class Program {

	public static void main(String[] args) {
		try {
			// chargement/initialisation du driver MYSQL
			Class.forName("com.mysql.jdbc.Driver");
			
			// Connection est l'interface d�crivant un objet permettant de se connecter a une base de donn�e
			// le DriverManager renvoie un objet impl�mentant cette interface qui est capable de g�rer l'url qu'on lui a fournie
		    Connection base = DriverManager.getConnection("jdbc:mysql://localhost:3306/bddarticles","root","");
		    System.out.println("connect� � la base de donn�es!");
		    
		    //  je creer mon objet permettant de requetter la base
		    Statement request = base.createStatement();
		    
		    // execution d'une requette select, elle nous renvoie un "resultset" qui nous permet
		    // de parcourir les lignes renvoy�e
		    ResultSet rs = request.executeQuery("select * from `articles`");
		    
		    // parcourir les lignes
		    while (rs.next()){
		    	// r�cup�rer les colonnes qui nous int�ressent
		    	// sur la ligne courante
		    	System.out.println("article : " + rs.getString("libelle") + " prix => " + rs.getDouble("prix")+"�");
		    }
		    
		    // attention a bien lib�rer les ressources
		    rs.close();
		    base.close();
			
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		

	}

}
