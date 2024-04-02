package frontiere;

import controleur.ControlEmmenager;

public class BoundaryEmmenager {
	private ControlEmmenager controlEmmenager;

	public BoundaryEmmenager(ControlEmmenager controlEmmenager) {
		this.controlEmmenager = controlEmmenager;
	}

	public void emmenager(String nomVisiteur) {
		if (controlEmmenager.isHabitant(nomVisiteur)) {
			System.out.println(
					"Mais vous êtes déjà un habitant du village !");
		} else {
			StringBuilder question = new StringBuilder();
			question.append("Êtes-vous :\n");
			question.append("1 - un druide.\n");
			question.append("2 - un gaulois.\n");
			int choixUtilisateur = -1;
			do {
				choixUtilisateur = Clavier.entrerEntier(question.toString());
				switch (choixUtilisateur) {
				case 1:
					emmenagerDruide(nomVisiteur);
					break;

				case 2:
					emmenagerGaulois(nomVisiteur);
					break;

				default:
					System.out
							.println("Vous devez choisir le chiffre 1 ou 2 !");
					break;
				}
			} while (choixUtilisateur != 1 && choixUtilisateur != 2);
		}
	}

	private void emmenagerDruide(String nomVisiteur) {
		int choixUtilisateurEffetPotionMax = -1;
		int choixUtilisateurEffetPotionMin = -1;
		int choixUtilisatuerForce = -1;
		StringBuilder questionForce = new StringBuilder();
		questionForce.append("Quelle est votre force?");
		choixUtilisatuerForce = Clavier.entrerEntier(questionForce.toString());
		StringBuilder questionEffetPotionMax = new StringBuilder();
		questionEffetPotionMax.append("Quelle est la force de potion la plus forte que vous produisez ?\n");
		StringBuilder questionEffetPotionMin = new StringBuilder();
		questionEffetPotionMin.append("Quelle est la force de potion la plus faible que vous produisez ?\n");
		do {
			choixUtilisateurEffetPotionMin = Clavier.entrerEntier(questionEffetPotionMin.toString());
			choixUtilisateurEffetPotionMax = Clavier.entrerEntier(questionEffetPotionMax.toString());
			if (choixUtilisateurEffetPotionMax < choixUtilisateurEffetPotionMin) {
				System.out.println("Attention Druide, vous vous êtes trompé entre le minimum et le maximum.\n");
			}
		} while (choixUtilisateurEffetPotionMax < choixUtilisateurEffetPotionMin);
		controlEmmenager.ajouterDruide(nomVisiteur, choixUtilisatuerForce, choixUtilisateurEffetPotionMin, choixUtilisateurEffetPotionMax);
		
	}
	
	private void emmenagerGaulois(String nomVisiteur) {
		
	}
}
