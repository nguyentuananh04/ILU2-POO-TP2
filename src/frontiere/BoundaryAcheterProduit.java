package frontiere;

import java.util.Iterator;

import controleur.ControlAcheterProduit;
import personnages.Gaulois;

public class BoundaryAcheterProduit {
	private ControlAcheterProduit controlAcheterProduit;

	public BoundaryAcheterProduit(ControlAcheterProduit controlAcheterProduit) {
		this.controlAcheterProduit = controlAcheterProduit;
	}

	public void acheterProduit(String nomAcheteur) {
		StringBuilder produitAcheteQuestion = new StringBuilder();
		StringBuilder vendeurQuestion = new StringBuilder();
		StringBuilder quantiteAcheteQuestion = new StringBuilder();
		String produitAchete = null;
		Gaulois[] vendeursProduit = null;
		String choixVendeur = null;
		int choixQuanTiteAcheter = -1;
		int quantiteAcheter = -1;
		produitAcheteQuestion.append("Quel produits voulez-vous acheter?");
		produitAchete = Clavier.entrerChaine(produitAcheteQuestion.toString());
		vendeursProduit = controlAcheterProduit.trouverEtalProduit(produitAchete);
		
		if(vendeursProduit.length == 0)
			System.out.println("Désolé, personne ne vend ce produit au marché!");
		else {
			vendeurQuestion.append("Chez quel commerçant voulez-vous acheter des fleurs?\n");
			for (int i = 0; i < vendeursProduit.length; i++) {
				vendeurQuestion.append((i + 1) + " - "+ vendeursProduit[i].getNom());
			}
		}
		choixVendeur = vendeursProduit[(Clavier.entrerEntier(vendeurQuestion.toString())) - 1].getNom();
		
		System.out.println(nomAcheteur + " se déplace jusqu'à l'étal du vendeur " + choixVendeur);
		System.out.println("Bonjour " + nomAcheteur);
		quantiteAcheteQuestion.append("Combien de fleurs voulez-vous acheter?");
		choixQuanTiteAcheter = Clavier.entrerEntier(quantiteAcheteQuestion.toString());
		quantiteAcheter = controlAcheterProduit.trouverEtalVendeur(choixVendeur).acheterProduit(choixQuanTiteAcheter);
		if (quantiteAcheter == 0) {
			System.out.println(nomAcheteur + " veut acheter " + choixQuanTiteAcheter + " " + produitAchete + ", malheureusement il n'y en a plus !");
		}
		else if (quantiteAcheter >= choixQuanTiteAcheter) {
			System.out.println(nomAcheteur + " achète " + choixQuanTiteAcheter + " " + produitAchete + " à " + choixVendeur);
		}
		else {
			System.out.println(nomAcheteur + " veut acheter " + choixQuanTiteAcheter + " " + produitAchete + ", malheureusement " + choixVendeur + " n'en a plus que " + quantiteAcheter + ". " + nomAcheteur + " achète tout le stock de " + choixVendeur + ".");
		}
	}
}
