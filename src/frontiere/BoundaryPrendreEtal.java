package frontiere;

import java.util.Scanner;

import controleur.ControlPrendreEtal;

public class BoundaryPrendreEtal {
	private ControlPrendreEtal controlPrendreEtal;
	private Scanner scan = new Scanner(System.in);

	public BoundaryPrendreEtal(ControlPrendreEtal controlChercherEtal) {
		this.controlPrendreEtal = controlChercherEtal;
	}

	public void prendreEtal(String nomVendeur) {
		if(!(controlPrendreEtal.verifierIdentite(nomVendeur))) {
			System.out.println("Je suis d�sol�e " + nomVendeur + " mais il faut �tre un habitant de notre village pour commercer ici.\n");
		}
		else {
			System.out.println("Bonjour " + nomVendeur + ", je vais regarder si je peux vous trouver un �tal.");
			if(!(controlPrendreEtal.resteEtals())) {
				System.out.println("D�sol�e "+ nomVendeur + " je n'ai plus d'�tal qui ne soit pas d�j� occup�.");
			}
			else {
				installerVendeur(nomVendeur);
			}	
		}
	}

	private void installerVendeur(String nomVendeur) {
		String choixUtilisateurProduit = null;
		int choixUtilisateurNbProduit = -1;
		System.out.println("C'est parfait, il me reste un �tal pour vous !");
		System.out.println("Il me faudrait quelques renseignements:");
		StringBuilder questionProduit = new StringBuilder();
		StringBuilder questionNbProduit = new StringBuilder();
		questionProduit.append("Quel produit souhaitez-vous vendre ?");
		questionNbProduit.append("Combien souhaitez-vous en vendre ?");
		choixUtilisateurProduit = Clavier.entrerChaine(questionProduit.toString());
		choixUtilisateurNbProduit = Clavier.entrerEntier(questionNbProduit.toString());
		int numeroEtal = -1;
		numeroEtal = controlPrendreEtal.prendreEtal(nomVendeur, choixUtilisateurProduit, choixUtilisateurNbProduit);
		if (numeroEtal != -1) {
			System.out.println("Le vendeur " + nomVendeur + " s'est install� � l'�tal n�" + numeroEtal +".\n");
		}
	}
}
