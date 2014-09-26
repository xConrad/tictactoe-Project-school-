package tictactoe;

/**
 * @author MAUD
 * Cette classe permet de créer une grille de jeu, de 3 par 3 cases
 */
public class Grille {
	private Case grille[][];	// le tableau de case
	private boolean remplie;	// si la grille est remplie
	
	
	/**
	 * Constructeur 
	 * Alloue un tableau 2D de 3 par 3
	 * Chaque element du tableau est construit avec un objet Case
	 */
	public Grille() {
		super();
		this.grille = new Case[3][3];
		for (int i=0; i<3;i++)
			for(int j=0; j<3; j++)
			{
				this.grille[i][j] = new Case(i, j);

			}
		this.remplie = false;
	}
	/**
	 * @param i
	 * @param j
	 * @return un objet Case dans la grille selon la position entree
	 */
	public Case getCase(int i, int j){
		return grille[i][j];
	}
	/**
	 * modifie une case (la couleur et si occupee) dans la grille selon la position entree
	 * @param i
	 * @param j
	 * @param couleur
	 * @param occupee
	 */
	public void setCase(int i, int j, char couleur, boolean occupee){
		this.grille[i][j].setCouleur(couleur);
		this.grille[i][j].setOccupee(occupee);
	}
	/**
	 * @return un tableau de cases (la grille au complet)
	 */
	public Case[][] getGrille() {
		return grille;
	}
	
	/**
	 * modifie le tableau de cases
	 * @param grille
	 */
	public void setGrille(Case[][] grille) {
		this.grille = grille;
	}
	
	/**
	 * @return un booleen qui indique si la grille est remplie,
	 * c'est-a-dire si toutes les cases sont occupees
	 */
	public boolean isRemplie() {
		int nbOcc = 0;
		for(int i = 0; i<3; i++)
			for(int j = 0; j<3; j++)
				if (this.grille[i][j].isOccupee())
					nbOcc++;
		if (nbOcc == 9)
			this.remplie = true;
		return remplie;
	}
	
	/**
	 * modifie le booleen qui indique que la grille est remplie
	 * @param remplie
	 */
	public void setRemplie(boolean remplie) {
		this.remplie = remplie;
	}
	
	/**
	 * affiche la grille a la console
	 */
	public void afficherConsole()
	{
		for(int i = 0; i<3; i++)
		{
			for(int j = 0; j<3; j++)
				System.out.print(this.grille[i][j].getCouleur() + " ");
			System.out.println();
		}
				
	}
	
	/**
	 * @return retourne les coordonnees des cases libres en chaines de caracteres
	 * sous la forme "x,y"
	 */
	public String[] getCasesPossibles()
	{
		String casesPossibles[] = new String[9];
		int nb = 0;
		for (int i = 0; i < 3; i++)
			for(int j = 0; j < 3; j++)
				if (this.grille[i][j].isOccupee())
				{
					casesPossibles[nb] = Integer.toString(i) + "," + 
										Integer.toString(j);
					nb++;
				}
		
		return casesPossibles;
	}
	
	
}
