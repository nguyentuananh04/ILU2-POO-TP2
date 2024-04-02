package frontiere;

import java.util.Scanner;

import controleur.ControlAcheterProduit;
import personnages.*;

public class BoundaryAcheterProduit {
	private Scanner scan = new Scanner(System.in);
	private ControlAcheterProduit controlAcheterProduit;

	public BoundaryAcheterProduit(ControlAcheterProduit controlAcheterProduit) {
		this.controlAcheterProduit = controlAcheterProduit;
	}

	public void acheterProduit(String nomAcheteur) {
		String choixUtilisateurProduit;
		String choixUtilisateurNomVendeur;
		int choixUtilisateurNbProduits;
		Gaulois[] vendeursProduit;
		if (!controlAcheterProduit.verifierIdentiteAcheteur(nomAcheteur)) {
			System.out.println("Je suis désolée " + nomAcheteur + " mais il faut être un habitant de notre village pour commercer ici.");
		}
		else {
			System.out.println("Quel produit voulez-vous acheter ?");
			choixUtilisateurProduit = scan.next();
			vendeursProduit = controlAcheterProduit.vendeursProduit(choixUtilisateurProduit);
			if (vendeursProduit == null) {
				System.out.println("Désolé, personne ne vend ce produit au marché.");
			}
			else {
				System.out.println("Chez quel commerçant voulez-vous acheter des " + choixUtilisateurProduit + " ?");
				for (int i = 0; i < vendeursProduit.length; i++) {
					System.out.println((i+1) + " - " + vendeursProduit[i].getNom());
				}
				int choixVendeur = scan.nextInt();
				choixUtilisateurNomVendeur = vendeursProduit[choixVendeur - 1].getNom();
				System.out.println(nomAcheteur + " se déplace jusqu'à l'étal du vendeur " + choixUtilisateurNomVendeur);
				System.out.println("Bonjour " + nomAcheteur);
				System.out.println("Combien de " + choixUtilisateurProduit + " voulez-vous acheter ?");
				choixUtilisateurNbProduits = scan.nextInt();
				int quantiteAcheteReelle = controlAcheterProduit.acheterProduit(choixUtilisateurNomVendeur, choixUtilisateurNbProduits);
				if (quantiteAcheteReelle == 0) {
					System.out.println(nomAcheteur + " veut acheter " + choixUtilisateurNbProduits + " " + choixUtilisateurProduit + ", malheureusement il n'y en a plus!");
				}
				else if (quantiteAcheteReelle < choixUtilisateurNbProduits) {
					System.out.println(nomAcheteur + " veut acheter " + choixUtilisateurNbProduits + " " + choixUtilisateurProduit + ", malheureusement " + choixUtilisateurNomVendeur + " n'en a plus que " + quantiteAcheteReelle + ". " + nomAcheteur + " achète tout le stock de " + choixUtilisateurNomVendeur + ".");
				}
				else {
					System.out.println(nomAcheteur + " achète " + choixUtilisateurNbProduits + " " + choixUtilisateurProduit + " à " + choixUtilisateurNomVendeur + ".");
				}
			}
		}
	}
}
