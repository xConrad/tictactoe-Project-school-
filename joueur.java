package tictactoe;

import java.util.Scanner;

import javax.swing.JFrame;



/**
 * @author MAUD
 * Cette classe permet de creer un jeu contenant les objets suivants:
 * une grille, deux joueurs et un JFrame
 */
public class Jeu {
	private Grille grille;	// la grille de jeu
	private Joueur joueurX; // le joueur X
	private Joueur joueurO; // le joueur Y
	private JFrame frame;	// panneau pour permettre au joueur d'entrer son choix
	
	
	/**
	 * Constructeur par defaut
	 * Instancie un objet Grille et un objet JFrame
	 */
	public Jeu() {
		super();
		grille = new Grille();
		frame = new JFrame("Tic Tac Toe");
	}
	/**
	 * @return l'objet Grille
	 */
	public Grille getGrille() {
		return grille;
	}
	/**
	 * Modifie l'attribut Grille
	 * @param grille
	 */
	public void setGrille(Grille grille) {
		this.grille = grille;
	}
	/**
	 * @return le joueur X
	 */
	public Joueur getJoueur1() {
		return joueurX;
	}
	/**
	 * modifie le joueur X
	 * @param joueur1
	 */
	public void setJoueur1(Joueur joueur1) {
		this.joueurX = joueur1;
	}
	/**
	 * @return le joueur O
	 */
	public Joueur getJoueur2() {
		return joueurO;
	}rintln("Joueur X, entre ton nom");
		String nomX = sc.nextLine();
		System.out.println("Joueur O, entre ton nom");
		String nomO = sc.nextLine();
		joueurX = new Joueur('X', nomX);
		joueurO = new Joueur('O', nomO);
		boolean X = true;
		boolean continuer = true;
		frame.setVisible(true);
		do
		{
			System.out.println("\nGrille actuelle:");
			grille.afficherConsole();
			if (X)
			{
				continuer = joueurX.jouer(frame, grille);
			}
			else
			{
				continuer = joueurO.jouer(frame, grille);
			}
			
			
		}while(!grille.isRemplie() && !joueurX.gagne() && !joueurO.gagne());
		
		System.out.println("\nGrille actuelle:");
		grille.afficherConsole();
		if (joueurX.gagne())
			System.out.println("\nBravo " + joueurX.getNom() + "!!!");
		else if (joueurO.gagne())
			System.out.println("\nBravo " + joueurO.getNom() + "!!!");
		else if (continuer == false)
			System.out.println("\nPartie avortée!!!!");
		frame.setVisible(false);
		
	}
	
	
	

}
