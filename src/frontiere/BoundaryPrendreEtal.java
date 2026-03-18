package frontiere;

import controleur.ControlPrendreEtal;

public class BoundaryPrendreEtal {
	private ControlPrendreEtal controlPrendreEtal;

	public BoundaryPrendreEtal(ControlPrendreEtal controlChercherEtal) {
		this.controlPrendreEtal = controlChercherEtal;
	}

	public void prendreEtal(String nomVendeur) {
		if (!(controlPrendreEtal.verifierIdentite(nomVendeur))) {
			System.out.println("Je suis désolée " + nomVendeur + " mais il faut être un habitant de notre village pour commercer ici.\n");
		}
		else {
			System.out.println("Bonjour " + nomVendeur + ", je vais regarder si je peux vous trouver un étal.\n");
			if(!controlPrendreEtal.resteEtals()) {
				System.out.println("Désolée " + nomVendeur + " je n'ai plus d'étal qui ne soit pas déjà occupé.\n");
			}
			else {
				installerVendeur(nomVendeur);
				StringBuilder produitQuestion = new StringBuilder();
				StringBuilder nbProduitQuestion = new StringBuilder();
				String produit = null;
				int nbProduit = -1;
				System.out.println("C'est parfait, il me reste un étal pour vous!\n");
				System.out.println("Il me faudrait quelques renseigenements.\n");
				produitQuestion.append("Quel produit souhaitez-vous vendre?\n");
				produit = Clavier.entrerChaine(produitQuestion.toString());
				nbProduitQuestion.append("Combien souhaitez-vous en vendre?\n");
				nbProduit = Clavier.entrerEntier(nbProduitQuestion.toString());
				int numeroEtal = controlPrendreEtal.prendreEtal(nomVendeur, produit, nbProduit);
				if (numeroEtal != -1) {
					System.out.println("Le vendeur " + nomVendeur + " s'est installé à l'étal n°" + (numeroEtal + 1) + "\n");
				}
			}
		}
	}

	private void installerVendeur(String nomVendeur) {
		//TODO a completer
	}
}
