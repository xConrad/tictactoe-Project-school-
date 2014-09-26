package tictactoe;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 * @author maud.el-hachem
 * Cette classe permet de creer un joueur avec son nom, sa couleur, la liste
 * des cases qu'il occupe et le nombre de jetons qu'il possede sur le jeu
 */
public class Joueur {
	private char couleur;	// couleur du joueur: 'X' ou 'O'
	private String nom;		// nom du joueur
	private Case caseOccupees[];	// tableau de Case, qui contient les cases occupees
									// par le joueur
	private int nbJetons;			// le nombre de jetons que le joueur possede sur la grille
	
	
	
	/**
	 * Constructeur par parametres
	 * Attribue la couleur et le nom passe par parametresS
	 * Si le nom est vide, attribue des noms par defaut
	 * Alloue l'espace pour le tableau de case a 5
	 * Met le nombre de jetons a zero
	 * @param couleur
	 * @param nom
	 */
	public Joueur(char couleur, String nom) {
		super();
		this.couleur = couleur;
		this.nom = nom;
		if (nom.equals("") && couleur == 'X' )
			this.nom = "Xavier Dolan";
		if (nom.equals("") && couleur == 'O' )
			this.nom = "Oliver Oil";
		this.caseOccupees = new Case[3];
		this.nbJetons = 0;
	}
		
	/**
	 * @return la couleur du joueur: un caractere: 'X' ou 'O'
	 */
	public char getCouleur() {
		return couleur;
	}
	/**
	 * modifie la couleur du joueur
	 * @param couleur
	 */
	public void setCouleur(char couleur) {
		this.couleur = couleur;
	}
	/**
	 * @return un String, le nom du joueur
	 */
	public String getNom() {
		return nom;
	}
	/**
	 * modifie le nom du joueur
	 * @param nom
	 */
	public void setNom(String nom) {
		this.nom = nom;
	}
	/**
	 * @return un tableau 1D de Case, les cases occupees par le joueur
	 */
	public Case[] getCaseOccupees() {
		return caseOccupees;
	}
	/**
	 * modifie le tableau 1D de Case, les cases occupes par le joueur
	 * @param caseOccupees
	 */
	public void setCaseOccupees(Case[] caseOccupees) {
		this.caseOccupees = caseOccupees;
	}
	/**
	 * @return le nombre de jetons du joueur sur la grille
	 */
	public int getNbJetons() {
		return nbJetons;
	}
	/**
	 * modifie le nombre de jetons du joueur sur la grille
	 * @param nbJetons
	 */
	public void setNbJetons(int nbJetons) {
		this.nbJetons = nbJetons;
	}
	/**
	 * @return un booleen qui indique si le joueur a gagne
	 * 1) pour toutes les cases occupees par le joueur, on compte
	 * le nombre de jetons que le joueur a sur chaque "ligne" possible
	 * (horizontale, verticale ou diagonale)
	 * 2) si l'une de ses lignes contient 3 jetons, le joueur a gagné
	 */
	public boolean gagne()
	{
		boolean victoire = false;
		int diag1 = 0, diag2 = 0, col1 = 0, col2 = 0, col3 = 0,
		ligne1 = 0, ligne2 = 0, ligne3 = 0;
		
		for (int i = 0; i < nbJetons; i++)
		{
			int X = this.caseOccupees[i].getX();
			int Y = this.caseOccupees[i].getY();
			
			if (X == Y)
				diag1++;
			if (X+Y == 2)
				diag2++;
			if (X == 0)
				ligne1++;
			if (X == 1)
				ligne2++;
			if (X == 2)
				ligne3++;
			if (Y == 0)
				col1++;
			if (Y == 1)
				col2++;
			if (Y == 2)
				col3++;
			
		}
		if(diag1==3 || diag2 == 3 || col1 == 3 || col2 == 3 || col3 == 3
				|| ligne1 == 3 || ligne2 == 3 || ligne3 == 3)
			victoire = true;
		
		return victoire;
	}
	

	/**
	 * @param frame
	 * @param grille
	 * @return vrai si le joueur a pu faire un choix, faux sinon
	 * cette fonction permet au joueur de faire un choix sur la grille
	 * 1) on va chercher à la liste des cases possibles sur la grille
	 * 2) on ouvre une fenêtre de dialogue qui affiche cette liste et qui permet
	 * au joueur d'entrer un choix
	 * 3) si le joueur a pu entrer un choix
	 * 	a) on récupère les valeurs x et y de ce choix
	 * 	b) on modifie la case correspondante pour y placer la couleur du joueur
	 * 		et indiquer que la case est occupée
	 * 	c) on ajoute cette case à la liste des cases occupées du joueur
	 * 	d) on incrémente le nombre de jetons du joueur
	 */
	public boolean jouer(JFrame frame, Grille grille)
	{
		Object[] possibilites = grille.getCasesPossibles();
		String s = null;
		
		s = (String)JOptionPane.showInputDialog(frame, "Entre ton choix\n", this.nom,
				JOptionPane.QUESTION_MESSAGE, null, possibilites, possibilites[0]);
		
		if (s != null && s.length() > 0)
		{
			
			int x = Integer.parseInt(s.charAt(0)+"");
			int y = Integer.parseInt(s.charAt(2)+"");
			grille.setCase(x, y, couleur, true);
			this.caseOccupees[nbJetons]=grille.getCase(x, y);
			nbJetons++;
		}
		else
			return false;
		
		return true;
		
	}
	
}
