package principal;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Date;

import javax.swing.BoxLayout;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import metier.Incident;
import metier.IncidentDAO;

public class FenetreManager extends JFrame implements ActionListener, ListSelectionListener
{
	public static final String CREATE_COMMAND = "create";
	public static final String EDIT_COMMAND = "edit";
	public static final String DELETE_COMMAND = "delete";
	public static final String RELOAD_COMMAND = "reload";
	
	private JButton btCreer, btEditer, btSupprimer, btReload;
	
	// les données de la liste
	private DefaultListModel<Incident> dataIncidents;
	// le composant graphique liste
	private JList<Incident> listeIncidents;
	//objet DAO
	private IncidentDAO incidentDAO;
	
	private FenetreEdit editWindow;
	
	public FenetreManager() {
		super("Manager d'incidents");
		setSize(700, 480);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		//notre fenetre sera de type borderlayout
		setLayout(new BorderLayout());
		
		//panelHaut sera de type BoxLayout
		JPanel panelHaut = new JPanel();
		BoxLayout bl = new BoxLayout(panelHaut, BoxLayout.X_AXIS);
		panelHaut.setLayout(bl);
		
		//pour tt nos boutons on cree des elements Jbutton, on les ajoute a notre jpanel panelHaut
		//on associe a chacun une action avec "setActionCommand(xxx)" xxx constante de type string
		//on declare l'instance courante de fenetreManager comme listener de ce bouton
		btCreer = new JButton("creer"); 
		panelHaut.add(btCreer);
		btCreer.setActionCommand(CREATE_COMMAND);
		btCreer.addActionListener(this);

		btEditer = new JButton("editer");
		panelHaut.add(btEditer);
		btEditer.setActionCommand(EDIT_COMMAND);
		btEditer.addActionListener(this);

		btSupprimer = new JButton("supprimer");
		panelHaut.add(btSupprimer);
		btSupprimer.setActionCommand(DELETE_COMMAND);
		btSupprimer.addActionListener(this);

		btReload = new JButton("rafraichir");
		panelHaut.add(btReload);
		btReload.setActionCommand(RELOAD_COMMAND);
		btReload.addActionListener(this);

		//a notre fenetre borderlayout on ajoute en haut panelHaut
		add(panelHaut, BorderLayout.NORTH);
		
		//on instancie nos liste modeles et graphiques
		dataIncidents = new DefaultListModel<Incident>();
		listeIncidents = new JList<Incident>(dataIncidents);
	
		//ajoute une zone avec scroll barre au centre qui contiendra la liste des incidents
		add(new JScrollPane(listeIncidents), BorderLayout.CENTER);
		//pour interagir avec la liste, selectionner un element:
		listeIncidents.addListSelectionListener(this);
	
		// initialisation connection a la base
		incidentDAO = new IncidentDAO();
		
		// on instancie une fenetre d'edition
		// en argument on passe l'instance de FenetreManager courante, (le parent qui a appelé fenetreEdit)
		//voir le constructeur de FenetreEdit
		editWindow = new FenetreEdit(this);
		
		refresh_liste();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		//on switch suivant le bouton actionné
		switch(e.getActionCommand()) {
			case CREATE_COMMAND:
				creer_incident();
				break;
			case EDIT_COMMAND:
				edit_incident();
				break;
			case DELETE_COMMAND:
				delete_incident();
				break;
			case RELOAD_COMMAND:
				refresh_liste();
				break;
		}
		
	}
	
	public void delete_incident() {
		// il faut le supprimer de la base, et rafraichir la JList
		incidentDAO.delete(listeIncidents.getSelectedValue());
		refresh_liste();
	}
		
	public void save_incident() {
		// il faut insérer dans la base, et ajouter dans la JList
		editWindow.setVisible(false);
		editWindow.refresh_object();
		incidentDAO.save(editWindow.getIncident());
		refresh_liste();
	}
	
	private void creer_incident() {
		Incident i = new Incident(0, "rien....", new Date(), 1, "defaut");
		editWindow.setIncident(i);
		editWindow.refresh_window();
		editWindow.setVisible(true);
	}
	
	private void edit_incident() {
		Incident i = listeIncidents.getSelectedValue();
		editWindow.setIncident(i);
		editWindow.refresh_window();
		editWindow.setVisible(true);
	}
	
	private void refresh_liste() {
		ArrayList<Incident> incidents = incidentDAO.findAll();
		// je vide la liste
		dataIncidents.clear();
		// je copie les incidents de la base dans la Jlist
		for (Incident i : incidents)
			dataIncidents.addElement(i);
		
		
	}

	// pour la liste
	@Override
	public void valueChanged(ListSelectionEvent e) {
		//JOptionPane.showMessageDialog(null, "selection de " + listeIncidents.getSelectedValue());
		
	}
	
	
	
}
