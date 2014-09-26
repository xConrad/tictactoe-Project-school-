
package tictactoe;

/**
 * @author MAUD
 * Cette classe permet de creer une case dans une grille
 */
public class Case {

	private int x;	// la position en x sur la grille
	private int y;	// la position en y sur la grille
	private char couleur; 	// la couleur qui occupe la case, X ou O
	private boolean occupee;// indique si la case est occupee
	
	
	/**
	 * Constructeur par parametres
	 * initialise la position, la couleur à '_' et si occupee a false
	 * @param x, la position en x
	 * @param y, la position en y
	 */
	public Case(int x, int y) {
		super();
		this.x = y;
		this.y = y;
		this.couleur = '_';
		this.occupee = false;
	}
	/**
	 * @return la position en x
	 */
	public int getX() {
		return x;
	}
	/**
	 * modifie la position en x
	 * @param x: la position en x
	 */
	public void setX(int x) {
		this.x = x;
	}
	/**
	 * @return la position en y
	 */
	public int getY() {
		return y;
	}
	/**
	 * modifie la position en y
	 * @param y: la position en y 
	 */
	public void setY(int y) {
		this.y = y;
	}
	/**
	 * @return la couleur
	 */
	public char getCouleur() {
		return couleur;
	}
	/**
	 * modifie la couleur
	 * @param couleur
	 */
	public void setCouleur(char couleur) {
		this.couleur = couleur;
	}
	/**
	 * @return si la case est occupée, true ou false
	 */
	public boolean isOccupee() {
		return occupee;
	}
	/**
	 * modifie si la case est occupee
	 * @param occupee
	 */
	public void setOccupee(boolean occupee) {
		this.occupee = occupee;
	}
	
	
	
}
